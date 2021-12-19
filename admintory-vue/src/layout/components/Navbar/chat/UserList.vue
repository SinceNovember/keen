<template>
  <div class="user-list-container">
    <div class="list-header">
      <el-input v-model="filterText" @input="search" class="search" placeholder="用户名"></el-input>
      <tree-select
        v-model="deptId"
        :data="deptOptions"
        clearable
        class="search"
        @popoverHide="popoverHide"
        @clear="popoverHide"
      ></tree-select>
    </div>
    <div class="card-list">
      <div class="card" v-for=" (item, index) in userList" :key="index">
        <div class="card-info">
          <div class="refresh">
            <i class="bx bx-chat" @click="openChat(item)"></i>
          </div>
          <div class="avatar-item" :class="{online:item.online}">
            <img class="avatar" :src="item.avatar" />
          </div>

          <span class="title">{{item.nickname}}</span>
          <span class="sub-title">{{item.deptName}}</span>

          <div class="other" @click="openActiveUserInfo(item)">
            <i class="el-icon-more"></i>
          </div>
        </div>
      </div>
    </div>
    <el-dialog :visible.sync="dialogVisible" v-if="dialogVisible" width="18%" height="500px">
      <active-user-info :activeUserInfo="activeUserInfo" @closeDialog="closeDeptDialog"></active-user-info>
    </el-dialog>
  </div>
</template>

<script>
import { fetchUsers } from "@/api/user";
import { fetchDeptOptions } from "@/api/dept";
import ActiveUserInfo from "@/views/monitor/active/components/ActiveUserInfo";
import TreeSelect from "@/components/TreeSelect.vue";

export default {
  components: {
    ActiveUserInfo,
    TreeSelect
  },
  props: {
    users: Array,
    userList: Array
  },
  data() {
    return {
      dialogVisible: false,
      activeUserInfo: "",
      deptOptions: [],
      filterText: "",
      deptId: ""
    };
  },
  mounted() {
    // this.loadUsers();
    this.loadDeptOptions();

  },
  methods: {
    loadUsers() {
      fetchUsers().then(res => {
        this.userList = res.data.records;
        this._userList = this.userList;
      });
    },
    loadDeptOptions() {
      fetchDeptOptions().then(res => {
        this.deptOptions = res.data;
      });
    },
    openChat(user) {
      this.$emit("addUserChat", user);
    },
    openActiveUserInfo(item) {
      this.activeUserInfo = item;
      this.dialogVisible = true;
    },
    closeDeptDialog() {
      this.dialogVisible = false;
    },
    popoverHide(key, value) {
      this.deptId = key;
      this.search();
    },
    search() {
      if (this.filterText && this.deptId) {
        this.userList = this.users.filter(item => {
          return (
            item.nickname.indexOf(this.filterText) !== -1 ||
            item.deptId == this.deptId
          );
        });
      } else if (this.filterText) {
        this.userList = this.users.filter(item => {
          return item.nickname.indexOf(this.filterText) !== -1;
        });
      } else if (this.deptId) {
        this.userList = this.users.filter(item => {
          return item.deptId == this.deptId;
        });
      } else {
        this.userList = this.users;
      }
    }
  }
};
</script>

<style lang="scss" scoped>
.user-list-container {
  height: 100%;
  background: #f5f7fb;
  padding: 10px;

  .list-header {
    height: 40px;
    margin-bottom: 10px;

    .search {
      width: 13rem;
      float: left;
      margin-right: 20px;
    }
  }

  .card-list {
    grid-template-columns: repeat(auto-fill, 185px);

    .card {
      height: 180px;

      .card-info {
        height: 100%;
        padding: 30px 40px;

        .refresh {
          font-size: 20px;
          top: 5px;
        }

        .avatar-item {
          .avatar {
            height: 48px;
            width: 48px;
          }
        }

        .title {
          height: 30px;
        }
      }
    }
  }
}
</style>