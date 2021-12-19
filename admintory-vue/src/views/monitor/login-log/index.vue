<template>
  <div class="container">
      <login-log-header ref="logHeader" @search="refreshTable" @deleteSelect="deleteSelect" ></login-log-header>
      <login-log-table ref="logTable"></login-log-table>
    </div>
</template>
<script>
import LoginLogHeader from './components/LoginLogHeader';
import LoginLogTable from './components/LoginLogTable';

export default {
  components:{
    LoginLogHeader,
    LoginLogTable
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