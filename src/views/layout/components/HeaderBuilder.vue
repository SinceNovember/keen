<template>
  <div class="tab-content pt-3">
    <div class="tab-pane active" id="kt_builder_header" role="tabpanel">
      <div class="form-group d-flex flex-stack">
        <div class="d-flex flex-column">
          <h4 class="fw-bold text-dark">Fixed</h4>
          <div class="fs-7 fw-semibold text-muted">
            Fixed header mode
          </div>
        </div>

        <div class="d-flex justify-content-end">
          <div class="form-check form-check-custom me-10">
            <el-switch v-model="settings.header.fixed.desktop" @change="toggleFixedHeader"></el-switch>
            <label class="form-check-label text-gray-700 fw-bold">Desktop Mode</label>
          </div>

          <div class="form-check form-check-custom form-check-solid">
            <el-switch v-model="settings.header.fixed.mobile" @change="toggleFixedMobileHeader"></el-switch>
            <label class="form-check-label text-gray-700 fw-bold">Mobile Mode</label>
          </div>
        </div>
      </div>

      <div class="separator separator-dashed my-6"></div>

      <div class="form-group d-flex flex-stack">
        <div class="d-flex flex-column">
          <h4 class="fw-bold text-dark">Content</h4>
          <div class="fs-7 fw-semibold text-muted">
            Header content type
          </div>
        </div>

        <div class="d-flex justify-content-end">
          <el-radio-group v-model="settings.header.content" @change="changeHeaderContent">
            <el-radio label="menu"><span class="text-gray-700 fw-bold">Menu</span></el-radio>
            <el-radio label="pageTitle"><span class="text-gray-700 fw-bold">Page Title</span></el-radio>
          </el-radio-group>
        </div>
      </div>

      <div class="separator separator-dashed my-6"></div>

      <div class="form-group d-flex flex-stack">
        <div class="d-flex flex-column">
          <h4 class="fw-bold text-dark">Page Title</h4>
          <div class="fs-7 fw-semibold text-muted">
            Page title layout options
          </div>
        </div>

        <div class="d-flex justify-content-end">
          <el-radio-group v-model="settings.header.pageTitle" @change="changeHeaderPageTitle">
            <el-radio label="column"><span class="text-gray-700 fw-bold">Column</span></el-radio>
            <el-radio label="row"><span class="text-gray-700 fw-bold">Row</span></el-radio>
          </el-radio-group>
        </div>
      </div>
    </div>
  </div>
</template>
<script>
import { mapGetters } from "vuex"

export default {
  name: 'Header',
  computed: {
    ...mapGetters(["settings"]),
  },
  data() {
    return {}
  },
  methods: {
    toggleFixedHeader() {
      this.$store.dispatch("app/toggleFixedHeader")
    },
    toggleFixedMobileHeader() {
      this.$store.dispatch("app/toggleFixedMobileHeader")
    },
    changeHeaderContent(val) {
      this.$store.dispatch("app/changeHeaderContent", val)
    },
    changeHeaderPageTitle(val) {
      this.$store.dispatch("app/changeHeaderPageTitle", val)
    },
  }
}
</script>
