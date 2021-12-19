<template>
  <div class="container">
      <code-item-header ref="codeItemHeader" :codeId="codeId" @search="refreshTable" @deleteSelect="deleteSelect" ></code-item-header>
      <code-item-table ref="codeItemTable" :codeId="codeId" @openEditDialog="openEditDialog"></code-item-table>
    </div>
</template>
<script>
import CodeItemHeader from './components/CodeItemHeader';
import CodeItemTable from './components/CodeItemTable';

export default {
  components:{
    CodeItemHeader,
    CodeItemTable
  },
  props:{
    codeId: Number
  },
  methods:{
    refreshTable(params){
      this.$refs.codeItemTable.searchTable(params);
    },
    deleteSelect(){
      this.$refs.codeItemTable.deleteSelect();
    },
    openEditDialog(itemId){
      this.$refs.codeItemHeader.openCodeItemDialog(itemId);
    }
  }


}

</script>
<!-- Add "scoped" attribute to limit CSS to this component only -->
<style  lang="scss" scoped>
.container{
  padding:40px;
}

  
</style>