<template>
  <div class="user-profile-container">
    <div class="user-avatar">
      <div class="upload-avatar">
        <el-upload
          class="avatar-uploader"
          action
          :show-file-list="false"
          :on-success="handleUpload"
          :before-upload="beforeAvatarUpload"
        >
          <img :src="userInfo.avatar" class="avatar" />
        </el-upload>
      </div>
    </div>
    <el-form :model="userInfo" ref="userInfo">
      <el-row class="demo-autocomplete">
        <el-col :span="12">
          <div class="sub-title">账号</div>
          <el-form-item prop="username">
            <el-input v-model="userInfo.username" disabled placeholder="请输入账号"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <div class="sub-title">昵称</div>
          <el-form-item prop="nickname">
            <el-input v-model="userInfo.nickname" placeholder="请输入密码"></el-input>
          </el-form-item>
        </el-col>
      </el-row>
      <el-row class="demo-autocomplete">
        <el-col :span="12">
          <div class="sub-title">性别</div>
          <el-form-item prop="ssex">
            <el-select v-model="userInfo.ssex" placeholder="请选择">
              <el-option
                v-for="item in sexOptions"
                :key="item.value"
                :label="item.label"
                :value="item.value"
              ></el-option>
            </el-select>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <div class="sub-title">状态</div>
          <el-form-item prop="status">
            <el-select v-model="userInfo.status" disabled placeholder="请选择">
              <el-option
                v-for="item in statusOptions"
                :key="item.value"
                :label="item.label"
                :value="item.value"
              ></el-option>
            </el-select>
          </el-form-item>
        </el-col>
      </el-row>
      <el-row class="demo-autocomplete">
        <el-col :span="12">
          <div class="sub-title">手机</div>
          <el-form-item prop="mobile">
            <el-input v-model="userInfo.mobile" placeholder="请输入手机号"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <div class="sub-title">邮箱</div>
          <el-form-item prop="email">
            <el-input v-model="userInfo.email" placeholder="请输入邮箱"></el-input>
          </el-form-item>
        </el-col>
      </el-row>
      <el-row class="demo-autocomplete">
        <el-col :span="12">
          <div class="sub-title">部门</div>
          <el-form-item>
            <el-input v-model="userInfo.deptName" disabled></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <div class="sub-title">角色</div>
          <el-form-item>
            <el-select v-model="userInfo.roleId" disabled multiple placeholder="请选择">
              <el-option
                v-for="item in roleOptions"
                :key="item.value"
                :label="item.label"
                :value="item.value"
              ></el-option>
            </el-select>
          </el-form-item>
        </el-col>
      </el-row>

      <el-row class="demo-autocomplete">
        <el-col :span="24">
          <div class="sub-title">简介</div>
          <el-input v-model="userInfo.description" type="textarea"></el-input>
        </el-col>
      </el-row>
    </el-form>
    <span slot="footer" class="dialog-footer">
      <el-button type="primary" @click="modifyUser('userInfo')">保存修改</el-button>
    </span>
  </div>
</template>

<script>
import { getCurrentUser, updateUser, uploadImg } from "@/api/user";
import { fetchDeptOptions } from "@/api/dept";
import { fetchRoleOptions } from "@/api/role";
import { getSexOption, getStatusOption } from "@/api/option";
import TreeSelect from "@/components/TreeSelect.vue";

export default {
  components: {
    TreeSelect
  },
  data() {
    return {
      userInfo: {
        avatar:
          "http://47.104.70.138:8080/febs/images/avatar/cnrhVkzwxjPwAaCfPbdc.png",
        username: "",
        password: "",
        nickname: "",
        mobile: "",
        email: "",
        ssex: "",
        status: "1",
        deptId: "",
        roleId: [],
        description: ""
      },
      defaultCheckedKeys: [],
      sexOptions: [],
      statusOptions: [],
      deptOptions: [],
      roleOptions: [],
      rules: {
        username: [
          { required: true, message: "账号不能为空", trigger: "blur" }
        ],
        password: [
          { required: true, message: "密码不能为空", trigger: "blur" }
        ],
        nickname: [
          { required: true, message: "昵称不能为空", trigger: "blur" }
        ],
        ssex: [{ required: true, message: "请选择性别", trigger: "change" }],
        status: [{ required: true, message: "请选择状态", trigger: "change" }],
        deptId: [{ required: true, message: "请选择部门", trigger: "change" }],
        roleId: [{ required: true, message: "请选择角色", trigger: "change" }]
      }
    };
  },
  mounted() {
    this.loadSexOption();
    this.loadStatusOption();
    this.loadUserInfo();
    this.loadDeptOptions();
    this.loadRoleOptions();
  },
  methods: {
    modifyUser(formName) {
      this.$refs[formName].validate(valid => {
        if (valid) {
          updateUser(this.userInfo).then(res => {
            this.$message({
              message: "修改成功",
              type: "success"
            });
          });
        }
      });
    },
    loadUserInfo() {
      getCurrentUser().then(res => {
        this.userInfo = res.data;
        this.defaultCheckedKeys = [this.userInfo.deptId];
      });
    },
    loadSexOption() {
      getSexOption().then(res => {
        this.sexOptions = res.data;
      });
    },
    loadStatusOption() {
      getStatusOption().then(res => {
        this.statusOptions = res.data;
      });
    },
    loadDeptOptions() {
      fetchDeptOptions().then(res => {
        this.deptOptions = res.data;
      });
    },
    loadRoleOptions() {
      fetchRoleOptions().then(res => {
        this.roleOptions = res.data;
      });
    },
    handleUpload(response, file, fileList) {
      if (response.data.indexOf("http://") == -1) {
        response.data = "http://" + response.data;
      }
      this.userInfo.avatar = response.data;
    },
    beforeAvatarUpload(file) {
      const isImg = file.type === "image/jpeg" || file.type === "image/png";
      const isLt2M = file.size / 1024 / 1024 < 2;

      if (!isImg) {
        this.$message.error("上传头像图片只能是 JPG/PNG 格式!");
      }
      if (!isLt2M) {
        this.$message.error("上传头像图片大小不能超过 2MB!");
      }
      if (isImg && isLt2M) {
        let param = new FormData(); // 创建form对象
        param.append("file", file, file.name); // file对象是 beforeUpload参数
        let config = {
          headers: { "Content-Type": "multipart/form-data" }
        };
        uploadImg(param, config).then(res => {
          this.userInfo.avatar = "http://" + res.data;
        });
      }
      return false;
    },
    popoverHide(key, value) {
      this.userInfo.deptId = key;
    }
  }
};
</script>

<style lang="scss" scoped>
.user-profile-container {
  color: #606266;
  font-size: 14px;
  padding: 20px 0px 0px 30px;

  .user-avatar {
    // margin: 20px 0px;
    height: 150px;
    text-align: center;

    img {
      width: 120px;
      height: 120px;
      border-radius: 50%;
    }
  }

  .el-col {
    padding: 0px 20px;
  }

  .el-select,
  .el-cascader {
    width: 100%;
  }

  .dialog-footer {
    display: flex;
    align-items: center;
    justify-content: left;
    margin: 20px;

    button {
      margin-right: 60px;
    }
  }
}
</style>