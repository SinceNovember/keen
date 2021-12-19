<template>
  <div id="tags-view-container" class="tags-view-container">
    <div class="tags-view-wrapper">
      <ul class="tags-view" ref="scrollPane">
        <router-link
          v-for="tag in visitedViews"
          ref="tag"
          :class="{'active': isActive(tag)}"
          :key="tag.path"
          :to="{ path: tag.path, query: tag.query, fullPath: tag.fullPath }"
          tag="li"
          class="tags-view-item"
          @contextmenu.prevent.native="openMenu(tag,$event)"
        >
          {{ tag.title }}
          <i
            v-if="!tag.meta.affix"
            class="bx bx-x"
            @click.prevent.stop="closeSelectedTag(tag)"
          ></i>
        </router-link>
      </ul>
    </div>
    <ul v-show="visible" :style="{left:left+'px',top:top+'px'}" class="context-menu">
      <li @click="refreshSelectedTag(selectedTag)"><i class='bx bx-refresh'></i>重新加载</li>
      <li
        v-if="!(selectedTag.meta&&selectedTag.meta.affix)"
        @click="closeSelectedTag(selectedTag)"
      ><i class='bx bx-x'></i>关闭</li>
      <li @click="closeOthersTags"><i class='bx bx-transfer'></i>关闭其他</li>
      <li @click="closeAllTags(selectedTag)"><i class='bx bx-minus'></i>关闭全部</li>
    </ul>
  </div>
</template>

<script>
import ScrollPane from "./ScrollPane";

export default {
  data() {
    return {
      //操作按钮是否可见
      visible: false,
      top: 0,
      left: 0,
      selectedTag: {},
      //固定的标签
      affixTags: []
    };
  },
  components: {
    ScrollPane
  },
  computed: {
    visitedViews() {
      return this.$store.state.tagsView.visitedViews;
    },
    routes() {
      return global.antRouter;
    }
  },
  watch: {
    //监听路由发生的变法,点击菜单添加标签
    $route() {
      this.addTags();
    },
    //监听操作菜单打开后，添加点击事件，点击空白区域，关闭操作菜单
    visible(value) {
      if (value) {
        document.body.addEventListener("click", this.closeMenu);
      } else {
        document.body.removeEventListener("click", this.closeMenu);
      }
    }
  },
  mounted() {
    this.initTags();
    this.addTags();
  },
  methods: {
    isActive(route) {
      //当前地址栏是否与渲染的路径相同，样式匹配
      return route.path === this.$route.path;
    },
    addTags() {
      const route = this.$route; //获取选中的地址
      if (route.path !== "/") {
        this.$store.dispatch("tagsView/addView", route);
      }
    },
    initTags() {
      const affixTags = (this.affixTags = this.filterAffixTags(this.routes));
      for (const tag of affixTags) {
        // Must have tag name
        if (tag.name) {
          this.$store.dispatch("tagsView/addVisitedView", tag);
        }
      }
    },
    filterAffixTags(routes, basePath = "/") {
      let tags = [];
      if (routes !== undefined) {
        routes.forEach(route => {
          if (route.meta && route.meta.affix) {
            console.log(route);
            // const tagPath = path.resolve(basePath, route.path)
            tags.push({
              fullPath: route.path,
              path: route.path,
              name: route.name,
              meta: { ...route.meta }
            });
          }
          if (route.children) {
            const tempTags = this.filterAffixTags(route.children, route.path);
            if (tempTags.length >= 1) {
              tags = [...tags, ...tempTags];
            }
          }
        });
      }
      return tags;
    },

    refreshSelectedTag(view) {
      this.$store.dispatch("tagsView/delCachedView", view).then(() => {
        const { fullPath } = view;
        this.$nextTick(() => {
          this.$router.replace({
            path: "/redirect" + fullPath,
          });
        });
      });
    },
    closeSelectedTag(view) {
      this.$store
        .dispatch("tagsView/delView", view)
        .then(({ visitedViews }) => {
          if (this.isActive(view)) {
            this.toLastView(visitedViews, view);
          }
        });
    },
    closeOthersTags() {
      this.$router.push(this.selectedTag);
      this.$store
        .dispatch("tagsView/delOthersViews", this.selectedTag)
        .then(() => {
          this.moveToCurrentTag();
        });
    },
    //移动到当当前的标签
    moveToCurrentTag() {
      const tags = this.$refs.tag;
      this.$nextTick(() => {
        for (const tag of tags) {
          if (tag.to.path === this.$route.path) {
            // this.$refs.scrollPane.moveToTarget(tag)
            // when query is different then update
            if (tag.to.fullPath !== this.$route.fullPath) {
              this.$store.dispatch("tagsView/updateVisitedView", this.$route);
            }
            break;
          }
        }
      });
    },
    closeAllTags(view) {
      this.$store.dispatch("tagsView/delAllViews").then(({ visitedViews }) => {
        if (this.affixTags.some(tag => tag.path === view.path)) {
          return;
        }
        this.toLastView(visitedViews, view);
      });
    },
    //打开到最后一个tag
    toLastView(visitedViews, view) {
      const latestView = visitedViews.slice(-1)[0];
      if (latestView) {
        this.$router.push(latestView);
      } else {
        // now the default is to redirect to the home page if there is no tags-view,
        // you can adjust it according to your needs.
        if (view.name === "Dashboard") {
          // to reload home page
          this.$router.replace({ path: "/redirect" + view.fullPath });
        } else {
          this.$router.push("/index/a");
        }
      }
    },

    openMenu(tag, e) {
      const menuMinWidth = 105;
      const offsetLeft = this.$el.getBoundingClientRect().left; // container margin left
      const offsetWidth = this.$el.offsetWidth; // container width
      const maxLeft = offsetWidth - menuMinWidth; // left boundary
      const left = e.clientX - offsetLeft + 15; // 15: margin right

      if (left > maxLeft) {
        this.left = maxLeft;
      } else {
        this.left = left;
      }
      this.top = e.clientY - 80;
      this.visible = true;
      this.selectedTag = tag;
    },
    closeMenu() {
      this.visible = false;
    }
  }
};
</script>

<style>
</style>