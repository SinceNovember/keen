<template>
    <div class="first-app"> 
        {{msg}}
        <div class="common-util">
            123
        </div>
        <div class="test">
            111
        </div>
  <button @click="theme('iview')">默认</button>
  <button @click="theme('light')">浅色</button>
  <button @click="theme('dark')">深色</button>
    </div>
</template>
<script>
export default {
    name:  "First.vue",
    data(){
        return {
            msg : 'Welcome'
        };
    },
    methods: {
        //换主题
        theme(type) {
        window.document.documentElement.setAttribute( "data-theme", type );
        }
    }
}
</script>
