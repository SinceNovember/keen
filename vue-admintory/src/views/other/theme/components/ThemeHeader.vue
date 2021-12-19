<template>
  <div class="form-header">
    <el-row>
      <el-col :xs="24" :sm="12">
        <div class="search-header">
          <el-input
            v-model="themeText"
            class="search-input"
            placeholder="主题文本"
            clearable
            @change="search"
          ></el-input>
          <el-input
            v-model="themeName"
            class="search-input"
            placeholder="主题名称"
            clearable
            @change="search"
          ></el-input>
        </div>
      </el-col>
      <el-col :xs="24" :sm="12">
        <div class="btn-header">
          <div class="other-btn">
            <i class="bx bx-dots-vertical-rounded"></i>
          </div>
          <el-button type="primary" icon="el-icon-plus" @click="openThemeDialog('')">添加参数</el-button>
          <el-button type="danger" icon="el-icon-plus" @click="deleteSelect" plain>删除选中</el-button>
        </div>
      </el-col>
    </el-row>
    <el-dialog :visible.sync="dialogVisible" v-if="dialogVisible" width="40%" height="400px">
      <theme-add :themeInfo="themeInfo" :fileList="fileList" @closeDialog="closeThemeDialog"></theme-add>
    </el-dialog>
  </div>
</template>

<script>
import { getTheme } from "@/api/theme";
import ThemeAdd from "./ThemeAdd";

export default {
  components: {
    ThemeAdd
  },
  data() {
    return {
      themeInfo: {
        themeText: "",
        themeName: "",
        orderNum: "",
        picUrl: ""
      },
      dialogVisible: false,
      themeText: "",
      themeName: "",
      fileList: []
    };
  },
  methods: {
    search() {
      var params = {
        themeText: this.themeText,
        themeName: this.themeName
      };
      this.$emit("search", params);
    },
    closeThemeDialog(type) {
      if (type) {
        this.$emit("search");
      }
      this.dialogVisible = false;
    },
    deleteSelect() {
      this.$emit("deleteSelectTheme");
    },
    openThemeDialog(id) {
      this.dialogVisible = true;
      this.themeInfo.id = id;
      this.fileList = [];
      if (id) {
        getTheme({
          id: id
        }).then(res => {
          this.themeInfo = res.data;
          this.fileList.push({
            name: this.themeInfo.themeText,
            url: this.themeInfo.picUrl
          });
        });
      } else {
        this.clearForm();
      }
    },
    clearForm() {
      this.themeInfo.themeText = "";
      this.themeInfo.themeName = "";
      this.themeInfo.orderNum = "";
      this.themeInfo.picUrl = "";
      this.fileList = [];
    }
  }
};
</script>

<style  lang="scss" scoped>
.search-input {
  width: 30%;
}

.el-row {
  width: 100%;
}
</style>