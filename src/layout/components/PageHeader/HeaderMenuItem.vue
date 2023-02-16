<template>
    <!--begin:Menu item-->
    <div data-kt-menu-trigger="{default: 'click', lg: 'hover'}" data-kt-menu-placement="bottom-start"
        @mouseenter="route.hover = true" @mouseleave="route.hover = false"
        class="menu-item menu-lg-down-accordion menu-sub-lg-down-indention me-0 me-lg-2"
        :class="{' menu-dropdown  show': route.hover}">
        <!-- <span class="menu-link"> -->
        <router-link ref="tag" tag="span" class="menu-link" :key="route.path"
            :to="{ path: route.path, fullPath: route.fullPath }">
            <span v-if="route.parentId" class="menu-link-icon">
                <span v-if="route.meta.icon" class="menu-icon">
                    <i class="fs-3 " :class="route.meta.icon"></i>
                </span>
                <span class="menu-bullet" v-else>
                    <span class="bullet bullet-dot"></span>
                </span>
            </span>

            <span class="menu-title">{{ route.meta.title }}</span>
            <span v-if="hasChild(route.children) && route.parentId" class="menu-arrow"></span>
        </router-link>
        <!-- </span> -->
        <!--end:Menu link-->

        <!--begin:Menu sub-->
        <div v-if="hasChild(route.children)"
            class="menu-sub menu-sub-lg-down-accordion menu-sub-lg-dropdown px-lg-2 py-lg-4 w-lg-200px"
            :class="menuSubCls(route)">
            <header-menu-item v-for="(subMenu, index) in route.children" :route="subMenu"
                :key="index"></header-menu-item>
        </div>
        <!--end:Menu sub-->
    </div>
    <!--end:Menu item-->
</template>
<script>
export default {
    name: 'HeaderMenuItem',
    props: {
        route: {
            type: Object
        }
    },
    data() {
        return {
        }
    },
    methods: {
        hasChild(children = []) {
            if (children.length > 0) {
                return true;
            }
            return false;
        },
        menuSubCls(route) {
            return !route.parentId ? 'show fixed-show' : 'show abs-show'
        }
    }
}
</script>
<style lang="scss" scoped>
.fixed-show {
    position: fixed;
    /* transform: translate(0px, 108px); */
    /* transform: translate3d(0px, 108px, 0px); */
    top: 70px;
}

.abs-show {
    position: absolute;
    transform: translate(180px, -35px);
    /* transform: translate3d(186px, -20px, 0px); */
    /* left: 100%;
    top: 10px;  */
}
</style>