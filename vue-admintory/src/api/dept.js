import axios from 'axios'

export const fetchDepts = params =>{return axios.get('/api/system/dept/list', {params:params});};

export const fetchDeptOptions = () => {return axios.get('api/system/dept/option');};

export const fetchDeptMemberCountTop6 = params => {return axios.get('/api/system/dept/count/member', {params:params});};

export const getDept = params =>{return axios.get('/api/system/dept', {params:params});};

export const saveDept  = params => { return axios.post('/api/system/dept', params);};

export const updateDept  = params => { return axios.put('/api/system/dept', params);};

export const deleteDept = params => {return axios.delete('/api/system/dept', {params:params});};

export const fetchDeptWithUserTreeModel = params =>{return axios.get('/api/system/dept/user/tree');};


