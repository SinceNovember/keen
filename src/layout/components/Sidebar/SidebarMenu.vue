<template>

    <!--begin::sidebar menu-->
    <div class="app-sidebar-menu overflow-hidden flex-column-fluid">
        <!--begin::Menu wrapper-->
        <div id="kt_app_sidebar_menu_wrapper" class="app-sidebar-wrapper hover-scroll-overlay-y my-5">
            <!--begin::Menu-->
            <div class=" menu menu-column menu-rounded menu-sub-indention fw-semibold px-3" id="#kt_app_sidebar_menu">
                <sidebar-menu-item v-for="(route, index) in menus" :route="route" :key="index"></sidebar-menu-item>
            </div>
        </div>
    </div>
</template>
<script>
import SidebarMenuItem from './SidebarMenuItem.vue'
export default {
    name: 'SidebarMenu',
    components: {
        SidebarMenuItem
    },
    data() {
        return {
            menus: global.antRouter
        }
    },
    mounted() {
    }
}
</script>
