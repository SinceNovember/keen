<template>
  <div class="form-container">
    <div class="form-table">
      <el-table
        ref="multipleTable"
        :data="logs"
        tooltip-effect="dark"
        style="width: 100%"
        @selection-change="handleSelectionChange"
      >
        <el-table-column type="selection" width="55"></el-table-column>
        <el-table-column label="登陆用户" prop="nickname" width="180"></el-table-column>
        <el-table-column label="IP地址" prop="ip" width="180"></el-table-column>
        <el-table-column label="登陆地点" prop="location" show-overflow-tooltip></el-table-column>
        <el-table-column label="登陆时间" prop="loginTime" width="180" show-overflow-tooltip></el-table-column>
        <el-table-column label="登陆系统" prop="system" width="180" show-overflow-tooltip></el-table-column>
        <el-table-column label="浏览器" prop="browser" width="180" show-overflow-tooltip></el-table-column>
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
  </div>
</template>

<script>
import { fetchLoginLogs, deleteLoginLog } from '@/api/monitor'


export default {

  data() {
    return {
      logs: [],
      currentPage: 1,
      pageSize: 10,
      total: 0,
      params: {
        nickname: "",
        createTimeFrom: "",
        createTimeTo: "",
        currentPage: 1,
        pageSize: 10
      },
      multipleSelection: [],
    };
  },
  mounted() {
    this.loadLogs();
  },
  methods: {
    searchTable(params) {
      if (params) {
        this.params.nickname = params.nickname;
        this.params.createTimeFrom = params.createTimeFrom;
        this.params.createTimeTo = params.createTimeTo;
      }
      this.loadLogs(this.currentPage, this.pageSize);
    },
    loadLogs(currentPage, pageSize) {
      this.params.currentPage = currentPage;
      this.params.pageSize = pageSize;
      fetchLoginLogs(this.params).then(res => {
        this.logs = res.data.records;
        this.total = res.data.total;
      });
    },
    handleSelectionChange(val) {
      this.multipleSelection = val;
    },
    handleSizeChange(pageSize) {
      this.pageSize = pageSize;
      this.loadLogs(this.currentPage, pageSize);
    },
    handleCurrentChange(currentPage) {
      this.currentPage = currentPage;
      this.loadLogs(currentPage, this.pageSize);
    },
    deleteSelect() {
      var idList = new Array();
      if (this.multipleSelection.length > 0) {
        this.$confirm("确定要删除选中的日志?", "提示", {
          confirmButtonText: "确定",
          cancelButtonText: "取消",
          type: "warning"
        }).then(() => {
          this.multipleSelection.map(item => {
            idList.push(item.id);
          });
          this.handleDelete(idList.toString());
        });
      } else {
        this.$message({
          message: "未选择日志",
          type: "info"
        });
      }
    },
    handleDelete(id) {
      deleteLoginLog({
        ids: id
      }).then(res => {
        this.$message({
          message: res.msg,
          type: "success"
        });
        this.loadLogs(this.currentPage, this.pageSize);
      });
    },
  }
};
</script>

<style lang="scss" scoped>

</style>