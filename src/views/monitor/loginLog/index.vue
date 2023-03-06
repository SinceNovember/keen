<template>
    <div class="d-flex flex-column flex-lg-row">
        <!--begin::Content-->
        <div class="flex-lg-row-fluid">
            <el-card shadow="never">
                <div slot="header">
                    <login-log-header ref="header" @search="refreshTable" @deleteSelected="deleteSelected"></login-log-header>
                </div>
                <login-log-table ref="table" @openEdit="openEdit"> </login-log-table>
            </el-card>
        </div>
    </div>
</template>
<script>
import LoginLogHeader from './components/LoginLogHeader'
import LoginLogTable from './components/LoginLogTable'
export default {
    components: {
        LoginLogHeader,
        LoginLogTable,
    },
    data() {
        return {
        }
    },
    methods: {
        refreshTable(params) {
            this.$refs.table.refreshTable(params)
        },
        deleteSelected() {
            this.$refs.table.deleteSelected()
        }
    }
}
</script>
<style lang="scss" scoped>

</style>