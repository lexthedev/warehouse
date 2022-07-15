import React, { useEffect, useState } from 'react';
import styles from '../../App.module.scss';
import { LANGUAGES } from '../../constants/defaults';
import { content } from '../../constants/text';
import { IProduct } from "../../models/Products";
import { ISettings } from '../../models/Settings';
import ProductService from '../../services/ProductService';
import SettingsService from '../../services/SettingsService';

interface IProducstsProps {
    language: LANGUAGES;
}

function Products(props: IProducstsProps) {

    const language = props.language;
    const [products, setProducts] = useState([] as IProduct[]);
    const [types, setTypes] = useState([] as string[]);
    const [addNew, setAddNew] = useState(false);
    const [editId, setEditId] = useState(-1 as number);
    useEffect(() => { getAll(); }, []);

    function getAll(): void {
        ProductService.getAll().then((data: IProduct[]) => {
            if (data) {
                console.log('data', data);
                setProducts(data)
            }
        })
        SettingsService.getAll().then((data: ISettings) => {
            console.log('data', data);
            setTypes(data.productTypes);
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
            "title": editFields[0].textContent as string,
            "type": (editFields[1] as HTMLOptionElement).value,
        }
        if (id < 0) { //new
            ProductService.create(data).then((data) => {
                refreshState();
            })
        } else {
            ProductService.edit({ ...data, id: id }).then((data) => {
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
        ProductService.delete(id).then((data) => {
            refreshState();
        });
    }

    function getTypeList(type: string = ''): JSX.Element {
        return (
            <select contentEditable={true}
                name="typeList"
                id="typeList">
                {types.map((elem) => {
                    return <option
                        value={elem}
                        selected={type === elem}>
                        {content[elem][language]}
                    </option>
                })}
            </select>)
    }

    return <div className={styles.interactive}>
        <table className={styles.dataTable}>
            <thead className={styles.theader}>
                <tr>
                    <th>{content.Name[language]}</th>
                    <th>{content.Type[language]}</th>
                    <th></th>
                    <th></th>
                </tr>
            </thead>
            <tbody className={styles.tbody}>
                {products && products.map(elem => {
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
                            <td className={thisEdit ? "openEditor" : ''}><div contentEditable={thisEdit}>{elem.title}</div></td>
                            <td className={thisEdit ? "openEditor" : ''}>
                                {thisEdit ? getTypeList(elem.type) : <div>{content[elem.type][language]}</div>}
                            </td>
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
                        colSpan={4}
                        onClick={() => { setAddNew(true) }}>{content.AddNew[language]}</td>
                </tr>}
                {addNew && <tr className={styles.tr} key={0}>
                    <td className='openEditor'><div contentEditable={"true"}></div></td>
                    <td className={'openEditor'}>
                        {getTypeList()}
                    </td>
                    <td onClick={() => { saveEdit(-1) }} className={styles.editBtn}>{content.Save[language]}</td>
                    <td onClick={cancelEdit} className={styles.deleteBtn}>{content.Cancel[language]}</td>
                </tr>}
            </tbody>
        </table>
    </div >;
}

export default Products;