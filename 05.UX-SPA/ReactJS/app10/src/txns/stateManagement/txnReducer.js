import Txn from '../model/Txn';
import TxnService from '../services/TxnService';

export const WAIT = "wait for txns";
export const ERR = "error on txns";
export const LOAD_TXNS = "load txns";
export const MARK_EDIT_TXN = "mark txn editable";
export const UNMARK_EDIT_TXN = "unmark txn editable";

export const createWaitAction = () => ({ type: WAIT });
export const createErrAction = errMsg => ({ type: ERR, errMsg });
export const createLoadTxnsAction = txns => ({ type: LOAD_TXNS, txns });
export const createMarkEditTxnAction = id => ({ type: MARK_EDIT_TXN, id });
export const createUnMarkEditTxnAction = id => ({ type: UNMARK_EDIT_TXN, id });

export const createLoadTxnsActionThunk = ahId => dispatch => {
    dispatch(createWaitAction());
    TxnService.getAllTxns(ahId)
        .then(resp => dispatch(createLoadTxnsAction(resp.data)))
        .catch(err => { console.log(err); dispatch(createErrAction("Unable to laod! Please retry later!")) })
}

export const createAddTxnActionThunk = txn => dispatch => {
    dispatch(createWaitAction());
    TxnService.addTxn(txn)
        .then(resp => createLoadTxnsActionThunk(txn.holder.ahId)(dispatch))
        .catch(err => { console.log(err); dispatch(createErrAction("Unable to save! Please retry later!")) })
}

export const createUpdateTxnActionThunk = txn => dispatch => {
    dispatch(createWaitAction());
    TxnService.updateTxn(txn)
        .then(resp => createLoadTxnsActionThunk(txn.holder.ahId)(dispatch))
        .catch(err => { console.log(err); dispatch(createErrAction("Unable to save! Please retry later!")) })
}

export const createDeleteTxnActionThunk = txn => dispatch => {
    dispatch(createWaitAction());
    TxnService.deleteTxnById(txn.id)
        .then(resp => createLoadTxnsActionThunk(txn.holder.ahId)(dispatch))
        .catch(err => { console.log(err); dispatch(createErrAction("Unable to save! Please retry later!")) })
}


const initState = () => ({
    txns: null,
    creditTotal: 0,
    debitTotal: 0,
    balance: 0,
    shallWait: false,
    errMsg: null
});

const sumAll = (txns,type) =>{
    let sum =0;

    if(txns && txns.length>0){
        let typedTxns = txns.filter(t => t.type===type);
        if(typedTxns && typedTxns.length>0){
            sum = typedTxns.map(t => t.amount).reduce((a1,a2)=>a1+a2);
        }
    }

    return sum;
}

const txnReducer = (oldState = initState(), action) => {
    let {txns,creditTotal,debitTotal,balance,shallWait,errMsg} = oldState;

    switch (action.type) {
        case WAIT:
            shallWait = true;
            break;
        case ERR:
            shallWait=false;
            errMsg=action.errMsg;
            break;
        case LOAD_TXNS:
            txns = action.txns;
            shallWait=false;
            errMsg=null;
            creditTotal=sumAll(txns,'CREDIT');
            debitTotal=sumAll(txns,'DEBIT');
            balance=creditTotal-debitTotal;
            break;
        case MARK_EDIT_TXN:
            txns =txns.map(t => t.txnId != action.id ? t : { ...t, isEditable: true });
            break;
        case UNMARK_EDIT_TXN:
            txns =txns.map(t => t.txnId != action.id ? t : { ...t, isEditable: undefined });
            break;
    }

    return {txns,creditTotal,debitTotal,balance,shallWait,errMsg};
}

export default txnReducer;