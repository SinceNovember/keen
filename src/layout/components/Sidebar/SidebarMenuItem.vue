<template>
    <!--begin:Menu item-->
    <div data-kt-menu-trigger="click" class="menu-item menu-accordion"
        :class="{ 'show': route.expand, 'pt-5': route.isHeader }">
        <!--begin:Menu link-->
        <!--begin:Menu content-->
        <!-- <div v-if="route.isHeader" class="menu-content">
            <span class="menu-heading fw-bold text-uppercase fs-7">
                {{ route.meta.title }}
            </span>
        </div> -->
        <!--end:Menu content-->
        <span v-if="hasChild(route.children)" class="menu-link" @click="toggleMenu(route)">
            <span v-if="route.meta.icon" class="menu-icon">
                <i class="fs-3 " :class="route.meta.icon"></i>
            </span>
            <span v-else class="menu-bullet">
                <span class="bullet bullet-dot"></span>
            </span>
            <span class="menu-title">{{ route.meta.title }} </span>
            <!-- <span class="menu-badge"><span class="badge badge-success">3</span></span> -->
            <span class="menu-arrow"></span>
        </span>
        <router-link v-else ref="tag" tag="span" class="menu-link" :key="route.path"
            :to="{ path: route.path, fullPath: route.fullPath }">
            <span v-if="route.meta.icon" class="menu-icon">
                <i class="fs-3 " :class="route.meta.icon"></i>
            </span>
            <span class="menu-bullet" v-else>
                <span class="bullet bullet-dot"></span>
            </span>
            <span class="menu-title">{{ route.meta.title }}</span>
        </router-link>
        <div v-if="hasChild(route.children)" class="menu-sub menu-sub-accordion">
            <sidebar-menu-item v-for="(subMenu, index) in route.children" :route="subMenu"
                :key="index"></sidebar-menu-item>
        </div>
    </div>

</template>
<script>
export default {
    name: 'SidebarMenuItem',
    data() {
        return {
            selectedId: '',
        }
    },
    props: {
        route: {
            type: Object
        }
    },
    methods: {
        hasChild(children = []) {
            if (children.length > 0) {
                return true;
            }
            return false;
        },
        toggleMenu(route) {
            console.log(route)
            route.expand = !route.expand;
        },
        checkName(route) {
            this.selectedId = route.id
            console.log(this.selectedId)
        }
    }

}
</script>