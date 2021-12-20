<template>
  <div class="chat-container">
    <el-tabs tab-position="left" v-model="activeName">
      <el-tab-pane name="chat">
        <span slot="label">
          <div class="chat-sidebar-item">
            <i class="bx bx-chat"></i>
          </div>
        </span>
        <chat
          :user="user"
          ref="chat"
          :onlineUserList="onlineUserList"
          :userList="userList"
          @changeOnlineStatus="changeOnlineStatus"
          @updateUnreadCount="updateUnreadCount"
        ></chat>
      </el-tab-pane>
      <el-tab-pane name="list">
        <span slot="label">
          <div class="chat-sidebar-item">
            <i class="el-icon-user"></i>
          </div>
        </span>
        <user-list ref="userList" :users="users" :userList="userList" @addUserChat="addUserChat"></user-list>
      </el-tab-pane>
    </el-tabs>
  </div>
</template>

<script>
import Chat from "./Chat";
import UserList from "./UserList";
import { fetchUsers, fetchOnlineUsers } from "@/api/user";

export default {
  props: {
    user: Object
  },
  components: {
    UserList,
    Chat
  },
  data() {
    return {
      users: [],
      userList: [],
      onlineUserList: [],
      activeName: "chat"
    };
  },
  mounted() {
    this.loadUsers();
  },
  methods: {
    loadUsers() {
      fetchUsers().then(res => {
        this.users = res.data.records;
        this.userList = this.users;
        this.onlineUserList = this.users.filter(user => user.online);
      });
    },
    addUserChat(user) {
      this.activeName = "chat";
      this.$refs.chat.addUserChat(user);
    },
    changeOnlineStatus(userId, status) {
      this.users.forEach(user => {
        if (user.userId == userId) {
          user.online = status;
        }
      });
      this.onlineUserList = this.users.filter(user => user.online);
    },
    updateUnreadCount(totalUnread) {
      this.$emit("updateUnreadCount", totalUnread);
    }
  }
};
</script>

<style lang="scss" scoped>
.chat-container {
  background: #ffffff;
  height: 80vh;

  .el-tabs {
    height: 100%;
    width: 100%;

    .el-tab-pane {
      width: 100%;
      height: 100%;
    }
  }
}
</style>