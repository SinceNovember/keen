<template>
  <div class="container">
    <menu-header ref="menuHeader" @search="refreshTable" @deleteSelect="deleteSelect"></menu-header>
    <menu-table ref="menuTable" @openEditDialog="openEditDialog"></menu-table>
  </div>
</template>
<script>
import MenuHeader from "./components/MenuHeader";
import MenuTable from "./components/MenuTable";

export default {
  components: {
    MenuHeader,
    MenuTable
  },
  methods: {
    refreshTable(params) {
      this.$refs.menuTable.searchTable(params);
    },
    deleteSelect() {
      this.$refs.menuTable.deleteSelect();
    },
    openEditDialog(menuId) {
      this.$refs.menuHeader.openMenuDialog(menuId);
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