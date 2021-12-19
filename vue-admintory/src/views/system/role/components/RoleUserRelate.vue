<template>
  <div class="add-container">
    <div class="dialog-title">用户角色关系</div>
    <div class="info-container">
      <el-form :model="roleInfo" label-position="right" label-width="80px" ref="roleInfo">
        <el-form-item label="角色名称" prop="roleName">
          <el-input v-model="roleInfo.roleName" :disabled="true" class="inline-input"></el-input>
        </el-form-item>
        <el-form-item label="角色标识">
          <el-input v-model="roleInfo.roleTag" :disabled="true" class="inline-input"></el-input>
        </el-form-item>
        <el-form-item label="用户列表">
          <div class="user-tree-container">
            <el-tree
              :data="treeModel"
              show-checkbox
              node-key="value"
              ref="tree"
              :default-expanded-keys="checkedIds"
              :default-checked-keys="checkedIds"
              highlight-current
            ></el-tree>
          </div>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="addRelate">确认</el-button>
          <el-button @click="closeDialog">取消</el-button>
        </el-form-item>
      </el-form>
    </div>
  </div>
</template>

<script>
import { fetchDeptWithUserTreeModel } from "@/api/dept";
import { fetchRoleUserRelate, updateRoleUserRelate } from "@/api/role";
export default {
  props: {
    roleInfo: Object
  },
  data() {
    return {
      treeModel: [],
      checkedIds: []
    };
  },
  mounted() {
    this.loadTreeModel();
  },
  methods: {
    loadTreeModel() {
      fetchDeptWithUserTreeModel().then(res => {
        this.treeModel = res.data;
        fetchRoleUserRelate({
          roleId: this.roleInfo.roleId
        }).then(res => {
          this.checkedIds = res.data;
        });
      });
    },
    addRelate() {
      var checkedUserIds = [];
      this.$refs.tree.getCheckedNodes().forEach(node => {
        if (node.nodeType == 1) {
          checkedUserIds.push(node.value);
        }
      });
      updateRoleUserRelate({
        roleId: this.roleInfo.roleId,
        userIdList: checkedUserIds
      }).then(res => {
        this.$message({
          message: "修改成功",
          type: "success"
        });
        this.$emit("closeDialog");
      });
    },
    closeDialog() {
      this.$emit("closeDialog");
    }
  }
};
</script>

<style lang="scss" scoped>
.user-tree-container {
  border: 1px solid #ebebeb;
  border-radius: 4px;
  min-height: 200px;
}
</style>