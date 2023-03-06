import axios from 'axios'

export const fetchPageCodeMains = params => { return axios.get('/api/metadata/codeMain/page', { params: params }); };

export const getCodeMain = params => { return axios.get('/api/metadata/codeMain', { params: params }); };

export const addOrUpdateCodeMain = params => { return axios.post('/api/metadata/codeMain', params); };

export const deleteCodeMain = params => { return axios.post('/api/metadata/codeMain/delete', params); };


