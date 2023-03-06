<template>
    <div class="info-container">
        <div class="info-row">
            <div class="info-col">
                <span class="info-title">操作人：</span>
                <span class="info-content">{{ dataInfo.nickname }}</span>
            </div>
            <div class="info-col">
                <span class="info-title">操作：</span>
                <span class="info-content">{{ dataInfo.operation }}</span>
            </div>
        </div>
        <div class="info-row">
            <div class="info-col line">
                <span class="info-title">操作方法：</span>
                <span class="info-content">{{ dataInfo.method }}</span>
            </div>
        </div>
        <div class="info-row">
            <div class="info-col line">
                <span class="info-title">操作参数：</span>
                <span class="info-content">{{ dataInfo.params }}</span>
            </div>
        </div>
        <div class="info-row">
            <div class="info-col">
                <span class="info-title">操作地：</span>
                <span class="info-content">{{ dataInfo.location }}</span>
            </div>
            <div class="info-col">
                <span class="info-title">操作ip：</span>
                <span class="info-content">{{ dataInfo.ip }}</span>
            </div>
        </div>
        <div class="info-row">
            <div class="info-col">
                <span class="info-title">操作时间：</span>
                <span class="info-content">{{ dataInfo.operateTime }}</span>
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
