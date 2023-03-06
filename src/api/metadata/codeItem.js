import axios from 'axios'

export const fetchPageCodeItems = params => { return axios.get('/api/metadata/codeItem/page', { params: params }); };

export const getCodeItem = params => { return axios.get('/api/metadata/codeItem', { params: params }); };

export const addOrUpdateCodeItem = params => { return axios.post('/api/metadata/codeItem', params); };

export const deleteCodeItem = params => { return axios.post('/api/metadata/codeItem/delete', params); };


