<template>
    <div class="info-container">
        <div class="info-row">
            <div class="info-col">
                <span class="info-title">上级菜单：</span>
                <span class="info-content">{{ dataInfo.parentTitle }}</span>
            </div>
            <div class="info-col">
                <span class="info-title">{{ dataInfo.type != 'BUTTON' ? '菜单名称：' : '按钮名称：' }} </span>
                <span class="info-content">{{ dataInfo.title }}</span>
            </div>
        </div>
        <div class="info-row" v-if="dataInfo.type != 'BUTTON'">
            <div class="info-col">
                <span class="info-title">菜单图标：</span>
                <span class="info-content"><i :class="dataInfo.icon"></i>{{ dataInfo.icon }}</span>
            </div>
            <div class="info-col">
                <span class="info-title">标志：</span>
                <span class="info-content">{{ dataInfo.name }}</span>
            </div>
        </div>
        <div class="info-row">
            <div class="info-col">
                <span class="info-title">{{ dataInfo.type != 'BUTTON' ? '路由地址：' : 'API地址：' }}</span>
                <span class="info-content">{{ dataInfo.path }}</span>
            </div>
            <div class="info-col" v-if="dataInfo.type != 'BUTTON'">
                <span class="info-title">组件地址：</span>
                <span class="info-content">{{ dataInfo.component }}</span>
            </div>
            <div class="info-col" v-if="dataInfo.type == 'BUTTON'">
                <span class="info-title">API类型：</span>
                <span class="info-content">{{ dataInfo.requestMethod }}</span>
            </div>
        </div>
        <div class="info-row">

            <div class="info-col" v-if="dataInfo.type != 'BUTTON'">
                <span class="info-title">重定向：</span>
                <span class="info-content">{{ dataInfo.redirect }}</span>
            </div>
            <div class="info-col">
                <span class="info-title">排序：</span>
                <span class="info-content">{{ dataInfo.orderNum }}</span>
            </div>
        </div>
        <div class="info-row" v-if="dataInfo.type != 'BUTTON'">
            <div class="info-col">
                <span class="info-title">是否隐藏：</span>
                <span class="info-content">{{ dataInfo.hidden | StatusFilter }}</span>
            </div>
            <div class="info-col">
                <span class="info-title">是否公开：</span>
                <span class="info-content">{{ dataInfo.alwaysShow | StatusFilter }}</span>
            </div>
        </div>
        <div class="info-row" v-if="dataInfo.type != 'BUTTON'">
            <div class="info-col">
                <span class="info-title">面包屑：</span>
                <span class="info-content">{{ dataInfo.breadCrumb | StatusFilter }}</span>
            </div>
            <div class="info-col">
                <span class="info-title">默认展开：</span>
                <span class="info-content">{{ dataInfo.expand | StatusFilter }}</span>
            </div>
        </div>
    </div>
</template>
<script>
export default {
    props: {
        dataInfo: Object
    }
}
</script>

<style lang="scss" scoped>
</style>