<template>
  <div class="container">
      <theme-header ref="themeHeader" @search="refreshTable" @deleteSelectTheme="deleteSelectTheme" ></theme-header>
      <theme-table ref="themeTable" @openEditDialog="openEditDialog"></theme-table>
    </div>
</template>
<script>
import ThemeHeader from './components/ThemeHeader';
import ThemeTable from './components/ThemeTable';

export default {
  components:{
    ThemeHeader,
    ThemeTable
  },
  methods:{
    refreshTable(params){
      this.$refs.themeTable.searchTable(params);
    },
    deleteSelectTheme(){
      this.$refs.themeTable.deleteSelectTheme();
    },

    openEditDialog(id){
      this.$refs.themeHeader.openThemeDialog(id);
    }
  }


}

</script>
<!-- Add "scoped" attribute to limit CSS to this component only -->
<style  lang="scss" scoped>
.container{
  padding:20px 40px;



}

  
</style>