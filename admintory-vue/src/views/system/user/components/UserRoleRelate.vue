<template>
  <div class="add-container">
    <div class="dialog-title">分配角色</div>
    <div class="info-container">
      <el-form :model="userInfo" label-position="right" label-width="80px" ref="roleInfo">
        <el-form-item label="账号" prop="roleName">
          <el-input v-model="userInfo.username" :disabled="true"></el-input>
        </el-form-item>
        <el-form-item label="昵称">
          <el-input v-model="userInfo.nickname" :disabled="true"></el-input>
        </el-form-item>
        <el-form-item label="角色">
          <el-select v-model="checkedIds" multiple class="select-input" placeholder="请选择">
            <el-option
              v-for="item in roleOptions"
              :key="item.value"
              :label="item.label"
              :value="item.value"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="modifyRole">确认</el-button>
          <el-button @click="closeDialog">取消</el-button>
        </el-form-item>
      </el-form>
    </div>
  </div>
</template>

<script>
import { fetchRoleOptions, updateRoleUserRelate } from "@/api/role";
import { fetchUserRoleRelate, updateUserRoleRelate } from "@/api/user";
export default {
  props: {
    userInfo: Object
  },
  data() {
    return {
      roleOptions: [],
      checkedIds: []
    };
  },
  mounted() {
    this.loadRoleModel();
  },

  methods: {
    loadRoleModel() {
      fetchRoleOptions().then(res => {
        this.roleOptions = res.data;
        fetchUserRoleRelate({
          userId: this.userInfo.userId
        }).then(res => {
          this.checkedIds = res.data;
        });
      });
    },

    modifyRole() {
      updateUserRoleRelate({
        userId: this.userInfo.userId,
        roleId: this.checkedIds
      }).then(res => {
        this.$message({
          message: "修改成功",
          type: "success"
        });
        closeDialog();
      });
    },
    closeDialog() {
      this.$emit("closeDialog");
    }
  }
};
</script>

<style lang="scss" scoped>
.select-input {
  width: 100%;
}
</style>