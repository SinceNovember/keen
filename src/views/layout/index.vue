<template>
    <div class="card">
        <el-tabs v-model="activeName" @tab-click="handleClick">
            <el-tab-pane label="Main" name="first">
                <main-builder></main-builder>
            </el-tab-pane>
            <el-tab-pane label="Sidebar" name="third">
                <sidebar-builder></sidebar-builder>
            </el-tab-pane>
            <el-tab-pane label="Header" name="fourth">
                <header-builder></header-builder>
            </el-tab-pane>
            <el-tab-pane label="Toolbar" name="second">
                <toolbar-builder></toolbar-builder>
            </el-tab-pane>
        </el-tabs>
    </div>
</template>
<script>
import MainBuilder from './components/MainBuilder.vue'
import SidebarBuilder from './components/SidebarBuilder.vue'
import HeaderBuilder from './components/HeaderBuilder.vue'
import ToolbarBuilder from './components/ToolbarBuilder.vue'
export default {
    name: 'LayoutBuilder',
    components: {
        MainBuilder,
        SidebarBuilder,
        ToolbarBuilder,
        HeaderBuilder
    },
    data() {
        return {}
    },
    methods: {}
}
</script>
<style>

</style>