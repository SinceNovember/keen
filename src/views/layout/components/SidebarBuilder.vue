<template>
  <div class="tab-content pt-3">

    <div class="tab-pane active " id="kt_builder_sidebar" role="tabpanel">
      <div class="form-group d-flex flex-stack">
        <div class="d-flex flex-column">
          <h4 class="fw-bold text-dark">Minimize</h4>
          <div class="fs-7 fw-semibold text-muted">
            Sidebar minimize mode
          </div>
        </div>

        <div class="d-flex align-items-center justify-content-end">
          <div class="form-check form-check-custom me-8">
            <el-switch v-model="settings.sidebar.toggle"></el-switch>
            <label class="form-check-label text-gray-700 fw-bold">Minimize Toggle</label>
          </div>

          <div class="form-check form-check-custom me-8">
            <el-switch v-model="settings.sidebar.hoverable" @change="toggleSidebarHoverable"></el-switch>
            <label class="form-check-label text-gray-700 fw-bold">Hoverable</label>
          </div>

          <div class="form-check form-check-custom">
            <el-switch v-model="settings.sidebar.closed" @change="toggleSidebarMinimized"></el-switch>
            <label class="form-check-label text-gray-700 fw-bold">Default Minimized</label>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>
<script>
import { mapGetters } from "vuex"

export default {
  name: 'Sidebar',
  computed: {
    ...mapGetters(["settings"]),
  },
  data() {
    return {}
  },
  methods: {
    toggleSidebarHoverable() {
      console.log("11")
      this.$store.dispatch("app/toggleSidebarHoverable")
    },
    toggleSidebarMinimized() {
      this.$store.dispatch("app/toggleSidebarMinimized")
    },
  }
}
</script>
