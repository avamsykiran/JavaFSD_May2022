import {Fragment} from 'react';
import AccountHolders from './components/AccountHolders';
import Header from './components/Header';

const App = props => (
  <Fragment>
    <Header appTitle="Income Statement" />
    <AccountHolders />
  </Fragment>
);

export default App;
