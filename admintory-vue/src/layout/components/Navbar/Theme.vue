<template>
  <div class="theme-container">
    <h2>更换主题</h2>
    <div class="theme-list">
      <div class="theme-item" v-for="(item, index) in themeList" :key="index">
        <div class="theme-item-img" :class="{active: item.themeName == theme}">
          <img :src="item.picUrl" />
        </div>
        <div class="theme-item-content">
          <h2>{{item.themeText}}</h2>
          <template v-if="item.themeName == theme">
            <el-button type="primary" size="small" @click="changeTheme(item.themeName)">已应用</el-button>
          </template>
          <template v-else>
            <el-button size="small" @click="changeTheme(item.themeName)">应用</el-button>
          </template>
        </div>
      </div>
    </div>
  </div>
</template>
<script>
import { mapGetters } from "vuex";
import { fetchThemes } from "@/api/theme";
export default {
  data() {
    return {
      themeList: []
    };
  },
  computed: {
    ...mapGetters(["theme"])
  },
  mounted() {
    this.loadThemes();
  },
  methods: {
    loadThemes() {
      fetchThemes().then(res => {
        this.themeList = res.data.records;
      });
    },
    //换主题
    changeTheme(type) {
      this.$store.dispatch("app/changeTheme", type);
      window.document.documentElement.setAttribute("data-theme", type);
    }
  }
};
</script>
<style lang="scss" scoped>
.theme-container {
  padding: 20px 40px;
  .theme-list {
    display: grid;
    grid-template-columns: repeat(auto-fill, 400px);
    grid-row-gap: 20px;
    grid-column-gap: 100px;
    margin-top: 20px;

    .theme-item {
      width: 400px;
      height: 300px;
      padding: 2px;

      .active {
        border: 2px solid #0960bd;
        border-radius: 4px;
        padding: 2px;
        box-shadow: 0 1px 2.5px #0000002e;
      }

      .theme-item-img {
        width: 100%;
        height: 80%;

        img {
          width: 100%;
          height: 100%;
          box-shadow: 0 2px 8px #7e7e7e;
        }
      }

      .theme-item-content {
        display: flex;
        justify-content: space-between;
        margin-top: 10px;
        padding: 5px 10px;
      }
    }
  }
}
</style>
