import { useParams } from 'react-router-dom';
import { useSelector,useDispatch} from  'react-redux';
import { useEffect } from 'react';

import TxnRow from './TxnRow';
import TxnForm from './TxnForm';
import { createLoadTxnsActionThunk} from '../stateManagement/txnReducer'

const Txns = () => {

    const dispatch = useDispatch();
    
    let {ahId} = useParams();
    
    useEffect( () => { dispatch(createLoadTxnsActionThunk(ahId))},[ahId]);

    let txns = useSelector(state => state.txnsState.txns);
    let shallWait = useSelector(state => state.txnsState.shallWait);
    let errMsg = useSelector(state => state.txnsState.errMsg);

    return (
        <section className='container-fluid p-4'>
            <h4>Statement</h4>

            {shallWait &&
                <p className="alert alert-info p-4">
                    Please wait while loading data...
                </p>
            }

            {errMsg &&
                <p className="alert alert-info p-4">
                    {errMsg}
                </p>
            }

            {(txns && txns.length === 0) &&
                <p className="alert alert-info p-4">
                    No Transactions Available To Display
                </p>
            }

            <table className='table table-bordered table-striped table-hover'>
                <thead>
                    <tr>
                        <th>Id</th>
                        <th>Date</th>
                        <th>Desp</th>
                        <th>Credit</th>
                        <th>Debit</th>
                        <th></th>
                    </tr>
                </thead>
                <tbody>
                    <TxnForm ahId={ahId}/>
                    {(txns && txns.length > 0) &&
                        txns.map(
                            txn => txn.isEditable ?
                                <TxnForm txn={txn} key={txn.txnId} /> :
                                <TxnRow txn={txn} key={txn.txnId} />
                        )
                    }
                </tbody>
            </table>
        </section>
    );
}

export default Txns;