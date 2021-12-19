<template>
  <div class="container">
      <role-header ref="roleHeader" @search="refreshTable" @deleteSelect="deleteSelect"  @toggleRoleStatus="toggleRoleStatus"></role-header>
      <role-table ref="roleTable" @openEditDialog="openEditDialog"></role-table>
    </div>
</template>
<script>
import RoleHeader from './components/RoleHeader';
import RoleTable from './components/RoleTable';

export default {
  components:{
    RoleHeader,
    RoleTable
  },
  methods:{
    refreshTable(params){
      this.$refs.roleTable.searchTable(params);
    },
    deleteSelect(){
      this.$refs.roleTable.deleteSelect();
    },
    toggleRoleStatus(){
      this.$refs.roleTable.updateRoleStatus();
    },
    openEditDialog(roleId){
      this.$refs.roleHeader.openRoleDialog(roleId);
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