<template>
    <div class="d-flex flex-column flex-lg-row">
        <!--begin::Content-->
        <div class="flex-lg-row-fluid">
            <el-card shadow="never">
                <div slot="header">
                    <code-item-header ref="header" @search="refreshTable" @deleteSelected="deleteSelected"
                        :codeId="codeId"></code-item-header>
                </div>
                <code-item-table ref="table" @openEdit="openEdit" :codeId="codeId"> </code-item-table>
            </el-card>
        </div>
    </div>
</template>
<script>
import CodeItemHeader from './components/CodeItemHeader'
import CodeItemTable from './components/CodeItemTable'
export default {
    components: {
        CodeItemHeader,
        CodeItemTable,
    },
    props: {
        codeId: Number,
        itemList: Object,
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