<template>
  <div class="menu-permission-container">
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
                <el-checkbox :label="item.value" size="medium" :value="item.value">{{ item.label }}</el-checkbox>
              </template>
            </el-checkbox-group>
          </div>
        </el-tab-pane>
        <el-tab-pane label="部门" name="DEPT">
          <tree-list ref="deptTree" :treeTitle="deptTitle" :checkStrictly="true" :treeData="deptTree"
            :selectedKeyList="deptSelectedKeyList" :selectedList="deptSelectedList"></tree-list>
        </el-tab-pane>
        <el-tab-pane label="用户" name="USER">
          <tree-list ref="userTree" :onlyLeaf="true" :treeTitle="userTitle" :treeData="userTree" treeType="user"
            :selectedKeyList="userSelectedKeyList" :selectedList="userSelectedList"></tree-list>
        </el-tab-pane>
      </el-tabs>
    </div>
  </div>
</template>

<script>
import { fetchUserTreeModel } from '@/api/system/user'
import { fetchDeptTreeModel } from "@/api/system/dept"
import { fetchRoleOptionModel } from "@/api/system/role"
import { fetchMenuPermissions, addOrUpdateMenuPermission } from "@/api/system/menu"
import TreeSelect from "@/components/TreeSelect"
import TreeList from "@/components/TreeList"

export default {
  components: {
    TreeSelect,
    TreeList
  },
  props: {
    menuId: String
  },
  data() {
    return {
      activeName: "ROLE",
      deptTitle: "授权部门",
      userTitle: "授权用户",
      deptTree: [],
      userTree: [],
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
      console.log(val)
      if (val) {
        this.roleList = this.roleList.filter(item => {
          return item.label.indexOf(val) !== -1;
        });
      } else {
        this.roleList = this._roleList;
      }
    },
  },
  mounted() {
    this.loadMenuPermission();
  },
  methods: {
    loadMenuPermission() {
      fetchMenuPermissions({
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
        this.loadRoleList()
        this.loadDeptTree()
        this.loadUserTree()
      });
    },
    loadDeptTree() {
      fetchDeptTreeModel().then(res => {
        this.deptTree = res.data;
        this.recursiveNode(
          this.deptTree,
          this.deptSelectedKeyList,
          this.deptSelectedList
        );
      });
    },
    loadUserTree() {
      fetchUserTreeModel().then(res => {
        this.userTree = res.data;
        this.recursiveNode(
          this.userTree,
          this.userSelectedKeyList,
          this.userSelectedList
        );
      });
    },
    loadRoleList() {
      fetchRoleOptionModel().then(res => {
        this.roleList = res.data;
        this._roleList = this.roleList;
      });
    },
    recursiveNode(tree, arr, toArr) {
      tree.forEach(node => {
        if (arr && arr.indexOf(node.value) != -1) {
          toArr.push(node);
        }
        if (node.children) {
          this.recursiveNode(node.children, arr, toArr);
        }
      });
    },
    handleClick(tab, event) {
      this.activeName = tab.name;
    },
    save() {
      var menuPermissionMap = {
        ROLE: this.roleSelectedKeyList,
        DEPT: this.$refs.deptTree.selectedNodeList.map(item => item.value),
        USER: this.$refs.userTree.selectedNodeList.map(item => item.value)
      }
      addOrUpdateMenuPermission({
        menuId: this.menuId,
        menuPermissionMap: menuPermissionMap
      }).then(res => {
        this.$emit("cancel")
        this.$message.success('保存成功')
      })
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
      font-size: 1.5rem;
      margin: 5px 10px;
      color: var(--bs-gray-700);


      .role-search {
        float: right;
        width: 300px;
      }
    }

    .role-body {
      margin: 20px 10px;
      min-height: 300px;

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