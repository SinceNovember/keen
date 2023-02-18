<template>
    <!--begin::Page-->
    <div class="app-page  flex-column flex-column-fluid " id="kt_app_page">
        <page-header></page-header>
        <div class="app-wrapper flex-column flex-row-fluid">
            <sidebar></sidebar>
            <app-main></app-main>
        </div>
        <page-footer></page-footer>
        <settings></settings>

    </div>
</template>
<script>
import { getLoginUserInfo } from '@/api/user'
import { PageHeader, Sidebar, AppMain, Settings, PageFooter } from './components'
import { mapGetters } from "vuex"
export default {
    name: "Layout",
    components: {
        PageHeader,
        Sidebar,
        AppMain,
        Settings,
        PageFooter
    },
    mounted() {
    },
    methods: {

    }
};
</script>
