import axios from 'axios'

export const fetchPageRoles = params => { return axios.get('/api/system/role/page', { params: params }); };

export const fetchRoleOptionModel = params => { return axios.get('api/system/role/option'); };

export const fetchRoleTreeModel = () => { return axios.get('/api/system/role/tree'); };

export const fetchRoleUserRelate = params => { return axios.get('/api/system/role/user/relate', { params: params }); };

export const fetchRoleMemberCountTop6 = params => { return axios.get('/api/system/role/count/member', { params: params }); };

export const getRole = params => { return axios.get('/api/system/role', { params: params }); };

export const addOrUpdateRole = params => { return axios.post('/api/system/role', params); };

export const updateRole = params => { return axios.put('/api/system/role', params); };

export const deleteRole = params => { return axios.post('/api/system/role/delete', params); };

export const toggleRoleStatus = params => { return axios.put('/api/system/role/status', params); };

export const updateRoleUserRelate = params => { return axios.put('/api/system/role/user/relate', params); };



