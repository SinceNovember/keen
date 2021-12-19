import Cookies from 'js-cookie'

const TokenKey = 'Admintory'

export function getToken() {
  return Cookies.get(TokenKey)
}

export function setToken(token) {
  return Cookies.set(TokenKey, token)
}

export function removeToken() {
  return Cookies.remove(TokenKey)
}

export function setUserId(userId) {
  return Cookies.set("userId", userId)
}

export function getUserId() {
  return Cookies.get("userId")
}
