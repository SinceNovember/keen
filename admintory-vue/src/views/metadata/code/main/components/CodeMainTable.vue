<template>
  <div class="form-container">
    <div class="form-table">
      <el-table
        ref="multipleTable"
        :data="codeMains"
        tooltip-effect="dark"
        style="width: 100%"
        @selection-change="handleSelectionChange"
      >
        <el-table-column type="selection" width="55"></el-table-column>
        <el-table-column label="序" type="index" width="80"></el-table-column>
        <el-table-column label="代码名称" prop="codeName" width="300"></el-table-column>
        <el-table-column label="代码说明" prop="description"></el-table-column>
        <el-table-column label="排序号" prop="orderNum" width="180" sortable show-overflow-tooltip></el-table-column>
        <el-table-column label="操作" width="120" show-overflow-tooltip>
          <template slot-scope="{row}">
            <div class="handle-icon">
              <i class="bx bxs-edit-alt" @click="edit(row)"></i>
            </div>
            <div class="handle-icon">
              <i class="bx bx-x" @click="deleteOne(row)"></i>
            </div>
            <div class="handle-icon">
              <i class="bx bx-copy" @click="openCodeItem(row)"></i>
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

    <el-dialog :visible.sync="dialogVisible" v-if="dialogVisible" width="50rem"   >
      <code-item :codeId="codeId" @closeDialog="closeCodeItemDialog"></code-item>
    </el-dialog>
  </div>
</template>

<script>
import { fetchCodeMains, deleteCodeMain } from "@/api/metadata";
import CodeItem from "../../item/index";

export default {
  components: {
    CodeItem
  },
  data() {
    return {
      codeMains: [],
      currentPage: 1,
      pageSize: 10,
      total: 0,
      codeMainInfo: "",
      params: {
        codeName: "",
        description: "",
        currentPage: 1,
        pageSize: 10
      },
      codeId: "",
      multipleSelection: [],
      dialogVisible: false
    };
  },
  mounted() {
    this.loadCodeMains();
  },
  methods: {
    searchTable(params) {
      if (params) {
        this.params.codeName = params.codeName;
        this.params.description = params.description;
      }
      this.loadCodeMains(this.currentPage, this.pageSize);
    },
    loadCodeMains(currentPage, pageSize) {
      this.params.currentPage = currentPage;
      this.params.pageSize = pageSize;
      fetchCodeMains(this.params).then(res => {
        this.codeMains = res.data.records;
        this.total = res.data.total;
      });
    },
    handleSelectionChange(val) {
      this.multipleSelection = val;
    },
    handleSizeChange(pageSize) {
      this.pageSize = pageSize;
      this.loadCodeMains(this.currentPage, pageSize);
    },
    handleCurrentChange(currentPage) {
      this.currentPage = currentPage;
      this.loadCodeMains(currentPage, this.pageSize);
    },
    deleteOne(row) {
      this.$confirm("确定要删除该代码?", "提示", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning"
      }).then(() => {
        this.handleDelete(row.codeId);
      });
    },
    deleteSelect() {
      var idList = new Array();
      if (this.multipleSelection.length > 0) {
        this.$confirm("确定要删除选中的代码?", "提示", {
          confirmButtonText: "确定",
          cancelButtonText: "取消",
          type: "warning"
        }).then(() => {
          this.multipleSelection.map(item => {
            idList.push(item.codeId);
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
      deleteCodeMain({
        ids: id
      }).then(res => {
        this.$message({
          message: "删除成功",
          type: "success"
        });
        this.loadCodeMains(this.currentPage, this.pageSize);
      });
    },
    edit(row) {
      this.$emit("openEditDialog", row.codeId);
    },
    openCodeItem(row) {
      this.codeId = row.codeId;
      this.dialogVisible = true;
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