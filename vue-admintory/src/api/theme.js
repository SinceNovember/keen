import axios from 'axios'

export const fetchThemes = params =>{return axios.get('/api/other/theme/list', {params:params});};

export const getTheme = params =>{return axios.get('/api/other/theme', {params:params});};

export const saveTheme  = params => { return axios.post('/api/other/theme', params);};

export const updateTheme  = params => { return axios.put('/api/other/theme', params);};

export const deleteTheme = params => {return axios.delete('/api/other/theme', {params:params});};