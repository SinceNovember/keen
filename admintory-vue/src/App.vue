<template>
  <div id="app">
    <router-view />
    </div>
</template>

<script>
import { getToken, getUserId } from "@/utils/auth";
export default {
  name: "App",

};
</script>

<style>
@font-face {
  font-family: hansans;
  src: url("./assets/fonts/SourceHanSansCN-Regular.otf");
}
</style>
