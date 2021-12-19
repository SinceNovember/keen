import Vue from 'vue'
import Router from 'vue-router'
import Login from '@/views/login/'

Vue.use(Router)

export const constantRoutes = [
    { path: '/login', component: Login },

  ]

const createRouter = () => new Router({
  // mode: 'history', // require service support
  scrollBehavior: () => ({ y: 0 }),
  routes: constantRoutes
})

const router = createRouter()

export function resetRouter() {
  const newRouter = createRouter()
  router.matcher = newRouter.matcher // reset router
}

export default router

