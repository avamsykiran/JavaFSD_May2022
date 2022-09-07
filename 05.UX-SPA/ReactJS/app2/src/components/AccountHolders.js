import { Component } from 'react';
import AccountHolder from '../models/AccountHolder';

class AccountHolders extends Component {
    constructor(props){
        super(props);
        this.state={
            ahs:[
                new AccountHolder(101,"Vamsy Kiran", "9052224753","vamsy@gmail.com",0),
                new AccountHolder(102,"Srinivas", "7777777788","srinu@gmail.com",0),
                new AccountHolder(103,"Abhishek", "8888889988","abhi@gmail.com",0)
            ]
        }
    }

    render(){
        let {ahs} = this.state;

        return (
            <section className='container-fluid p-4'>
                <h4>Account Holders</h4>

                {(!ahs || ahs.length===0) && 
                    <p className="alert alert-info p-4">
                        No Account Holder Records Available To Display
                    </p>
                }

                {(ahs && ahs.length>0) &&
                    <table className='table table-bordered table-striped table-hover'>
                        <thead>
                            <tr>
                                <th>Id</th>
                                <th>Name</th>
                                <th>Mail Id</th>
                                <th>Mobile</th>
                                <th>Balance</th>
                            </tr>
                        </thead>
                        <tbody>
                            {
                                ahs.map(ah => (
                                    <tr key={ah.ahId}>
                                        <td>{ah.ahId}</td>
                                        <td>{ah.fullName}</td>
                                        <td>{ah.mailId}</td>
                                        <td>{ah.mobile}</td>
                                        <td>{ah.currentBalance}</td>
                                    </tr>
                                ))
                            }
                        </tbody>
                    </table>
                }
            </section>
        );
    }
}

export default AccountHolders;