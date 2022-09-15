import AccountHolder from '../models/AccountHolder';
import AhForm from './AhForm';
import AhRow from './AhRow';

import { connect } from 'react-redux';

const AccountHolders = ({ ahs }) => (
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
                    <AhForm />
                    {
                        ahs.map(
                            ah => ah.isEditable ?
                                <AhForm ah={ah} key={ah.ahId} /> :
                                <AhRow ah={ah} key={ah.ahId} />
                        )
                    }
                </tbody>
            </table>
        }
    </section>
);

const mapStateToProps = state => ({ ahs: state.ahs });
const mapDispatchToProps = null;

const hoc = connect(mapStateToProps, mapDispatchToProps);
export default hoc(AccountHolders);