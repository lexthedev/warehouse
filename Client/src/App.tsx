import React, { useState } from 'react';
import styles from './App.module.scss';
import Footer from './components/statics/Footer';
import Header from './components/statics/Header';
import Clients from './components/tabs/Clients';
import Goods from './components/tabs/Goods';
import Incoming from './components/tabs/Incoming';
import Outcoming from './components/tabs/Outcoming';
import Products from './components/tabs/Products';
import Storages from './components/tabs/Storages';
import { TABS } from './constants/defaults';

function App() {

  const [activeTab, setActiveTab] = useState(TABS.Outcoming);

  return (<div className={styles.app}>
    <Header
      activeTab={activeTab}
      setActiveTab={setActiveTab} />
    <div className={styles.interactive}>
      {activeTab === TABS.Products && <Products />}
      {activeTab === TABS.Clients && <Clients />}
      {activeTab === TABS.Storage && <Storages />}
      {activeTab === TABS.Incoming && <Incoming />}
      {activeTab === TABS.Outcoming && <Outcoming />}
      {activeTab === TABS.Goods && <Goods />}
    </div>
    <Footer />
  </div>
  );
}

export default App;
