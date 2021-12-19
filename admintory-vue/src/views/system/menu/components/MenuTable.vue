<template>
  <div class="form-container">
    <div class="menu-form-table">
      <el-table
        ref="multipleTable"
        :data="menus"
        row-key="id"
        tooltip-effect="dark"
        style="width: 100%"
        :tree-props="{children: 'children', hasChildren: 'hasChildren'}"
        @selection-change="handleSelectionChange"
      >
        <el-table-column type="selection" width="55"></el-table-column>
        <el-table-column label="菜单名称" width="200" prop="meta.title"></el-table-column>
        <el-table-column label="图标" width="80">
          <template slot-scope="{row}">
            <i class="ico bx" :class="row.meta.icon"></i>
          </template>
        </el-table-column>
        <el-table-column prop="component" label="组件路径" show-overflow-tooltip></el-table-column>
        <el-table-column prop="path" label="路由地址"></el-table-column>
        <el-table-column prop="redirect" label="重定向地址" width="200"></el-table-column>
        <el-table-column prop="orderNum" sortable width="100" label="排序"></el-table-column>
        <el-table-column width="60" label="隐藏">
          <template slot-scope="{row}">
            <el-checkbox v-model="row.hidden" @change="updateRow(row)"></el-checkbox>
          </template>
        </el-table-column>
        <el-table-column width="60" label="展开">
          <template slot-scope="{row}">
            <el-checkbox v-model="row.isExpand" @change="updateRow(row)"></el-checkbox>
          </template>
        </el-table-column>
        <el-table-column width="60" label="固定">
          <template slot-scope="{row}">
            <el-checkbox v-model="row.meta.affix" @change="updateRow(row)"></el-checkbox>
          </template>
        </el-table-column>
        <el-table-column width="60" label="公开">
          <template slot-scope="{row}">
            <el-checkbox v-model="row.alwaysShow" @change="updateRow(row)"></el-checkbox>
          </template>
        </el-table-column>
        <el-table-column label="操作" width="120" show-overflow-tooltip>
          <template slot-scope="{row}">
            <div class="handle-icon">
              <i class="bx bxs-edit-alt" @click="edit(row)"></i>
            </div>
            <div class="handle-icon">
              <i class="bx bx-x" @click="deleteOne(row)"></i>
            </div>
            <el-dropdown @command="handleCommand(row)" trigger="click">
              <div class="handle-icon">
                <i class="bx bx-dots-vertical-rounded"></i>
              </div>
              <el-dropdown-menu slot="dropdown">
                <el-dropdown-item icon="el-icon-copy-document">菜单分配</el-dropdown-item>
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

    <el-dialog :visible.sync="dialogVisible" v-if="dialogVisible" width="65rem">
      <menu-assign :menuId="menuId" @closeDialog="closeAssignDialog"></menu-assign>
    </el-dialog>
  </div>
</template>

<script>
import { fetchMenus, deleteMenu, updateMenu } from "@/api/menu";
import MenuInfo from "./MenuInfo";
import MenuAssign from "./MenuAssign";

export default {
  components: {
    MenuInfo,
    MenuAssign
  },
  data() {
    return {
      menus: [],
      currentPage: 1,
      pageSize: 10,
      total: 0,
      params: {
        title: "",
        currentPage: 1,
        pageSize: 10
      },
      multipleSelection: [],
      dialogVisible: false,
      menuId: ""
    };
  },
  mounted() {
    this.loadMenus();
  },
  methods: {
    searchTable(params) {
      if (params) {
        this.params.title = params.title;
      }
      this.loadMenus(this.currentPage, this.pageSize);
    },
    loadMenus(currentPage, pageSize) {
      this.params.currentPage = currentPage;
      this.params.pageSize = pageSize;
      fetchMenus(this.params).then(res => {
        this.menus = res.data.records;
        this.total = res.data.total;
      });
    },

    handleSelectionChange(val) {
      this.multipleSelection = val;
    },
    handleSizeChange(pageSize) {
      this.pageSize = pageSize;
      this.loadMenus(this.currentPage, pageSize);
    },
    handleCurrentChange(currentPage) {
      this.currentPage = currentPage;
      this.loadMenus(currentPage, this.pageSize);
    },
    deleteOne(row) {
      this.$confirm("确定要删除该菜单?", "提示", {
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
        this.$confirm("确定要删除选中的按钮?", "提示", {
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
          message: "未选择按钮",
          type: "info"
        });
      }
    },
    handleDelete(id) {
      deleteMenu({
        ids: id
      }).then(res => {
        this.$message({
          message: res.msg,
          type: "success"
        });
        this.loadMenus(this.currentPage, this.pageSize);
      });
    },
    edit(row) {
      this.$emit("openEditDialog", row.id);
    },
    updateRow(row) {
      updateMenu(row).then(res => {
        this.$message({
          message: "修改成功",
          type: "success"
        });
      });
    },
    handleCommand(row) {
      this.menuId = row.id;
      this.dialogVisible = true;
    },
    closeAssignDialog() {
      this.dialogVisible = false;
    }
  }
};
</script>

<style lang="scss" scoped>
</style>