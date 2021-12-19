<template>
  <div class="form-header">
    <el-row>
      <el-col :xs="24" :sm="12">
        <div class="search-header">
          <el-input
            v-model="nickname"
            class="search-input"
            placeholder="昵称"
            clearable
            @change="search"
          ></el-input>
          <tree-select
            v-model="deptId"
            :data="deptOptions"
            clearable
            class="search-input"
            @popoverHide="popoverHide"
            @change="searchDept"
          ></tree-select>

          <el-select v-model="sex" placeholder="性别" class="search-input" clearable @change="search">
            <el-option
              v-for="item in sexOptions"
              :key="item.value"
              :label="item.label"
              :value="item.value"
            ></el-option>
          </el-select>
          <el-select
            v-model="status"
            placeholder="状态"
            class="search-input"
            clearable
            @change="search"
          >
            <el-option
              v-for="item in statusOptions"
              :key="item.value"
              :label="item.label"
              :value="item.value"
            ></el-option>
          </el-select>
        </div>
      </el-col>
      <el-col :xs="24" :sm="12">
        <div class="btn-header">
          <div class="other-btn">
            <i class="bx bx-dots-vertical-rounded"></i>
          </div>
          <el-button @click="toggleUserStatus">启用/禁用</el-button>
          <el-button type="primary" icon="el-icon-plus" @click="dialogVisible = true">添加用户</el-button>
          <el-button type="danger" icon="el-icon-plus" @click="deleteSelect" plain>删除选中</el-button>
        </div>
      </el-col>
    </el-row>

    <el-dialog :visible.sync="dialogVisible" v-if="dialogVisible" width="75rem">
      <user-add
        :userInfo="userInfo"
        :deptOptions="deptOptions"
        :roleOptions="roleOptions"
        @closeDialog="closeUserDialog"
      ></user-add>
    </el-dialog>
  </div>
</template>

<script>
import { getUser } from "@/api/user";
import { getSexOption, getStatusOption } from "@/api/option";
import { fetchDeptOptions } from "@/api/dept";
import { fetchRoleOptions } from "@/api/role";
import TreeSelect from "@/components/TreeSelect.vue";
import UserAdd from "./UserAdd";

export default {
  components: {
    UserAdd,
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
        status: "VALID",
        deptId: "",
        roleId: "",
        description: ""
      },
      dialogVisible: false,
      users: [],
      userId: "",
      nickname: "",
      deptId: "",
      sex: "",
      status: "",
      deptOptions: [],
      roleOptions: [],
      sexOptions: [],
      statusOptions: []
    };
  },
  mounted() {
    this.loadSexOption();
    this.loadStatusOption();
    this.loadDeptOptions();
    this.loadRoleOptions();
  },
  methods: {
    search() {
      var params = {
          nickname: this.nickname,
          ssex: this.sex,
          status: this.status,
          deptId: this.deptId
        };
      this.$emit("search", params);
    },
    searchDept(deptId) {
      this.deptId = deptId;
      this.search();
    },
    deleteSelect() {
      this.$emit("deleteSelect");
    },
    toggleUserStatus() {
      this.$emit("toggleUserStatus");
    },
    closeUserDialog(type) {
      if (type) {
        this.$emit("search");
        this.clearForm();
      }
      this.dialogVisible = false;
    },
    openUserDialog(userId) {
      this.dialogVisible = true;
      this.userId = userId;
      getUser({
        userId: userId
      }).then(res => {
        this.userInfo = res.data;
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
    clearForm() {
      this.userInfo.avatar =
        "http://47.104.70.138:8080/febs/images/avatar/cnrhVkzwxjPwAaCfPbdc.png";
      this.userInfo.username = "";
      this.userInfo.password = "";
      this.userInfo.nickname = "";
      this.userInfo.mobile = "";
      this.userInfo.email = "";
      this.userInfo.ssex = "";
      this.userInfo.status = "VALID";
      this.userInfo.deptId = "";
      this.userInfo.roleId = "";
      this.userInfo.description = "";
    },
    popoverHide(key, value) {
      this.deptId = key;
    }
  }
};
</script>

<style  lang="scss" scoped>
.el-row {
  width: 100%;
}
.search-input {
  width: 20%;
}
</style>