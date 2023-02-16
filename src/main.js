// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import store from './store/index.js'
import router from './router'
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';
import 'bootstrap-icons/font/bootstrap-icons.css'
import 'font-awesome/css/font-awesome.min.css'

import '@/assets/css/style.bundle.css'
import '@/styles/index.scss'

import '@/utils/utils.js'
import '@/utils/filter.js'
import '@/utils/request.js'
import '@/promission.js'

Vue.config.productionTip = false

Vue.use(ElementUI);

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  store,
  components: { App },
  template: '<App/>'
})
