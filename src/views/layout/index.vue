<template>
    <div class="card">
        <el-tabs v-model="activeName">
            <el-tab-pane label="Main" name="main">
                <main-builder></main-builder>
            </el-tab-pane>
            <el-tab-pane label="Sidebar" name="sidebar">
                <sidebar-builder></sidebar-builder>
            </el-tab-pane>
            <el-tab-pane label="Header" name="header">
                <header-builder></header-builder>
            </el-tab-pane>
            <el-tab-pane label="Toolbar" name="toolbar">
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
        return {
            activeName: 'main'
        }
    },
    methods: {
    }
}
</script>
<style>

</style>