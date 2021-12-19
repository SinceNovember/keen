<template>
  <div class="form-container">
    <div class="form-table">
      <el-table
        ref="multipleTable"
        :data="roles"
        tooltip-effect="dark"
        style="width: 100%"
        @selection-change="handleSelectionChange"
      >
        <el-table-column type="selection" width="55"></el-table-column>
        <el-table-column label="序" type="index" width="80"></el-table-column>
        <el-table-column label="角色名称" prop="roleName" width="300"></el-table-column>
        <el-table-column label="角色标识" prop="roleTag" width="240"></el-table-column>
        <el-table-column label="状态" width="200" show-overflow-tooltip>
          <template slot-scope="{row}">
            <span class="status-tag" :class="row.status =='LOCK' ? 'danger' : '' "></span>
            {{row.status | StatusInfoFilter}}
          </template>
        </el-table-column>
        <el-table-column prop="orderNum" label="排序号" width="180" sortable show-overflow-tooltip></el-table-column>
        <el-table-column prop="createTime" label="创建时间" show-overflow-tooltip></el-table-column>
        <el-table-column label="操作" width="120" show-overflow-tooltip>
          <template slot-scope="{row}">
            <div class="handle-icon">
              <i class="bx bxs-edit-alt" @click="edit(row)"></i>
            </div>
            <div class="handle-icon">
              <i class="bx bx-x" @click="deleteOne(row)"></i>
            </div>
            <el-dropdown @command="openRelateDialog(row)" trigger="click">
              <div class="handle-icon">
                <i class="bx bx-dots-vertical-rounded"></i>
              </div>
              <el-dropdown-menu slot="dropdown">
                <el-dropdown-item icon="el-icon-copy-document">角色分配</el-dropdown-item>
              </el-dropdown-menu>
            </el-dropdown>
          </template>
        </el-table-column>
      </el-table>
    </div>
    <div class="form-pagination">
      <el-pagination
        background
        @size-change="handleSizeChange"
        @current-change="handleCurrentChange"
        :current-page.sync="currentPage"
        layout="prev, pager, next, jumper,sizes, total"
        :total="total"
      ></el-pagination>
    </div>

    <el-dialog v-if="dialogVisible==true" :visible.sync="dialogVisible" width="50rem">
      <role-user-relate ref="roleUserInfo" :roleInfo="roleInfo" @closeDialog="dialogVisible=false"></role-user-relate>
    </el-dialog>
  </div>
</template>

<script>
import { fetchDeptWithUserTreeModel } from "@/api/dept";
import { fetchRoles, deleteRole, toggleRoleStatus, fetchRoleUserRelate } from "@/api/role";
import RoleInfo from "./RoleInfo";
import RoleUserRelate from "./RoleUserRelate";

export default {
  components: {
    RoleInfo,
    RoleUserRelate
  },
  data() {
    return {
      roles: [],
      currentPage: 1,
      pageSize: 10,
      total: 0,
      roleInfo: "",
      params: {
        roleName: "",
        roleTag: "",
        status: "",
        currentPage: 1,
        pageSize: 10
      },
      multipleSelection: [],
      dialogVisible: false
    };
  },
  mounted() {
    this.loadRoles();
  },
  methods: {
    searchTable(params) {
      if (params) {
        this.params.roleName = params.roleName;
        this.params.roleTag = params.roleTag;
        this.params.status = params.status;
      }
      this.loadRoles(this.currentPage, this.pageSize);
    },
    loadRoles(currentPage, pageSize) {
      this.params.currentPage = currentPage;
      this.params.pageSize = pageSize;
      fetchRoles(this.params).then(res => {
        this.roles = res.data.records;
        this.total = res.data.total;
      });
    },
    handleSelectionChange(val) {
      this.multipleSelection = val;
    },
    handleSizeChange(pageSize) {
      this.pageSize = pageSize;
      this.loadRoles(this.currentPage, pageSize);
    },
    handleCurrentChange(currentPage) {
      this.currentPage = currentPage;
      this.loadRoles(currentPage, this.pageSize);
    },
    deleteOne(row) {
      this.$confirm("确定要删除该角色?", "提示", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning"
      }).then(() => {
        this.handleDelete(row.roleId);
      });
    },
    deleteSelect() {
      var idList = new Array();
      if (this.multipleSelection.length > 0) {
        this.$confirm("确定要删除选中的角色?", "提示", {
          confirmButtonText: "确定",
          cancelButtonText: "取消",
          type: "warning"
        }).then(() => {
          this.multipleSelection.map(item => {
            idList.push(item.roleId);
          });
          this.handleDelete(idList.toString());
        });
      } else {
        this.$message({
          message: "未选择角色",
          type: "info"
        });
      }
    },

    handleDelete(id) {
      deleteRole({
        ids: id
      }).then(res => {
        this.$message({
          message: res.msg,
          type: "success"
        });
        this.loadRoles(this.currentPage, this.pageSize);
      });
    },
    edit(row) {
      this.$emit("openEditDialog", row.roleId);
    },
    updateRoleStatus() {
      var idList = new Array();
      if (this.multipleSelection.length > 0) {
        this.$confirm("确定要启用/禁用选中的角色?", "提示", {
          confirmButtonText: "确定",
          cancelButtonText: "取消",
          type: "warning"
        }).then(() => {
          this.multipleSelection.map(item => {
            idList.push(item.roleId);
          });

          toggleRoleStatus({
            ids: idList.toString()
          }).then(res => {
            this.$message({
              message: "启用/禁用成功",
              type: "success"
            });
            this.loadRoles(this.currentPage, this.pageSize);
          });
        });
      } else {
        this.$message({
          message: "未选择角色",
          type: "info"
        });
      }
    },
    openRelateDialog(row) {
      this.dialogVisible = true;
      this.roleInfo = row;
    }
  }
};
</script>

<style lang="scss" scoped>
</style>