<template>
  <div class="dept-user-list-container">
    <h4s>部门成员</h4s>
    <div class="navbar-search">
      <el-input
        v-model="search"
        prefix-icon="el-icon-search"
        @input="filterUser"
        placeholder="请输入内容"
      ></el-input>
    </div>
    <ul>
      <li v-for="user in userList">
        <img class="avatar" :src="user.avatar" />
        <div class>
          <span class="item">{{user.nickname}}</span>
          <span class="sub-item">{{user.description}}</span>
        </div>
      </li>
    </ul>
  </div>
</template>

<script>
export default {
  props: {
    userList: Array
  },
  data() {
    return {
      _userList: []
    };
  },
  mounted() {
    this._userList = this.userList;
  },
  methods: {
    filterUser(val) {
      if (!val) {
        this.userList = this._userList;
      } else {
        this.userList = this.userList.filter(
          user => user.nickname.indexOf(val) != -1
        );
      }
    }
  }
};
</script>

<style lang="scss" scoped>
.dept-user-list-container {
  padding: 20px 0px 20px 20px;

  .navbar-search {
    margin: 20px 0px;
    width: 95%;
  }

  ul {
    list-style: none;
    height: 400px;
    overflow-y: scroll;

    li {
      display: flex;
      justify-content: flex-start;
      align-items: center;
      margin: 0px 20px 20px;

      .avatar {
        height: 48px;
        width: 48px;
        background-color: #e5e7eb;
        border-radius: 90px;
        border: 2px solid #fff;
        margin-right: -8px;
        display: flex;
        justify-content: center;
        align-items: center;
      }

      .item,
      .sub-item {
        display: block;
        margin: 0px 20px;
        font-size: 16px;
      }
      .sub-item {
        font-size: 12px;
        color: #b8b9d1;
      }
    }
  }
}
</style>