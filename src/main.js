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

import '@/utils'
import globalComponents from '@/utils/globalComponents.js'

Vue.config.productionTip = false

Vue.use(ElementUI)
Vue.use(globalComponents)

// 滚动加载更多
Vue.directive('loadMore', {
  bind(el, binding) {
    // 获取element，定义scroll
    let select_dom = el.querySelector('.el-select-dropdown .el-select-dropdown__wrap');
    select_dom.addEventListener('scroll', function () {
      let height = this.scrollHeight - this.scrollTop <= this.clientHeight;
      if (height) {
        binding.value()
      }
    })
  }
});

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  store,
  components: { App },
  template: '<App/>'
})
