<template>
  <div class="container">
      <operation-log-header ref="logHeader" @search="refreshTable" @deleteSelect="deleteSelect" ></operation-log-header>
      <operation-log-table ref="logTable"></operation-log-table>
    </div>
</template>
<script>
import OperationLogHeader from './components/OperationLogHeader';
import OperationLogTable from './components/OperationLogTable';

export default {
  components:{
    OperationLogHeader,
    OperationLogTable
  },
  methods:{
    refreshTable(params){
      this.$refs.logTable.searchTable(params);
    },
    deleteSelect(){
      this.$refs.logTable.deleteSelect();
    },
 
  }


}

</script>
<!-- Add "scoped" attribute to limit CSS to this component only -->
<style  lang="scss" scoped>
.container{
  padding:20px 40px;



}

  
</style>