const getters = {
  sidebar: state => state.app.sidebar,
  theme: state => state.app.theme,
  token: state => state.user.token,
  userId: state => state.user.userId,
  avatar: state => state.user.avatar,
}

export default getters