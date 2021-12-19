<template>
  <div class="profile-container">
  <el-tabs v-model="activeName" @tab-click="handleClick" tab-position="left">
    <el-tab-pane name="info"> 
      <div  class="item" slot="label">
        <i class='bx bxs-edit-alt'></i> <span>个人资料</span>
      </div>
      <div class="user-profile">
          <user-profile></user-profile>
      </div>
    </el-tab-pane>
    <el-tab-pane label="配置管理" name="password">
      <div  class="item" slot="label">
        <i class='bx bx-shield-quarter'></i> <span>密码修改</span>
      </div>
      <div class="user-password">
          <user-password></user-password>
      </div>
    </el-tab-pane>
  </el-tabs>
  </div>
</template> 

<script>
import UserProfile from './components/UserProfile'
import UserPassword from './components/UserPassword'
export default {
  components:{
    UserProfile,
    UserPassword
  },
  data(){
    return {
      activeName: "info"
    }
  }
}
</script>

<style lang="scss" scoped>

  .profile-container{
    height: 100%;

    .item{
      display: flex;
      align-items: center;
      font-size: 16px;
      text-align: left;
      margin: 10px 5px;

      i{
          font-size: 20px;
          margin-right: 5px;
        }
    }
  }
</style>