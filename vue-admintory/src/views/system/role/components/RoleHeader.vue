<template>
  <div class="form-header">
    <el-row>
      <el-col :xs="24" :sm="12">
        <div class="search-header">
          <el-input
            v-model="roleName"
            class="search-input"
            placeholder="角色名称"
            clearable
            @change="search"
          ></el-input>
          <el-input
            v-model="roleTag"
            class="search-input"
            placeholder="角色标志"
            clearable
            @change="search"
          ></el-input>
          <el-select
            v-model="status"
            placeholder="状态"
            clearable
            class="search-input"
            @change="search"
          >
            <el-option
              v-for="item in statusOptions"
              :key="item.value"
              :label="item.label"
              :value="item.value"
            ></el-option>
          </el-select>
          <!-- <el-button  type="primary" plain icon="el-icon-search"  @click="search" ></el-button> -->
        </div>
      </el-col>
      <el-col :xs="24" :sm="12">
        <div class="btn-header">
          <div class="other-btn">
            <i class="bx bx-dots-vertical-rounded"></i>
          </div>
          <el-button @click="toggleRoleStatus">启用/禁用</el-button>
          <el-button type="primary" icon="el-icon-plus" @click="openRoleDialog('')">添加角色</el-button>
          <el-button type="danger" icon="el-icon-plus" @click="deleteSelect" plain>删除选中</el-button>
        </div>
      </el-col>
    </el-row>

    <el-dialog :visible.sync="dialogVisible" v-if="dialogVisible" width="50rem" height="500px">
      <role-add :roleInfo="roleInfo" @closeDialog="closeRoleDialog"></role-add>
    </el-dialog>
  </div>
</template>

<script>
import { getRole } from "@/api/role";
import { getStatusOption } from "@/api/option";

import RoleAdd from "./RoleAdd";

export default {
  components: {
    RoleAdd
  },
  data() {
    return {
      roleInfo: {
        roleName: "",
        roleTag: "",
        status: "VALID",
        orderNum: "",
        description: ""
      },
      dialogVisible: false,
      roleName: "",
      roleId: "",
      roleTag: "",
      status: "",
      deptOptions: [],
      statusOptions: []
    };
  },
  mounted() {
    this.loadStatusOption();
  },
  methods: {
    loadStatusOption() {
      getStatusOption().then(res => {
        this.statusOptions = res.data;
      });
    },
    search() {
      var params = {
        roleName: this.roleName,
        roleTag: this.roleTag,
        status: this.status
      };
      this.$emit("search", params);
    },
    toggleRoleStatus() {
      this.$emit("toggleRoleStatus");
    },
    closeRoleDialog(type) {
      if (type) {
        this.$emit("search");
      }
      this.dialogVisible = false;
    },
    deleteSelect() {
      this.$emit("deleteSelect");
    },
    openRoleDialog(roleId) {
      this.dialogVisible = true;
      if (roleId) {
        this.roleId = roleId;
        getRole({
          roleId: roleId
        }).then(res => {
          this.roleInfo = res.data;
        });
      } else {
        this.clearForm();
      }
    },
    clearForm() {
      this.roleInfo.roleId = "";
      this.roleInfo.roleName = "";
      this.roleInfo.roleTag = "";
      this.roleInfo.status = "VALID";
      this.roleInfo.orderNum = "";
      this.roleInfo.description = "";
    }
  }
};
</script>

<style  lang="scss" scoped>
.search-input {
  width: 28%;
}
.el-row{
  width: 100%;
}

</style>