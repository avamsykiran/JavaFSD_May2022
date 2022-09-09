import { Component, createRef } from 'react';
import AccountHolder from '../models/AccountHolder';

class AhForm extends Component {
    constructor(props) {
        super(props);
        this.ahIdRef = createRef();
        this.fullNameRef = createRef();
        this.mailIdRef = createRef();
        this.mobileRef = createRef();
    }

    save = event => {
        let ah = new AccountHolder(
            this.ahIdRef.current.value,
            this.fullNameRef.current.value,
            this.mobileRef.current.value,
            this.mailIdRef.current.value,0);

        if (this.props.ah) {
            this.props.update(ah);
        } else {
            this.props.add(ah);
            this.ahIdRef.current.value=0;
            this.fullNameRef.current.value='';
            this.mobileRef.current.value='';
            this.mailIdRef.current.value='';
        }
    }

    render() {
        let { ahId, fullName, mailId, mobile, isEditable } = this.props.ah?this.props.ah:new AccountHolder(0,'','','',0);

        return (
            <tr>
                <td>
                    <input type="number" name="ahId" defaultValue={ahId} className="form-control" ref={this.ahIdRef} />
                </td>
                <td>
                    <input type="text" name="fullName" defaultValue={fullName} className="form-control" ref={this.fullNameRef} />
                </td>
                <td>
                    <input type="text" name="mailId" defaultValue={mailId} className="form-control" ref={this.mailIdRef} />
                </td>
                <td>
                    <input type="text" name="mobile" defaultValue={mobile} className="form-control" ref={this.mobileRef} />
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