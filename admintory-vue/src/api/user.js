import axios from 'axios'

export const login  = params => { return axios.post('/api/system/login', params);};

export const fetchUsers = params =>{return axios.get('/api/system/user/list', {params:params});};

export const fetchOnlineUsers = params =>{return axios.get('/api/system/user/online', {params:params});};

export const getUser = params =>{return axios.get('/api/system/user', {params:params});};

export const getCurrentUser = () =>{return axios.get('/api/system/user/current');};

export const getUserByToken = params =>{return axios.get('/api/system/user/token', {params:params});};

export const saveUser  = params => { return axios.post('/api/system/user', params);};

export const updateUser  = params => { return axios.put('/api/system/user', params);};

export const updateUserDept = params => { return axios.put('/api/system/user/dept', params);}

export const updatePassword = params => { return axios.put('/api/system/user/password', params);};

export const resetPassword = params => { return axios.put('/api/system/user/password/reset', params);};

export const deleteUser = params => {return axios.delete('/api/system/user', {params:params});};

export const toggleUserStatus = params => {return axios.put('/api/system/user/status', params);};

export const fetchUserRoleRelate = params =>{return axios.get('/api/system/user/role/relate', {params:params});};

export const updateUserRoleRelate  = params => { return axios.put('/api/system/user/role/relate', params);};

export const uploadImg = (params, config) => { return axios.post('/upload/image', params, config);};

export const logout  = params => { return axios.post('/api/system/logout', params);};
