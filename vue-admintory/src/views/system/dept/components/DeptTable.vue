<template>
  <div class="form-container">
    <div class="dept-form-table">
      <el-table
        ref="multipleTable"
        :data="depts"
        row-key="deptId"
        tooltip-effect="dark"
        style="width: 100%"
        :tree-props="{children: 'children', hasChildren: 'hasChildren'}"
        @selection-change="handleSelectionChange"
      >
        <el-table-column type="selection" width="55">
          <i class="bx bxs-folder"></i>
        </el-table-column>
        <el-table-column prop="deptName" label="部门名称" width="240"></el-table-column>
        <el-table-column prop="deptShortName" label="部门简称" width="200"></el-table-column>
        <el-table-column prop="createUser.username" label="创建者" width="220"></el-table-column>
        <el-table-column prop="address" label="部门成员" width="240">
          <template slot-scope="{row}">
            <template v-for="(member, idx) in row.memberList">
              <img v-if="idx <= 2" class="avatar" :src="member.avatar" :key="idx" />
            </template>
            <template v-if="row.memberList.length > 3">
              <div class="avatar more" @click="openUserListDialog(row)">
                <span>+{{row.memberList.length - 3}}</span>
              </div>
            </template>
          </template>
        </el-table-column>
        <el-table-column prop="createTime" label="创建时间"></el-table-column>
        <el-table-column prop="orderNum" sortable label="排序"></el-table-column>
        <el-table-column label="操作" width="120" show-overflow-tooltip>
          <template slot-scope="{row}">
            <div class="handle-icon">
              <i class="bx bxs-edit-alt" @click="edit(row)"></i>
            </div>
            <div class="handle-icon">
              <i class="bx bx-x" @click="deleteOne(row)"></i>
            </div>
            <div class="handle-icon">
              <i class="bx bx-dots-vertical-rounded"></i>
            </div>
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
    <el-dialog :visible.sync="dialogVisible" v-if="dialogVisible" width="18%" height="300px">
      <dept-user-list
        :userList="userList"
      ></dept-user-list>
    </el-dialog>
  </div>
</template>

<script>
import { fetchDepts, deleteDept } from '@/api/dept'
import DeptInfo from './DeptInfo'
import DeptUserList from './DeptUserList'

export default {
  components: {
    DeptInfo,
    DeptUserList
  },
  data() {
    return {
      depts: [],
      currentPage: 1,
      pageSize: 10,
      total: 0,
      params: {
        deptName: "",
        username: "",
        currentPage: 1,
        pageSize: 10
      },
      multipleSelection: [],
      dialogVisible: false,
      userList: [],
    };
  },
  mounted() {
    this.loadDepts();
  },
  methods: {
    searchTable(params) {
      var _this = this;
      if (params) {
        _this.params.deptName = params.deptName
        _this.params.username = params.username
      }
      _this.loadDepts(_this.currentPage, _this.pageSize);
    },
    loadDepts(currentPage, pageSize) {
      var _this = this
      _this.params.currentPage = currentPage
      _this.params.pageSize = pageSize
      fetchDepts(_this.params).then(res => {
        _this.depts = res.data.records
        _this.total = res.data.total
      });
    },

    handleSelectionChange(val) {
      this.multipleSelection = val
    },
    handleSizeChange(pageSize) {
      this.pageSize = pageSize
      this.loadDepts(this.currentPage, pageSize)
    },
    handleCurrentChange(currentPage) {
      this.currentPage = currentPage
      this.loadDepts(currentPage, this.pageSize)
    },
    deleteOne(row) {
      this.$confirm("确定要删除该部门?", "提示", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning"
      }).then(() => {
        this.handleDelete(row.deptId)
      });
    },
    handleDelete(id) {
      deleteDept({
        id: id
      }).then(res => {
        this.loadDepts(this.currentPage, this.pageSize)
        this.$message({
          message: res.msg,
          type: "success"
        })
      })
    },
    edit(row) {
      this.$emit("openEditDialog", row.deptId)
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
            this.$message({
              message: "启用/禁用成功",
              type: "success"
            });
            this.loadDepts(this.currentPage, this.pageSize);
          });
        });
      } else {
        this.$message({
          message: "未选择用户",
          type: "info"
        });
      }
    },
    openUserListDialog(row){
      this.dialogVisible = true
      this.userList = row.memberList
    }
  }
};
</script>

<style lang="scss" scoped>
.form-container {

  .dept-form-table {
    .bxs-folder {
      color: #4f46e5;
      font-size: 18px;
    }

    .avatar {
      height: 36px;
      width: 36px;
      background-color: #e5e7eb;
      border-radius: 90px;
      border: 2px solid #fff;
      margin-right: -8px;
      display: flex;
      justify-content: center;
      align-items: center;
    }

    .more {
      cursor: pointer;
    }

  }
}

</style>