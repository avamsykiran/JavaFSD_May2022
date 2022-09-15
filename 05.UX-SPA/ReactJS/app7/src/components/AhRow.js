import {connect} from 'react-redux';
import {createDeleteAhAction,createMarkEditAhAction} from '../stateManagement/ahReducer';

const AhRow = ({ ah, del,makeEditable }) => (
    <tr>
        <td>{ah.ahId}</td>
        <td>{ah.fullName}</td>
        <td>{ah.mailId}</td>
        <td>{ah.mobile}</td>
        <td>{ah.currentBalance}</td>
        <td>
            <button className='btn btn-sm btn-secondary'
                onClick={e => makeEditable(ah.ahId)}>
                EDIT
            </button>
            <button className='btn btn-sm btn-danger'
                onClick={e => del(ah.ahId)}>
                DELETE
            </button>
        </td>
    </tr>
);

const mapStateToProps =null;
const mapDispatchToProps = dispatch => ({
    del: ahId => dispatch(createDeleteAhAction(ahId)),
    makeEditable: ahId => dispatch(createMarkEditAhAction(ahId))
});

const hoc = connect(mapStateToProps, mapDispatchToProps);
export default hoc(AhRow);
