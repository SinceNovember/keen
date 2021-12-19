<template>
  <div class="form-header">
    <el-row>
      <el-col :xs="24" :sm="12">
        <div class="search-header">
          <el-input
            v-model="title"
            class="search-input"
            placeholder="菜单名称"
            clearable
            @change="search"
          ></el-input>
          <!-- <el-button  type="primary" plain icon="el-icon-search"  @click="search" ></el-button> -->
        </div>
      </el-col>
      <el-col :xs="24" :sm="12">
        <div class="btn-header">
          <div class="other-btn">
            <i class="bx bx-dots-vertical-rounded"></i>
          </div>
          <el-button type="primary" icon="el-icon-plus" @click="openMenuDialog('')">添加菜单</el-button>
          <el-button type="danger" icon="el-icon-plus" @click="deleteSelect" plain>删除选中</el-button>
        </div>
      </el-col>
    </el-row>
    <el-dialog :visible.sync="dialogVisible" v-if="dialogVisible" width="50rem">
      <menu-add
        :defaultCheckedKeys="defaultCheckedKeys"
        :activeIndex="activeIndex"
        :menuInfo="menuInfo"
        @closeDialog="closeMenuDialog"
      ></menu-add>
    </el-dialog>
  </div>
</template>

<script>
import { getMenu } from "@/api/menu";
import MenuAdd from "./MenuAdd";

export default {
  components: {
    MenuAdd
  },
  data() {
    return {
      menuInfo: {
        id: "",
        menuType: "DIRECTORY",
        path: "",
        component: "",
        parentId: "2",
        name: "",
        redirect: "",
        orderNum: "",
        requestMethod: "GET",
        hidden: false,
        isExpand: false,
        alwaysShow: false,
        meta: {
          title: "",
          icon: "",
          affix: false
        }
      },
      dialogVisible: false,
      title: "",
      menuId: "",
      activeIndex: "DIRECTORY",
      defaultCheckedKeys: []
    };
  },
  methods: {
    search() {
      var _this = this,
        params = {
          title: _this.title
        };
      this.$emit("search", params);
    },
    closeMenuDialog(type) {
      if (type) {
        this.$emit("search");
      }
      this.dialogVisible = false;
    },
    openMenuDialog(menuId) {
      if (menuId) {
        // _this.menuId = menuId;
        getMenu({
          menuId: menuId
        }).then(res => {
          this.menuInfo = res.data;
          this.activeIndex = this.menuInfo.menuType;

          this.defaultCheckedKeys = [];
          this.defaultCheckedKeys.push(this.menuInfo.parentId);
        });
      } else {
        this.clearForm();
      }
      this.dialogVisible = true;
    },
    deleteSelect() {
      this.$emit("deleteSelect");
    },
    clearForm() {
      var _this = this;
      _this.defaultCheckedKeys = [];
      _this.menuInfo.id = "";
      _this.menuInfo.menuType = "DIRECTORY";
      _this.menuInfo.path = "";
      _this.menuInfo.component = "";
      _this.menuInfo.parentId = "";
      _this.menuInfo.name = "";
      _this.menuInfo.redirect = "";
      _this.menuInfo.orderNum = "";
      _this.menuInfo.hidden = false;
      _this.menuInfo.isExpand = false;
      _this.menuInfo.alwaysShow = false;
      _this.menuInfo.meta.title = "";
      _this.menuInfo.meta.icon = "";
      _this.menuInfo.meta.affix = false;
    }
  }
};
</script>

<style  lang="scss" scoped>
.search-input {
  width: 50%;
}
.el-row {
  width: 100%;
}
</style>