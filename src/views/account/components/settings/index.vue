<template>
  <div class="settings-container">
    <profile-settings :userInfo="userInfo" class="mb-10" @refreshInfo="refreshInfo"></profile-settings>
    <login-settings :userInfo="userInfo" @refreshInfo="refreshInfo"></login-settings>
  </div>
</template>
<script>
import ProfileSettings from './components/ProfileSettings'
import LoginSettings from './components/LoginSettings'
export default {
  name: 'Settings',
  components: {
    ProfileSettings,
    LoginSettings
  },
  props: {
    userInfo: Object,
  },
  data() {
    return {}
  },
  methods: {
    refreshInfo() {
      this.$emit('refreshInfo')
    }
  }
}
</script>
<style lang="scss" scoped>

</style>