<template>
  <div class="form-container">
    <div class="form-table">
      <el-table
        ref="multipleTable"
        :data="themes"
        tooltip-effect="dark"
        style="width: 100%"
        @selection-change="handleSelectionChange"
      >
        <el-table-column type="selection" width="55"></el-table-column>
        <el-table-column label="序" type="index" width="80"></el-table-column>
        <el-table-column label="主题文本" prop="themeText" width="150"></el-table-column>
        <el-table-column label="主题名称" prop="themeName" width="150"></el-table-column>
        <el-table-column label="图片地址" prop="picUrl"></el-table-column>
        <el-table-column label="排序号" prop="orderNum" width="120" sortable show-overflow-tooltip></el-table-column>
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
import { fetchThemes, deleteTheme } from "@/api/theme";

export default {
  data() {
    return {
      themes: [],
      currentPage: 1,
      pageSize: 10,
      total: 0,
      themeInfo: "",
      params: {
        themeText: "",
        themeName: "",
        currentPage: 1,
        pageSize: 10
      },
      multipleSelection: [],
      dialogVisible: false
    };
  },
  mounted() {
    this.loadThemes();
  },
  methods: {
    searchTable(params) {
      if (params) {
        this.params.themeText = params.themeText;
        this.params.themeName = params.themeName;
      }
      this.loadThemes(this.currentPage, this.pageSize);
    },
    loadThemes(currentPage, pageSize) {
      this.params.currentPage = currentPage;
      this.params.pageSize = pageSize;
      fetchThemes(this.params).then(res => {
        this.themes = res.data.records;
        this.total = res.data.total;
      });
    },
    handleSelectionChange(val) {
      this.multipleSelection = val;
    },
    handleSizeChange(pageSize) {
      this.pageSize = pageSize;
      this.loadThemes(this.currentPage, pageSize);
    },
    handleCurrentChange(currentPage) {
      this.currentPage = currentPage;
      this.loadThemes(currentPage, this.pageSize);
    },
    deleteOne(row) {
      this.$confirm("确定要删除该主题?", "提示", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning"
      }).then(() => {
        this.handleDelete(row.id);
      });
    },
    deleteSelectTheme() {
      var idList = new Array();
      if (this.multipleSelection.length > 0) {
        this.$confirm("确定要删除选中的主题?", "提示", {
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
          message: "未选择代码",
          type: "info"
        });
      }
    },
    handleDelete(id) {
      deleteTheme({
        ids: id
      }).then(res => {
        this.$message({
          message: "删除成功",
          type: "success"
        });
        this.loadThemes(this.currentPage, this.pageSize);
      });
    },
    edit(row) {
      this.$emit("openEditDialog", row.id);
    },
    closeCodeItemDialog(type) {
      if (type) {
        this.$emit("search");
      }
      this.dialogVisible = false;
    }
  }
};
</script>

<style lang="scss" scoped>
</style>