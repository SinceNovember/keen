<template>
  <div class="tab-content pt-3">
    <div class="tab-pane active">
      <div class="form-group d-flex flex-stack">
        <div class="d-flex flex-column">
          <h4 class="fw-bold text-dark">Display</h4>
          <div class="fs-7 fw-semibold text-muted">
            Enable or disable Toolbar
          </div>
        </div>

        <div class="d-flex justify-content-end">
          <el-switch v-model="settings.toolbar.display" @change="toggleToolbar"></el-switch>
        </div>
      </div>

      <div class="separator separator-dashed my-6"></div>

      <div class="form-group d-flex flex-stack">
        <div class="d-flex flex-column">
          <h4 class="fw-bold text-dark">Fixed</h4>
          <div class="fs-7 fw-semibold text-muted">
            Fixed toolbar mode
          </div>
        </div>

        <div class="d-flex justify-content-end">
          <div class="form-check form-check-custom me-10">
            <el-switch v-model="settings.toolbar.fixed.desktop" @change="toggleFixedToolbar"></el-switch>
            <label class="form-check-label text-gray-700 fw-bold">Desktop Mode</label>
          </div>

          <div class="form-check form-check-custom">
            <el-switch v-model="settings.toolbar.fixed.mobile" @change="toggleFixedMobileToolbar"></el-switch>
            <label class="form-check-label text-gray-700 fw-bold">Mobile Mode</label>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>
<script>
import { mapGetters } from "vuex"

export default {
  name: 'Toolbar',
  computed: {
    ...mapGetters(["settings"]),
  },
  data() {
    return {}
  },
  methods: {
    toggleToolbar() {
      this.$store.dispatch("app/toggleToolbar")
    },
    toggleFixedToolbar() {
      this.$store.dispatch("app/toggleFixedToolbar")
    },
    toggleFixedMobileToolbar() {
      this.$store.dispatch("app/toggleFixedMobileToolbar")
    },
  }
}
</script>
