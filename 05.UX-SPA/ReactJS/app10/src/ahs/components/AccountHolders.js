import AccountHolder from '../models/AccountHolder';
import AhForm from './AhForm';
import AhRow from './AhRow';

import { useSelector, useDispatch } from 'react-redux';
import { useEffect } from 'react';
import { createLoadAhsActionThunk} from '../stateManagement/ahReducer'

const AccountHolders = () => {

    const dispatch = useDispatch();
    let ahs = useSelector(state => state.ahs);
    let shallWait = useSelector(state => state.shallWait);
    let errMsg = useSelector(state => state.errMsg);
    useEffect(() => dispatch(createLoadAhsActionThunk()), []);

    return (
        <section className='container-fluid p-4'>
            <h4>Account Holders</h4>

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

            {(ahs && ahs.length === 0) &&
                <p className="alert alert-info p-4">
                    No Account Holder Records Available To Display
                </p>
            }

            <table className='table table-bordered table-striped table-hover'>
                <thead>
                    <tr>
                        <th>Id</th>
                        <th>Name</th>
                        <th>Mail Id</th>
                        <th>Mobile</th>
                        <th>Balance</th>
                        <th></th>
                    </tr>
                </thead>
                <tbody>
                    <AhForm />
                    {(ahs && ahs.length > 0) &&
                        ahs.map(
                            ah => ah.isEditable ?
                                <AhForm ah={ah} key={ah.ahId} /> :
                                <AhRow ah={ah} key={ah.ahId} />
                        )
                    }
                </tbody>
            </table>
        </section>
    );
}

export default AccountHolders;