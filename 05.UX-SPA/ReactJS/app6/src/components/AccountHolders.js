import { useEffect, useState } from 'react';
import AccountHolder from '../models/AccountHolder';
import AhForm from './AhForm';
import AhRow from './AhRow';
import AHService from '../services/AHService';

const AccountHolders = () => {

    let [ahs, setAhs] = useState(null);
    let [errMsg, setErrMsg] = useState(null);

    const loadData = () => {
        AHService.getAllAccounts()
            .then(resp => { setAhs(resp.data); setErrMsg(null) })
            .catch(err => { console.error(err); setErrMsg("Unable To Load Data! Please Retry Later!") });
    }

    useEffect(loadData, []);

    const add = ah => {
        AHService.addAccount(ah)
            .then(resp => loadData())
            .catch(err => { console.error(err); setErrMsg("Unable To Save Data! Please Retry Later!") });
    };

    const makeEditable = ahId => setAhs(ahs.map(ah => ah.ahId === ahId ? { ...ah, isEditable: true } : ah))

    const cancelEditable = ahId => setAhs(ahs.map(ah => ah.ahId === ahId ? { ...ah, isEditable: undefined } : ah))

    const update = ahToBeSaved => {
        AHService.updateAccount({ ...ahToBeSaved, isEditable: undefined })
            .then(resp => loadData())
            .catch(err => { console.error(err); setErrMsg("Unable To Save Data! Please Retry Later!") });
    };

    return (
        <section className='container-fluid p-4'>
            <h4>Account Holders</h4>

            {(!ahs && !errMsg) &&
                <p className="alert alert-info p-4">
                    Loading Please wait...
                </p>
            }

            {(ahs && ahs.length === 0) &&
                <p className="alert alert-info p-4">
                    No Account Holder Records Available To Display
                </p>
            }

            {errMsg &&
                <p className="alert alert-danger p-4">
                    {errMsg}
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
                    <AhForm add={add} />
                    {(ahs && ahs.length > 0) &&
                        ahs.map(
                            ah => ah.isEditable ?
                                <AhForm ah={ah}
                                    key={ah.ahId}
                                    update={update}
                                    cancelEditable={cancelEditable} /> :
                                <AhRow ah={ah}
                                    key={ah.ahId}
                                    makeEditable={makeEditable} />
                        )
                    }
                </tbody>
            </table>

        </section>
    );
}

export default AccountHolders;