<template>
    <el-card shadow="nerve">
        <div slot="header" class="cursor-pointer  d-flex flex-stack">
            <!--begin::Card title-->
            <div class="card-title m-0">
                <h3 class="fw-bold m-0">登录日志</h3>
            </div>
            <!--end::Card title-->
        </div>
        <el-table ref="table" :data="list" tooltip-effect="dark" style="width: 100%" v-loading="loading"
            @selection-change="handleSelectionChange" element-loading-text="Loading...">
            <el-table-column prop="location" label="登录地" min-width="180" show-overflow-tooltip>
            </el-table-column>
            <el-table-column prop="ip" label="IP" min-width="120" show-overflow-tooltip>
            </el-table-column>
            <el-table-column prop="system" label="系统" min-width="180" show-overflow-tooltip>
            </el-table-column>
            <el-table-column prop="browser" label="浏览器" min-width="180" show-overflow-tooltip>
            </el-table-column>
            <el-table-column prop="loginTime" label="登录时间" width="160" show-overflow-tooltip>
            </el-table-column>
        </el-table>
        <div class="row py-7 float-end">
            <el-pagination layout="total,sizes, prev, pager, next" @size-change="handleSizeChange"
                @current-change="handleCurrentChange" :total="total">
            </el-pagination>
        </div>
    </el-card>
</template>
<script>
import { fetchUserLoginLogs } from "@/api/system/user"
import { fetchPageLoginLogs } from "@/api/monitor/loginLog"
export default {
    name: 'LoginLog',
    data() {
        return {
            list: [],
            total: 0,
            params: {
                pageNum: 1,
                pageSize: 10,
                orderBy: '',
                orderType: '',
            },
            loading: false,
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
            var mtx;
            if (this.$route.query.id) {
                this.params.userId = this.$route.query.id
                mtx = fetchPageLoginLogs(this.params)
            } else {
                mtx = fetchUserLoginLogs(this.params)
            }
            mtx.then(res => {
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
        sortTable(params) {
            this.params.orderBy = params.key
            this.params.orderType = params.order
            this.refreshTable()
        },
    }
}
</script>
<style lang="scss" scoped>

</style>