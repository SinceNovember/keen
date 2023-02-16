<template>
    <a href="/keen/demo1/../demo1/index.html">
        <img v-if="settings.layout.color == 'light' && settings.theme == 'light'" alt="Logo"
            src="@/assets/media/logos/default-dark.svg" class="h-20px h-lg-30px app-sidebar-logo-default">
        <img v-else alt="Logo" src="@/assets/media/logos/default.svg" class="h-20px h-lg-30px app-sidebar-logo-default">
    </a>
</template>

<script>
import { mapGetters } from "vuex"
export default {
    name: "Logo",
    computed: {
        ...mapGetters(["settings"]),
    }
}
</script>