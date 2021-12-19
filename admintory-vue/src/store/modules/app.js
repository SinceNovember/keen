
const state = {
  sidebar: {
    opened: false,
    withoutAnimation: false
  },
  device: 'desktop',
  theme: 'default'
}

const mutations = {
  TOGGLE_SIDEBAR: state => {
    state.sidebar.opened = !state.sidebar.opened
    state.sidebar.withoutAnimation = false

  },
  CLOSE_SIDEBAR: (state, withoutAnimation) => {
    state.sidebar.opened = false
    state.sidebar.withoutAnimation = withoutAnimation
  },
  TOGGLE_DEVICE: (state, device) => {
    state.device = device
  },
  CHANGE_THEME: (state, theme) => {
    state.theme = theme
  }

}

const actions = {
  toggleSideBar({ commit }) {
    commit('TOGGLE_SIDEBAR', '1')
  },
  closeSideBar({ commit }, { withoutAnimation }) {
    commit('CLOSE_SIDEBAR', withoutAnimation)
  },
  toggleDevice({ commit }, device) {
    commit('TOGGLE_DEVICE', device)
  },
  changeTheme({ commit }, theme) {
    commit('CHANGE_THEME', theme)
  }

}

export default {
  namespaced: true,
  state,
  mutations,
  actions
}
