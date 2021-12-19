<template>
  <div class="container">
      <user-header ref="userHeader" @search="refreshTable" @deleteSelect="deleteSelect" @toggleUserStatus="toggleUserStatus"></user-header>
      <user-table ref="userTable" @openEditDialog="openEditDialog"></user-table>
    </div>
</template>
<script>
import UserHeader from './components/UserHeader';
import UserTable from './components/UserTable';
import { fetchUsers } from "@/api/user";

export default {
  components:{
    UserHeader,
    UserTable
  },
  methods:{
    refreshTable(params){
      this.$refs.userTable.searchTable(params);
    },
    deleteSelect(){
      this.$refs.userTable.deleteSelect();
    },
    toggleUserStatus(){
      this.$refs.userTable.updateUserStatus();
    },
    openEditDialog(userId){
      this.$refs.userHeader.openUserDialog(userId);
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