<template>
  <div class="container">
    <sidebar />
    <div class="layout-body-container">
      <div class="mask" @click="closeSidebar"></div>
      <navbar />
      <tags-view></tags-view>
      <app-main></app-main>
    </div>
  </div>
</template>

<script>
import { Sidebar, Navbar, TagsView, AppMain } from "./components";
export default {
  name: "Layout",
  components: {
    Sidebar,
    Navbar,
    TagsView,
    AppMain
  },
  methods: {
    closeSidebar() {
      this.$store.dispatch("app/toggleSideBar");
    }
  }
};
</script>

<style lang="scss" scoped>
</style>