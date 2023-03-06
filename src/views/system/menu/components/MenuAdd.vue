<template>
    <div class="menu-add-container">
        <el-tabs v-model="menuInfo.type" @tab-click="handleTabs">
            <el-tab-pane label="目录" name="DIRECTORY"></el-tab-pane>
            <el-tab-pane label="菜单" name="MENU"></el-tab-pane>
            <el-tab-pane label="按钮" name="BUTTON"></el-tab-pane>
        </el-tabs>

        <el-form :model="menuInfo" label-position="right" label-width="90px" ref="formValidate">
            <div class="menu-content">
                <el-row v-if="menuInfo.type != 'DIRECTORY'">
                    <el-form-item label="上级菜单">
                        <tree-select :value="menuInfo.parentId" :options="treeModelData" class="w-100"
                            @getValue="getValue($event)"></tree-select>
                    </el-form-item>
                </el-row>
                <el-row>
                    <el-form-item :label="menuInfo.type != 'BUTTON' ? '菜单名称' : '按钮名称'">
                        <el-input v-model="menuInfo.title"></el-input>
                    </el-form-item>
                </el-row>
                <el-row v-if="menuInfo.type != 'BUTTON'">
                    <el-col :span="16">
                        <el-form-item label="图标">
                            <el-select v-model="menuInfo.icon" filterable :filter-method="filterIcon" class="w-100"
                                v-loadMore="loadMore">
                                <template #prefix>
                                    <div class="prefix-icon-badget"><i :class="menuInfo.icon"></i></div>
                                </template>
                                <div class="menu-icon-list">
                                    <el-option v-for="icon in loadedIcons" :value="icon" :key="icon" :label="icon">
                                        <i :class="icon"></i>
                                    </el-option>
                                </div>
                            </el-select>
                            <!-- <el-input v-model="menuInfo.icon"></el-input> -->
                        </el-form-item>
                    </el-col>
                    <el-col :span="8">
                        <el-form-item label="标志">
                            <el-input v-model="menuInfo.name"></el-input>
                        </el-form-item>
                    </el-col>
                </el-row>
                <el-row>
                    <el-form-item :label="menuInfo.type != 'BUTTON' ? '路由地址' : 'Api地址'" prop="path">
                        <el-input v-model="menuInfo.path"></el-input>
                    </el-form-item>
                </el-row>
                <el-row v-if="menuInfo.type == 'MENU'">
                    <el-form-item label="组件地址" prop="component">
                        <el-input v-model="menuInfo.component"></el-input>
                    </el-form-item>
                </el-row>

                <el-row v-if="menuInfo.type == 'BUTTON'">
                    <el-form-item label="Api类型">
                        <el-radio-group v-model="menuInfo.requestMethod">
                            <el-radio label="GET">GET</el-radio>
                            <el-radio label="POST">POST</el-radio>
                            <el-radio label="PUT">PUT</el-radio>
                            <el-radio label="DELETE">DELETE</el-radio>
                        </el-radio-group>
                    </el-form-item>
                </el-row>

                <el-row>
                    <el-col :span="12" v-if="menuInfo.type != 'BUTTON'">
                        <el-form-item label="重定向">
                            <el-input v-model="menuInfo.redirect"></el-input>
                        </el-form-item>
                    </el-col>
                    <el-col :span="12">
                        <el-form-item label="排序">
                            <el-input-number v-model="menuInfo.orderNum"></el-input-number>
                        </el-form-item>
                    </el-col>
                </el-row>
                <el-row v-if="menuInfo.type != 'BUTTON'">
                    <el-col :span="4">
                        <el-form-item label="隐藏">
                            <el-checkbox v-model="menuInfo.hidden"></el-checkbox>
                        </el-form-item>
                    </el-col>
                    <el-col :span="4">
                        <el-form-item label="公开">
                            <el-checkbox v-model="menuInfo.alwaysShow"></el-checkbox>
                        </el-form-item>
                    </el-col>
                    <el-col :span="4">
                        <el-form-item label="面包屑">
                            <el-checkbox v-model="menuInfo.breadCrumb"></el-checkbox>
                        </el-form-item>
                    </el-col>
                    <el-col :span="4">
                        <el-form-item label="展开">
                            <el-checkbox v-model="menuInfo.expand"></el-checkbox>
                        </el-form-item>
                    </el-col>
                </el-row>
            </div>
        </el-form>
    </div>
</template>
<script>
import { fetchMenuTreeModel, addOrUpdateMenu } from '@/api/system/menu'
import icons from '@/assets/json/icons.json'
import TreeSelect from '@/components/TreeSelect'
export default {
    name: 'MenuAdd',
    props: {
        menuInfo: Object,
    },
    components: {
        TreeSelect
    },
    data() {
        return {
            treeModelData: [],
            pageData: {
                index: 1,
                size: 100
            },
            loadedIcons: icons.slice(0, 100),
            filterAllIcons: [],
            iconFilterVal: '',

        }
    },
    mounted() {
        this.loadTreeModel()
    },
    methods: {
        loadTreeModel() {
            fetchMenuTreeModel().then(res => {
                this.treeModelData = res.data;
            });
        },
        save() {
            this.$refs['formValidate'].validate((valid) => {
                if (valid) {
                    addOrUpdateMenu(this.menuInfo)
                        .then(res => {
                            this.search()
                            this.$emit("cancel")
                            this.$message.success('保存成功')
                        })
                }
            })
        },
        search() {
            this.$emit("search")
        },
        handleTabs(tab) {
            this.menuInfo.type = tab.name
        },
        getValue(value) {
            this.menuInfo.parentId = value
        },
        filterIcon(val) {
            this.pageData.index = 0
            this.iconFilterVal = val
            if (val.trim()) {
                this.filterAllIcons = icons.filter(icon => icon.indexOf(val.trim()) != -1)
            }
            this.loadMore()

        },
        loadMore() {
            this.pageData.index++;
            if (this.iconFilterVal) {
                this.loadedIcons = this.filterAllIcons.slice(0, this.pageData.index * this.pageData.size)
            } else {
                this.loadedIcons = icons.slice(0, this.pageData.index * this.pageData.size)
            }
        },
    }
}
</script>
<style lang="scss" scoped>
.prefix-icon-badget {
    display: flex;
    align-items: center;
    position: relative;
    height: 2.25rem;
    line-height: 2.25rem;
    top: 6px;

    i {
        color: var(--bs-gray-600) !important;
        font-size: 1.5rem;
    }
}
</style>