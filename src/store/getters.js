const getters = {
  settings: state => state.app.settings,
  theme: state => state.app.theme,
  token: state => state.user.token,
  userInfo: state => state.user.userInfo,
  userId: state => state.user.userId,
  avatar: state => state.user.avatar,
}

export default getters