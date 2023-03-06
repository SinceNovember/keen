<template>
    <div class="d-flex flex-column flex-lg-row">
        <!--begin::Content-->
        <div class="flex-lg-row-fluid">
            <el-card shadow="never">
                <div slot="header">
                    <system-config-header ref="header" @search="refreshTable" @deleteSelected="deleteSelected"></system-config-header>
                </div>
                <system-config-table ref="table" @openEdit="openEdit"> </system-config-table>
            </el-card>
        </div>
    </div>
</template>
<script>
import SystemConfigHeader from './components/SystemConfigHeader'
import SystemConfigTable from './components/SystemConfigTable'
export default {
    components: {
        SystemConfigHeader,
        SystemConfigTable,
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