<template>
  <div class="form-header">
    <el-row>
      <el-col :xs="24" :sm="12">
        <div class="search-header">
          <el-input
            v-model="deptName"
            class="search-input"
            placeholder="部门名称"
            clearable
            @change="search"
          ></el-input>
          <el-input
            v-model="username"
            class="search-input"
            placeholder="创建者"
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
          <el-button type="primary" icon="el-icon-plus" @click="openDeptDialog('')">添加部门</el-button>
        </div>
      </el-col>
    </el-row>

    <el-dialog :visible.sync="dialogVisible" v-if="dialogVisible" width="50rem" height="500px">
      <dept-add
        :deptInfo="deptInfo"
        @closeDialog="closeDeptDialog"
        :defaultCheckedKeys="defaultCheckedKeys"
      ></dept-add>
    </el-dialog>
  </div>
</template>

<script>
import { getDept } from "@/api/dept";
import DeptAdd from "./DeptAdd";

export default {
  components: {
    DeptAdd
  },
  data() {
    return {
      deptInfo: {
        deptName: "",
        deptShortName: "",
        orderNum: "",
        description: ""
      },
      dialogVisible: false,
      deptName: "",
      username: "",
      deptId: "",
      defaultCheckedKeys: []
    };
  },
  methods: {
    search() {
      var params = {
          deptName: this.deptName,
          username: this.username
        };
      this.$emit("search", params);
    },
    closeDeptDialog(type) {
      if (type) {
        this.$emit("search");
      }
      this.dialogVisible = false;
    },
    openDeptDialog(deptId) {
      if (deptId) {
        this.deptId = deptId;
        getDept({
          deptId: deptId
        }).then(res => {
          this.deptInfo = res.data;
          this.defaultCheckedKeys = [];
          this.defaultCheckedKeys.push(this.deptInfo.parentId);
        });
      } else {
        this.clearForm();
      }
      this.dialogVisible = true;
    },
    clearForm() {
      this.deptInfo.deptId = "";
      this.deptInfo.deptName = "";
      this.deptInfo.deptShortName = "";
      this.deptInfo.orderNum = "";
      this.deptInfo.parentId = "";
      this.deptInfo.description = "";
      this.defaultCheckedKeys = [];
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