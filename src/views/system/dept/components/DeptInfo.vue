<template>
    <div class="info-container">
        <div class="info-row">
            <div class="info-col">
                <span class="info-title">上级部门：</span>
                <span class="info-content">{{ dataInfo.parentName }}</span>
            </div>
            <div class="info-col">
                <span class="info-title">部门名称：</span>
                <span class="info-content">{{ dataInfo.deptName }}</span>
            </div>
        </div>
        <div class="info-row">
            <div class="info-col">
                <span class="info-title">部门简称：</span>
                <span class="info-content">{{ dataInfo.deptShortName }}</span>

            </div>
            <div class="info-col">
                <span class="info-title">排序：</span>
                <span class="info-content">{{ dataInfo.orderNum }}</span>
            </div>
        </div>
        <div class="info-row">
            <div class="info-col">
                <span class="info-title">描述：</span>
                <span class="info-content">{{ dataInfo.description }}</span>
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
