import { useState } from 'react';
import AccountHolder from '../models/AccountHolder';
import { useDispatch } from 'react-redux';
import { createAddAhActionThunk,createUpdateAhActionThunk,createUnMarkEditAhAction } from '../stateManagement/ahReducer';

const AhForm = ({ ah }) => {

    let [myAh, setMyAh] = useState(ah ? { ...ah } : new AccountHolder(0, '', '', '', 0));

    const dispatch = useDispatch();

    const save = event => {
        let ah = { ...myAh };

        if (ah.isEditable) {
            dispatch(createUpdateAhActionThunk(ah))
        } else {
            dispatch(createAddAhActionThunk(ah))
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
                {myAh.ahId}
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
                        onClick={event => dispatch(createUnMarkEditAhAction(myAh.ahId))}>
                        CANCEL
                    </button>
                }
            </td>
        </tr>
    );
}

export default AhForm;
