<template>
  <div class="user-password-container">
    <el-form :model="form" status-icon :rules="rules" ref="form" label-width="100px">
      <el-form-item label="原密码" prop="pass">
        <el-input type="password" v-model="form.pass"></el-input>
      </el-form-item>
      <el-form-item label="新密码" prop="newPass">
        <el-input type="password" v-model="form.newPass"></el-input>
      </el-form-item>
      <el-form-item label="确认密码" prop="checkPass">
        <el-input type="password" v-model="form.checkPass" autocomplete="off"></el-input>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="saveForm('form')">保存修改</el-button>
        <el-button @click="resetForm('form')">重置</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>
import { updatePassword } from "@/api/user";
export default {
  data() {
    var validatePass = (rule, value, callback) => {
      if (this.form.checkPass !== "") {
        this.$refs.form.validateField("checkPass");
      }
      callback();
    };
    var validatePass2 = (rule, value, callback) => {
      if (value !== this.form.newPass) {
        callback(new Error("两次输入密码不一致!"));
      } else {
        callback();
      }
    };
    return {
      form: {
        pass: "",
        newPass: "",
        checkPass: ""
      },
      rules: {
        pass: [{ required: true, message: "请输入原密码", trigger: "blur" }],
        newPass: [
          { required: true, message: "请输入新密码", trigger: "blur" },
          { validator: validatePass, trigger: "blur" },
          { min: 6, message: "密码最低6位", trigger: "blur" }
        ],
        checkPass: [
          { required: true, message: "请输入确认密码", trigger: "blur" },
          { validator: validatePass2, trigger: "blur" },
          { min: 6, message: "密码最低6位", trigger: "blur" }
        ]
      }
    };
  },
  methods: {
    saveForm(formName) {
      this.$refs[formName].validate(valid => {
        if (valid) {
          var _this = this;
          updatePassword({
            password: _this.form.pass,
            newPassword: _this.form.newPass
          }).then(res => {
            this.$message({
              message: "修改成功",
              type: "success"
            });
          });
        }
      });
    },
    resetForm(formName) {
      this.$refs[formName].resetFields();
    }
  }
};
</script>

<style lang="scss" scoped>
.user-password-container {
  margin: 40px 20px;
}
</style>