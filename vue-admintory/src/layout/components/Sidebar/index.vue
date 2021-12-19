<template>
		<div class="sidebar" :class="{'close' : isCollapse}">
            <logo/>
            <sidebar-menu></sidebar-menu>
		</div>
</template>

<script>

import { mapGetters } from 'vuex'
import Logo from './Logo'
import SidebarMenu from './SidebarMenu'

export default {
  components: { SidebarMenu, Logo },
  computed:{
    ...mapGetters([
      'sidebar'
    ]),
    isCollapse(){
        return !this.sidebar.opened
    }
  }
}
</script>

<style>

</style>