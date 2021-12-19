<template>
  <div class="chat-container">
    <div class="chat-body">
      <div class="chat-sidebar">
        <div class="online-body">
          <div class="online-header">
            <h3>在线用户</h3>
            <span>10</span>
          </div>
          <div class="online-list">
            <img src="http://47.104.70.138:8080/febs/images/avatar/cnrhVkzwxjPwAaCfPbdc.png" />
            <img src="http://47.104.70.138:8080/febs/images/avatar/cnrhVkzwxjPwAaCfPbdc.png" />
            <img src="http://47.104.70.138:8080/febs/images/avatar/cnrhVkzwxjPwAaCfPbdc.png" />
          </div>
        </div>
        <div class="list-body">
          <div class="list-header">
            <h3>用户列表</h3>
            <el-input
              class="search"
              prefix-icon="el-icon-search"
              v-model="input"
              width="80px"
              placeholder="请输入内容"
            ></el-input>
          </div>
          <ul class="user-list">
            <li class="user-item">
              <div class="tab-content">
                <img
                  src="http://47.104.70.138:8080/febs/images/avatar/cnrhVkzwxjPwAaCfPbdc.png"
                  class="avatar"
                />
                <div class="info-group">
                  <span class="name">刘勇</span>
                  <span class="msg">你最近发了什么消息啊</span>
                </div>
                <span class="time">11:45</span>
              </div>
            </li>
            <li class="user-item">
              <div class="tab-content">
                <img
                  src="http://47.104.70.138:8080/febs/images/avatar/cnrhVkzwxjPwAaCfPbdc.png"
                  class="avatar"
                />
                <div class="info-group">
                  <span class="name">刘勇</span>
                  <span class="msg">你最近发了什么消息啊</span>
                </div>
                <span class="time">11:45 pm</span>
              </div>
            </li>
            <li class="user-item">
              <div class="tab-content">
                <img
                  src="http://47.104.70.138:8080/febs/images/avatar/cnrhVkzwxjPwAaCfPbdc.png"
                  class="avatar"
                />
                <div class="info-group">
                  <span class="name">刘勇</span>
                  <span class="msg">你最近发了什么消息啊</span>
                </div>
                <span class="time">11:45 pm</span>
              </div>
            </li>
            <li class="user-item">
              <div class="tab-content">
                <img
                  src="http://47.104.70.138:8080/febs/images/avatar/cnrhVkzwxjPwAaCfPbdc.png"
                  class="avatar"
                />
                <div class="info-group">
                  <span class="name">刘勇</span>
                  <span class="msg">你最近发了什么消息啊</span>
                </div>
                <span class="time">11-15</span>
              </div>
            </li>
            <li class="user-item">
              <div class="tab-content">
                <img
                  src="http://47.104.70.138:8080/febs/images/avatar/cnrhVkzwxjPwAaCfPbdc.png"
                  class="avatar"
                />
                <div class="info-group">
                  <span class="name">刘勇</span>
                  <span class="msg">你最近发了什么消息啊</span>
                </div>
                <span class="time">11:45 pm</span>
              </div>
            </li>
            <li class="user-item">
              <div class="tab-content">
                <img
                  src="http://47.104.70.138:8080/febs/images/avatar/cnrhVkzwxjPwAaCfPbdc.png"
                  class="avatar"
                />
                <div class="info-group">
                  <span class="name">刘勇</span>
                  <span class="msg">你最近发了什么消息啊</span>
                </div>
                <span class="time">11:45 pm</span>
              </div>
            </li>
            <li class="user-item">
              <div class="tab-content">
                <img
                  src="http://47.104.70.138:8080/febs/images/avatar/cnrhVkzwxjPwAaCfPbdc.png"
                  class="avatar"
                />
                <div class="info-group">
                  <span class="name">刘勇</span>
                  <span class="msg">你最近发了什么消息啊</span>
                </div>
                <span class="time">11:45 pm</span>
              </div>
            </li>
          </ul>
        </div>
      </div>
      <div class="chat-main">
        <div class="main-header">
          <div class="header-info">
            <div class="info">
              <span class="info-name">刘宇东</span>
              <span class="info-dept">大数据研发2部</span>
            </div>
            <div class="btn">
              <i class="bx bx-file"></i>
            </div>
          </div>
        </div>
        <div class="main-content">
          <template v-for="message in messageList">
            <div class="message" :class="message.from" :key="message.id">
              <div class="time-line" v-if="message.time">11:56</div>
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
            <input type="input" v-model="message.content" placeholder="Please Enter..." />
            <i class="bx bx-paperclip"></i>
            <i class="bx bxl-telegram" @click="sendDataToServer"></i>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      // ws是否启动
      wsIsRun: false,
      // 定义ws对象
      webSocket: null,
      // ws请求链接（类似于ws后台地址）
      ws: "",
      // ws定时器
      wsTimer: null,
      message: {
        fromId: 23,
        toId: 32,
        content: "",
        type: "SINGlE_MSG"
      },
      messageList: [
        {
          time: "2020-10-20",
          content: "你好啊",
          avatar:
            "http://47.104.70.138:8080/febs/images/avatar/cnrhVkzwxjPwAaCfPbdc.png",
          from: "me"
        },
        {
          time: "",
          content: "你好啊",
          avatar:
            "http://47.104.70.138:8080/febs/images/avatar/cnrhVkzwxjPwAaCfPbdc.png",
          from: "me"
        },
        {
          time: "2020-12-32",
          content: "你好啊",
          avatar:
            "http://47.104.70.138:8080/febs/images/avatar/cnrhVkzwxjPwAaCfPbdc.png",
          from: "other"
        },
        {
          time: "",
          content:
            "你好啊你好啊你好啊你好啊你好啊你好啊你好啊你好啊你好啊你好啊你好啊你好啊你好啊你好啊你好啊你好啊你好啊你好啊你好啊你好啊你好啊你好啊你好啊",
          avatar:
            "http://47.104.70.138:8080/febs/images/avatar/cnrhVkzwxjPwAaCfPbdc.png",
          from: "other"
        },
        {
          time: "",
          content: "你好啊",
          avatar:
            "http://47.104.70.138:8080/febs/images/avatar/cnrhVkzwxjPwAaCfPbdc.png",
          from: "me"
        },
        {
          time: "11.25",
          content:
            "你好啊你好啊你好啊你好啊你好啊你好啊你好啊你好啊你好啊你好啊你好啊你好啊你好啊你好啊你好啊你好啊你好啊你好啊你好啊你好啊你好啊你好啊你好啊你好啊",
          avatar:
            "http://47.104.70.138:8080/febs/images/avatar/cnrhVkzwxjPwAaCfPbdc.png",
          from: "me"
        }
      ]
    };
  },
  async mounted() {
    this.wsIsRun = true;
    this.wsInit();
  },
  methods: {
    sendDataToServer() {
      if (this.webSocket.readyState === 1) {
        this.webSocket.send(JSON.stringify(this.message));
      } else {
        throw Error("服务未连接");
      }
    },
    /**
     * 初始化ws
     */
    wsInit() {
      const wsuri = "ws://localhost:9999/ws";
      this.ws = wsuri;
      if (!this.wsIsRun) return;
      // 销毁ws
      this.wsDestroy();
      // 初始化ws
      this.webSocket = new WebSocket(this.ws);
      // ws连接建立时触发
      this.webSocket.addEventListener("open", this.wsOpenHanler);
      // ws服务端给客户端推送消息
      this.webSocket.addEventListener("message", this.wsMessageHanler);
      // ws通信发生错误时触发
      this.webSocket.addEventListener("error", this.wsErrorHanler);
      // ws关闭时触发
      this.webSocket.addEventListener("close", this.wsCloseHanler);

      // 检查ws连接状态,readyState值为0表示尚未连接，1表示建立连接，2正在关闭连接，3已经关闭或无法打开
      clearInterval(this.wsTimer);
      this.wsTimer = setInterval(() => {
        if (this.webSocket.readyState === 1) {
          clearInterval(this.wsTimer);
        } else {
          console.log("ws建立连接失败");
          this.wsInit();
        }
      }, 3000);
    },
    wsOpenHanler(event) {
      console.log("ws建立连接成功");
    },
    wsMessageHanler(e) {
      console.log("wsMessageHanler");
      console.log(e);
      //const redata = JSON.parse(e.data)
      //console.log(redata)
    },
    /**
     * ws通信发生错误
     */
    wsErrorHanler(event) {
      console.log(event, "通信发生错误");
      this.wsInit();
    },
    /**
     * ws关闭
     */
    wsCloseHanler(event) {
      console.log(event, "ws关闭");
      this.wsInit();
    },
    /**
     * 销毁ws
     */
    wsDestroy() {
      if (this.webSocket !== null) {
        this.webSocket.removeEventListener("open", this.wsOpenHanler);
        this.webSocket.removeEventListener("message", this.wsMessageHanler);
        this.webSocket.removeEventListener("error", this.wsErrorHanler);
        this.webSocket.removeEventListener("close", this.wsCloseHanler);
        this.webSocket.close();
        this.webSocket = null;
        clearInterval(this.wsTimer);
      }
    }
  }
};
</script>

<style lang="scss" scoped>
.chat-container {
  background: #ffffff;
  height: 80vh;

  .chat-body {
    height: 100%;

    .chat-sidebar {
      padding: 30px 10px 30px 30px;
      background: #fafafa;
      width: 35%;
      height: 100%;
      float: left;

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
          height: calc(100% - 100px);
          overflow: scroll;

          .user-item {
            background: #fefefe;
            border-radius: 10px;
            margin-bottom: 0px 5px 20px 0px;
            padding: 10px;
            cursor: pointer;

            &:active {
              background: linear-gradient(45deg, #d9d9d961, #dbe5ed5c);
            }

            .tab-content {
              display: flex;
              align-items: center;

              .avatar {
                width: 48px;
                height: 48px;
                border-radius: 50%;
              }
              .info-group {
                width: 70%;
                margin-left: 20px;
                display: flex;
                flex-direction: column;

                .name {
                  font-size: 20px;
                  padding-bottom: 5 px;
                }

                .msg {
                  font-size: 14px;
                  color: #999;
                }
              }
              .time {
                font-size: 14px;
                width: calc(30% - 48px);
                color: #999;
                text-align: right;
              }
            }
          }
        }
      }
    }

    .chat-main {
      width: 65%;
      height: calc(100% - 30px);
      float: right;

      .main-header {
        height: 40px;
        border-bottom: 1px solid #eee;

        .header-info {
          display: flex;
          justify-content: space-between;
          align-items: center;
          padding: 5px 20px;

          .info-name {
            position: absolute;
            top: 8px;
            font-size: 18px;
          }
          .info-dept {
            color: #999;
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
        height: calc(100% - 110px);
        padding: 20px 20px 0px;
        overflow: scroll;

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
              min-height: 40px;
              background: #f6f5f8;
              border-radius: 5px;
              line-height: 40px;
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
}
</style>