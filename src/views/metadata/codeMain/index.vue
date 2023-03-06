<template>
    <div class="d-flex flex-column flex-lg-row">
        <!--begin::Content-->
        <div class="flex-lg-row-fluid">
            <el-card shadow="never">
                <div slot="header">
                    <code-main-header ref="header" @search="refreshTable" @deleteSelected="deleteSelected"></code-main-header>
                </div>
                <code-main-table ref="table" @openEdit="openEdit"> </code-main-table>
            </el-card>
        </div>
    </div>
</template>
<script>
import CodeMainHeader from './components/CodeMainHeader'
import CodeMainTable from './components/CodeMainTable'
export default {
    components: {
        CodeMainHeader,
        CodeMainTable,
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