import axios from 'axios';

const apiUrl = "http://localhost:8888/accounts"

const AHService = {
    getAllAccounts : () => axios.get(apiUrl),
    getAccountById : id => axios.get(`${apiUrl}/${id}`),
    addAccount : ah => axios.post(apiUrl,ah),
    updateAccount: ah => axios.put(apiUrl,ah)
};

export default AHService;