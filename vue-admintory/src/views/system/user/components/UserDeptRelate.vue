<template>
  <div class="add-container">
    <div class="dialog-title">调整部门</div>
    <div class="info-container">
      <el-form :model="userInfo" label-position="right" label-width="80px" ref="roleInfo">
        <el-form-item label="账号" prop="roleName">
          <el-input v-model="userInfo.username" :disabled="true"></el-input>
        </el-form-item>
        <el-form-item label="昵称">
          <el-input v-model="userInfo.nickname" :disabled="true"></el-input>
        </el-form-item>
        <el-form-item label="部门">
          <tree-select
            v-model="deptId"
            :width="340"
            :data="deptOptions"
            nodeKey="value"
            :checkedKeys="defaultCheckedKeys"
            @popoverHide="popoverHide"
          ></tree-select>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="modifyDept">确认</el-button>
          <el-button @click="closeDialog">取消</el-button>
        </el-form-item>
      </el-form>
    </div>
  </div>
</template>

<script>
import {  updateUserDept } from "@/api/user";
import { fetchDeptOptions} from "@/api/dept";
import TreeSelect from "@/components/TreeSelect.vue";

export default {
  components: {
    TreeSelect
  },
  props: {
    userInfo: Object
  },
  data() {
    return {
      roleOptions: [],
      checkedIds: [],
      deptOptions: [],
      deptId: "",
      defaultCheckedKeys: []
    };
  },
  mounted() {
    this.defaultCheckedKeys = [this.userInfo.deptId];
    this.loadDeptOptions();
  },

  methods: {
    loadDeptOptions() {
      fetchDeptOptions().then(res => {
        this.deptOptions = res.data;
      });
    },
    modifyDept() {
      var _this = this;
      updateUserDept({
        userId: _this.userInfo.userId,
        deptId: _this.deptId
      }).then(res => {
        this.$message({
          message: "修改成功",
          type: "success"
        });
        this.$emit("closeDialog");
      });
    },
    popoverHide(key, value) {
      this.deptId = key
    },
    closeDialog() {
      this.$emit("closeDialog");
    }
  }
};
</script>

<style lang="scss" scoped>
</style>