<template>
  <div class="form-header">
    <el-row>
      <el-col :xs="24" :sm="12">
        <div class="search-header">
          <el-input
            v-model="configName"
            class="search-input"
            placeholder="参数名称"
            clearable
            @change="search"
          ></el-input>
          <el-input
            v-model="description"
            class="search-input"
            placeholder="参数描述"
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
          <el-button type="primary" icon="el-icon-plus" @click="openConfigDialog('')">添加参数</el-button>
          <el-button type="danger" icon="el-icon-plus" @click="deleteSelect" plain>删除选中</el-button>
        </div>
      </el-col>
    </el-row>
    <el-dialog :visible.sync="dialogVisible" v-if="dialogVisible" width="50rem">
      <system-config-add :configInfo="configInfo" @closeDialog="closeConfigDialog"></system-config-add>
    </el-dialog>
  </div>
</template>

<script>
import { getSystemConfig } from "@/api/metadata";
import SystemConfigAdd from "./SystemConfigAdd";

export default {
  components: {
    SystemConfigAdd
  },
  data() {
    return {
      configInfo: {
        configName: "",
        configValue: "",
        orderNum: "",
        description: ""
      },
      dialogVisible: false,
      configName: "",
      description: ""
    };
  },
  methods: {
    search() {
      var params = {
        configName: this.configName,
        description: this.description
      };
      this.$emit("search", params);
    },

    closeConfigDialog(type) {
      if (type) {
        this.$emit("search");
      }
      this.dialogVisible = false;
    },
    deleteSelect() {
      this.$emit("deleteSelect");
    },
    openConfigDialog(configId) {
      this.dialogVisible = true;
      this.configInfo.id = configId;
      if (configId) {
        getSystemConfig({
          configId: configId
        }).then(res => {
          this.configInfo = res.data;
        });
      } else {
        this.clearForm();
      }
    },
    clearForm() {
      this.configInfo.configName = "";
      this.configInfo.configValue = "";
      this.configInfo.description = "";
      this.configInfo.orderNum = "";
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