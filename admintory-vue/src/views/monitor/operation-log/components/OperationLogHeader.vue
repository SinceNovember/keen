<template>
  <div class="form-header">
    <el-row>
      <el-col :xs="24" :sm="16">
        <div class="search-header">
          <el-input
            v-model="nickname"
            class="search-input"
            placeholder="操作人"
            clearable
            @change="search"
          ></el-input>
          <el-input
            v-model="operation"
            class="search-input"
            placeholder="操作描述"
            clearable
            @change="search"
          ></el-input>
          <el-date-picker
            v-model="createTime"
            class="search-date"
            type="daterange"
            range-separator="-"
            start-placeholder="开始日期"
            end-placeholder="结束日期"
            value-format="yyyy-MM-dd"
            clearable
            @change="search"
          ></el-date-picker>
        </div>
      </el-col>
      <el-col :xs="24" :sm="8">
        <div class="btn-header">
          <div class="other-btn">
            <i class="bx bx-dots-vertical-rounded"></i>
          </div>
          <el-button type="danger" icon="el-icon-plus" @click="deleteSelect" plain>删除选中</el-button>
        </div>
      </el-col>
    </el-row>
  </div>
</template>

<script>
export default {
  data() {
    return {
      dialogVisible: false,
      nickname: "",
      operation: "",
      createTime: ""
    };
  },
  methods: {
    search() {
      var _this = this,
        createTimeFrom = "",
        createTimeTo = "",
        params = {};
      if (this.createTime) {
        createTimeFrom = _this.createTime[0];
        createTimeTo = _this.createTime[1];
      }
      params = {
        nickname: _this.nickname,
        operation: _this.operation,
        createTimeFrom: createTimeFrom,
        createTimeTo: createTimeTo
      };
      this.$emit("search", params);
    },

    deleteSelect() {
      this.$emit("deleteSelect");
    }
  }
};
</script>

<style  lang="scss" scoped>
.search-input {
  width: 20%;
}
.search-date {
  width: 35%;
}
.el-row {
  width: 100%;
}
</style>