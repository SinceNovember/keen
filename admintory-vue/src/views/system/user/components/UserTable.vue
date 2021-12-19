<template>
  <div class="form-container">
    <div class="form-table">
      <el-table
        ref="multipleTable"
        :data="users"
        tooltip-effect="dark"
        style="width: 100%"
        @selection-change="handleSelectionChange"
      >
        <el-table-column type="selection" width="55"></el-table-column>
        <el-table-column type="expand" width="25" align="center">
          <template slot-scope="{row}">
            <el-form label-position="left" inline class="demo-table-expand">
              <user-info :userInfo="row"></user-info>
            </el-form>
          </template>
        </el-table-column>
        <el-table-column label="用户名" width="150">
          <template slot-scope="{row}">
            <img class="avatar" :src="row.avatar" />
            {{ row.username }}
          </template>
        </el-table-column>
        <el-table-column label="昵称" prop="nickname" width="150"></el-table-column>
        <el-table-column label="性别" width="120">
          <template slot-scope="{row}">{{row.ssex | SexFilter}}</template>
        </el-table-column>
        <el-table-column prop="deptName" label="部门" show-overflow-tooltip></el-table-column>
        <el-table-column prop="mobile" label="手机" show-overflow-tooltip></el-table-column>
        <el-table-column prop="email" label="邮箱" show-overflow-tooltip></el-table-column>
        <el-table-column label="状态" width="100" show-overflow-tooltip>
          <template slot-scope="{row}">
            <span class="status-tag" :class="row.status =='LOCK' ? 'danger' : '' "></span>
            {{row.status | StatusInfoFilter}}
            <!-- <el-tag :type="row.status | StatusFilter">{{row.status | StatusInfoFilter}}</el-tag> -->
          </template>
        </el-table-column>
        <el-table-column prop="createTime" label="创建时间" sortable show-overflow-tooltip></el-table-column>
        <el-table-column label="操作" width="120" show-overflow-tooltip>
          <template slot-scope="{row}">
            <!-- <div class='handle-icon'><i class='bx bxs-edit-alt' @click="edit(row)"></i></div> -->
            <div class="handle-icon">
              <i class="bx bx-x" @click="deleteOne(row)"></i>
            </div>
            <div class="handle-icon">
              <i class="bx bx-refresh" @click="resetPass(row)"></i>
            </div>
            <!-- <el-dropdown @command="openRelateDialog(row)"> -->
            <el-dropdown @command="handleCommand" trigger="click">
              <div class="handle-icon">
                <i class="bx bx-dots-vertical-rounded"></i>
              </div>
              <el-dropdown-menu slot="dropdown">
                <el-dropdown-item
                  icon="el-icon-copy-document"
                  :command="beforeHandleCommand(row,'role')"
                >分配角色</el-dropdown-item>
                <el-dropdown-item
                  icon="el-icon-s-operation"
                  :command="beforeHandleCommand(row,'dept')"
                >调整部门</el-dropdown-item>
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
      <user-role-relate ref="userRoleInfo" :userInfo="userInfo" @closeDialog="dialogVisible=false"></user-role-relate>
    </el-dialog>
    <el-dialog
      v-if="deptDialogVisible==true"
      :visible.sync="deptDialogVisible"
      width="50rem"
    >
      <user-dept-relate ref="userDeptInfo" :userInfo="userInfo" @closeDialog="closeDeptDialog"></user-dept-relate>
    </el-dialog>
  </div>
</template>

<script>
import {
  fetchUsers,
  deleteUser,
  toggleUserStatus,
  resetPassword
} from "@/api/user";
import UserInfo from "./UserInfo";
import UserRoleRelate from "./UserRoleRelate";
import UserDeptRelate from "./UserDeptRelate";

export default {
  components: {
    UserInfo,
    UserRoleRelate,
    UserDeptRelate
  },
  data() {
    return {
      users: [],
      userInfo: "",
      currentPage: 1,
      pageSize: 10,
      total: 0,
      params: {
        nickname: "",
        deptId: null,
        ssex: null,
        status: null,
        currentPage: 1,
        pageSize: 10
      },
      dialogVisible: false,
      deptDialogVisible: false,
      multipleSelection: []
    };
  },
  mounted() {
    var _this = this;
    _this.loadUsers();
  },
  methods: {
    searchTable(params) {
      var _this = this;
      if (params) {
        _this.params.nickname = params.nickname;
        _this.params.deptId = params.deptId;
        _this.params.ssex = params.ssex;
        _this.params.status = params.status;
      }
      _this.loadUsers(_this.currentPage, _this.pageSize);
    },
    loadUsers(currentPage, pageSize) {
      var _this = this;
      _this.params.currentPage = currentPage;
      _this.params.pageSize = pageSize;
      fetchUsers(_this.params).then(res => {
        _this.users = res.data.records;
        _this.total = res.data.total;
      });
    },
    handleSelectionChange(val) {
      this.multipleSelection = val;
    },
    handleSizeChange(pageSize) {
      this.pageSize = pageSize;
      this.loadUsers(this.currentPage, pageSize);
    },
    handleCurrentChange(currentPage) {
      this.currentPage = currentPage;
      this.loadUsers(currentPage, this.pageSize);
    },
    deleteOne(row) {
      this.$confirm("确定要删除该用户?", "提示", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning"
      }).then(() => {
        this.handleDelete(row.userId);
      });
    },
    resetPass(row) {
      this.$confirm("确定要重置该用户密码?", "提示", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning"
      }).then(() => {
        resetPassword(row.userId).then(res => {
          this.$message({
            message: "密码重置成功",
            type: "success"
          });
        });
      });
    },
    deleteSelect() {
      var idList = new Array();
      if (this.multipleSelection.length > 0) {
        this.$confirm("确定要删除选中的用户?", "提示", {
          confirmButtonText: "确定",
          cancelButtonText: "取消",
          type: "warning"
        }).then(() => {
          this.multipleSelection.map(item => {
            idList.push(item.userId);
          });
          this.handleDelete(idList.toString());
        });
      } else {
        this.$message({
          message: "未选择用户",
          type: "info"
        });
      }
    },
    handleDelete(ids) {
      deleteUser({
        ids: ids
      }).then(res => {
        this.loadUsers(this.currentPage, this.pageSize);
        this.$message({
          message: "删除成功",
          type: "success"
        });
      });
    },
    edit(row) {
      this.$emit("openEditDialog", row.userId);
    },
    updateUserStatus() {
      var idList = new Array();
      if (this.multipleSelection.length > 0) {
        this.$confirm("确定要启用/禁用选中的用户?", "提示", {
          confirmButtonText: "确定",
          cancelButtonText: "取消",
          type: "warning"
        }).then(() => {
          this.multipleSelection.map(item => {
            idList.push(item.userId);
          });
          toggleUserStatus({
            ids: idList.toString()
          }).then(res => {
            this.loadUsers(this.currentPage, this.pageSize);
            this.$message({
              message: "启用/禁用成功",
              type: "success"
            });
          });
        });
      } else {
        this.$message({
          message: "未选择用户",
          type: "info"
        });
      }
    },

    beforeHandleCommand(row, command) {
      return {
        row: row,
        command: command
      };
    },
    handleCommand(command) {
      switch (command.command) {
        case "role": //编辑
          this.openRoleRelateDialog(command.row);
          break;
        case "dept": //删除
          this.openDeptRelateDialog(command.row);
          break;
      }
    },
    openRoleRelateDialog(row) {
      this.dialogVisible = true;
      this.userInfo = row;
    },

    openDeptRelateDialog(row) {
      this.deptDialogVisible = true;
      this.userInfo = row;
    },
    closeDeptDialog() {
      this.deptDialogVisible = false;
      this.searchTable();
    }
  }
};
</script>

<style lang="scss" scoped>
.avatar {
  height: 36px;
  width: 36px;
  border-radius: 90px;
  margin-right: 10px;
}
</style>