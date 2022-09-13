
const AhRow = ({ ah, makeEditable }) => (
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
        </td>
    </tr>
);

export default AhRow;