import { useDispatch } from 'react-redux';
import { createMarkEditAhAction } from '../stateManagement/ahReducer';

const AhRow = ({ ah }) => {
    
    const dispatch = useDispatch();

    return  (
        <tr>
            <td>{ah.ahId}</td>
            <td>{ah.fullName}</td>
            <td>{ah.mailId}</td>
            <td>{ah.mobile}</td>
            <td>{ah.currentBalance}</td>
            <td>
                <button className='btn btn-sm btn-secondary'
                    onClick={e => dispatch(createMarkEditAhAction(ah.ahId))}>
                    EDIT
                </button>
            </td>
        </tr>
    );
}

export default AhRow;
