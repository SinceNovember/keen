<template>
  <div class="dashboard-container">
    <h2>控制台</h2>
    <panel-group :visitCount="visitCount" :todayCount="todayCount" :messageCount="messageCount" :onlineCount="onlineCount"></panel-group>
    <el-row :gutter="40" class="chart-panel-group">
      <el-col :lg="17" :xs="24" :sm="24" class="card-panel-col">
        <el-row :gutter="40" class="chart-panel-group history-chart">
          <el-card class="box-card">
            <div slot="header" class="clearfix">
              <span class="card-title">历史访问</span>
            </div>
            <div class="text item">
              <line-chart :chart-data="visitHistory" />
            </div>
          </el-card>
        </el-row>
        <el-row :gutter="40" class="chart-panel-group">
          <el-col :gutter="40" :lg="12" :xs="24" :sm="24" class="card-panel-col">
            <el-card class="box-card">
              <div slot="header" class="clearfix">
                <span class="card-title">部门数据</span>
              </div>
              <div class="text item">
                <bar-chart :chart-data="deptMember" />
              </div>
            </el-card>
          </el-col>
          <el-col :gutter="40" :lg="12" :xs="24" :sm="24" class="card-panel-col">
            <el-card class="box-card">
              <div slot="header" class="clearfix">
                <span class="card-title">角色数据</span>
              </div>
              <div class="text item">
                <ring-chart :chart-data="roleMember" />
              </div>
            </el-card>
          </el-col>
        </el-row>
      </el-col>
      <el-col :gutter="40" :lg="7" :xs="24" :sm="24" class="card-panel-col">
        <el-card class="box-card">
          <div slot="header" class="clearfix">
            <span class="card-title">消息列表</span>
          </div>
          <div class="msg-list">
            <div v-if="messageList.length === 0" class="no-msg">
              <i class="el-icon-chat-line-round"></i>
              您暂时还没有收到任何消息
            </div>
            <div v-else class="msg-item" v-for="(msg, index) in messageList" :key="index">
              <el-avatar class="avatar" :size="size" :src="msg.avatar"></el-avatar>
              <div class="item-text">
                <span class="title">
                  <span class="name">{{msg.nickname}}</span>回复了你
                </span>
                <el-tooltip
                  class="tooltop"
                  effect="dark"
                  :content="msg.content"
                  placement="top-start"
                >
                  <span class="msg">{{msg.content}}</span>
                </el-tooltip>

                <span class="time">{{msg.createTime | dateStrFilter}}</span>
              </div>
            </div>
          </div>
        </el-card>
      </el-col>
    </el-row>
  </div>
</template>
<script>
import { fetchLoginLogCount, fetchLoginLogHistory } from "@/api/monitor";
import { countUnreadAllMsg } from "@/api/msg";
import { fetchActiveUsers } from "@/api/monitor";
import { fetchDeptMemberCountTop6 } from "@/api/dept";
import { fetchRoleMemberCountTop6 } from "@/api/role";
import { fetchUnreadAllMsg } from "@/api/msg";
import PanelGroup from "./components/PanelGroup";
import LineChart from "./components/LineChart";
import BarChart from "./components/BarChart";
import RingChart from "./components/RingChart";

export default {
  components: {
    PanelGroup,
    LineChart,
    BarChart,
    RingChart
  },
  data() {
    return {
      visitHistory: {
        nameList: [],
        dataList: []
      },
      deptMember: {
        nameList: [],
        dataList: []
      },
      roleMember: {},
      visitCount: 0,
      todayCount: 0,
      messageCount: 0,
      onlineCount: 0,
      messageList: [],
      chartBackgroundColor: "#fff",
      // lineChartData: lineChartData.newVisitis,

      size: 48
    };
  },

  mounted() {
    this.initData();
  },
  methods: {
    initData() {
      fetchLoginLogCount().then(res => {
        this.visitCount = res.data;
      });
      countUnreadAllMsg().then(res => {
        this.messageCount = res.data;
      });
      fetchActiveUsers().then(res => {
        this.onlineCount = res.data.length;
      });
      fetchLoginLogHistory().then(res => {
        const { data } = res;
        this.visitHistory.nameList = data.map(item => item.date);
        this.visitHistory.dataList = data.map(item => item.count);
        this.todayCount = this.visitHistory.dataList[this.visitHistory.dataList.length - 1];
        console.log(this.todayCount);
      });
      fetchDeptMemberCountTop6().then(res => {
        const { data } = res;
        this.deptMember.nameList = data.map(item => item.name);
        this.deptMember.dataList = data.map(item => item.value);
      });
      fetchRoleMemberCountTop6().then(res => {
        this.roleMember = res.data;
      });
      fetchUnreadAllMsg().then(res => {
        this.messageList = res.data;
      });
    }
  }
};
</script>
<!-- Add "scoped" attribute to limit CSS to this component only -->
<style lang="scss" scoped>
.dashboard-container {
  padding: 20px 32px 32px;
  height: 100vh;

  .history-chart {
    padding: 0px 20px;
  }

  .chart-panel-group {
    height: 450px;

    .box-card {
      margin-bottom: 32px;
    }

    .card-title {
      font-size: 18px;
      font-weight: bold;
    }

    .msg-list {
      height: 765px;

      .msg-item {
        display: flex;
        align-items: flex-start;
        justify-content: flex-start;
        border-bottom: 1px solid #eee;
        padding-bottom: 10px;
        margin-bottom: 20px;

        .avatar {
          margin-right: 5px;
        }

        .item-text {
          display: flex;
          flex-direction: column;
          margin-left: 15px;
          width: 80%;

          .title {
            margin-bottom: 5px;

            .name {
              font-size: 16px;
              font-weight: bold;
              margin-right: 4px;
            }
          }

          .msg {
            font-size: 15px;
            margin-bottom: 3px;
            color: #606266;
            display: -webkit-box;
            -webkit-box-orient: vertical;
            -webkit-line-clamp: 2;
            overflow: hidden;
            width: 95%;
          }

          .time {
            font-size: 14px;
            color: #999;
          }
        }
      }

      .no-msg {
        display: flex;
        flex-direction: column;
        align-items: center;
        justify-content: center;
        height: 100%;
        color: #6d6c72bf;

        i {
          font-size: 80px;
          margin-bottom: 10px;
        }
      }
    }
  }
}
</style>