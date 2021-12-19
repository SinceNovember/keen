<template>
  <div class="chat-body">
    <div class="chat-sidebar" :class="back ? 'show' : 'close'">
      <div class="online-body">
        <div class="online-header">
          <h3>在线用户</h3>
          <span>{{onlineUserList.length}}</span>
        </div>
        <div class="online-list">
          <div class="avatar-item" v-for="(item, index) in onlineUserList" :key="index">
            <img class="avatar" :src="item.avatar" />
          </div>
        </div>
      </div>
      <div class="list-body">
        <div class="list-header">
          <h3>用户列表</h3>
          <el-input
            class="search"
            prefix-icon="el-icon-search"
            v-model="filterText"
            width="80px"
            placeholder="请输入用户昵称"
          ></el-input>
        </div>
        <ul class="user-list">
          <li
            class="user-item"
            :class="activeClass == user.userDTO.userId ? 'active' :''"
            :id="index"
            v-trigger
            v-for="(user,index) in relatedUserList"
            :key="index"
            @click="openMsg(user)"
          >
            <div class="tab-content">
              <div class="avatar-item" :class="{online: user.userDTO.online}">
                <img :src="user.userDTO.avatar" class="avatar" />
              </div>
              <div class="info-group">
                <span class="name">{{user.userDTO.nickname}}</span>
                <span
                  class="msg"
                >{{user.msgList.length > 0 ? user.msgList[user.msgList.length - 1].content : ''}}</span>
              </div>
              <div class="time">
                <template
                  v-if="user.unreadMsgCount == 0"
                >{{user.msgList.length > 0 ? user.msgList[user.msgList.length - 1].createTime : ''| dateStrFilter}}</template>
                <template v-else>
                  <span class="msg-num">{{user.unreadMsgCount}}</span>
                </template>
              </div>
            </div>
          </li>
        </ul>
      </div>
    </div>
    <div class="chat-main" :class="!back ? 'show' : 'close'">
      <div class="main-header">
        <div class="header-info">
          <div class="back" @click="back = true">
            <span>
              <i class="bx bx-chevron-left"></i>
            </span>
          </div>
          <div class="info">
            <span class="info-name">
              <span class="name">{{toUser.nickname}}</span>
              <span v-if="toUser.online" class="online-text">[在线]</span>
              <span v-else class="online-text">[离线]</span>
            </span>
            <span class="info-dept">{{toUser.deptName}}</span>
          </div>
          <div class="btn">
            <i class="bx bx-file"></i>
          </div>
        </div>
      </div>
      <div class="main-content" id="mainContent">
        <template v-for="message in messageList">
          <div class="message" :class="message.from" :key="message.id">
            <div class="time-line" v-if="message.timeLine">{{message.timeLine}}</div>
            <div class="message-content">
              <template v-if="message.from == 'me'">
                <div class="message-input">{{message.content}}</div>
                <img :src="message.avatar" />
              </template>
              <template v-else>
                <img :src="message.avatar" />
                <div class="message-input">{{message.content}}</div>
              </template>
            </div>
          </div>
        </template>
      </div>
      <div class="main-footer">
        <div class="send-content">
          <img
            class="user-avatar"
            src="http://47.104.70.138:8080/febs/images/avatar/cnrhVkzwxjPwAaCfPbdc.png"
          />
          <input v-model="content" placeholder="Please Enter..." />
          <i class="bx bx-paperclip"></i>
          <i class="bx bxl-telegram" @click="sendMsg"></i>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import { websocketSend, setMessageCallback } from "@/utils/websocket";
import { fetchMsgs, fetchRelatedUsers, clearUnreadMsg } from "@/api/msg";
import { fetchOnlineUsers } from "@/api/user";
import { dateFormat, nowTimeStr, getTimeLine } from "@/utils/utils";
export default {
  props: {
    user: Object,
    onlineUserList: Array
  },
  data() {
    return {
      content: "",
      toUser: {
        avatar:
          "http://47.104.70.138:8080/febs/images/avatar/cnrhVkzwxjPwAaCfPbdc.png"
      },
      message: {
        fromId: "",
        toId: "",
        content: "",
        type: "SINGLE_MSG"
      },
      //   onlineUserList: [],
      relatedUserList: [],
      _relatedUserList: [],
      messageList: [],
      activeClass: 0,
      filterText: "",
      back: true
    };
  },
  directives: {
    trigger: {
      inserted(el, binging) {
        el.id == 0 ? el.click() : null; // 只点击第一个，id是在循环中手动添加的
      }
    }
  },
  watch: {
    filterText(val) {
      if (val) {
        this.relatedUserList = this.relatedUserList.filter(item => {
          return item.userDTO.nickname.indexOf(val) !== -1;
        });
      } else {
        this.relatedUserList = this._relatedUserList;
      }
    }
  },
  mounted() {
    //打开聊天界面，初始化接受消息的方法
    setMessageCallback(this.wsMessage);
    this.loadRelatedUsers();
    this.bindEnterEvent();
  },
  methods: {
    loadRelatedUsers() {
      fetchRelatedUsers().then(res => {
        this.relatedUserList = res.data;
        this._relatedUserList = this.relatedUserList;
      });
    },
    sendMsg() {
      if (this.content) {
        //发送消息
        this.message.fromId = this.user.userId;
        this.message.toId = this.toUser.userId;
        this.message.content = this.content;
        websocketSend(this.message);

        this.messageList.push({
          content: this.content,
          from: "me",
          avatar: this.user.avatar,
          timeLine: getTimeLine(this.messageList[this.messageList.length - 1]),
          createTime: nowTimeStr()
        });
        this.relatedUserList.forEach(user => {
          if (user.userDTO.userId == this.toUser.userId) {
            user.unreadMsgCount = 0;
          }
        });
        this.content = "";
        this.refreshUnreadCount();
        this.sortRelatedUserList(this.toUser.userId);
        this.scrollToBottom();
      }
    },
    //接受消息方法
    wsMessage(data) {
      this.relatedUserList.forEach(user => {
        if (user.userDTO.userId == data.fromId) {
          if (data.type == "SINGLE_MSG") {
            user.msgList.push({
              content: data.content,
              from: "other",
              avatar: this.toUser.avatar,
              timeLine: getTimeLine(user.msgList[user.msgList.length - 1]),
              createTime: nowTimeStr()
            });
            // if (this.toUser.userId != data.fromId) {
            user.unreadMsgCount += 1;
            // }
            this.refreshUnreadCount();
            this.sortRelatedUserList(data.fromId);
            this.scrollToBottom();
          } else {
            if (data.type == "LOGIN_MSG") {
              user.userDTO.online = true;
              //给用户列表通知用户上线
            } else if (data.type == "LOGOUT_MSG") {
              user.userDTO.online = false;
              this.onlineUserList = this.onlineUserList.filter(
                user => user.userId != data.fromId
              );
            }
            this.$emit("changeOnlineStatus", data.fromId, user.userDTO.online);
          }
        }
      });
    },
    // ws连接失败，组件要执行的代码
    wsError() {
      // 比如取消页面的loading
    },
    openMsg(user) {
      this.activeClass = user.userDTO.userId; // 把当前点击元素的index，赋值给activeClass
      this.toUser = user.userDTO;
      this.messageList = user.msgList;
      //设置消息已读
      clearUnreadMsg({
        fromId: user.userDTO.userId
      }).then(res => {
        user.unreadMsgCount = 0;

        this.refreshUnreadCount();
      });

      this.scrollToBottom();
      this.back = false;
    },

    addUserChat(user) {
      var toUser = user,
        toMessageList = [],
        newUser = true;
      this.activeClass = user.userId;
      this.relatedUserList.forEach(item => {
        if (item.userDTO.userId == user.userId) {
          this.toUser = item.userDTO;
          this.messageList = item.msgList;
          newUser = false;
          this.scrollToBottom();
        }
      });
      if (newUser) {
        this.relatedUserList.unshift({
          userDTO: user,
          msgList: [],
          unreadMsgCount: 0
        });
        this.toUser = user;
        this.messageList = [];
      }
      this._relatedUserList = this.relatedUserList;
    },
    refreshUnreadCount() {
      var totalUnread = 0;
      this.relatedUserList.forEach(user => {
        totalUnread += user.unreadMsgCount;
      });
      this.$emit("updateUnreadCount", totalUnread);
    },
    //将滚动条置于底部
    scrollToBottom() {
      this.$nextTick(() => {
        let msg = document.getElementById("mainContent"); // 获取对象
        msg.scrollTop = msg.scrollHeight; // 滚动高度
      });
    },
    bindEnterEvent() {
      let _this = this;
      document.onkeydown = function(e) {
        let ev = document.all ? window.event : e;
        if (ev.keyCode === 13) {
          _this.sendMsg();
        }
      };
    },
    sortRelatedUserList(userId) {
      this.relatedUserList.map((item, index) => {
        if (item.userDTO.userId == userId) {
          this.relatedUserList.unshift(
            this.relatedUserList.splice(index, 1)[0]
          );
        }
      });
    }
  }
};
</script>

<style lang="scss" scoped>
.chat-body {
  height: 100%;

  .chat-sidebar {
    padding: 30px 10px 30px 30px;
    background: #fafafa;
    width: 35%;
    height: 100%;
    float: left;

    .avatar {
      width: 48px;
      height: 48px;
      border-radius: 50%;
    }

    .online-body {
      height: 130px;

      .online-header {
        display: flex;
        justify-content: space-between;

        span {
          font-size: 16px;
          height: 20px;
          width: 20px;
          background: #fff;
          color: #636ae7;
          display: flex;
          justify-content: center;
          align-items: center;
        }
      }

      .online-list {
        height: calc(100% - 40px);
        display: flex;
        align-items: center;

        img {
          width: 48px;
          height: 48px;
          margin-right: 20px;
        }
      }
    }

    .list-body {
      height: calc(100% - 130px);

      .list-header {
        height: 100px;

        .search {
          width: 98%;
          margin: 15px 0px;
        }
      }

      .user-list {
        // margin-right: 5px;
        height: calc(100% - 100px);
        overflow-y: scroll;

        .user-item {
          background: #fefefe;
          border-radius: 10px;
          margin: 0px 5px 20px 0px;
          padding: 10px;
          cursor: pointer;

          .tab-content {
            display: flex;
            align-items: center;

            .online {
              &::after {
                bottom: 5px;
              }
            }

            .info-group {
              width: 65%;
              margin-left: 20px;
              display: flex;
              flex-direction: column;

              .name {
                font-size: 18px;
              }

              .msg {
                font-size: 14px;
                overflow: hidden;
                text-overflow: ellipsis;
                white-space: nowrap;
              }
            }
            .time {
              font-size: 14px;
              width: calc(35% - 48px);
              color: #999;
              display: flex;
              align-content: center;
              justify-content: flex-end;
            }
            .msg-num {
              width: 24px;
              height: 24px;
              display: inline-block;
              font-size: 10px;
              border-radius: 50%;
              background: #3598ff;
              color: #ffffff;
              display: flex;
              justify-content: center;
              align-items: center;
            }
          }
        }
        .active {
          background: linear-gradient(45deg, #d9d9d961, #dbe5ed5c);
        }
      }
    }
  }

  .chat-main {
    width: 65%;
    height: calc(100% - 30px);
    float: right;

    .main-header {
      height: 60px;
      border-bottom: 1px solid #eee;

      .header-info {
        display: flex;
        justify-content: space-between;
        align-items: center;
        padding: 5px 40px 5px 5px;

        .back {
          display: none;
          font-size: 20px;
        }

        .info {
          display: flex;
          flex-direction: column;

          span {
            color: #999;
          }

          .info-name {
            display: flex;
            align-items: center;
            line-height: 25px;

            .name {
              font-size: 18px;
              color: #606266;
            }
            .online-text {
              margin-left: 4px;
              font-size: 14px;
            }
          }
        }

        .btn {
          i {
            font-size: 20px;
            color: #999;
          }
        }
      }
    }
    .main-content {
      height: calc(100% - 120px);
      padding: 20px 20px 0px;
      overflow-y: scroll;

      .message {
        width: 100%;
        margin-bottom: 30px;
        display: flex;
        flex-direction: column;
        align-items: flex-start;

        .time-line {
          padding-bottom: 20px;
          color: #999;
          width: 100%;
          display: flex;
          justify-content: center;
        }

        .message-content {
          display: flex;

          img {
            width: 48px;
            height: 48px;
            border-radius: 50%;
          }

          .message-input {
            width: 85%;
            position: relative;
            display: flex;
            align-items: center;
            min-height: 40px;
            background: #f6f5f8;
            border-radius: 5px;
            word-break: break-word;
            padding: 10px;
            line-height: 18px;

            &::after {
              content: "";
              display: block;
              position: absolute;
              width: 0;
              height: 0;
              border: 8px solid transparent;
              top: 15px;
            }
          }
        }
      }
      .other {
        .message-content {
          .message-input {
            margin-left: 10px;

            &::after {
              border-right-color: #f6f5f8;
              left: -14px;
            }
          }
        }
      }
      .me {
        display: flex;
        align-items: flex-end;

        .message-content {
          display: flex;
          justify-content: flex-end;

          .message-input {
            margin-right: 10px;
            background: #3598ff;
            color: #fbfbfb;

            &::after {
              border-left-color: #3598ff;
              right: -14px;
            }
          }
        }
      }
    }
    .main-footer {
      height: 80px;
      background: #fafafa;
      display: flex;
      align-items: center;
      justify-content: center;

      .send-content {
        position: relative;
        display: flex;
        align-items: center;
        justify-content: center;
        width: 100%;

        .user-avatar {
          width: 28px;
          height: 28px;
          border-radius: 50%;
          position: absolute;
          left: 10px;
        }

        input {
          outline: none;
          padding-left: 45px;
          padding-right: 90px;
          height: 50px;
          line-height: 35px;
          width: 100%;
          border-radius: 5px;
          border: 1px solid #fafafa;
        }

        i {
          position: absolute;
          font-size: 20px;
          cursor: pointer;
        }

        .bx-paperclip {
          right: 60px;
        }

        .bxl-telegram {
          right: 30px;
          color: #3598ff;
        }
      }
    }
  }
}

</style>