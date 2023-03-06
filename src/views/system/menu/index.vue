<template>
    <div class="d-flex flex-column flex-lg-row">
        <!--begin::Content-->
        <div class="flex-lg-row-fluid">
            <el-card shadow="never">
                <div slot="header">
                    <menu-header ref="header" @search="refreshTable" @deleteSelected="deleteSelected"></menu-header>
                </div>
                <menu-table ref="table" @openEdit="openEdit"> </menu-table>
            </el-card>
        </div>
    </div>
</template>
<script>
import MenuHeader from './components/MenuHeader'
import MenuTable from './components/MenuTable'
export default {
    components: {
        MenuHeader,
        MenuTable,
    },
    data() {
        return {
        }
    },
    methods: {
        refreshTable(params) {
            this.$refs.table.refreshTable(params)
        },
        openEdit(params) {
            this.$refs.header.openEditDialog(params)
        },
        deleteSelected() {
            this.$refs.table.deleteSelected()
        }
    }
}
</script>
<style lang="scss" scoped>

</style>