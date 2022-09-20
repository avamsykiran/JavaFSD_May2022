import axios from 'axios';

const apiUrl = "http://localhost:8888/txns"

const TxnService = {
    getAllTxns : ahId => axios.get(`${apiUrl}/byAccount/${ahId}`),
    getTxnById : id => axios.get(`${apiUrl}/${id}`),
    addTxn : txn => axios.post(apiUrl,txn),
    updateTxn: txn => axios.put(apiUrl,txn),
    deleteTxnById : id => axios.delete(`${apiUrl}/${id}`)
};

export default TxnService;