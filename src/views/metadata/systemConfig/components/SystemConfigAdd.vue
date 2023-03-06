<template>
    <el-form :model="systemConfigInfo" ref="form" label-width="80px" class="form-container">
        <el-row>
            <el-col>
                <el-form-item label="参数名称" prop="systemConfigName">
                    <el-input v-model="systemConfigInfo.configName"></el-input>
                </el-form-item>
            </el-col>
        </el-row>
        <el-row>
            <el-col>
                <el-form-item label="参数值" prop="systemConfigTag">
                    <el-input v-model="systemConfigInfo.configValue"></el-input>
                </el-form-item>
            </el-col>
        </el-row>
        <el-row>
            <el-col>
                <el-form-item label="排序" prop="orderNum">
                    <el-input-number v-model="systemConfigInfo.orderNum"></el-input-number>
                </el-form-item>
            </el-col>
        </el-row>
        <el-row>
            <el-form-item label="描述" prop="description">
                <el-input v-model="systemConfigInfo.description" type="textarea" :row="4"></el-input>
            </el-form-item>
        </el-row>
    </el-form>
</template>
<script>
import { addOrUpdateSystemConfig } from '@/api/metadata/systemConfig'
import { getStatusOption } from '@/api/option'

export default {
    name: 'SystemConfigAdd',
    props: {
        systemConfigInfo: Object,
    },
    data() {
        return {
            statusOptions: [
                {
                    value: 'VALID',
                    label: '启用'
                },
                {
                    value: 'LOCK',
                    label: '禁用'
                },
            ],
            ruleForm: {
                name: '',
                region: '',
                date1: '',
                date2: '',
                delivery: false,
                type: [],
                resource: '',
                desc: ''
            },
        };
    },
    mounted() {
        this.loadStatusOptionModel()
    },
    methods: {
        loadStatusOptionModel() {
            getStatusOption().then(res => {
                this.statusOptions = res.data
            })
        },
        search() {
            this.$emit("search")
        },
        save() {
            this.$refs['form'].validate((valid) => {
                if (valid) {
                    addOrUpdateSystemConfig(this.systemConfigInfo)
                        .then(res => {
                            this.$emit("cancel")
                            this.$message.success("添加成功")
                            this.search()
                        })
                }
            })
        },
    }
}
</script>
<style lang="scss" scoped>
.form-container {
    padding: 15px 0px;

    .image-input-position {
        position: absolute;
        right: 70px;
    }

    .image-input {
        [data-kt-image-input-action=remove] {
            top: 86%;
        }
    }
}
</style>