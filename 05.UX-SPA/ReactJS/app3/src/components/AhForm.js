import { Component } from 'react';
import AccountHolder from '../models/AccountHolder';

class AhForm extends Component {
    constructor(props) {
        super(props);
        this.state = props.ah ? { ...props.ah } : {
            ahId: 0,
            fullName: '',
            mailId: '',
            mobile: '',
            currentBalance: 0
        };
    }

    save = event => {

        if (this.state.isEditable) {
            this.props.update({ ...this.state });
        } else {
            this.props.add({ ...this.state });
            this.setState({
                ahId: 0,
                fullName: '',
                mailId: '',
                mobile: '',
                currentBalance: 0
            });
        }

    }

    updateData = event => {
        let fieldName = event.target.name;
        let fieldValue = event.target.type == 'number' ? parseInt(event.target.value) : event.target.value;
        this.setState({ [fieldName]: fieldValue });
    };

    render() {
        let { ahId, fullName, mailId, mobile, isEditable } = this.state;

        return (
            <tr>
                <td>
                    <input type="number" name="ahId" value={ahId} className="form-control" onChange={this.updateData} />
                </td>
                <td>
                    <input type="text" name="fullName" value={fullName} className="form-control" onChange={this.updateData} />
                </td>
                <td>
                    <input type="text" name="mailId" value={mailId} className="form-control" onChange={this.updateData} />
                </td>
                <td>
                    <input type="text" name="mobile" value={mobile} className="form-control" onChange={this.updateData} />
                </td>
                <td></td>
                <td>
                    <button className='btn btn-sm btn-primary'
                        onClick={this.save}>
                        {isEditable ? "SAVE" : "ADD"}
                    </button>

                    {isEditable &&
                        <button className='btn btn-sm btn-danger'
                            onClick={event => this.props.cancelEditable(ahId)}>
                            CANCEL
                        </button>
                    }
                </td>
            </tr>
        );
    }
}

export default AhForm;