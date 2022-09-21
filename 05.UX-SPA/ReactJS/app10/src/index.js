import 'bootstrap/dist/css/bootstrap.min.css';
import 'bootstrap/dist/js/bootstrap.bundle';

import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
import App from './App';
import reportWebVitals from './reportWebVitals';

import ahReducer from './ahs/stateManagement/ahReducer';
import txnReducer from './txns/stateManagement/txnReducer';
import { createStore,applyMiddleware,combineReducers } from 'redux';
import thunk from 'redux-thunk';
import { Provider } from 'react-redux';

const root = ReactDOM.createRoot(document.getElementById('root'));
const rootReducer = combineReducers({ahsState:ahReducer,txnsState:txnReducer})
const incomeStatementStore = createStore(rootReducer,applyMiddleware(thunk));

root.render(
  <React.StrictMode>
    <Provider store={incomeStatementStore}>
      <App />
    </Provider>
  </React.StrictMode>
);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();
