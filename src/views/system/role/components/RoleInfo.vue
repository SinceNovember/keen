<template>
    <div class="info-container">
        <div class="info-row">
            <div class="info-col">
                <span class="info-title">角色名称：</span>
                <span class="info-content">{{ dataInfo.roleName }}</span>
            </div>
            <div class="info-col">
                <span class="info-title">角色标志：</span>
                <span class="info-content">{{ dataInfo.roleTag }}</span>
            </div>
        </div>
        <div class="info-row">
            <div class="info-col">
                <span class="info-title">状态：</span>
                <div class="badge fw-bold"
                    :class="dataInfo.status == 'VALID' ? 'badge-light-success' : 'badge-light-danger'">
                    {{ dataInfo.status | StatusTypeFilter }}
                </div>
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
