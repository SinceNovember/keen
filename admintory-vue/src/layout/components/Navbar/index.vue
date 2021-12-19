<template>
  <div class="navbar">
    <div class="home-content">
      <i class="bx bx-menu" @click="toggleSidebar()"></i>
    </div>

    <div class="navbar-actions-area">
      <div class="navbar-search">
        <input type="input" placeholder="Search..." />
        <i class="bx bx-search"></i>
      </div>
      <div class="navbar-detail-actions">
        <div class="action-icon" @click="dialogVisible=true">
          <i class="bx bx-message-rounded"></i>
          <span v-if="unreadCount != 0" class="msg-num">{{unreadCount}}</span>
        </div>
        <div class="action-icon" @click="themeDialogVisible=true">
          <i class="bx bx-layer"></i>
        </div>
        <div class="action-icon">
          <i class="bx bx-help-circle"></i>
        </div>
        <div class="user-dropdown">
          <el-dropdown trigger="click" @command="handleCommand">
            <div class="user-info">
              <img :src="user.avatar" />
              <span class="user-info-name">{{user.nickname}}</span>
            </div>
            <el-dropdown-menu split-button slot="dropdown">
              <div class="user-summary">
                <div class="user-summary-img">
                  <img :src="user.avatar" />
                </div>
                <div class="user-summary-info">
                  <div class="user-summary-info-name">{{user.nickname}}</div>
                  <div class="user-summary-info-dept">{{user.deptName}}</div>
                </div>
              </div>
              <el-dropdown-item command="info" divided>
                <i class="bx bx-user"></i>个人信息
              </el-dropdown-item>
              <el-dropdown-item command="setting">
                <i class="bx bxs-wrench"></i>系统设置
              </el-dropdown-item>
              <el-dropdown-item divided command="logout">
                <i class="bx bx-power-off"></i>注销登陆
              </el-dropdown-item>
            </el-dropdown-menu>
          </el-dropdown>
        </div>
      </div>
    </div>

    <el-dialog :visible.sync="dialogVisible" width="60%" height="500px">
      <chat :user="user" @updateUnreadCount="updateUnreadCount" ref="chat"></chat>
    </el-dialog>

    <el-dialog :visible.sync="themeDialogVisible" v-if="themeDialogVisible" width="70rem">
      <theme></theme>
    </el-dialog>
  </div>
</template>

<script>
import { sendWebsocket, closeWebsocket } from "@/utils/websocket";
import { mapGetters } from "vuex";
import { getUserByToken } from "@/api/user";
import { getToken } from "@/utils/auth";
import { countUnreadAllMsg } from "@/api/msg";
import Chat from "./chat/index";
import Theme from "./Theme";

export default {
  beforeDestroy() {
    // 页面销毁时关闭ws。因为有可能ws连接接收数据尚未完成，用户就跳转了页面
    // 在需要主动关闭ws的地方都可以调用该方法
    closeWebsocket();
  },
  components: {
    Chat,
    Theme
  },
  data() {
    return {
      user: {},
      dialogVisible: false,
      themeDialogVisible: false,
      message: {
        fromId: "",
        toId: "",
        content: "",
        type: "LOGIN_MSG"
      },
      unreadCount: 0
    };
  },
  computed: {
    ...mapGetters(["sidebar"])
  },
  mounted() {
    getUserByToken({
      token: getToken()
    }).then(res => {
      this.user = res.data;
      this.initWs();
    });
  },
  methods: {
    updateUnreadCount(totalUnread) {
      this.unreadCount = totalUnread;
    },
    // // ws连接成功，后台返回的ws数据，组件要拿数据渲染页面等操作
    wsMessage(data) {
      this.unreadCount++;
      // 这里写拿到数据后的业务代码
    },
    // ws连接失败，组件要执行的代码
    wsError() {
      // 比如取消页面的loading
    },
    initWs() {
      //初始化websocket,向服务器发起连接请求，记录用户
      // 防止用户多次连续点击发起请求，所以要先关闭上次的ws请求。
      closeWebsocket();
      // 跟后端协商，需要什么参数数据给后台
      this.message.fromId = this.user.userId;
      // 发起ws请求
      sendWebsocket(this.message, this.wsMessage, this.wsError);
      countUnreadAllMsg().then(res => {
        this.unreadCount = res.data;
      });
    },
    openMsgDialog() {
      this.dialogVisible = true;
      this.$refs.chat.scrollToBottom();
    },

    toggleSidebar() {
      this.$store.dispatch("app/toggleSideBar");
    },
    handleCommand(command) {
      if (command == "info") {
        this.$router.push(`/base/profile`);
      } else if (command == "setting") {
      } else if (command == "logout") {
        this.$confirm("确认退出登陆？", "退出登陆", {
          confirmButtonText: "确认",
          cancelButtonText: "取消",
          type: "warning"
        }).then(() => {
          this.logout();
        });
      }
    },
    async logout() {
      await this.$store.dispatch("user/logout");
      this.$router.push(`/login?redirect=${this.$route.fullPath}`);
    }
  }
};
</script>

<style>
</style>