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
      var _this = this,
        params = {
          deptName: _this.deptName,
          username: _this.username
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
      var _this = this;
      if (deptId) {
        _this.deptId = deptId;
        getDept({
          deptId: deptId
        }).then(res => {
          _this.deptInfo = res.data;
          _this.defaultCheckedKeys = [];
          _this.defaultCheckedKeys.push(_this.deptInfo.parentId);
        });
      } else {
        _this.clearForm();
      }
      _this.dialogVisible = true;
    },
    clearForm() {
      var _this = this;
      _this.deptInfo.deptId = "";
      _this.deptInfo.deptName = "";
      _this.deptInfo.deptShortName = "";
      _this.deptInfo.orderNum = "";
      _this.deptInfo.parentId = "";
      _this.deptInfo.description = "";
      _this.defaultCheckedKeys = [];
    }
  }
};
</script>

<style  lang="scss" scoped>
.search-input {
  width: 30%;
}
.el-row{
  width: 100%;
}

</style>