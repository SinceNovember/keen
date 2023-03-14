<template>
    <div>
        <profile :userInfo="userInfo" :isCurrent="isCurrent"></profile>
        <navbar :activeTab="activeTab" @changeTab="changeTab" :isCurrent="isCurrent"></navbar>
        <overview v-if="activeTab == 'overview'" :userInfo="userInfo" :isCurrent="isCurrent"></overview>
        <settings v-if="activeTab == 'settings'" :userInfo="userInfo" @refreshInfo="loadUserInfo"></settings>
        <logs v-if="activeTab == 'logs'"></logs>
    </div>
</template>
<script>
import { getUser, getLoginUserInfo } from "@/api/system/user"
import { Profile, Navbar, Overview, Settings, Logs } from './components'
export default {
    name: 'index',
    components: {
        Profile,
        Navbar,
        Overview,
        Settings,
        Logs
    },
    data() {
        return {
            isCurrent: this.$route.query.id == null,
            activeTab: 'overview',
            userInfo: {}
        }
    },
    watch: {
        $route(to, from) {
            this.loadUserInfo()
            this.isCurrent = true
        }
    },
    mounted() {
        this.loadUserInfo()
    },
    methods: {
        loadUserInfo() {
            var mth;
            if (!this.$route.query.id) {
                mth = getLoginUserInfo()
            } else {
                mth = getUser({
                    id: this.$route.query.id
                })
            }
            mth.then(res => {
                this.userInfo = res.data
                const { roleNames } = res.data
                if (roleNames) {
                    this.userInfo.roleNames = roleNames.join(", ")
                }
            })
        },
        changeTab(tab) {
            this.activeTab = tab
        },
    }
}
</script>
<style lang="scss" scoped>

</style>