<template>
    <div class="symbol-group symbol-hover flex-nowrap">

        <div v-for="(item, index) in currentList" :key="index" class="symbol symbol-35px symbol-circle">
            <el-tooltip class="item" effect="dark" :content="item.nickname" placement="top-start">
                <img alt="Pic" :src="item.avatar">
            </el-tooltip>
        </div>
        <a v-if="list.length > max" href="#" class="symbol symbol-35px symbol-circle" data-bs-toggle="modal"
            data-bs-target="#kt_modal_view_users">
            <span class="symbol-label bg-light text-gray-400 fs-8 fw-bold">+{{ list.length - max }}</span>
        </a>
    </div>
</template>
<script>
export default {
    name: 'AvatarList',
    props: {
        list: {
            type: Array,
            default: () => []
        },
        max: {
            type: Number,
            default() {
                return 8
            }
        },
    },
    data() {
        return {}
    },
    computed: {
        currentList() {
            const len = this.list.length;
            const max = this.max;
            if (len <= max) {
                return [...this.list];
            } else {
                return [...this.list].slice(0, max);
            }
        }
    },
    methods: {

    }
}
</script>
<style lang="scss" scoped>

</style>