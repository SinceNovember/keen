<template>
  <div class="container">
    <code-main-header ref="codeMainHeader" @search="refreshTable" @deleteSelect="deleteSelect"></code-main-header>
    <code-main-table ref="codeMainTable" @openEditDialog="openEditDialog"></code-main-table>
  </div>
</template>
<script>
import CodeMainHeader from "./components/CodeMainHeader";
import CodeMainTable from "./components/CodeMainTable";

export default {
  components: {
    CodeMainHeader,
    CodeMainTable
  },
  methods: {
    refreshTable(params) {
      this.$refs.codeMainTable.searchTable(params);
    },
    deleteSelect() {
      this.$refs.codeMainTable.deleteSelect();
    },

    openEditDialog(codeId) {
      this.$refs.codeMainHeader.openCodeMainDialog(codeId);
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