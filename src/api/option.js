import axios from 'axios'

export const getSexOption = () =>{return axios.get('/api/metadata/option/sex');};

export const getStatusOption = () =>{return axios.get('/api/metadata/option/status');};

