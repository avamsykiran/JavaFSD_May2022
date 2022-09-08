
const AhRow = ({ ah, del }) => (
    <tr>
        <td>{ah.ahId}</td>
        <td>{ah.fullName}</td>
        <td>{ah.mailId}</td>
        <td>{ah.mobile}</td>
        <td>{ah.currentBalance}</td>
        <td>
            <button className='btn btn-sm btn-secondary'>
                EDIT
            </button>
            <button className='btn btn-sm btn-danger'
                onClick={e => del(ah.ahId)}>
                DELETE
            </button>
        </td>
    </tr>
);

export default AhRow;