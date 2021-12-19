import axios from 'axios'

export const fetchOperationLogs= params => {return axios.get('/api/monitor/log/operation/list', {params:params});};

export const deleteOperationLog = params => { return axios.delete('/api/monitor/log/operation', {params:params});};

export const fetchLoginLogs= params => {return axios.get('/api/monitor/log/login/list', {params:params});};

export const fetchLoginLogCount= params => {return axios.get('/api/monitor/log/login/count', {params:params});};

export const fetchLoginLogHistory= params => {return axios.get('/api/monitor/log/login/count/history', {params:params});};

export const deleteLoginLog = params => { return axios.delete('/api/monitor/log/login', {params:params});};

export const fetchActiveUsers= params => {return axios.get('/api/monitor/session/list', {params:params});};

export const deleteActiveUser = params => { return axios.delete('/api/monitor/session', {params:params});};

