import axios from 'axios'

export const fetchRoles = params =>{return axios.get('/api/system/role/list', {params:params});};

export const fetchRoleOptions = params => {return axios.get('api/system/role/option');};

export const fetchRoleUserRelate = params =>{return axios.get('/api/system/role/user/relate', {params:params});};

export const fetchRoleMemberCountTop6 = params => {return axios.get('/api/system/role/count/member', {params:params});};

export const getRole = params =>{return axios.get('/api/system/role', {params:params});};

export const saveRole  = params => { return axios.post('/api/system/role', params);};

export const updateRole  = params => { return axios.put('/api/system/role', params);};

export const deleteRole = params => {return axios.delete('/api/system/role', {params:params});};

export const toggleRoleStatus = params => {return axios.put('/api/system/role/status', params);};

export const updateRoleUserRelate  = params => { return axios.put('/api/system/role/user/relate', params);};



