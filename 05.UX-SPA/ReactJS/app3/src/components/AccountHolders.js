import { Component } from 'react';
import AccountHolder from '../models/AccountHolder';
import AhForm from './AhForm';
import AhRow from './AhRow';

class AccountHolders extends Component {
    constructor(props) {
        super(props);
        this.state = {
            ahs: [
                new AccountHolder(101, "Vamsy Kiran", "9052224753", "vamsy@gmail.com", 0),
                new AccountHolder(102, "Srinivas", "7777777788", "srinu@gmail.com", 0),
                new AccountHolder(103, "Abhishek", "8888889988", "abhi@gmail.com", 0)
            ]
        }
    }

    add = ah => {
        let orgAhs = this.state.ahs;
        let modifiedAhs = [...orgAhs,ah];
        this.setState({ ahs: modifiedAhs });
    }

    del = ahId => {
        if (window.confirm(`Are you sure of deleting account holder # ${ahId}?`)) {
            let orgAhs = this.state.ahs;
            let filteredAhs = orgAhs.filter(a => a.ahId != ahId);
            this.setState({ ahs: filteredAhs })
        }
    }

    render() {
        let { ahs } = this.state;

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
                            <AhForm add={this.add} />
                            {
                                ahs.map(ah => <AhRow ah={ah} key={ah.ahId} del={this.del} />)
                            }
                        </tbody>
                    </table>
                }
            </section>
        );
    }
}

export default AccountHolders;