import axios from 'axios'

export const fetchMsgs= params => {return axios.get('/api/msg/history', {params:params});};

export const fetchRelatedUsers= params => {return axios.get('/api/msg/relate/user', {params:params});};

export const fetchUnreadAllMsg= params => {return axios.get('/api/msg/unread/all', {params:params});};

export const countUnreadAllMsg= params => {return axios.get('/api/msg/unread/count', {params:params});};

export const clearUnreadMsg = params => { return axios.put('/api/msg/unread/clear', params);};
