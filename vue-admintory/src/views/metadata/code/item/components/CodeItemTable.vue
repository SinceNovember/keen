<template>
  <div class="form-container">
    <div class="form-table">
      <el-table
        ref="multipleTable"
        :data="codeItems"
        tooltip-effect="dark"
        style="width: 100%"
        @selection-change="handleSelectionChange"
      >
        <el-table-column type="selection" width="55"></el-table-column>
        <el-table-column label="序" type="index" width="80"></el-table-column>
        <el-table-column label="代码项名称" prop="itemText" width="300"></el-table-column>
        <el-table-column label="代码项值" prop="itemValue"></el-table-column>
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
import { fetchCodeItems, deleteCodeItem } from "@/api/metadata";

export default {
  data() {
    return {
      codeItems: [],
      currentPage: 1,
      pageSize: 10,
      total: 0,
      codeItemInfo: "",
      params: {
        codeId: '',
        itemText: '',
        currentPage: 1,
        pageSize: 10
      },
      multipleSelection: [],
      dialogVisible: false
    };
  },
  props:{
    codeId: Number
  },
  mounted() {
    this.loadCodeItems();
  },
  methods: {
    searchTable(params) {
      if (params) {
        this.params.itemText = params.itemText;
      }
      this.loadCodeItems(this.currentPage, this.pageSize);
    },
    loadCodeItems(currentPage, pageSize) {
      this.params.currentPage = currentPage;
      this.params.pageSize = pageSize;
      this.params.codeId = this.codeId;
      fetchCodeItems(this.params).then(res => {
        this.codeItems = res.data.records;
        this.total = res.data.total;
      });
    },
    handleSelectionChange(val) {
      this.multipleSelection = val;
    },
    handleSizeChange(pageSize) {
      this.pageSize = pageSize;
      this.loadCodeItems(this.currentPage, pageSize);
    },
    handleCurrentChange(currentPage) {
      this.currentPage = currentPage;
      this.loadCodeItems(currentPage, this.pageSize);
    },
    deleteOne(row) {
      this.$confirm("确定要删除该代码项?", "提示", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning"
      }).then(() => {
        this.handleDelete(row.itemId);
      });
    },
    deleteSelect() {
      var idList = new Array();
      if (this.multipleSelection.length > 0) {
        this.$confirm("确定要删除选中的代码项?", "提示", {
          confirmButtonText: "确定",
          cancelButtonText: "取消",
          type: "warning"
        }).then(() => {
          this.multipleSelection.map(item => {
            idList.push(item.itemId);
          });
          this.handleDelete(idList.toString());
        });
      } else {
        this.$message({
          message: "未选择代码",
          type: "info"
        });
      }
    },

    handleDelete(id) {
      deleteCodeItem({
        ids: id
      }).then(res => {
        this.$message({
          message: "删除成功",
          type: "success"
        });
        this.loadCodeItems(this.currentPage, this.pageSize);
      });
    },
    edit(row) {
      this.$emit("openEditDialog", row.itemId);
    }
  }
};
</script>

<style lang="scss" scoped>
</style>