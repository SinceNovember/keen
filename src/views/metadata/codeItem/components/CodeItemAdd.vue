<template>
    <el-form :model="codeItemInfo" ref="form" label-width="80px" class="form-container">
        <el-row>
            <el-col>
                <el-form-item label="代码项名">
                    <el-input v-model="codeItemInfo.itemText"></el-input>
                </el-form-item>
            </el-col>
        </el-row>
        <el-row>
            <el-col>
                <el-form-item label="代码项值">
                    <el-input v-model="codeItemInfo.itemValue"></el-input>
                </el-form-item>
            </el-col>
        </el-row>
        <el-row>
            <el-col>
                <el-form-item label="排序">
                    <el-input-number v-model="codeItemInfo.orderNum"></el-input-number>
                </el-form-item>
            </el-col>
        </el-row>
        <el-row>
            <el-form-item label="描述">
                <el-input v-model="codeItemInfo.description" type="textarea" :row="4"></el-input>
            </el-form-item>
        </el-row>
    </el-form>
</template>
<script>
import { addOrUpdateCodeItem } from '@/api/metadata/codeItem'
import { getStatusOption } from '@/api/option'

export default {
    name: 'CodeItemAdd',
    props: {
        codeItemInfo: Object,
    },
    data() {
        return {
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
                    addOrUpdateCodeItem(this.codeItemInfo)
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