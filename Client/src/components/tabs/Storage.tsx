import React, { useEffect, useState } from 'react';
import styles from '../../App.module.scss';
import { LANGUAGES } from '../../constants/defaults';
import { content } from '../../constants/text';
import { ICell } from "../../models/Storage";
import StorageService from '../../services/StorageService';

interface IStorageProps {
    language: LANGUAGES;
}

function Storage(props: IStorageProps) {

    const language = props.language;
    const [cells, setCells] = useState([] as ICell[]);
    const [addNew, setAddNew] = useState(false);
    const [editId, setEditId] = useState(-1 as number);
    useEffect(() => { getAll(); }, []);

    function getAll(): void {
        StorageService.getAll().then((data: ICell[]) => {
            if (data) {
                console.log('data', data);
                setCells(data)
            }
        })
    }

    function refreshState() {
        getAll();
        setEditId(-1);
        setAddNew(false);
    }

    function cancelEdit() {
        setEditId(-1);
        setAddNew(false);
    }

    function saveEdit(id: number = -1) {
        const editFields = document.querySelectorAll(`table .openEditor > *`);
        const data = {
            "cellName": editFields[0].textContent as string,
        }
        if (id < 0) { //new
            StorageService.create(data).then((data) => {
                refreshState();
            })
        } else {
            StorageService.edit({ ...data, id: id }).then((data) => {
                refreshState();
            })
        }
    }

    function setEdit(id: number = -1): void {
        if (editId) {
            setEditId(id);
        } else {
            setEditId(id);
        }
    }

    function deleteElement(id: number): void {
        StorageService.delete(id).then((data) => {
            refreshState();
        });
    }

    return <div className={styles.interactive}>
        <table className={styles.dataTable}>
            <thead className={styles.theader}>
                <tr>
                    <th>{content.CellName[language]}</th>
                    <th></th>
                    <th></th>
                </tr>
            </thead>
            <tbody className={styles.tbody}>
                {cells && cells.map(elem => {
                    const id = elem.id;
                    let showEdit = editId < 0;
                    let thisEdit = editId === id;
                    let buttonText = '';
                    if (showEdit) {
                        buttonText = content.Edit[language];
                    }
                    if (thisEdit) {
                        buttonText = content.Save[language];
                    }
                    return (
                        <tr className={styles.tr} key={id}>
                            <td className={thisEdit ? "openEditor" : ''}><div contentEditable={thisEdit}>{elem.cellName}</div></td>
                            <td className={styles.editBtn}
                                onClick={() => {
                                    if (showEdit) { setEdit(id) } else { saveEdit(id) };
                                }}>{buttonText}</td>
                            {thisEdit
                                ? <td onClick={cancelEdit} className={styles.deleteBtn}>{content.Cancel[language]}</td>
                                : <td onClick={() => { deleteElement(id as number) }} className={styles.deleteBtn}>{content.Delete[language]}</td>}
                        </tr>
                    )
                })}
                {!addNew && <tr>
                    <td className={styles.addBtn}
                        colSpan={3}
                        onClick={() => { setAddNew(true) }}>{content.AddNew[language]}</td>
                </tr>}
                {addNew && <tr className={styles.tr} key={0}>
                    <td className='openEditor'><div contentEditable={"true"}></div></td>
                    <td onClick={() => { saveEdit(-1) }} className={styles.editBtn}>{content.Save[language]}</td>
                    <td onClick={cancelEdit} className={styles.deleteBtn}>{content.Cancel[language]}</td>
                </tr>}
            </tbody>
        </table>
    </div >;
}

export default Storage;