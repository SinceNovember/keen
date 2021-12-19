<template>
  <div class="user-info-detail">
    <div class="detail-avatar">
      <img :src="userInfo.avatar" />
    </div>
    <div class="detail-info">
      <div class="info-content">
        <div class="info-content-line">
          <div class="sub-title">用户名</div>
          <div class="sub-content">{{userInfo.username}}</div>
        </div>
        <div class="info-content-line">
          <div class="sub-title">性别</div>
          <div class="sub-content">{{userInfo.ssex | SexFilter}}</div>
        </div>
        <div class="info-content-line">
          <div class="sub-title">所属部门</div>
          <div class="sub-content">{{userInfo.deptName}}</div>
        </div>
      </div>

      <div class="info-content">
        <div class="info-content-line">
          <div class="sub-title">创建时间</div>
          <div class="sub-content">
            <i class="bx bxs-time"></i>
            {{userInfo.createTime}}
          </div>
        </div>
        <div class="info-content-line">
          <div class="sub-title">最后登陆时间</div>
          <div class="sub-content">{{userInfo.lastLoginTime}}</div>
        </div>
        <div class="info-content-line">
          <div class="sub-title">状态</div>
          <div class="sub-content">
            <el-tag :type="userInfo.status | StatusFilter">{{userInfo.status | StatusInfoFilter}}</el-tag>
          </div>
        </div>
      </div>

      <div class="info-content">
        <div class="info-content-line">
          <div class="sub-title">联系方式</div>
          <div class="sub-content l">
            <i class="bx bx-phone"></i>
            {{userInfo.mobile}}
          </div>
        </div>
        <div class="info-content-line">
          <div class="sub-title"></div>
          <div class="sub-content l">
            <i class="bx bx-mail-send"></i>
            {{userInfo.email}}
          </div>
        </div>
        <div class="info-content-line">
          <div class="sub-title">简介</div>
          <div class="sub-content l">
            <i class="bx bxs-id-card"></i>
            {{userInfo.description}}
          </div>
        </div>
      </div>

      <div class="info-content role-content">
        <div class="info-content-line">
          <div class="sub-title">角色</div>
          <div class="sub-content">
            <template v-for="(role, index) in userInfo.roleNameList">
              <el-tag :key="index">{{role}}</el-tag>
            </template>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  props: {
    userInfo: Object
  }
};
</script>

<style lang="scss" scoped>
.user-info-detail {
  background-color: #fdfdfd;
  .detail-avatar {
    margin: 20px 0px 0px 40px;
    float: left;
    img {
      width: 96px;
      height: 96px;
      border-radius: 90px;
    }
  }

  .detail-info {
    font-size: 16px;

    .info-content {
      float: left;
      margin: 10px 40px 0px 40px;
      padding-right: 50px;
      width: 23%;
      border-right: 1px solid #eee;
      color: #7c7a7a;

      &:nth-child(3) {
        border: none;
        padding-right: 0px;
      }

      .info-content-line {
        line-height: 60px;
        height: 60px;

        .sub-title {
          float: left;
          min-width: 100px;
          min-height: 60px;
        }

        .sub-content {
          float: right;
          i {
            margin-right: 10px;
          }
          .el-tag {
            margin-left: 10px;
          }
        }

        .role-content {
          width: 170px;
        }
      }
    }
    .role-content {
      width: 100%;
      margin: 0px 175px;

      .info-content-line {
        .sub-content {
          float: left;
        }
      }
    }
  }
}
</style>