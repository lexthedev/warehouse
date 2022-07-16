import React, { useState } from 'react';
import styles from './App.module.scss';
import Footer from './components/statics/Footer';
import Header from './components/statics/Header';
import Clients from './components/tabs/Clients';
import Goods from './components/tabs/Goods';
import Incoming from './components/tabs/Incoming';
import Outcoming from './components/tabs/Outcoming';
import Products from './components/tabs/Products';
import Storage from './components/tabs/Storage';
import { LANGUAGES, TABS } from './constants/defaults';

function App() {

  const [activeTab, setActiveTab] = useState(TABS.Outcoming);
  const [language, setlang] = useState(LANGUAGES.EN);

  return (<div className={styles.app}>
    <Header
      activeTab={activeTab}
      setActiveTab={setActiveTab}
      switchLang={setlang}
      language={language} />
    <div>
      {activeTab === TABS.Products && <Products language={language} />}
      {activeTab === TABS.Clients && <Clients language={language} />}
      {activeTab === TABS.Storage && <Storage language={language} />}
      {activeTab === TABS.Incoming && <Incoming language={language} />}
      {activeTab === TABS.Outcoming && <Outcoming language={language} />}
      {activeTab === TABS.Goods && <Goods language={language} />}
    </div>
    <Footer />
  </div>
  );
}

export default App;
