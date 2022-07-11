import React from 'react';
import styles from '../../App.module.scss';
import { TABS } from '../../constants/defaults';
import Help from '../help/Help';

interface IHeaderProps {
    activeTab: TABS;
    setActiveTab: (TABS: TABS) => any;
}

function Header(props: IHeaderProps) {

    let tabs: Array<JSX.Element> = [];
    for (let tab in TABS) {
        tabs.push(
            <div
                onClick={() => {
                    props.setActiveTab(tab as TABS)
                }}
                key={tab}
                className={`${styles.tab} ${tab === props.activeTab.toString() ? styles.active : ''}`}>
                {tab}
            </div>)
    }

    return <div className={styles.headerWrap}>
        <h1>TOTALLY NEW WAREHOUSE</h1>
        <Help />
        <nav className={styles.tabs}>
            {tabs}
        </nav>
    </div>;
}

export default Header;