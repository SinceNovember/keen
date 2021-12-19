import axios from 'axios'

export const fetchAllMenus= () =>{return axios.get('/api/system/menu/all');};

export const fetchMenus= params => {return axios.get('/api/system/menu/list', {params:params});};

export const fetchMenuTreeModel = () =>{return axios.get('/api/system/menu/tree');};

export const getMenu = params =>{return axios.get('/api/system/menu', {params:params});};

export const getFirstMenuPermission = params =>{ return axios.get('/api/system/menu/first', {params:params});}

export const saveMenu  = params => { return axios.post('/api/system/menu', params);};

export const updateMenu  = params => { return axios.put('/api/system/menu', params);};

export const deleteMenu = params => { return axios.delete('/api/system/menu', {params:params});};

export const fetchMenuPermission = params =>{ return axios.get('/api/system/menu/permission', {params:params});}

export const updateMenuPermission = params => { return axios.put('/api/system/menu/permission', params);}



