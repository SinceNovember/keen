<template>
    <el-card shadow="nerve">
        <div slot="header" class="cursor-pointer  d-flex flex-stack">
            <!--begin::Card title-->
            <div class="card-title m-0">
                <h3 class="fw-bold m-0">操作日志</h3>
            </div>
            <!--end::Card title-->
        </div>
        <el-table ref="table" :data="list" tooltip-effect="dark" style="width: 100%" v-loading="loading"
            @selection-change="handleSelectionChange" element-loading-text="Loading...">
            <el-table-column prop="operation" label="操作" width="160" show-overflow-tooltip>
            </el-table-column>
            <el-table-column prop="method" label="操作方法" show-overflow-tooltip>
            </el-table-column>
            <el-table-column prop="params" label="操作参数" show-overflow-tooltip>
            </el-table-column>
            <el-table-column prop="location" label="操作地" show-overflow-tooltip>
            </el-table-column>
            <el-table-column prop="ip" label="操作ip" width="100" show-overflow-tooltip>
            </el-table-column>
            <el-table-column prop="time" label="耗时" width="80" show-overflow-tooltip>
                <template slot-scope="scope">
                    <div class="badge fw-bold badge-light-success">
                        {{ scope.row.time }}ms
                    </div>
                </template>
            </el-table-column>
            <el-table-column prop="operateTime" label="操作时间" width="180" show-overflow-tooltip>
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
import { fetchUserOperateLogs } from "@/api/system/user"
import { fetchPageOperateLogs } from "@/api/monitor/operateLog"
export default {
    name: 'OperateLog',
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
                mtx = fetchPageOperateLogs(this.params)
            } else {
                mtx = fetchUserOperateLogs(this.params)
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