<template>
    <ul class="breadcrumb breadcrumb-separatorless fw-semibold fs-7 my-0 pt-1">
        <template v-for="(item, index) in levelList">
            <li class="breadcrumb-item text-muted">
                <router-link ref="tag" tag="a" class="text-muted text-hover-primary" :to="{ path: item.meta.path }">
                    {{ item.meta.title }}
                </router-link>
            </li>
            <li v-if="index < levelList.length - 1" class="breadcrumb-item">
                <span class="bullet bg-gray-400 w-5px h-2px"></span>
            </li>
        </template>
    </ul>
</template>
<script>
export default {
    name: 'Breadcrumb',
    data() {
        return {
            levelList: null
        }
    },
    watch: {
        $route(route) {
            // if (route.path.startWith('/redirect/')) {
            //     return
            // }
            this.getBreadcrumb()
        }
    },
    created() {
        this.getBreadcrumb()
    },
    methods: {
        getBreadcrumb() {
            let matched = this.$route.matched.filter(item => item.meta && item.meta.title)
            const first = matched[0]

            this.levelList = matched.filter(item => {
                item.meta.path = item.path
                return item.meta && item.meta.title && item.meta.breadcrumb !== false
            })
        }
    }
}
</script>
<style>

</style>