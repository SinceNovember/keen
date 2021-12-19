<template>
  <div class="menu-permission-container">
    <div class="dialog-title">添加菜单</div>
    <div class="permission-info-container">
      <el-tabs v-model="activeName" @tab-click="handleClick">
        <el-tab-pane label="角色" name="ROLE">
          <div class="role-header">
            <span>授权角色</span>
            <el-input class="role-search" placeholder="搜索角色名称" v-model="filterText"></el-input>
          </div>
          <div class="role-body">
            <el-checkbox-group v-model="roleSelectedKeyList">
              <template v-for="item in roleList">
                <el-checkbox
                  :label="item.value"
                  border
                  size="medium"
                  :value="item.value"
                  :key="item.value"
                >{{item.label}}</el-checkbox>
              </template>
            </el-checkbox-group>
          </div>
        </el-tab-pane>
        <el-tab-pane label="部门" name="DEPT">
          <tree-list
            ref="deptTree"
            :treeTitle="deptTitle"
            :checkStrictly="true"
            :deptTree="deptTree"
            :selectedKeyList="deptSelectedKeyList"
            :selectedList="deptSelectedList"
          ></tree-list>
        </el-tab-pane>
        <el-tab-pane label="用户" name="USER">
          <tree-list
            ref="deptUserTree"
            :onlyLeaf="true"
            :treeTitle="userTitle"
            :deptTree="deptUserTree"
            treeType="user"
            :selectedKeyList="userSelectedKeyList"
            :selectedList="userSelectedList"
          ></tree-list>
        </el-tab-pane>
      </el-tabs>
    </div>
    <div class="footer-btns">
      <el-button type="primary" @click="addMenuPermission">保存设置</el-button>
      <el-button @click="closeDialog">取消</el-button>
    </div>
  </div>
</template>

<script>
import { fetchDeptOptions, fetchDeptWithUserTreeModel } from "@/api/dept";
import { fetchMenuPermission, updateMenuPermission } from "@/api/menu";
import { fetchRoleOptions } from "@/api/role";
import TreeSelect from "@/components/TreeSelect.vue";
import TreeList from "@/components/TreeList.vue";

export default {
  components: {
    TreeSelect,
    TreeList
  },
  props: {
    menuId: Number
  },
  data() {
    return {
      activeName: "ROLE",
      deptTitle: "授权部门",
      userTitle: "授权用户",
      deptTree: [],
      deptUserTree: [],
      roleList: [],
      _roleList: [],
      checkList: [],
      filterText: "",
      roleSelectedKeyList: [],
      deptSelectedKeyList: [],
      deptSelectedList: [],
      userSelectedKeyList: [],
      userSelectedList: []
    };
  },
  watch: {
    filterText(val) {
      if (val) {
        this.roleList = this.roleList.filter(item => {
          return item.label.indexOf(val) !== -1;
        });
      } else {
        this.roleList = this._roleList;
      }
    }
  },
  mounted() {
    this.loadMenuPermission();
    this.loadDeptTree();
    this.loadDeptUserTree();
    this.loadRoleList();
  },
  methods: {
    recursiveNode(tree, arr, toArr) {
      tree.forEach(node => {
        if (arr.indexOf(node.value) != -1) {
          toArr.push(node);
        }
        if (node.children.length > 0) {
          this.recursiveNode(node.children, arr, toArr);
        }
      });
    },
    loadMenuPermission() {
      fetchMenuPermission({
        menuId: this.menuId
      }).then(res => {
        var data = res.data;
        if (data.ROLE) {
          this.roleSelectedKeyList = data.ROLE;
        }
        if (data.DEPT) {
          this.deptSelectedKeyList = data.DEPT;
        }
        if (data.USER) {
          this.userSelectedKeyList = data.USER;
        }
      });
    },
    loadDeptTree() {
      fetchDeptOptions().then(res => {
        this.deptTree = res.data;
        this.recursiveNode(
          this.deptTree,
          this.deptSelectedKeyList,
          this.deptSelectedList
        );
      });
    },
    loadDeptUserTree() {
      fetchDeptWithUserTreeModel().then(res => {
        this.deptUserTree = res.data;
        this.recursiveNode(
          this.deptUserTree,
          this.userSelectedKeyList,
          this.userSelectedList
        );
      });
    },
    loadRoleList() {
      fetchRoleOptions().then(res => {
        this.roleList = res.data;
        this._roleList = this.roleList;
      });
    },
    handleClick(tab, event) {
      this.activeName = tab.name;
    },
    addMenuPermission() {
      var checkedKeys = [];
      if (this.activeName == "ROLE") {
        checkedKeys = this.roleSelectedKeyList;
      } else if (this.activeName == "DEPT") {
        checkedKeys = this.$refs.deptTree.getCheckedKeys();
      } else {
        checkedKeys = this.$refs.deptUserTree.getCheckedKeys();
      }
      updateMenuPermission({
        menuId: this.menuId,
        type: this.activeName,
        permissionIdList: checkedKeys
      }).then(res => {
        this.closeDialog();
        this.$message({
          message: "修改成功",
          type: "success"
        });
      });
    },
    closeDialog() {
      this.$emit("closeDialog");
    }
  }
};
</script>

<style lang="scss" scoped>
.menu-permission-container {
  .dialog-title {
    font-size: 20px;
    padding: 10px 20px;
  }

  .permission-info-container {
    height: 100%;

    .role-header {
      height: 30px;
      font-size: 18px;
      margin: 5px 10px;

      .role-search {
        float: right;
        width: 300px;
      }
    }

    .role-body {
      margin: 20px 10px;
      min-height: 400px;

      .el-checkbox {
        margin: 10px 20px;
      }
    }
  }

  .footer-btns {
    margin-top: 10px;
    height: 100px;
    display: flex;
    align-items: center;
    justify-content: center;
  }
  .inline-textarea {
    width: 650px;
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