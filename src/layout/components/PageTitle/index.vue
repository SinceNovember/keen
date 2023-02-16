<template>
    <div class="page-title d-flex  flex-wrap me-3 "
        :class="[isRow ? 'align-items-center mb-lg-0' : 'flex-column justify-content-center']">
        <h1 class="page-heading d-flex text-dark fw-bold fs-3 flex-column justify-content-center my-0">
            {{ $route.meta.title }}
        </h1>
        <span v-if="isRow" class="h-20px border-gray-300 border-start mx-4"></span>
        <breadcrumb></breadcrumb>
    </div>
</template>
<script>
import Breadcrumb from '@/components/Breadcrumb'
import { mapGetters } from "vuex"

export default {
    name: 'PageTitle',
    components: {
        Breadcrumb
    },
    computed: {
        ...mapGetters(["settings"]),
        isRow() {
            return this.settings.header.pageTitle == 'row';
        }
    },
}
</script>
