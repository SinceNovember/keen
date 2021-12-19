<template>
  <div class="form-header">
    <el-row>
      <el-col :xs="24" :sm="12">
        <div class="search-header">
          <el-input
            v-model="itemText"
            class="search-input"
            placeholder="代码项名称"
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
          <el-button type="primary" icon="el-icon-plus" @click="openCodeItemDialog('')">添加参数</el-button>
          <el-button type="danger" icon="el-icon-plus" @click="deleteSelect" plain>删除选中</el-button>
        </div>
      </el-col>
    </el-row>
    <el-dialog :visible.sync="dialogVisible" v-if="dialogVisible" class="dialog-cls" width="45rem">
      <code-item-add :codeItemInfo="codeItemInfo" @closeDialog="closeCodeItemDialog"></code-item-add>
    </el-dialog>
  </div>
</template>

<script>
import { getCodeItem } from "@/api/metadata";
import CodeItemAdd from "./CodeItemAdd";

export default {
  components: {
    CodeItemAdd
  },
  props: {
    codeId: Number
  },
  data() {
    return {
      codeItemInfo: {
        itemText: "",
        itemValue: "",
        orderNum: ""
      },
      dialogVisible: false,
      itemText: "",
      description: ""
    };
  },
  methods: {
    search() {
      var params = {
        itemText: this.itemText
      };
      this.$emit("search", params);
    },

    closeCodeItemDialog(type) {
      if (type) {
        this.$emit("search");
      }
      this.dialogVisible = false;
    },
    deleteSelect() {
      this.$emit("deleteSelect");
    },
    openCodeItemDialog(itemId) {
      this.dialogVisible = true;
      this.codeItemInfo.codeId = this.codeId;
      this.codeItemInfo.itemId = itemId;
      if (itemId) {
        getCodeItem({
          itemId: itemId
        }).then(res => {
          this.codeItemInfo = res.data;
        });
      } else {
        this.clearForm();
      }
    },
    clearForm() {
      this.codeItemInfo.itemText = "";
      this.codeItemInfo.itemValue = "";
      this.codeItemInfo.orderNum = "";
    }
  }
};
</script>

<style  lang="scss" scoped>
.search-input {
  width: 60%;
}

.el-row {
  width: 100%;
}
</style>