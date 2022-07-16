import React from 'react';
import styles from '../../App.module.scss';

interface IFooterProps {
    mainRef: React.MutableRefObject<HTMLDivElement>
}

function Footer(props: IFooterProps) {

    return <footer ref={props.mainRef} className={styles.footerWrap}>
        <div>this app created as diploma practice for mechanical college</div>
    </footer>;
}

export default Footer;