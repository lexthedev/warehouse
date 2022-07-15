import React, { ChangeEvent } from 'react';
import { content } from '../../constants/text';
import styles from '../../App.module.scss';
import { TABS, LANGUAGES } from '../../constants/defaults';
import Help from '../help/Help';

interface IHeaderProps {
    activeTab: TABS;
    language: LANGUAGES;
    setActiveTab: (TABS: TABS) => any;
    switchLang: (s: LANGUAGES) => void;
}

function Header(props: IHeaderProps) {

    const language = props.language;
    let tabs: Array<JSX.Element> = [];

    for (let tab in TABS) {
        tabs.push(
            <div
                onClick={() => {
                    props.setActiveTab(tab as TABS)
                }}
                key={tab}
                className={`${styles.tab} ${tab === props.activeTab.toString() ? styles.active : ''}`}>
                {content[tab][language]}
            </div>)
    }

    function changeLang(e: ChangeEvent<HTMLSelectElement>) {
        props.switchLang(e.target.value as LANGUAGES);
    }

    function getLanguagesOptions(): JSX.Element[] {
        let options = []
        for (var lang in LANGUAGES) {
            options.push(<option key={lang}>{lang}</option>)
        }
        return options;
    }

    return <div className={styles.headerWrap}>
        <h1>{content.heading[language]}</h1>
        <div className={styles.floatRight}>
            <div className={styles.langSwitcher}>
                <span>{content.languageButton[language]}:</span>
                <select name="lang" id="lang" onChange={(e) => changeLang(e)}>
                    {getLanguagesOptions()}
                </select>
            </div>
            <Help language={language} />
        </div>
        <nav className={styles.tabs}>
            {tabs}
        </nav>
    </div>;
}

export default Header;