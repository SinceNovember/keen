<template>
  <div class="menu">
    <ul class="nav-links">
      <sidebar-menu-item v-for="(route, index) in menus" :route="route" :key="index"></sidebar-menu-item>
    </ul>
  </div>
</template>

<script>
import SidebarMenuItem from "./SidebarMenuItem";
export default {
  name: "SidebarMenu",
  components: {
    SidebarMenuItem
  },
  data() {
    return {
      menus: global.antRouter
    };
  }
};
</script>

<style>
</style>