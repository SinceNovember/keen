<template>
    <!--begin::Header-->
    <div id="kt_app_header" class="app-header ">
        <!--begin::Header container-->
        <div class="app-container  container-fluid d-flex align-items-stretch justify-content-between "
            id="kt_app_header_container">

            <!--begin::Logo-->
            <div v-if="settings.layout.type == 'header'"
                class="d-flex align-items-center flex-grow-1 flex-lg-grow-0 me-lg-15">
                <logo></logo>
            </div>
            <!--end::Logo-->


            <!--begin::Header wrapper-->
            <div class="d-flex align-items-stretch justify-content-between flex-lg-grow-1" id="kt_app_header_wrapper">

                <header-menu v-if="settings.header.content == 'menu'"></header-menu>
                <page-title v-else></page-title>

                <!--begin::Navbar-->
                <header-navbar></header-navbar>
                <!--end::Navbar-->
            </div>
            <!--end::Header wrapper-->
        </div>
        <!--end::Header container-->
    </div>
    <!--end::Header-->
</template>
<script>
import Logo from '../Logo'
import PageTitle from '../PageTitle'
import HeaderMenu from './HeaderMenu'
import HeaderNavbar from './HeaderNavbar'
import { mapGetters } from "vuex"

export default {
    name: "PageHeader",
    components: {
        Logo,
        PageTitle,
        HeaderMenu,
        HeaderNavbar,
    },
    computed: {
        ...mapGetters(["settings"]),
    },
}
</script>
<style>

</style>