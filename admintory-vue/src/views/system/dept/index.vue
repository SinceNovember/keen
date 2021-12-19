<template>
  <div class="container">
    <dept-header ref="deptHeader" @search="refreshTable"></dept-header>
    <dept-table ref="deptTable" @openEditDialog="openEditDialog"></dept-table>
  </div>
</template>
<script>
import DeptHeader from "./components/DeptHeader";
import DeptTable from "./components/DeptTable";

export default {
  components: {
    DeptHeader,
    DeptTable
  },
  methods: {
    refreshTable(params) {
      this.$refs.deptTable.searchTable(params);
    },

    openEditDialog(deptId) {
      this.$refs.deptHeader.openDeptDialog(deptId);
    }
  }
};
</script>
<!-- Add "scoped" attribute to limit CSS to this component only -->
<style  lang="scss" scoped>
.container {
  padding: 20px 40px;
}
</style>