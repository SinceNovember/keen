<template>
    <div class="d-flex flex-column flex-lg-row">
        <!--begin::Content-->
        <div class="flex-lg-row-fluid">
            <el-card shadow="never">
                <div slot="header">
                    <dept-header ref="header" @search="refreshTable" @deleteSelected="deleteSelected"></dept-header>
                </div>
                <dept-table ref="table" @openEdit="openEdit"> </dept-table>
            </el-card>
        </div>
    </div>
</template>
<script>
import DeptHeader from './components/DeptHeader'
import DeptTable from './components/DeptTable'
export default {
    components: {
        DeptHeader,
        DeptTable,
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