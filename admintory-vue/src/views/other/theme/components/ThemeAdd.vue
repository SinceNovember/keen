<template>
  <div class="theme-add-container">
    <div class="dialog-title">添加主题</div>
    <div class="theme-info-container">
      <el-form
        :model="themeInfo"
        label-position="right"
        label-width="80px"
        :rules="rules"
        ref="themeInfo"
      >
        <el-form-item label="主题文本" prop="codeName">
          <el-input v-model="themeInfo.themeText" class="inline-input"></el-input>
        </el-form-item>
        <el-form-item label="主题名称">
          <el-input v-model="themeInfo.themeName" class="inline-input"></el-input>
        </el-form-item>
        <el-form-item label="排序号">
          <el-input-number v-model="themeInfo.orderNum" class="inline-input"></el-input-number>
        </el-form-item>
        <el-form-item label="图片">
          <el-upload
            class="upload-demo"
            action="#"
            :before-upload="beforeAvatarUpload"
            :file-list="fileList"
            :limit="limit"
            :on-remove="handleRemove"
            list-type="picture"
          >
            <el-button size="small" class="upload-btn" type="primary">点击上传</el-button>
          </el-upload>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="addTheme('themeInfo')">确认</el-button>
          <el-button @click="closeDialog">取消</el-button>
        </el-form-item>
      </el-form>
    </div>
  </div>
</template>

<script>
import { uploadImg } from "@/api/user";
import { saveTheme, updateTheme } from "@/api/theme";

export default {
  props: {
    themeInfo: Object,
    fileList: Array
  },
  data() {
    return {
      limit: 1,
      rules: {
        themeText: [
          { required: true, message: "主题文本不能为空", trigger: "blur" }
        ]
      }
    };
  },
  methods: {
    addTheme(formName) {
      this.$refs[formName].validate(valid => {
        if (valid) {
          if (this.themeInfo.id) {
            updateTheme(this.themeInfo).then(res => {
              this.$emit("closeDialog", 1);
              this.$message({
                message: "修改成功",
                type: "success"
              });
            });
          } else {
            saveTheme(this.themeInfo).then(res => {
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
    beforeAvatarUpload(file) {
      const isImg = file.type === "image/jpeg" || file.type === "image/png";
      const isLt2M = file.size / 1024 / 1024 < 2;

      if (!isImg) {
        this.$message.error("上传头像图片只能是 JPG/PNG 格式!");
      }
      if (!isLt2M) {
        this.$message.error("上传头像图片大小不能超过 2MB!");
      }
      if (isImg && isLt2M) {
        let param = new FormData(); // 创建form对象
        param.append("file", file, file.name); // file对象是 beforeUpload参数
        let config = {
          headers: { "Content-Type": "multipart/form-data" }
        };
        uploadImg(param, config).then(res => {
          this.themeInfo.picUrl = "http://" + res.data;
          this.fileList.push({
            name: "url1",
            url: this.themeInfo.picUrl
          });
          console.log(this.fileList);
        });
      }
      return false;
    },
    handleRemove(file, files) {
      this.fileList = [];
      this.themeInfo.picUrl = "";
    },
    closeDialog() {
      this.$emit("closeDialog");
    }
  }
};
</script>

<style lang="scss" scoped>
.theme-add-container {
  height: 500px;

  .dialog-title {
    font-size: 20px;
    padding: 10px 20px;
  }

  .theme-info-container {
    padding: 20px 120px;
  }
  .inline-input {
    width: 440px;
  }

  .inline-textarea {
    width: 650px;
  }

  .demo-autocomplete {
    margin-bottom: 10px;
  }

  .dialog-footer {
    display: flex;
    align-items: center;
    justify-content: center;
    margin-top: 20px;

    button {
      margin-right: 60px;
    }
  }
}
</style>