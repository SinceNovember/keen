<template>
  <div class="form-container">
    <div class="form-table">
      <el-table
        ref="multipleTable"
        :data="configs"
        tooltip-effect="dark"
        style="width: 100%"
        @selection-change="handleSelectionChange"
      >
        <el-table-column type="selection" width="55"></el-table-column>
        <el-table-column label="序" type="index" width="80"></el-table-column>
        <el-table-column label="参数名称" prop="configName" width="300"></el-table-column>
        <el-table-column label="参数值" prop="configValue" width="240"></el-table-column>
        <el-table-column label="参数描述" prop="description"></el-table-column>
        <el-table-column label="排序号" prop="orderNum" width="180" sortable show-overflow-tooltip></el-table-column>
        <el-table-column label="操作" width="120" show-overflow-tooltip>
          <template slot-scope="{row}">
            <div class="handle-icon">
              <i class="bx bxs-edit-alt" @click="edit(row)"></i>
            </div>
            <div class="handle-icon">
              <i class="bx bx-x" @click="deleteOne(row)"></i>
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
  </div>
</template>

<script>
import { fetchSystemConfigs, deleteSystemConfig } from "@/api/metadata";

export default {
  data() {
    return {
      configs: [],
      currentPage: 1,
      pageSize: 10,
      total: 0,
      configInfo: "",
      params: {
        configName: "",
        description: "",
        currentPage: 1,
        pageSize: 10
      },
      multipleSelection: [],
      dialogVisible: false
    };
  },
  mounted() {
    this.loadSystemConfigs();
  },
  methods: {
    searchTable(params) {
      if (params) {
        this.params.configName = params.configName;
        this.params.description = params.description;
      }
      this.loadSystemConfigs(this.currentPage, this.pageSize);
    },
    loadSystemConfigs(currentPage, pageSize) {
      this.params.currentPage = currentPage;
      this.params.pageSize = pageSize;
      fetchSystemConfigs(this.params).then(res => {
        this.configs = res.data.records;
        this.total = res.data.total;
      });
    },
    handleSelectionChange(val) {
      this.multipleSelection = val;
    },
    handleSizeChange(pageSize) {
      this.pageSize = pageSize;
      this.loadSystemConfigs(this.currentPage, pageSize);
    },
    handleCurrentChange(currentPage) {
      this.currentPage = currentPage;
      this.loadSystemConfigs(currentPage, this.pageSize);
    },
    deleteOne(row) {
      this.$confirm("确定要删除该系统参数?", "提示", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning"
      }).then(() => {
        this.handleDelete(row.id);
      });
    },
    deleteSelect() {
      var idList = new Array();
      if (this.multipleSelection.length > 0) {
        this.$confirm("确定要删除选中的系统参数?", "提示", {
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
          message: "未选择系统参数",
          type: "info"
        });
      }
    },

    handleDelete(id) {
      deleteSystemConfig({
        ids: id
      }).then(res => {
        this.$message({
          message: "删除成功",
          type: "success"
        });
        this.loadSystemConfigs(this.currentPage, this.pageSize);
      });
    },
    edit(row) {
      this.$emit("openEditDialog", row.id);
    }
  }
};
</script>

<style lang="scss" scoped>
</style>