import axios from 'axios'

export const fetchPageOperateLogs = params => { return axios.get('/api/monitor/operateLog/page', { params: params }); };

export const getOperateLog = params => { return axios.get('/api/monitor/operateLog', { params: params }); };

export const addOrUpdateOperateLog = params => { return axios.post('/api/monitor/operateLog', params); };

export const deleteOperateLog = params => { return axios.post('/api/monitor/operateLog/delete', params); };


