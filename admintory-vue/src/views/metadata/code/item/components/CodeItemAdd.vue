<template>
  <div class="add-container">
    <div class="dialog-title">添加代码子项</div>
    <div class="info-container">
      <el-form
        :model="codeItemInfo"
        label-position="right"
        label-width="100px"
        :rules="rules"
        ref="codeItemInfo"
      >
        <el-form-item label="代码项名称" prop="itemText">
          <el-input v-model="codeItemInfo.itemText"></el-input>
        </el-form-item>
        <el-form-item label="代码项值" prop="itemValue">
          <el-input v-model="codeItemInfo.itemValue"></el-input>
        </el-form-item>
        <el-form-item label="排序号">
          <el-input-number v-model="codeItemInfo.orderNum"></el-input-number>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="addCodeItem('codeItemInfo')">确认</el-button>
          <el-button @click="closeDialog">取消</el-button>
        </el-form-item>
      </el-form>
    </div>
  </div>
</template>

<script>
import { saveCodeItem, updateCodeItem } from "@/api/metadata";

export default {
  props: {
    codeItemInfo: Object
  },
  data() {
    return {
      rules: {
        itemText: [
          { required: true, message: "代码项名称不能为空", trigger: "blur" }
        ],
        itemValue: [
          { required: true, message: "代码项值不能为空", trigger: "blur" }
        ]
      }
    };
  },
  methods: {
    addCodeItem(formName) {
      this.$refs[formName].validate(valid => {
        if (valid) {
          if (this.codeItemInfo.itemId) {
            updateCodeItem(this.codeItemInfo).then(res => {
              this.$emit("closeDialog", 1);
              this.$message({
                message: "修改成功",
                type: "success"
              });
            });
          } else {
            saveCodeItem(this.codeItemInfo).then(res => {
              this.$emit("closeDialog", 1);
              this.$message({
                message: "添加成功",
                type: "success"
              });
            });
          }
        }
      });
    },
    closeDialog() {
      this.$emit("closeDialog");
    }
  }
};
</script>

<style lang="scss" scoped>

</style>