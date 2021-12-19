<template>
  <div class="card-list">
    <div class="card" v-for="item in activeUserList" :key="item.id">
      <div class="card-info">
        <div class="refresh">
          <i class="el-icon-refresh" @click="loadActiveUsers"></i>
        </div>
        <img class="avatar" :src="item.user.avatar" />
        <span class="title">{{item.user.nickname}}</span>
        <span class="sub-title">{{item.user.deptName}}</span>
        <span class="sub-title intro-title">{{item.user.description}}</span>

        <div class="other" @click="openActiveUserInfo(item)">
          <i class="el-icon-more"></i>
        </div>
      </div>

      <div class="card-bottom" v-if="!item.current" @click="forceLogout(item)">
        <i class="bx bx-log-out"></i>
        <span class="title">强制退出</span>
      </div>
    </div>

    <el-dialog :visible.sync="dialogVisible" v-if="dialogVisible" width="30rem">
      <active-user-info :activeUserInfo="activeUserInfo" @closeDialog="closeDeptDialog"></active-user-info>
    </el-dialog>
  </div>
</template>

<script>
import { fetchActiveUsers, deleteActiveUser } from "@/api/monitor";
import ActiveUserInfo from "./ActiveUserInfo";
export default {
  components: {
    ActiveUserInfo
  },
  data() {
    return {
      activeUserList: [],
      dialogVisible: false,
      activeUserInfo: ""
    };
  },
  mounted() {
    this.loadActiveUsers();
  },
  methods: {
    loadActiveUsers() {
      fetchActiveUsers().then(res => {
        this.activeUserList = res.data;
      });
    },
    forceLogout(activeUser) {
      this.$confirm("确定要强制退出用户?", "提示", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning"
      }).then(() => {
        deleteActiveUser({
          id: activeUser.id,
          userId: activeUser.userId,
          current: activeUser.current
        }).then(res => {
          this.loadActiveUsers();
          this.$message({
            message: "强制退出成功",
            type: "success"
          });
        });
      });
    },
    openActiveUserInfo(item) {
      this.activeUserInfo = item;
      this.dialogVisible = true;
    }
  }
};
</script>

<style lang="scss" scoped>
.card-list{
  margin-top: 10px;
}
</style>