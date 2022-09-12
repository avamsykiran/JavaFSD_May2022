import { Component, useState } from 'react';
import AccountHolder from '../models/AccountHolder';

const AhForm = ({ ah, update, add, cancelEditable }) => {

    let [myAh, setMyAh] = useState(ah ? { ...ah } : new AccountHolder(0, '', '', '', 0));

    const save = event => {
        let ah = { ...myAh };

        if (ah.isEditable) {
            update(ah);
        } else {
            add(ah);
            setMyAh(new AccountHolder(0, '', '', '', 0));
        }
    }

    const updateData = event => {
        let fieldName = event.target.name;
        let fieldValue = event.target.type == 'number' ? parseInt(event.target.value) : event.target.value;
        setMyAh({ ...myAh, [fieldName]: fieldValue });
    };


    return (
        <tr>
            <td>
                <input type="number" name="ahId" value={myAh.ahId} className="form-control" onChange={updateData} />
            </td>
            <td>
                <input type="text" name="fullName" value={myAh.fullName} className="form-control" onChange={updateData} />
            </td>
            <td>
                <input type="text" name="mailId" value={myAh.mailId} className="form-control" onChange={updateData} />
            </td>
            <td>
                <input type="text" name="mobile" value={myAh.mobile} className="form-control" onChange={updateData} />
            </td>
            <td></td>
            <td>
                <button className='btn btn-sm btn-primary'
                    onClick={save}>
                    {myAh.isEditable ? "SAVE" : "ADD"}
                </button>

                {myAh.isEditable &&
                    <button className='btn btn-sm btn-danger'
                        onClick={event => cancelEditable(myAh.ahId)}>
                        CANCEL
                    </button>
                }
            </td>
        </tr>
    );
}

export default AhForm;