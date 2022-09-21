import { Link } from 'react-router-dom';
import { useDispatch } from 'react-redux';
import { createMarkEditTxnAction,createDeleteTxnActionThunk } from '../stateManagement/txnReducer';
const TxnRow = ({ txn }) => {

    const dispatch = useDispatch();
    return (
        <tr>
            <td>{txn.txnId}</td>
            <td>{txn.txnDate}</td>
            <td>{txn.desp}</td>
            <td className='text-end'>{txn.type === 'CREDIT' ? txn.amount : ''}</td>
            <td className='text-end'>{txn.type === 'DEBIT' ? txn.amount : ''}</td>
            <td>
                <button className='btn btn-sm btn-secondary'
                    onClick={e => dispatch(createMarkEditTxnAction(txn.txnId))}>
                    EDIT
                </button>
                <button className='btn btn-sm btn-danger'
                    onClick={e => dispatch(createDeleteTxnActionThunk(txn))}>
                    DELETE
                </button>

            </td>
        </tr>
    );
}

export default TxnRow;
