import { Component, useState } from 'react';
import AccountHolder from '../models/AccountHolder';
import AhForm from './AhForm';
import AhRow from './AhRow';

const AccountHolders = () => {

    let [ahs, setAhs] = useState([
        new AccountHolder(101, "Vamsy Kiran", "9052224753", "vamsy@gmail.com", 0),
        new AccountHolder(102, "Srinivas", "7777777788", "srinu@gmail.com", 0),
        new AccountHolder(103, "Abhishek", "8888889988", "abhi@gmail.com", 0)
    ]);

    const add = ah => setAhs([...ahs, ah])

    const del = ahId => {
        if (window.confirm(`Are you sure of deleting account holder # ${ahId}?`)) {
            let filteredAhs = ahs.filter(a => a.ahId != ahId);
            setAhs(filteredAhs);
        }
    }

    const makeEditable = ahId => setAhs(ahs.map(ah => ah.ahId === ahId ? { ...ah, isEditable: true } : ah))

    const cancelEditable = ahId => setAhs(ahs.map(ah => ah.ahId === ahId ? { ...ah, isEditable: undefined } : ah))

    const update = ahToBeSaved => setAhs(ahs.map(ah => ah.ahId === ahToBeSaved.ahId ? { ...ahToBeSaved, isEditable: undefined } : ah))

    return (
        <section className='container-fluid p-4'>
            <h4>Account Holders</h4>

            {(!ahs || ahs.length === 0) &&
                <p className="alert alert-info p-4">
                    No Account Holder Records Available To Display
                </p>
            }

            {(ahs && ahs.length > 0) &&
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
                        {
                            ahs.map(
                                ah => ah.isEditable ?
                                    <AhForm ah={ah}
                                        key={ah.ahId}
                                        update={update}
                                        cancelEditable={cancelEditable} /> :
                                    <AhRow ah={ah}
                                        key={ah.ahId}
                                        del={del}
                                        makeEditable={makeEditable} />
                            )
                        }
                    </tbody>
                </table>
            }
        </section>
    );
}

export default AccountHolders;