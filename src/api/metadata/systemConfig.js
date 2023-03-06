import axios from 'axios'

export const fetchPageSystemConfigs = params => { return axios.get('/api/metadata/systemConfig/page', { params: params }); };

export const getSystemConfig = params => { return axios.get('/api/metadata/systemConfig', { params: params }); };

export const addOrUpdateSystemConfig = params => { return axios.post('/api/metadata/systemConfig', params); };

export const deleteSystemConfig = params => { return axios.post('/api/metadata/systemConfig/delete', params); };


