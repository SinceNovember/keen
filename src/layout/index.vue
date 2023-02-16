<template>
    <!--begin::Page-->
    <div class="app-page  flex-column flex-column-fluid " id="kt_app_page">
        <page-header></page-header>
        <div class="app-wrapper flex-column flex-row-fluid">
            <sidebar></sidebar>
            <app-main></app-main>
        </div>
        <settings></settings>
    </div>
</template>
<script>
import { PageHeader, Sidebar, AppMain, Settings } from './components'
export default {
    name: "Layout",
    components: {
        PageHeader,
        Sidebar,
        AppMain,
        Settings
        // Navbar,
        // Topnav,
        // AppMain,
    },
    mounted() {
    },
    methods: {

    }
};
</script>
