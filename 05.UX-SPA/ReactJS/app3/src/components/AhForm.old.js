import { Component } from 'react';
import AccountHolder from '../models/AccountHolder';

class AhForm extends Component {
    constructor(props) {
        super(props);
        this.state = {
            ahId: 0,
            fullName: '',
            mailId: '',
            mobile: '',
            currentBalance: 0
        };
    }

    save = event => {
        this.props.add({ ...this.state });
        this.setState({
            ahId: 0,
            fullName: '',
            mailId: '',
            mobile: '',
            currentBalance: 0
        });
    }

    render() {
        let { ahId, fullName, mailId, mobile } = this.state;

        return (
            <tr>
                <td>
                    <input type="number" value={ahId} className="form-control"
                    onChange={event => {this.setState({ahId:parseInt(event.target.value)})} } /> 
                </td>
                <td>
                    <input type="text" value={fullName} className="form-control"
                    onChange={event => {this.setState({fullName:event.target.value})} } /> 
                </td>
                <td>
                    <input type="text" value={mailId} className="form-control" 
                    onChange={event => {this.setState({mailId:event.target.value})} } /> 
                </td>
                <td>
                    <input type="text" value={mobile} className="form-control" 
                    onChange={event => {this.setState({mobile:event.target.value})} } />  
                </td>
                <td></td>
                <td>
                    <button className='btn btn-sm btn-primary'
                        onClick={this.save}>
                        ADD
                    </button>
                </td>
            </tr>
        );
    }
}

export default AhForm;