import axios from 'axios'

export const fetchPageLoginLogs = params => { return axios.get('/api/monitor/loginLog/page', { params: params }); };

export const getLoginLog = params => { return axios.get('/api/monitor/loginLog', { params: params }); };

export const addOrUpdateLoginLog = params => { return axios.post('/api/monitor/loginLog', params); };

export const deleteLoginLog = params => { return axios.post('/api/monitor/loginLog/delete', params); };


