import { changeHtmlVal, changeElementVal } from "@/utils/utils"

const state = {
  settings: {
    theme: 'light',
    widthMode: {
      name: 'fluid',
      val: 'container-fluid'
    },
    layout: {
      type: 'sidebar',
      color: 'dark'
    },
    sidebar: {
      closed: false,
      hoverable: true,
      toggle: true,
      fixed: false,
      withoutAnimation: false,
    },
    header: {
      fixed: {
        desktop: false,
        mobile: false
      },
      content: 'menu',
      pageTitle: 'column'
    },
    toolbar: {
      display: true,
      fixed: {
        desktop: false,
        mobile: false
      }
    },
  },
}

const mutations = {
  TOGGLE_SIDEBAR: state => {
    state.settings.sidebar.closed = !state.settings.sidebar.closed
    changeElementVal('data-kt-app-sidebar-minimize', state.settings.sidebar.closed ? 'on' : 'off')
  },
  TOGGLE_SIDEBAR_MINIMIZED: state => {
    changeElementVal('data-kt-app-sidebar-minimize', state.settings.sidebar.closed ? 'on' : 'off')
  },
  TOGGLE_SIDEBAR_HOVERABLE: state => {
    // state.settings.sidebar.hoverable = !state.settings.sidebar.hoverable
    changeElementVal('data-kt-app-sidebar-hoverable', state.settings.sidebar.hoverable)
  },
  TOGGLE_SIDEBAR_TOGGLE: state => {
    state.settings.sidebar.toggle = !state.settings.sidebar.toggle
  },
  FIXED_SIDEBAR: state => {
    state.settings.sidebar.fixed = !state.settings.sidebar.fixed
    changeElementVal('data-kt-app-sidebar-minimize', state.settings.sidebar.fixed ? 'sm-hover-active' : 'sm-hover')
  },
  TOGGLE_THEME: state => {
    if (state.settings.theme == 'light') {
      state.settings.theme = 'dark'
    } else {
      state.settings.theme = 'light'
    }
    changeHtmlVal('data-bs-theme', state.settings.theme)
  },
  CHANGE_THEME: (state, val) => {
    state.settings.theme = val
    changeHtmlVal('data-bs-theme', val)
  },
  CHANGE_LAYOUT: (state, val) => {
    const color = val.split("-")[0], type = val.split("-")[1]
    state.settings.layout.color = color
    state.settings.layout.type = type
    changeElementVal('data-kt-app-sidebar-fixed', type != 'header')
    changeElementVal('data-kt-app-layout', val)
  },
  CHANGE_SETTINGS: (state, { name, val }) => {
    if (name == 'data-kt-app-layout') {
      const color = val.split("-")[0], type = val.split("-")[1]
      state.settings.layout.color = color
      state.settings.layout.type = type
      changeElementVal('data-kt-app-sidebar-fixed', type != 'header')
    }
    changeElementVal(name, val)
  },
  CHANGE_WIDTH_MODE: (state, val) => {
    if (val == 'fluid') {
      state.settings.widthMode.name = 'fluid'
      state.settings.widthMode.val = 'container-fluid'
    } else if (val == 'fixed') {
      state.settings.widthMode.name = 'fixed'
      state.settings.widthMode.val = 'container-xxl'
    } else {
      state.settings.widthMode.name = 'default'
      state.settings.widthMode.val = 'container-xxl'
    }
  },
  CHANGE_HEADER_CONTENT: (state, val) => {
    if (val == 'pageTitle') {
      state.settings.toolbar.display = false
      changeElementVal('data-kt-app-toolbar-enabled', state.settings.toolbar.display)
    }
    state.settings.header.content = val
  },
  CHANGE_HEADER_PAGE_TITLE: (state, val) => {
    state.settings.header.pageTitle = val
  },
  TOGGLE_FIXED_HEADER: (state) => {
    // state.settings.header.fixed.desktop = !state.settings.header.fixed.desktop
    changeElementVal('data-kt-app-header-fixed', state.settings.header.fixed.desktop)
  },
  TOGGLE_FIXED_MOBILE_HEADER: (state) => {
    // state.settings.header.fixed.mobile = !state.settings.header.fixed.mobile
    changeElementVal('data-kt-app-header-fixed-mobile', state.settings.header.fixed.mobile)
  },
  TOGGLE_TOOLBAR: (state) => {
    if (state.settings.header.content != 'pageTitle') {
      // state.settings.toolbar.display = !state.settings.toolbar.display
      changeElementVal('data-kt-app-toolbar-enabled', state.settings.toolbar.display)
    }
  },
  TOGGLE_FIXED_TOOLBAR: (state) => {
    // state.settings.toolbar.fixed.desktop = !state.settings.toolbar.fixed.desktop
    changeElementVal('data-kt-app-toolbar-fixed', state.settings.toolbar.fixed.desktop)
  },
  TOGGLE_FIXED_MOBILE_TOOLBAR: (state) => {
    // state.settings.toolbar.fixed.mobile = !state.settings.toolbar.fixed.mobile
    changeElementVal('data-kt-app-toolbar-fixed-mobile', state.settings.toolbar.fixed.mobile)
  },
}

const actions = {
  toggleSidebar({ commit }) {
    commit('TOGGLE_SIDEBAR')
  },
  toggleSidebarMinimized({ commit }) {
    commit('TOGGLE_SIDEBAR_MINIMIZED')
  },
  toggleSidebarHoverable({ commit }) {
    commit('TOGGLE_SIDEBAR_HOVERABLE')
  },
  toggleSidebarToggle({ commit }) {
    commit('TOGGLE_SIDEBAR_TOGGLE')
  },
  fixedSidebar({ commit }) {
    commit('FIXED_SIDEBAR')
  },
  toggleTheme({ commit }) {
    commit('TOGGLE_THEME')
  },
  changeTheme({ commit }, data) {
    commit('CHANGE_THEME', data)
  },
  changeLayout({ commit }, data) {
    commit('CHANGE_LAYOUT', data)
  },
  changeSettings({ commit }, data) {
    commit('CHANGE_SETTINGS', data)
  },
  changeWidthMode({ commit }, data) {
    commit('CHANGE_WIDTH_MODE', data)
  },
  changeHeaderContent({ commit }, data) {
    commit('CHANGE_HEADER_CONTENT', data)
  },
  changeHeaderPageTitle({ commit }, data) {
    commit('CHANGE_HEADER_PAGE_TITLE', data)
  },
  toggleFixedHeader({ commit }) {
    commit('TOGGLE_FIXED_HEADER')
  },
  toggleFixedMobileHeader({ commit }) {
    commit('TOGGLE_FIXED_MOBILE_HEADER')
  },
  toggleToolbar({ commit }) {
    commit('TOGGLE_TOOLBAR')
  },
  toggleFixedToolbar({ commit }) {
    commit('TOGGLE_FIXED_TOOLBAR')
  },
  toggleFixedMobileToolbar({ commit }) {
    commit('TOGGLE_FIXED_MOBILE_TOOLBAR')
  },
}

export default {
  namespaced: true,
  state,
  mutations,
  actions
}
