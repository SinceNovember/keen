<template>
    <div class="table-main">
        <el-table ref="table" :data="list" tooltip-effect="dark" style="width: 100%" v-loading="loading"
            @selection-change="handleSelectionChange" element-loading-text="Loading...">
            <el-table-column type="selection" width="55">
            </el-table-column>
            <el-table-column prop="nickname" label="登录名" min-width="160" show-overflow-tooltip>
            </el-table-column>
            <el-table-column prop="location" label="登录地" min-width="180" show-overflow-tooltip>
            </el-table-column>
            <el-table-column prop="ip" label="IP" min-width="120" show-overflow-tooltip>
            </el-table-column>
            <el-table-column prop="system" label="系统"  min-width="180" show-overflow-tooltip>
            </el-table-column>
            <el-table-column prop="browser" label="浏览器"  min-width="180" show-overflow-tooltip>
            </el-table-column>
            <el-table-column prop="loginTime" label="登录时间" width="160" show-overflow-tooltip>
            </el-table-column>
            <el-table-column label="操作" width="90" show-overflow-tooltip>
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
            <login-log-info :dataInfo="dataInfo"></login-log-info>
            <span slot="footer" class="dialog-footer">
                <el-button @click="infoDialog = false">取 消</el-button>
            </span>
        </el-dialog> -->

        <keen-dialog :visible.sync="infoDialog" title="登录日志详情" @cancel="infoDialog = false" :showSave="false">
            <login-log-info :dataInfo="dataInfo"></login-log-info>
        </keen-dialog>
    </div>
</template>
<script>
import { fetchPageLoginLogs, getLoginLog, deleteLoginLog } from "@/api/monitor/loginLog"
import LoginLogInfo from './LoginLogInfo.vue'
export default {
    name: 'LoginLogTable',
    components: {
        LoginLogInfo
    },
    data() {
        return {
            list: [],
            total: 0,
            loading: false,
            params: {
                nickname: '',
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
                this.params.nickname = params.nickname
                this.params.pageNum = params.pageNum
            }
            this.spinShow = true
            fetchPageLoginLogs(this.params).then(res => {
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
            getLoginLog({
                id: row.id
            }).then(res => {
                this.dataInfo = res.data
                this.infoDialog = true
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
            deleteLoginLog({
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