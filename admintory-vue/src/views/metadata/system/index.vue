<template>
  <div class="container">
      <system-config-header ref="configHeader" @search="refreshTable" @deleteSelect="deleteSelect" ></system-config-header>
      <system-config-table ref="configTable" @openEditDialog="openEditDialog"></system-config-table>
    </div>
</template>
<script>
import SystemConfigHeader from './components/SystemConfigHeader';
import SystemConfigTable from './components/SystemConfigTable';

export default {
  components:{
    SystemConfigHeader,
    SystemConfigTable
  },
  methods:{
    refreshTable(params){
      this.$refs.configTable.searchTable(params);
    },
    deleteSelect(){
      this.$refs.configTable.deleteSelect();
    },

    openEditDialog(configId){
      this.$refs.configHeader.openConfigDialog(configId);
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