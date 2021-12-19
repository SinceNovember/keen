// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'

import App from './App'
import store from './store'
import Element from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'


import '@/promission.js'
import '@/utils/filter.js'
import router from './router'

import '@/styles/index.scss'// global css
import '@/utils/request'


Vue.use(Element)

Vue.config.productionTip = false

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  store,
  components: { App },
  template: '<App/>'
})
