<template>
  <div class="info-container">
    <div class="info-summary">
      <img class="avatar" :src="activeUserInfo.user.avatar" />
      <span class="title">{{activeUserInfo.user.nickname}}</span>
    </div>
    <span class="sub-title">
      <i class="bx bxs-group"></i>
      {{activeUserInfo.user.deptName}}
    </span>
    <span class="sub-title">
      <i class="bx bx-user"></i>
      {{activeUserInfo.user.ssex | SexFilter}}
    </span>
    <span class="sub-title">
      <i class="bx bx-phone"></i>
      {{activeUserInfo.user.mobile}}
    </span>
    <span class="sub-title">
      <i class="bx bx-mail-send"></i>
      {{activeUserInfo.user.email}}
    </span>
    <span class="sub-title">
      <i class="bx bxl-internet-explorer"></i>
      {{activeUserInfo.host}}
    </span>
    <span class="sub-title">
      <i class="el-icon-map-location"></i>
      {{activeUserInfo.location}}
    </span>
    <span class="sub-title">
      <i class="bx bx-time"></i>
      {{activeUserInfo.startTime}}
    </span>
    <span class="sub-title">
      <i class="bx bxs-id-card"></i>
      {{activeUserInfo.user.description}}
    </span>
  </div>
</template>

<script>
export default {
  props: {
    activeUserInfo: Object
  }
};
</script>

<style lang="scss" scoped>
.info-container {
  padding: 40px;
  width: 100%;
  display: flex;
  flex-direction: column;

  .info-summary {
    display: flex;
    justify-content: center;
    flex-direction: column;
    align-items: center;
  }

  .avatar {
    height: 140px;
    width: 140px;
    border-radius: 50%;
    margin-bottom: 20px;
  }

  span {
    margin: 10px 30px;

    i {
      font-size: 20px;
      margin-right: 10px;
    }
  }

  .title {
    line-height: 30px;
    font-size: 26px;
    font-weight: 600;
    letter-spacing: 12px;
  }

  .sub-title {
    display: flex;
    align-items: center;
    line-height: 30px;
    font-size: 14px;
    color: #999;
  }
}
</style>