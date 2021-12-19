<template>
  <div class="user-add-container">
    <div class="user-avatar-container">
      <div class="user-avatar">
        <img :src="userInfo.avatar" />
        <div class="upload-avatar">
          <el-upload
            class="upload-demo"
            action=""
            :on-success="handleUpload"
            :before-upload="beforeAvatarUpload"
          >
            <el-button size="small" class="upload-btn" type="primary">点击上传</el-button>
          </el-upload>
        </div>
      </div>
    </div>
    <div class="user-info-container">
      <el-form :model="userInfo" ref="userInfo" :rules="rules">
        <el-row class="demo-autocomplete">
          <el-col :span="12">
            <div class="sub-title">账号</div>
            <el-form-item prop="username">
              <el-input v-model="userInfo.username" class="inline-input" placeholder="请输入账号"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <div class="sub-title">密码</div>
            <el-form-item prop="password">
              <el-input v-model="userInfo.password" class="inline-input" placeholder="请输入密码"></el-input>
            </el-form-item>
          </el-col>
        </el-row>
        <el-row class="demo-autocomplete">
          <el-col :span="12">
            <div class="sub-title">昵称</div>
            <el-form-item prop="nickname">
              <el-input v-model="userInfo.nickname" class="inline-input" placeholder="请输入密码"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <div class="sub-title">性别</div>
            <el-form-item prop="ssex">
              <el-select v-model="userInfo.ssex" class="inline-input" placeholder="请选择">
                <el-option
                  v-for="item in sexOptions"
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
              <el-input v-model="userInfo.mobile" class="inline-input" placeholder="请输入手机号"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <div class="sub-title">邮箱</div>
            <el-form-item prop="email">
              <el-input v-model="userInfo.email" class="inline-input" placeholder="请输入邮箱"></el-input>
            </el-form-item>
          </el-col>
        </el-row>
        <el-row class="demo-autocomplete">
          <el-col :span="12">
            <div class="sub-title">状态</div>
            <el-form-item prop="status">
              <el-select v-model="userInfo.status" class="inline-input" placeholder="请选择">
                <el-option
                  v-for="item in statusOptions"
                  :key="item.value"
                  :label="item.label"
                  :value="item.value"
                ></el-option>
              </el-select>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <div class="sub-title">部门</div>
            <el-form-item>
              <tree-select
                v-model="userInfo.deptId"
                :width="340"
                :data="deptOptions"
                class="inline-input"
                :checkedKeys="defaultCheckedKeys"
                @popoverHide="popoverHide"
              ></tree-select>
            </el-form-item>
          </el-col>
        </el-row>
        <el-row class="demo-autocomplete">
          <el-col :span="24">
            <div class="sub-title">角色</div>
            <el-form-item>
              <el-select
                v-model="userInfo.roleId"
                multiple
                class="inline-textarea"
                placeholder="请选择"
              >
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
            <el-input v-model="userInfo.description" class="inline-textarea" type="textarea"></el-input>
          </el-col>
        </el-row>
      </el-form>
      <span slot="footer" class="dialog-footer">
        <el-button type="primary" @click="addUser('userInfo')">确 定</el-button>
        <el-button @click="closeDialog">取 消</el-button>
      </span>
    </div>
  </div>
</template>

<script>
import { saveUser, uploadImg } from "@/api/user";
import { fetchDeptOptions } from "@/api/dept";
import { getSexOption, getStatusOption } from "@/api/option";
import TreeSelect from "@/components/TreeSelect.vue";
import { checkPhone, checkEmail } from "@/utils/rule";

export default {
  components: {
    TreeSelect
  },
  props: {
    userInfo: Object,
    deptOptions: Array,
    roleOptions: Array
  },
  data() {
    return {
      sexOptions: [],
      statusOptions: [],
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
        mobile: [{ required: true, trigger: "blur", validator: checkPhone }],
        email: [{ required: true, trigger: "blur", validator: checkEmail }],
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
  },
  methods: {
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
    addUser(formName) {
      this.$refs[formName].validate(valid => {
        if (valid) {
          saveUser(this.userInfo).then(res => {
            this.$emit("closeDialog", 1);
            this.$message({
              message: "添加成功",
              type: "success"
            });
          });
        }
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
    closeDialog() {
      this.$emit("closeDialog");
    },
    popoverHide(key, value) {
      this.userInfo.deptId = key;
    }
  }
};
</script>

<style lang="scss" scoped>
.user-add-container {
  height: 680px;

  .user-avatar-container {
    width: 36%;
    float: left;
    height: 100%;
    display: flex;
    align-items: center;
    justify-content: center;

    .user-avatar {
      img {
        height: 180px;
        width: 180px;
        border-radius: 90px;
      }
      .upload-avatar {
        display: flex;
        justify-content: center;
        margin-top: 30px;

        .upload-btn {
          width: 120px;
        }
      }
    }
  }
  .user-info-container {
    width: 60%;
    height: 100%;
    float: right;
    display: flex;
    flex-direction: column;
    justify-content: center;
  }
  .inline-input {
    width: 90%;
  }

  .inline-textarea {
    width: 95%;
  }

  .demo-autocomplete {
    margin-bottom: 10px;
  }

  .dialog-footer {
    display: flex;
    align-items: center;
    justify-content: center;
    margin-top: 20px;

    button {
      margin-right: 60px;
    }
  }
}
</style>