<template>
    <el-form :model="roleInfo" ref="form" label-width="80px" class="form-container">
        <el-row>
            <el-col>
                <el-form-item label="角色名称" prop="roleName">
                    <el-input v-model="roleInfo.roleName"></el-input>
                </el-form-item>
            </el-col>
        </el-row>
        <el-row>
            <el-col>
                <el-form-item label="角色标志" prop="roleTag">
                    <el-input v-model="roleInfo.roleTag"></el-input>
                </el-form-item>
            </el-col>
        </el-row>
        <el-row>
            <el-col :span="12">
                <el-form-item label="状态" prop="status">
                    <el-select v-model="roleInfo.status" class="w-100" placeholder="请选择状态">
                        <el-option v-for="item in statusOptions" :key="item.value" :label="item.label"
                            :value="item.value"></el-option>
                    </el-select>
                </el-form-item>
            </el-col>
            <el-col :span="12">
                <el-form-item label="排序" prop="orderNum">
                    <el-input-number v-model="roleInfo.orderNum"></el-input-number>
                </el-form-item>
            </el-col>
        </el-row>
        <el-row>
            <el-form-item label="描述"  prop="description">
                <el-input v-model="roleInfo.description" type="textarea" :row="4"></el-input>
            </el-form-item>
        </el-row>
    </el-form>
</template>
<script>
import { addOrUpdateRole } from '@/api/system/role'
import { getStatusOption } from '@/api/option'

export default {
    name: 'RoleAdd',
    props: {
        roleInfo: Object,
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
                if (res.data) {
                    this.statusOptions = res.data
                }
            })
        },
        search() {
            this.$emit("search")
        },
        save() {
            this.$refs['form'].validate((valid) => {
                if (valid) {
                    addOrUpdateRole(this.roleInfo)
                        .then(res => {
                            this.$emit("cancel")
                            this.$message.success("添加成功")
                            this.search()
                        })
                }
            })
        }
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