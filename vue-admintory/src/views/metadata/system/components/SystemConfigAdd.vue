<template>
  <div class="add-container">
    <div class="dialog-title">添加系统参数</div>
    <div class="info-container">
      <el-form
        :model="configInfo"
        label-position="right"
        label-width="80px"
        :rules="rules"
        ref="configInfo"
      >
        <el-form-item label="参数名称" prop="configName">
          <el-input v-model="configInfo.configName" ></el-input>
        </el-form-item>
        <el-form-item label="参数值" prop="configValue">
          <el-input v-model="configInfo.configValue"></el-input>
        </el-form-item>
        <el-form-item label="参数描述">
          <el-input v-model="configInfo.description"></el-input>
        </el-form-item>
        <el-form-item label="排序号">
          <el-input-number v-model="configInfo.orderNum"></el-input-number>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="addConfig('configInfo')">确认</el-button>
          <el-button @click="closeDialog">取消</el-button>
        </el-form-item>
      </el-form>
    </div>
  </div>
</template>

<script>
import { saveSystemConfig, updateSystemConfig } from "@/api/metadata";

export default {
  props: {
    configInfo: Object
  },
  data() {
    return {
      rules: {
        configName: [
          { required: true, message: "参数名称不能为空", trigger: "blur" }
        ],
        configValue: [
          { required: true, message: "参数值不能为空", trigger: "blur" }
        ]
      }
    };
  },
  methods: {
    addConfig(formName) {
      this.$refs[formName].validate(valid => {
        if (valid) {
          if (this.configInfo.id) {
            updateSystemConfig(this.configInfo).then(res => {
              this.$emit("closeDialog", 1);
              this.$message({
                message: "修改成功",
                type: "success"
              });
            });
          } else {
            saveSystemConfig(this.configInfo).then(res => {
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