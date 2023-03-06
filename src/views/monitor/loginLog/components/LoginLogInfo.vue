<template>
  <div class="info-container">
        <div class="info-row">
            <div class="info-col">
                <span class="info-title">登录名：</span>
                <span class="info-content">{{ dataInfo.nickname }}</span>
            </div>
            <div class="info-col">
                <span class="info-title">登录地：</span>
                <span class="info-content">{{ dataInfo.location }}</span>
            </div>
        </div>
        <div class="info-row">
            <div class="info-col">
                <span class="info-title">IP：</span>
                <span class="info-content">{{ dataInfo.ip }}</span>
            </div>
            <div class="info-col">
                <span class="info-title">系统：</span>
                <span class="info-content">{{ dataInfo.system }}</span>
            </div>
        </div>
        <div class="info-row">
            <div class="info-col">
                <span class="info-title">浏览器：</span>
                <span class="info-content">{{ dataInfo.browser }}</span>
            </div>
            <div class="info-col">
                <span class="info-title">登录时间：</span>
                <span class="info-content">{{ dataInfo.loginTime }}</span>
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
