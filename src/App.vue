<template>
  <div class="d-flex flex-column flex-root app-root">
    <router-view/>
  </div>
</template>

<script>
import Layout from './layout'
export default {
  name: 'App',
  components: {
    Layout
  }
}
</script>

<style>

</style>
