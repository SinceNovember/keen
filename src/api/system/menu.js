import axios from 'axios'

export const fetchAllMenus = () => { return axios.get('/api/system/menu/all'); };

export const fetchPageMenus = params => { return axios.get('/api/system/menu/page', { params: params }) }

export const fetchMenus = params => { return axios.get('/api/system/menu/list', { params: params }); };

export const fetchMenuTreeModel = () => { return axios.get('/api/system/menu/tree'); };

export const fetchMenuPermissions = params => { return axios.get('/api/system/menu/permission', { params: params }); }

export const getMenu = params => { return axios.get('/api/system/menu', { params: params }); };

export const getFirstMenuPermission = params => { return axios.get('/api/system/menu/first', { params: params }); }

export const addOrUpdateMenu = params => { return axios.post('/api/system/menu', params); };

export const updateMenuHidden = params => { return axios.put('/api/system/menu/hidden', params); };

export const updateMenu = params => { return axios.put('/api/system/menu', params); };

export const deleteMenu = params => { return axios.post('/api/system/menu/delete', params); };

export const addOrUpdateMenuPermission = params => { return axios.post('/api/system/menu/permission', params); }



