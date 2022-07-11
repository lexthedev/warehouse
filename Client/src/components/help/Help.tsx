import classNames from 'classnames';
import React, { useRef, useState } from 'react';
import styles from '../../App.module.scss';

function Help() {

    const [isOpen, setIsOpen] = useState(false);
    // const helpRef = React.createRef<HTMLDivElement>();
    const helpRef = useRef<HTMLDivElement>() as React.MutableRefObject<HTMLDivElement>;
    function setHelpIsOpen(open: boolean) {
        setIsOpen(open);
        if (open) {
            const help = helpRef.current;

            if (help) {
                let winHeight = document.body.clientHeight;
                help.style.maxHeight = (winHeight - 200) + 'px';
            }
        }
    }

    return <div className={styles.helpWrap}>
        <div className={styles.helpBtn} onClick={(() => { setHelpIsOpen(!isOpen) })}><div>?</div></div>
        <div ref={helpRef}
            onMouseLeave={() => { setIsOpen(false) }}
            className={classNames(styles.helpText, isOpen ? styles.show : "")}>
            <div className={styles.closeHelp}
                onClick={() => { setIsOpen(false) }}>x</div>
            <div>
                <h3>Help center for warehouse app.</h3>
                <br />
                <div>This app needs to make life of warehouse workers easier and happy. There are some info to help you use this app.</div>
                <br />
                <strong>How to use this app:</strong>
                <br />
                <p>By clicking on tabs at the top of this app you may change work environment.</p>
                <p>You may add, edit or delete some of it and save changes on the server using the buttons with the same text in it.</p>
                <p><i>Products</i> - tab for products list. It contains name and type of each product.</p>
                <p><i>Clients</i> - tab with list of our clients. It consist of clients's company name, name, phone and email addresses.</p>
                <p><i>Storage</i> - tab consists only of cell names.</p>
                <p><i>Incoming</i> / <i>Outcoming</i> - tabs that show such as its names direction's documents, we create when we buy (income) or sell (outcome) some goods.</p>
                <p><i>Goods</i> - the final tab, that shows us report of goods movements created by documents on previous tab.</p>

            </div>
        </div>
    </div>;
}

export default Help;