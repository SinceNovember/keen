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
    var _this = this;
    _this.loadMenuPermission();
    _this.loadDeptTree();
    _this.loadDeptUserTree();
    _this.loadRoleList();
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
      var _this = this;
      fetchMenuPermission({
        menuId: _this.menuId
      }).then(res => {
        var data = res.data;
        if (data.ROLE) {
          _this.roleSelectedKeyList = data.ROLE;
        }
        if (data.DEPT) {
          _this.deptSelectedKeyList = data.DEPT;
        }
        if (data.USER) {
          _this.userSelectedKeyList = data.USER;
        }
      });
    },
    loadDeptTree() {
      var _this = this;
      fetchDeptOptions().then(res => {
        _this.deptTree = res.data;
        _this.recursiveNode(
          _this.deptTree,
          _this.deptSelectedKeyList,
          _this.deptSelectedList
        );
      });
    },
    loadDeptUserTree() {
      var _this = this;
      fetchDeptWithUserTreeModel().then(res => {
        _this.deptUserTree = res.data;
        _this.recursiveNode(
          _this.deptUserTree,
          _this.userSelectedKeyList,
          _this.userSelectedList
        );
      });
    },
    loadRoleList() {
      var _this = this;
      fetchRoleOptions().then(res => {
        _this.roleList = res.data;
        _this._roleList = _this.roleList;
      });
    },
    handleClick(tab, event) {
      this.activeName = tab.name;
    },
    addMenuPermission() {
      var _this = this,
        checkedKeys = [];
      if (_this.activeName == "ROLE") {
        checkedKeys = _this.roleSelectedKeyList;
      } else if (_this.activeName == "DEPT") {
        checkedKeys = this.$refs.deptTree.getCheckedKeys();
      } else {
        checkedKeys = this.$refs.deptUserTree.getCheckedKeys();
      }
      updateMenuPermission({
        menuId: _this.menuId,
        type: _this.activeName,
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