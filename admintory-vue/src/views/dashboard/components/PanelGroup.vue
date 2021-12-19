<template>
  <el-row :gutter="40" class="panel-group">
    <el-col :xs="12" :sm="12" :lg="6" class="card-panel-col">
      <div class="card-panel" @click="handleSetLineChartData('newVisitis')">
        <div class="card-panel-icon-wrapper icon-people">
          <i class="bx bx-group"></i>
        </div>
        <div class="card-panel-description">
          <div class="card-panel-text">访问总量</div>
          <count-to :start-val="0" :end-val="visitCount" :duration="2600" class="card-panel-num" />
        </div>
      </div>
    </el-col>
    <el-col :xs="12" :sm="12" :lg="6" class="card-panel-col">
      <div class="card-panel" @click="handleSetLineChartData('messages')">
        <div class="card-panel-icon-wrapper icon-message">
          <i class="bx bx-message-dots"></i>
        </div>
        <div class="card-panel-description">
          <div class="card-panel-text">未读消息</div>
          <count-to :start-val="0" :end-val="messageCount" :duration="3000" class="card-panel-num" />
        </div>
      </div>
    </el-col>
    <el-col :xs="12" :sm="12" :lg="6" class="card-panel-col">
      <div class="card-panel" @click="handleSetLineChartData('purchases')">
        <div class="card-panel-icon-wrapper icon-money">
          <i class="bx bx-user-check"></i>
        </div>
        <div class="card-panel-description">
          <div class="card-panel-text">在线人数</div>
          <count-to :start-val="0" :end-val="onlineCount" :duration="3200" class="card-panel-num" />
        </div>
      </div>
    </el-col>
    <el-col :xs="12" :sm="12" :lg="6" class="card-panel-col">
      <div class="card-panel" @click="handleSetLineChartData('shoppings')">
        <div class="card-panel-icon-wrapper icon-shopping">
          <i class='bx bx-sun'></i>
        </div>
        <div class="card-panel-description">
          <div class="card-panel-text">今日访问</div>
          <count-to :start-val="0" :end-val="10" :duration="3600" class="card-panel-num" />
        </div>
      </div>
    </el-col>
  </el-row>
</template>

<script>
import CountTo from "vue-count-to";
export default {
  components: {
    CountTo
  },
  props: {
    visitCount: Number,
    messageCount: Number,
    onlineCount: Number
  },
  methods: {
    handleSetLineChartData(type) {
      this.$emit("handleSetLineChartData", type);
    }
  }
};
</script>

<style lang="scss" scoped>
.panel-group {
  margin-top: 18px;

  .card-panel-col {
    margin-bottom: 32px;
  }

  .card-panel {
    height: 108px;
    cursor: pointer;
    font-size: 12px;
    position: relative;
    overflow: hidden;
    color: #666;
    background: #fff;
    box-shadow: 4px 4px 40px rgba(0, 0, 0, 0.05);
    border-color: rgba(0, 0, 0, 0.05);

    .icon-people {
      background-color: #8ccc40;
    }

    .icon-message {
      background-color: #8d80eb;
    }

    .icon-money {
      background-color: #fe5d5a;
    }

    .icon-shopping {
      background-color: #04bca7;
    }

    .card-panel-icon-wrapper {
      height: 100%;
      width: 35%;
      display: flex;
      float: left;
      align-items: center;
      justify-content: center;
      transition: all 0.38s ease-out;

      i {
        float: left;
        font-size: 48px;
        color: #ffffffe0;
      }
    }

    .card-panel-icon {
      float: left;
      font-size: 48px;
    }

    .card-panel-description {
      float: left;
      font-weight: bold;
      margin: 26px;
      margin-left: 20px;

      .card-panel-text {
        line-height: 18px;
        color: rgba(0, 0, 0, 0.45);
        font-size: 16px;
        margin-bottom: 12px;
      }

      .card-panel-num {
        font-size: 20px;
      }
    }
  }
}

@media (max-width: 550px) {
  .card-panel-description {
    display: none;
  }

  .card-panel-icon-wrapper {
    float: none !important;
    width: 100%;
    height: 100%;
    margin: 0 !important;

    .svg-icon {
      display: block;
      margin: 14px auto !important;
      float: none !important;
    }
  }
}
</style>