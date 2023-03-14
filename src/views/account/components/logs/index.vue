<template>
    <div>
        <login-log ref="loginLogRef"></login-log>
        <operate-log ref="operateLogRef" class="mt-10"></operate-log>
    </div>
</template>
<script>
import LoginLog from './components/LoginLog'
import OperateLog from './components/OperateLog'
export default {
    name: 'index',
    components: {
        LoginLog,
        OperateLog
    },
    data() {
        return {
        }
    },
    watch: {
        $route(to, from) {
            this.loadLogs()
        }
    },
    methods: {
        loadLogs() {
            this.$refs.loginLogRef.refreshTable()
            this.$refs.operateLogRef.refreshTable()
        }
    }
}
</script>
<style lang="scss" scoped>

</style>