<template>
  <li
    v-if="!route.hidden"
    :class="{'has-sub' : !hasOneShowingChild(route.children, route), 'showMenu' :route.isExpand}"
  >
    <template v-if="hasOneShowingChild(route.children, route)">
      <div class="icon-link">
        <router-link
          ref="tag"
          :key="onlyOneChild.path"
          :to="{ path: onlyOneChild.path,  fullPath: onlyOneChild.fullPath }"
          tag="a"
          class="tags-view-item"
        >
          <i class="bx" :class="onlyOneChild.meta.icon"></i>
          <span class="link_name">{{onlyOneChild.meta.title}}</span>
        </router-link>
      </div>
      <ul class="sub-menu blank">
        <li>
          <a class="link_name" href="#">{{onlyOneChild.meta.title}}</a>
        </li>
      </ul>
    </template>
    <template v-else>
      <div class="icon-link" @click="toggleMenu(route)">
        <a href="#" v-if="!route.hidden">
          <i class="bx" :class="route.meta.icon"></i>
          <span class="link_name">{{route.meta.title}}</span>
        </a>
        <i class="bx bxs-chevron-down arrow"></i>
      </div>
      <ul class="sub-menu">
        <template v-for="(subMenu, index) in route.children">
          <template v-if="subMenu.children.length > 0">
            <sidebar-menu-item :route="subMenu" :key="index"></sidebar-menu-item>
          </template>
          <template v-else>
            <router-link
              ref="tag"
              :key="subMenu.path"
              :to="{ path: subMenu.path,  fullPath: subMenu.fullPath}"
              tag="li"
              class="tags-view-item"
            >
              <a class="sub-link-name" href="#" v-if="!subMenu.hidden">
                <i class="bx" :class="subMenu.meta.icon"></i>
                <span class="link_name">{{subMenu.meta.title}}</span>
              </a>
            </router-link>
          </template>
        </template>
      </ul>
    </template>
  </li>
</template>

<script>
import path from "path";
export default {
  name: "SidebarMenuItem",
  data() {
    this.onlyOneChild = null;
    return {};
  },
  props: {
    route: {
      type: Object
    }
  },
  methods: {
    hasOneShowingChild(children = [], parent) {
      if (parent.component.name != "Layout") {
        return false;
      }
      const showingChildren = children.filter(item => {
        if (item.hidden) {
          return false;
        } else {
          // Temp set(will be used if only has one showing child)
          this.onlyOneChild = item;
          return true;
        }
      });

      // When there is only one child router, the child router is displayed by default
      if (showingChildren.length === 1) {
        return true;
      }

      // Show parent if there are no child router to display
      if (showingChildren.length === 0) {
        this.onlyOneChild = { ...parent, path: "", noShowingChildren: true };
        return true;
      }

      return false;
    },
    toggleMenu(route) {
      //   route.hasSub = !route.hasSub;
      route.isExpand = !route.isExpand;
    }
  }
};
</script>

<style>
</style>