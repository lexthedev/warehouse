import React, { useEffect, useState } from 'react';
import styles from '../../App.module.scss';
import { LANGUAGES } from '../../constants/defaults';
import { content } from '../../constants/text';
import { IClient } from "../../models/Clients";
import ClientService from '../../services/ClientService';

interface IClientProps {
    language: LANGUAGES;
}

function Clients(props: IClientProps) {

    const language = props.language;
    const [clients, setClients] = useState([] as IClient[]);
    const [addNew, setAddNew] = useState(false);
    const [editId, setEditId] = useState(-1 as number);
    useEffect(() => { getAll(); }, []);

    function getAll(): void {
        ClientService.getAll().then((data: IClient[]) => {
            if (data) {
                console.log('data', data);
                setClients(data)
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
            companyName: editFields[0].textContent as string,
            name: editFields[1].textContent as string,
            phone: editFields[2].textContent as string,
            email: editFields[3].textContent as string,
        }
        if (id < 0) { //new
            ClientService.create(data).then((data) => {
                refreshState();
            })
        } else {
            ClientService.edit({ ...data, id: id }).then((data) => {
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
        ClientService.delete(id).then((data) => {
            refreshState();
        });
    }

    return <div className={styles.interactive}>
        <table className={styles.dataTable}>
            <thead className={styles.theader}>
                <tr>
                    <th>{content.CompanyName[language]}</th>
                    <th>{content.Name[language]}</th>
                    <th>{content.Phone[language]}</th>
                    <th>{content.Email[language]}</th>
                    <th></th>
                    <th></th>
                </tr>
            </thead>
            <tbody className={styles.tbody}>
                {clients && clients.map(elem => {
                    const id = elem.id;
                    let showEdit = editId < 0;
                    let thisEdit = editId === id;
                    let buttonText = '';
                    if (showEdit) {
                        buttonText = content.Edit[language];
                    }
                    if (thisEdit) {
                        buttonText = content.Save[language]
                    }
                    return (
                        <tr className={styles.tr} key={id}>
                            <td className={thisEdit ? "openEditor" : ''}><div contentEditable={thisEdit}>{elem.companyName}</div></td>
                            <td className={thisEdit ? "openEditor" : ''}><div contentEditable={thisEdit}>{elem.name}</div></td>
                            <td className={thisEdit ? "openEditor" : ''}><div contentEditable={thisEdit}>{elem.phone}</div></td>
                            <td className={thisEdit ? "openEditor" : ''}><div contentEditable={thisEdit}>{elem.email}</div></td>
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
                        colSpan={6}
                        onClick={() => { setAddNew(true) }}>{content.AddNew[language]}</td>
                </tr>}
                {addNew && <tr className={styles.tr} key={0}>
                    <td className='openEditor'><div contentEditable={"true"}></div></td>
                    <td className='openEditor'><div contentEditable={"true"}></div></td>
                    <td className='openEditor'><div contentEditable={"true"}></div></td>
                    <td className='openEditor'><div contentEditable={"true"}></div></td>
                    <td onClick={() => { saveEdit(-1) }} className={styles.editBtn}>{content.Save[language]}</td>
                    <td onClick={cancelEdit} className={styles.deleteBtn}>{content.Cancel[language]}</td>
                </tr>}
            </tbody>
        </table>
    </div >;
}

export default Clients;