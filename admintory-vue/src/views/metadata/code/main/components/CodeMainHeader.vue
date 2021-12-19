<template>
  <div class="form-header">
    <el-row>
      <el-col :xs="24" :sm="12">
        <div class="search-header">
          <el-input
            v-model="codeName"
            class="search-input"
            placeholder="代码名称"
            clearable
            @change="search"
          ></el-input>
          <el-input
            v-model="description"
            class="search-input"
            placeholder="代码说明"
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
          <el-button type="primary" icon="el-icon-plus" @click="openCodeMainDialog('')">添加参数</el-button>
          <el-button type="danger" icon="el-icon-plus" @click="deleteSelect" plain>删除选中</el-button>
        </div>
      </el-col>
    </el-row>
    <el-dialog :visible.sync="dialogVisible" v-if="dialogVisible" width="50rem">
      <code-main-add :codeMainInfo="codeMainInfo" @closeDialog="closeCodeMainDialog"></code-main-add>
    </el-dialog>
  </div>
</template>

<script>
import { getCodeMain } from "@/api/metadata";
import CodeMainAdd from "./CodeMainAdd";

export default {
  components: {
    CodeMainAdd
  },
  data() {
    return {
      codeMainInfo: {
        codeName: "",
        description: "",
        orderNum: ""
      },
      dialogVisible: false,
      codeName: "",
      description: ""
    };
  },
  methods: {
    search() {
      var params = {
        codeName: this.codeName,
        description: this.description
      };
      this.$emit("search", params);
    },

    closeCodeMainDialog(type) {
      if (type) {
        this.$emit("search");
      }
      this.dialogVisible = false;
    },
    deleteSelect() {
      this.$emit("deleteSelect");
    },
    openCodeMainDialog(codeId) {
      this.dialogVisible = true;
      this.codeMainInfo.codeId = codeId;
      if (codeId) {
        getCodeMain({
          codeId: codeId
        }).then(res => {
          this.codeMainInfo = res.data;
        });
      } else {
        this.clearForm();
      }
    },
    clearForm() {
      this.codeMainInfo.codeName = "";
      this.codeMainInfo.description = "";
      this.codeMainInfo.orderNum = "";
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