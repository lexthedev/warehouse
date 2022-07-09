import React from 'react';
import styles from '../../App.module.scss';
import { TABS } from '../../constants/defaults';

// interface IHeaderProps {
//     activeTab: TABS;
//     setActiveTab: (TABS: TABS) => any;
// }

// function Footer(props: IHeaderProps) {
function Footer() {

    return <div className={styles.footerWrap}>
        <div>this app created as diploma practice for mechanical college</div>
    </div>;
}

export default Footer;