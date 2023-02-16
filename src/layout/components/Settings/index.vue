<template>
    <div class="kt_app_setting_wrapper">
        <el-drawer  :visible.sync="settingsDrawer" :withHeader="false">
            <layout-settings @closeDrawer="closeDrawer"></layout-settings>
        </el-drawer>

        <!--begin::App settings toggle-->
        <button id="kt_app_layout_builder_toggle" class="btn btn-dark app-layout-builder-toggle lh-1 py-4 "
            title="Keen Builder" data-bs-custom-class="tooltip-inverse" data-bs-toggle="tooltip"
            data-bs-placement="left" data-bs-dismiss="click" data-bs-trigger="hover" @click="openDrawer">
            <i class="fonticon-equalizer fs-4 me-1"></i> Customize
        </button>
        <!--end::App settings toggle-->
    </div>
</template>
<script>
import LayoutSettings from './LayoutSettings'
export default {
    name: "Settings",
    data() {
        return {
            settingsDrawer: false,
        }
    },
    components: {
        LayoutSettings
    },
    methods: {
        openDrawer() {
            this.settingsDrawer = true
        },
        closeDrawer() {
            this.settingsDrawer = false
        }
    }
}
</script>