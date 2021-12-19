<template>
  <div class="main-container">
    <keep-alive>
      <router-view :key="key" />
    </keep-alive>
  </div>
</template>

<script>
export default {
  name: "AppMain",
  computed: {
    key() {
      this.$route.path;
    }
  }
};
</script>

<style lang="scss">
</style>