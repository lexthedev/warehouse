import classNames from 'classnames';
import React, { useRef, useState } from 'react';
import styles from '../../App.module.scss';
import { LANGUAGES } from '../../constants/defaults';
import { content } from '../../constants/text';

interface IHelpProps {
    language: LANGUAGES;
}

function Help(props: IHelpProps) {

    const language = props.language;
    const [isOpen, setIsOpen] = useState(false);
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
            <div dangerouslySetInnerHTML={{ __html: content.HelpText[language] }}>
            </div>
        </div>
    </div>;
}

export default Help;