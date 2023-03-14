<template>
    <!--begin::Nav-->
    <div class="rounded bg-gray-200 d-flex flex-stack flex-wrap mb-9 p-2">
        <ul class="nav flex-wrap border-transparent">
            <!--begin::Nav item-->
            <li class="nav-item my-1">
                <a class="btn btn-sm btn-color-gray-600 bg-state-body btn-active-color-gray-800 fw-bolder fw-bold fs-6 fs-lg-base nav-link px-3 px-lg-4 mx-1 "
                    :class="{ 'active': activeTab == 'overview' }" @click="changeTab('overview')">
                    Overview </a>
            </li>
            <!--end::Nav item-->
            <!--begin::Nav item-->
            <li v-if="isCurrent" class="nav-item my-1">
                <a class="btn btn-sm btn-color-gray-600 bg-state-body btn-active-color-gray-800 fw-bolder fw-bold fs-6 fs-lg-base nav-link px-3 px-lg-4 mx-1 "
                    :class="{ 'active': activeTab == 'settings' }" @click="changeTab('settings')">

                    Settings </a>
            </li>
            <!--end::Nav item-->
            <!--begin::Nav item-->
            <li class="nav-item my-1">
                <a class="btn btn-sm btn-color-gray-600 bg-state-body btn-active-color-gray-800 fw-bolder fw-bold fs-6 fs-lg-base nav-link px-3 px-lg-4 mx-1  
                    " href="/keen/demo1/../demo1/account/activity.html">

                    Activity </a>
            </li>
            <!--end::Nav item-->

            <!--begin::Nav item-->
            <li class="nav-item my-1">
                <a class="btn btn-sm btn-color-gray-600 bg-state-body btn-active-color-gray-800 fw-bolder fw-bold fs-6 fs-lg-base nav-link px-3 px-lg-4 mx-1  "
                    :class="{ 'active': activeTab == 'logs' }" @click="changeTab('logs')">

                    Logs </a>
            </li>
            <!--end::Nav item-->
        </ul>
    </div>
    <!--end::Nav-->
</template>
<script>
export default {
    name: 'Navbar',
    props: {
        activeTab: String,
        isCurrent: Boolean
    },
    data() {
        return {
            // isCurrent: this.$route.query.id == null
        }
    },
    methods: {
        changeTab(tab) {
            this.$emit('changeTab', tab)
        }
    }
}
</script>
<style lang="scss" scoped>

</style>