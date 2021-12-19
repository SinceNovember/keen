<template>
  <div class="add-container">
    <div class="dialog-title">添加代码</div>
    <div class="info-container">
      <el-form
        :model="codeMainInfo"
        label-position="right"
        label-width="80px"
        :rules="rules"
        ref="codeMainInfo"
      >
        <el-form-item label="代码名称" prop="codeName">
          <el-input v-model="codeMainInfo.codeName"></el-input>
        </el-form-item>
        <el-form-item label="代码说明">
          <el-input v-model="codeMainInfo.description"></el-input>
        </el-form-item>
        <el-form-item label="排序号">
          <el-input-number v-model="codeMainInfo.orderNum"></el-input-number>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="addCodeMain('codeMainInfo')">确认</el-button>
          <el-button @click="closeDialog">取消</el-button>
        </el-form-item>
      </el-form>
    </div>
  </div>
</template>

<script>
import { saveCodeMain, updateCodeMain } from "@/api/metadata";

export default {
  props: {
    codeMainInfo: Object
  },
  data() {
    return {
      rules: {
        codeName: [
          { required: true, message: "代码名称不能为空", trigger: "blur" }
        ]
      }
    };
  },
  methods: {
    addCodeMain(formName) {
      this.$refs[formName].validate(valid => {
        if (valid) {
          if (this.codeMainInfo.codeId) {
            updateCodeMain(this.codeMainInfo).then(res => {
              this.$emit("closeDialog", 1);
              this.$message({
                message: "修改成功",
                type: "success"
              });
            });
          } else {
            saveCodeMain(this.codeMainInfo).then(res => {
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