import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';

import AccountHolders from './ahs/components/AccountHolders';
import Header from './components/Header';
import Home from './components/Home';

const App = props => (
  <Router>
    <Header appTitle="Income Statement" />

    <Routes>
      <Route path='/' element={<Home />} />
      <Route path='/ahs' element={<AccountHolders />} />
    </Routes>
  </Router>
);

export default App;
