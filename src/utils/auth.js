import Cookies from 'js-cookie'

const tokenKey = 'Hyper-Token'

export function getToken() {
  return Cookies.get(tokenKey)
}

export function setToken(token) {
  return Cookies.set(tokenKey, token)
}

export function removeToken() {
  return Cookies.remove(tokenKey)
}

export function clearToken() {
  Cookies.remove(tokenKey)
}

