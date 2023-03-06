import axios from 'axios'

export const fetchPageDepts = params =>{return axios.get('/api/system/dept/page', {params:params});};

export const fetchDeptTreeModel = () => { return axios.get('/api/system/dept/tree'); };

export const fetchDeptUser = params => {return axios.get('/api/system/dept/user', {params:params});};

export const getDept = params =>{return axios.get('/api/system/dept', {params:params});};

export const addOrUpdateDept  = params => { return axios.post('/api/system/dept', params);};

export const updateDept  = params => { return axios.put('/api/system/dept', params);};

export const deleteDept = params => {return axios.post('/api/system/dept/delete', params);};

export const fetchDeptWithUserTreeModel = params =>{return axios.get('/api/system/dept/user/tree');};


