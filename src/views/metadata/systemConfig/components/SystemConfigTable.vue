<template>
    <div class="table-main">
        <el-table ref="table" :data="list" tooltip-effect="dark" style="width: 100%" v-loading="loading"
            @selection-change="handleSelectionChange" element-loading-text="Loading...">
            <el-table-column type="selection" width="55">
            </el-table-column>
            <el-table-column prop="configName" label="参数名称" width="220" show-overflow-tooltip>
            </el-table-column>
            <el-table-column prop="configValue" label="参数值" width="180" show-overflow-tooltip>
            </el-table-column>
            <el-table-column prop="description" label="描述" show-overflow-tooltip>
            </el-table-column>
            <el-table-column prop="orderNum" label="排序" width="100" align="center" sortable show-overflow-tooltip>
            </el-table-column>
            <el-table-column prop="createTime" label="创建日期" width="180" show-overflow-tooltip>
            </el-table-column>
            <el-table-column label="操作" width="120" show-overflow-tooltip>
                <template slot-scope="{row}">
                    <div class="d-flex my-2 flex-center">
                        <a class="btn btn-icon btn-active-light-primary w-30px h-30px me-2" @click="openDetail(row)">
                            <span class="svg-icon svg-icon-2"><svg width="24" height="24" viewBox="0 0 24 24"
                                    fill="none" xmlns="http://www.w3.org/2000/svg">
                                    <rect opacity="0.5" x="17.0365" y="15.1223" width="8.15546" height="2" rx="1"
                                        transform="rotate(45 17.0365 15.1223)" fill="currentColor" />
                                    <path
                                        d="M11 19C6.55556 19 3 15.4444 3 11C3 6.55556 6.55556 3 11 3C15.4444 3 19 6.55556 19 11C19 15.4444 15.4444 19 11 19ZM11 5C7.53333 5 5 7.53333 5 11C5 14.4667 7.53333 17 11 17C14.4667 17 17 14.4667 17 11C17 7.53333 14.4667 5 11 5Z"
                                        fill="currentColor" />
                                </svg>
                            </span>
                        </a>

                        <a class="btn btn-icon btn-active-light-primary w-30px h-30px me-2" @click="openEdit(row)">
                            <span class="svg-icon svg-icon-2"><svg width="24" height="24" viewBox="0 0 24 24"
                                    fill="none" xmlns="http://www.w3.org/2000/svg">
                                    <path opacity="0.3" fill-rule="evenodd" clip-rule="evenodd"
                                        d="M2 4.63158C2 3.1782 3.1782 2 4.63158 2H13.47C14.0155 2 14.278 2.66919 13.8778 3.04006L12.4556 4.35821C11.9009 4.87228 11.1726 5.15789 10.4163 5.15789H7.1579C6.05333 5.15789 5.15789 6.05333 5.15789 7.1579V16.8421C5.15789 17.9467 6.05333 18.8421 7.1579 18.8421H16.8421C17.9467 18.8421 18.8421 17.9467 18.8421 16.8421V13.7518C18.8421 12.927 19.1817 12.1387 19.7809 11.572L20.9878 10.4308C21.3703 10.0691 22 10.3403 22 10.8668V19.3684C22 20.8218 20.8218 22 19.3684 22H4.63158C3.1782 22 2 20.8218 2 19.3684V4.63158Z"
                                        fill="currentColor" />
                                    <path
                                        d="M10.9256 11.1882C10.5351 10.7977 10.5351 10.1645 10.9256 9.77397L18.0669 2.6327C18.8479 1.85165 20.1143 1.85165 20.8953 2.6327L21.3665 3.10391C22.1476 3.88496 22.1476 5.15129 21.3665 5.93234L14.2252 13.0736C13.8347 13.4641 13.2016 13.4641 12.811 13.0736L10.9256 11.1882Z"
                                        fill="currentColor" />
                                    <path
                                        d="M8.82343 12.0064L8.08852 14.3348C7.8655 15.0414 8.46151 15.7366 9.19388 15.6242L11.8974 15.2092C12.4642 15.1222 12.6916 14.4278 12.2861 14.0223L9.98595 11.7221C9.61452 11.3507 8.98154 11.5055 8.82343 12.0064Z"
                                        fill="currentColor" />
                                </svg>
                            </span>
                        </a>

                        <a class="btn btn-icon btn-active-light-primary w-30px h-30px me-2" @click="deleteOne(row)">
                            <span class="svg-icon svg-icon-2"><svg width="24" height="24" viewBox="0 0 24 24"
                                    fill="none" xmlns="http://www.w3.org/2000/svg">
                                    <path
                                        d="M5 9C5 8.44772 5.44772 8 6 8H18C18.5523 8 19 8.44772 19 9V18C19 19.6569 17.6569 21 16 21H8C6.34315 21 5 19.6569 5 18V9Z"
                                        fill="currentColor"></path>
                                    <path opacity="0.5"
                                        d="M5 5C5 4.44772 5.44772 4 6 4H18C18.5523 4 19 4.44772 19 5V5C19 5.55228 18.5523 6 18 6H6C5.44772 6 5 5.55228 5 5V5Z"
                                        fill="currentColor"></path>
                                    <path opacity="0.5"
                                        d="M9 4C9 3.44772 9.44772 3 10 3H14C14.5523 3 15 3.44772 15 4V4H9V4Z"
                                        fill="currentColor"></path>
                                </svg>
                            </span>
                        </a>
                    </div>
                </template>
            </el-table-column>
        </el-table>
        <div class="row py-7 float-end">
            <el-pagination layout="total,sizes, prev, pager, next" @size-change="handleSizeChange"
                @current-change="handleCurrentChange" :total="total">
            </el-pagination>
        </div>

        <!-- <el-dialog title="提示" :visible.sync="infoDialog" width="760px" top="50px">
            <div slot="title">
                <img alt="Logo" src="@/assets/media/logos/default-small.svg">
                <span class="header-title">
                    角色详情
                </span>
            </div>
            <system-config-info :dataInfo="dataInfo"></system-config-info>
            <span slot="footer" class="dialog-footer">
                <el-button @click="infoDialog = false">取 消</el-button>
            </span>
        </el-dialog> -->
        
        <keen-dialog :visible.sync="infoDialog" title="系统参数详情" @cancel="infoDialog = false" :showSave="false">
            <system-config-info :dataInfo="dataInfo"></system-config-info>
        </keen-dialog>
    </div>
</template>
<script>
import { fetchPageSystemConfigs, getSystemConfig, deleteSystemConfig } from "@/api/metadata/systemConfig"
import SystemConfigInfo from './SystemConfigInfo.vue'
export default {
    name: 'SystemConfigTable',
    components: {
        SystemConfigInfo
    },
    data() {
        return {
            list: [],
            total: 0,
            loading: false,
            params: {
                configName: '',
                pageNum: 1,
                pageSize: 10,
                orderBy: '',
                orderType: '',
            },
            dataInfo: {},
            infoDialog: false,
            multipleSelection: []
        }
    },
    mounted() {
        this.refreshTable()
    },
    methods: {
        refreshTable(params) {
            this.loading = true
            if (params) {
                this.params.configName = params.configName
                this.params.pageNum = params.pageNum
            }
            this.spinShow = true
            fetchPageSystemConfigs(this.params).then(res => {
                this.list = res.data.list
                this.total = res.data.total
                this.spinShow = false
                this.loading = false
            }).catch(e => {
                this.spinShow = false
                this.loading = false
            })
        },
        handleCurrentChange(pageNum) {
            this.params.pageNum = pageNum
            this.refreshTable()
        },
        handleSizeChange(pageSize) {
            this.params.pageSize = pageSize
            this.refreshTable()
        },
        handleSelectionChange(val) {
            this.multipleSelection = val;
        },
        sortTable(params) {
            this.params.orderBy = params.key
            this.params.orderType = params.order
            this.refreshTable()
        },
        openDetail(row) {
            getSystemConfig({
                id: row.id
            }).then(res => {
                this.dataInfo = res.data
                this.infoDialog = true
            })
        },
        openEdit(row) {
            getSystemConfig({
                id: row.id
            }).then(res => {
                this.$emit('openEdit', res.data)
            })
        },
        deleteOne(row) {
            this.$confirm("确定要删除该角色?", "提示", {
                confirmButtonText: "确定",
                cancelButtonText: "取消",
                type: "warning"
            }).then(() => {
                this.handleDelete([row.id])
            });
        },
        deleteSelected() {
            if (this.multipleSelection.length > 0) {
                this.$confirm("确定要删除选中的记录?", "提示", {
                    confirmButtonText: "确定",
                    cancelButtonText: "取消",
                    type: "warning"
                }).then(() => {
                    this.handleDelete(this.multipleSelection.map(item => item.id));
                });
            } else {
                this.$message("至少选中一条记录");
            }
        },

        handleDelete(ids) {
            deleteSystemConfig({
                ids: ids
            }).then(res => {
                this.refreshTable()
                this.$message.success("删除成功");
            });
        },
        cancel() {
            this.infoModal = false
        }
    }
}
</script>
<style lang="scss" scoped>

</style>