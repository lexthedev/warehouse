import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
import App from './App';
import reportWebVitals from './reportWebVitals';

const root = ReactDOM.createRoot(
  document.getElementById('root') as HTMLElement
);
root.render(
  <>
    <style>
      {`@media print
      {td[class^='App_editBtn'],
      td[class^='App_deleteBtn'],
      td[class^='App_addBtn'],
      div[class^='App_helpWrap']
        {
        display: none;
        }
        * {
          color: #000000
        }
        div[class^='App_tab']{
          color: #FFFFF0;
        }
        div[class*='App_active'] {
          color: #000000;
          font-weight: 900;
        }

      }`}
    </style>
    <React.StrictMode>
      <App />
    </React.StrictMode>
  </>
);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();
