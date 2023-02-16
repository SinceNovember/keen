<template>
  <!--begin::Main-->
  <div class="app-main flex-column flex-row-fluid" id="kt_app_main">
    <!--begin::Content wrapper-->
    <div class="d-flex flex-column flex-column-fluid">
      <toolbar v-if="settings.toolbar.display"></toolbar>
      <!--begin::Content-->
      <div id="kt_app_content" class="app-content  flex-column-fluid ">
        <!--begin::Content container-->
        <div id="kt_app_content_container" class="app-container " :class="settings.widthMode.val">
          <router-view :key="key" :include="key" />
        </div>
      </div>
    </div>
  </div>
</template>
<script>
import Toolbar from './Toolbar'
import { mapGetters } from "vuex"

export default {
  name: 'AppMain',
  components: {
    Toolbar
  },
  computed: {
    ...mapGetters(["settings"]),
    key() {
      this.$route.path;
    }
  },
}
</script>
<style>

</style>