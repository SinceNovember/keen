<template>
    <div class="info-container">
        <div class="info-row">
            <div class="info-col">
                <span class="info-title">参数名：</span>
                <span class="info-content">{{ dataInfo.configName }}</span>
            </div>
            <div class="info-col">
                <span class="info-title">参数值：</span>
                <span class="info-content">{{ dataInfo.configValue }}</span>
            </div>
        </div>
        <div class="info-row">
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
