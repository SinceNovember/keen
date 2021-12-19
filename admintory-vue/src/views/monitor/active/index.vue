<template>
  <div class="active-container">
    <h3>在线用户</h3>
    <active-user-table></active-user-table>
  </div>
</template>
<script>
import ActiveUserTable from "./components/ActiveUserTable";
export default {
  components: {
    ActiveUserTable
  },
  methods: {
    refreshTable(params) {
      this.$refs.logTable.searchTable(params);
    },
    deleteSelectLog() {
      this.$refs.logTable.deleteSelectLog();
    }
  }
};
</script>
<!-- Add "scoped" attribute to limit CSS to this component only -->
<style  lang="scss" scoped>
.active-container {
  // height: 100%;
  padding: 20px;
}
</style>