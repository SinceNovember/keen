<template>
  <div class="add-container">
    <div class="dialog-title">添加角色</div>
    <div class="info-container">
      <el-form
        :model="roleInfo"
        label-position="right"
        label-width="80px"
        :rules="rules"
        ref="roleInfo"
      >
        <el-form-item label="角色名称" prop="roleName">
          <el-input v-model="roleInfo.roleName" class="inline-input"></el-input>
        </el-form-item>
        <el-form-item label="角色标识">
          <el-input v-model="roleInfo.roleTag" class="inline-input"></el-input>
        </el-form-item>
        <el-form-item label="状态">
          <el-form-item prop="status">
            <el-select v-model="roleInfo.status" class="inline-input" placeholder="请选择状态">
              <el-option
                v-for="item in statusOptions"
                :key="item.value"
                :label="item.label"
                :value="item.value"
              ></el-option>
            </el-select>
          </el-form-item>
        </el-form-item>
        <el-form-item label="排序号">
          <el-input-number v-model="roleInfo.orderNum" class="inline-input"></el-input-number>
        </el-form-item>
        <el-form-item label="备注">
          <el-input v-model="roleInfo.description" class="inline-input" type="textarea"></el-input>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="addRole('roleInfo')">确认</el-button>
          <el-button @click="closeDialog">取消</el-button>
        </el-form-item>
      </el-form>
    </div>
  </div>
</template>

<script>
import { saveRole, updateRole } from "@/api/role";
import { getStatusOption } from "@/api/option";

export default {
  props: {
    roleInfo: Object
  },
  data() {
    return {
      deptOptions: [],
      statusOptions: [],
      rules: {
        roleName: [
          { required: true, message: "角色名称不能为空", trigger: "blur" }
        ]
      }
    };
  },
  mounted() {
    this.loadStatusOption();
  },
  methods: {
    loadStatusOption() {
      getStatusOption().then(res => {
        this.statusOptions = res.data;
      });
    },
    addRole(formName) {
      this.$refs[formName].validate(valid => {
        if (valid) {
          if (this.roleInfo.roleId) {
            updateRole(this.roleInfo).then(res => {
              this.$emit("closeDialog", 1);
              this.$message({
                message: "修改成功",
                type: "success"
              });
            });
          } else {
            saveRole(this.roleInfo).then(res => {
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