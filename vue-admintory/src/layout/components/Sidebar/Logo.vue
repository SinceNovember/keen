<template>
        <div class="logo-details">
            <i class='bx bxl-slack'></i>
            <span class="logo_name">{{title}}</span>
        </div>
</template>

<script>
export default {
  name: 'SidebarLogo',
  // props: {
  //   collapse: {
  //     type: Boolean,
  //     required: true
  //   }
  // },
  data() {
    return {
      title: 'ADMINTORY',
    }
  }
}
</script>
<style>

</style>