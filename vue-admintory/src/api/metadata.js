import axios from 'axios'

// 系统参数

export const fetchSystemConfigs = params =>{return axios.get('/api/metadata/system/list', {params:params});};

export const getSystemConfig = params =>{return axios.get('/api/metadata/system', {params:params});};

export const saveSystemConfig  = params => { return axios.post('/api/metadata/system', params);};

export const updateSystemConfig  = params => { return axios.put('/api/metadata/system', params);};

export const deleteSystemConfig = params => {return axios.delete('/api/metadata/system', {params:params});};


// 代码管理

export const fetchCodeMains = params =>{return axios.get('/api/metadata/code/main/list', {params:params});};

export const getCodeMain = params =>{return axios.get('/api/metadata/code/main', {params:params});};

export const saveCodeMain = params => { return axios.post('/api/metadata/code/main', params);};

export const updateCodeMain  = params => { return axios.put('/api/metadata/code/main', params);};

export const deleteCodeMain = params => {return axios.delete('/api/metadata/code/main', {params:params});};

// 代码子项管理

export const fetchCodeItems = params =>{return axios.get('/api/metadata/code/item/list', {params:params});};

export const getCodeItem = params =>{return axios.get('/api/metadata/code/item', {params:params});};

export const saveCodeItem = params => { return axios.post('/api/metadata/code/item', params);};

export const updateCodeItem  = params => { return axios.put('/api/metadata/code/item', params);};

export const deleteCodeItem = params => {return axios.delete('/api/metadata/code/item', {params:params});};
