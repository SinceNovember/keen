import router from './router'
const _import = require('./router/_import_' + process.env.NODE_ENV)//获取组件的方法
import { Message } from 'element-ui'
import Layout from '@/layout'
import { getToken, removeToken } from '@/utils/auth' // get token from cookie
import NProgress from 'nprogress' // progress bar
import 'nprogress/nprogress.css' // progress bar style
import { fetchAllMenus } from './api/menu'

var getRouter
const whiteList = ['/login', '/auth-redirect'] // no redirect whitelist

router.beforeEach(async (to, from, next) => {
  //从Cookie中获取token
  const hasToken = getToken()
  NProgress.start() //加载进度条
  if (hasToken) {
    if (to.path === '/login') {
      // if is logged in, redirect to the home page
      next({ path: '/' })
    } else {

      if (!getRouter) {
        if (!getRouter) {
          fetchAllMenus().then(res => {//从数据库获取菜单列表
            if (res.data && res.data.length > 0) {
              getRouter = res.data
              //后台拿到路由
              saveObjArr('router', getRouter) //存储路由到localStorage
              routerGo(to, next)
            } else {
              removeToken()
              next(`/login`)
            }

          })

        } else {
          getRouter = getObjectArr('router')
          routerGo(to, next)

        }
      } else {
        next()
      }
    }
  } else {
    /* has no token*/
    if (whiteList.indexOf(to.path) !== -1) {
      // in the free login whitelist, go directly
      next()
    } else {
      // other pages that do not have permission to access are redirected to the login page.
      next(`/login?redirect=${to.path}`)
    }
  }

  NProgress.done()//结束进度条

})

export function resetRouter() {
  getRouter = null
}

function routerGo(to, next) {
  getRouter = filterAsyncRouter(getRouter) //过滤路由
  router.addRoutes(getRouter) //动态添加路由`
  global.antRouter = getRouter //将路由数据传递给全局变量，做侧边栏菜单渲染工作
  next({ ...to, replace: true })
}

function saveObjArr(name, data) { //localStorage 存储数组对象的方法
  localStorage.setItem(name, JSON.stringify(data))
}

function getObjArr(name) { //localStorage 获取数组对象的方法
  return JSON.parse(window.localStorage.getItem(name));

}

function filterAsyncRouter(asyncRouterMap) { //遍历后台传来的路由字符串，转换为组件对象
  const accessedRouters = asyncRouterMap.filter(route => {
    if (route.component) {
      if (route.component === 'Layout') {//Layout组件特殊处理
        route.component = Layout
      } else {
        try {
          route.component = _import(route.component)
        } catch (e) {
          Message.error(route.component + "文件不存在,请重新设置")
          return false;
        }
      }
    }
    if (route.children && route.children.length) {
      route.children = filterAsyncRouter(route.children)
    }
    return true
  })

  return accessedRouters
}

