import { useState } from 'react';
import { useDispatch } from 'react-redux';
import Txn from '../model/Txn';

import { createAddTxnActionThunk, createUpdateTxnActionThunk, createUnMarkEditTxnAction } from '../stateManagement/txnReducer'

const TxnForm = ({ ahId, txn }) => {

    let [myTxn, setMyTxn] = useState(txn ? { ...txn } : new Txn(0, '', 0, new Date().toISOString().substring(0, 10), 'CREDIT', { ahId }));

    const dispatch = useDispatch();

    const save = event => {
        let txn = { ...myTxn };

        if (myTxn.isEditable) {
            dispatch(createUpdateTxnActionThunk(txn))
        } else {
            dispatch(createAddTxnActionThunk(txn))
            setMyTxn(new Txn(0, '', 0, new Date().toISOString().substring(0, 10), 'CREDIT', { ahId }));
        }
    }

    const updateData = event => {
        let fieldName = event.target.name;
        let fieldValue = event.target.type == 'number' ? parseInt(event.target.value) : event.target.value;
        setMyTxn({ ...myTxn, [fieldName]: fieldValue });
    };


    return (
        <tr>
            <td>
                {myTxn.txnId}
            </td>
            <td>
                <input type="date" name="txnDate" value={myTxn.txnDate} className="form-control" onChange={updateData} />
            </td>
            <td>
                <input type="text" name="desp" value={myTxn.desp} className="form-control" onChange={updateData} />
            </td>
            <td onClick={e => setMyTxn({ ...myTxn, type:'CREDIT' })}>
                {myTxn.type === 'CREDIT' &&
                    <input type="number" name="amount" value={myTxn.amount} className="form-control" onChange={updateData} />
                }
            </td>
            <td onClick={e => setMyTxn({ ...myTxn, type:'DEBIT' })}>
                {myTxn.type === 'DEBIT' &&
                    <input type="number" name="amount" value={myTxn.amount} className="form-control" onChange={updateData} />
                }
            </td>
            <td>
                <button className='btn btn-sm btn-primary'
                    onClick={save}>
                    {myTxn.isEditable ? "SAVE" : "ADD"}
                </button>

                {myTxn.isEditable &&
                    <button className='btn btn-sm btn-danger'
                        onClick={event => dispatch(createUnMarkEditTxnAction(myTxn.txnId))}>
                        CANCEL
                    </button>
                }
            </td>
        </tr>
    );
}

export default TxnForm;
