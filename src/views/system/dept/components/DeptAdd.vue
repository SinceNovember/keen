<template>
    <el-form :model="deptInfo" ref="form" label-width="80px" class="form-container">
        <el-row>
            <el-col>
                <el-form-item label="上级部门" prop="parentId">
                    <tree-select :value="deptInfo.parentId" :options="treeModelData" class="w-100" clearable
                        @getValue="getValue($event)"></tree-select>
                </el-form-item>
            </el-col>
        </el-row>
        <el-row>
            <el-col>
                <el-form-item label="部门名称" prop="deptTag">
                    <el-input v-model="deptInfo.deptName"></el-input>
                </el-form-item>
            </el-col>
        </el-row>
        <el-row>
            <el-col :span="12">
                <el-form-item label="部门简称" prop="deptShortName">
                    <el-input v-model="deptInfo.deptShortName"></el-input>
                </el-form-item>
            </el-col>
            <el-col :span="12">
                <el-form-item label="排序" prop="orderNum">
                    <el-input-number v-model="deptInfo.orderNum"></el-input-number>
                </el-form-item>
            </el-col>
        </el-row>
        <el-row>
            <el-form-item label="描述" prop="description">
                <el-input v-model="deptInfo.description" type="textarea" :row="4"></el-input>
            </el-form-item>
        </el-row>
    </el-form>
</template>
<script>
import { fetchDeptTreeModel, addOrUpdateDept } from '@/api/system/dept'
import TreeSelect from '@/components/TreeSelect'

export default {
    name: 'DeptAdd',
    components: {
        TreeSelect
    },
    props: {
        deptInfo: Object,
    },
    data() {
        return {
            treeModelData: [],
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
        this.loadTreeModel()
    },
    methods: {
        loadTreeModel() {
            fetchDeptTreeModel().then(res => {
                this.treeModelData = res.data;
            });
        },
        search() {
            this.$emit("search")
        },
        save() {
            this.$refs['form'].validate((valid) => {
                if (valid) {
                    addOrUpdateDept(this.deptInfo)
                        .then(res => {
                            this.$emit("cancel")
                            this.$message.success("添加成功")
                            this.search()
                        })
                }
            })
        },
        getValue(value) {
            this.deptInfo.parentId = value
        },
        clearForm() {
            this.$refs.form.resetFields()
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