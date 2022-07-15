import React, { useEffect, useState } from 'react';
import styles from '../../App.module.scss';
import { LANGUAGES } from '../../constants/defaults';
import { content } from '../../constants/text';
import { IClient } from '../../models/Clients';
import { IDocument } from '../../models/Documents';
import { IGoods } from '../../models/Goods';
import { IProduct } from "../../models/Products";
import { ICell } from '../../models/Storage';
import ClientService from '../../services/ClientService';
import DocumentService from '../../services/DocumentService';
import ProductService from '../../services/ProductService';
import StorageService from '../../services/StorageService';

interface IIncomingProps {
    language: LANGUAGES;
}

function Incoming(props: IIncomingProps) {

    const language = props.language;
    const [documents, setDocuments] = useState([] as IDocument[]);
    const [clients, setClients] = useState([] as IClient[]);
    const [cells, setCells] = useState([] as ICell[]);
    const [products, setProducts] = useState([] as IProduct[]);
    const [addNew, setAddNew] = useState(false);
    const [editId, setEditId] = useState(-1 as number);
    const [editDoc, setEditDoc] = useState(null as IDocument | null);
    const documentType = "SELL";
    useEffect(() => { getAll(); }, []);

    function getAll(): void {
        DocumentService.getAllOutcome().then((data: IDocument[]) => {
            if (data) {
                console.log('data', data);
                setDocuments(data)
            }
        });
        ProductService.getAll().then((data: IProduct[]) => {
            if (data) {
                console.log('data', data);
                setProducts(data)
            }
        });
        StorageService.getAll().then((data: ICell[]) => {
            if (data) {
                console.log('data', data);
                setCells(data)
            }
        });
        ClientService.getAll().then((data: IClient[]) => {
            if (data) {
                console.log('data', data);
                setClients(data)
            }
        });
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

    function createNewDoc() {
        const doc = {
            type: documentType,
            client_id: 0,
            date: new Date().toString(),
            goods: []
        } as IDocument;
        setEditDoc(doc);
        setAddNew(true);
    }

    function saveEdit(id: number = -1) {
        const docFields = document.querySelectorAll(`.docInfo td > *`);
        const goodsFields = document.querySelectorAll(`[id^="goodsEditor-"]`);
        const goods = [] as IGoods[];
        goodsFields.forEach((goodsField, goodsFieldId) => {
            const fields = goodsField.querySelectorAll('td > *')

            let good = {
                product_id: Number((fields[0] as HTMLInputElement).value) as number,
                value: Number(fields[1].textContent) as number,
                cell_id: Number((fields[2] as HTMLInputElement).value) as number
            } as IGoods;

            let idStr = goodsFields[goodsFieldId].id.split('goodsEditor-')[1]
            if (idStr !== 'undefined') {
                good.id = Number(idStr);
            }
            goods.push(good)
        })

        const docData = {
            id: Number(docFields[0].textContent),
            client_id: Number((docFields[1] as HTMLInputElement).value),
            date: new Date().toISOString(),
            type: documentType,
            goods: goods
        } as IDocument

        if (id < 0) { //new
            DocumentService.create(docData).then((data) => {
                refreshState();
            })
        } else {
            DocumentService.edit({ ...docData, id: id }).then((data) => {
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
        setEditDoc(getDocumentById(id));
    }

    function deleteGoodElement(arrId: number): void {
        editDoc?.goods.splice(arrId, 1)
        setEditDoc({ ...editDoc } as IDocument)
    }

    function deleteDocElement(id: number): void {
        DocumentService.delete(id).then((data) => {
            refreshState();
        });
    }

    function addGoods() {
        editDoc?.goods.push({
            value: 0,
            product_id: NaN,
            cell_id: NaN
        } as IGoods)
        setEditDoc({ ...editDoc } as IDocument)
    }

    function getCellList(id: number): JSX.Element {
        return (
            <select contentEditable={true}
                name="cellList"
                id="cellList">
                {cells.map((elem) => {
                    return <option
                        value={elem.id}
                        selected={id === elem.id}>
                        {elem.cellName}
                    </option>
                })}
            </select>)
    }

    function getProductList(id: number): JSX.Element {
        return (
            <select
                name="productsList"
                id="productsList">
                {products.map((elem) => {
                    return <option
                        value={elem.id}
                        selected={id === elem.id}>
                        {elem.title}
                    </option>
                })}
            </select>)
    }

    function getClientList(id: number): JSX.Element {
        return (
            <select
                name="clientsList"
                id="clientsList">
                {clients.map((elem) => {
                    return <option
                        value={elem.id}
                        selected={id === elem.id}>
                        {`${elem.name} (${elem.companyName})`}
                    </option>
                })}
            </select>)
    }

    function getClientById(id: number): IClient {
        let client = {} as IClient;
        clients.forEach(element => {
            if (element.id === id) {
                client = element;
            }
        });
        return client;
    }

    function getDocumentById(id: number): IDocument {
        let document = {} as IDocument;
        documents.forEach(element => {
            if (element.id === id) {
                document = element;
            }
        });
        return document;
    }

    return <div className={styles.interactive}>
        {(addNew || editId > -1) &&
            <>
                <table className={styles.dataTable}>
                    <thead className={styles.theader}>
                        <tr>
                            <th>{content.Id[language]}</th>
                            <th>{content.Client[language]}</th>
                            <th>{content.Date[language]}</th>
                            <th></th>
                            <th></th>
                        </tr>
                    </thead>
                    <tbody className={'docInfo'}>
                        {editDoc && <tr>
                            <td><div>{editId === -1 ? '' : editId}</div></td>
                            <td>{getClientList(editId as number)}</td>
                            <td><div>{new Date(editDoc.date).toLocaleDateString()}</div></td>
                            <td onClick={() => { saveEdit(editId) }} className={styles.editBtn}>{content.Save[language]}</td>
                            <td onClick={() => { cancelEdit() }} className={styles.editBtn}>{content.Cancel[language]}</td>
                            <td onClick={() => { deleteDocElement(editId) }} className={styles.deleteBtn}>{content.Delete[language]}</td>
                        </tr>}
                    </tbody>
                </table>
                <div className={styles.dataBreak}>{content.Goods[language]}:</div>
                <table className={styles.dataTable}>
                    <thead className={styles.theader}>
                        <tr>
                            <th>{content.Product[language]}</th>
                            <th>{content.Value[language]}</th>
                            <th>{content.Cell[language]}</th>
                            <th></th>
                        </tr>
                    </thead>
                    <tbody>
                        {editDoc && editDoc.goods.map((elem, arrId) => {
                            const id = elem.id as number;
                            return (
                                <tr id={'goodsEditor-' + id} key={arrId}>
                                    <td className={"openEditor"}>
                                        {getProductList(elem.product_id as number)}
                                    </td>
                                    <td className={"openEditor"}><div contentEditable={true}>{elem.value}</div></td>
                                    <td className={"openEditor"}>
                                        {getCellList(elem.cell_id as number)}
                                    </td>
                                    <td onClick={() => { deleteGoodElement(arrId) }} className={styles.deleteBtn}>{content.Delete[language]}</td>
                                </tr>
                            )
                        })}
                        <tr>
                            <td className={styles.addBtn}
                                colSpan={4}
                                onClick={() => { addGoods() }}>{content.AddNew[language]}</td>
                        </tr>
                    </tbody>
                </table> </>
        }
        {
            !addNew && editId === -1 && <table className={styles.dataTable}>
                <thead className={styles.theader}>
                    <tr>
                        <th>{content.Id[language]}</th>
                        <th>{content.Client[language]}</th>
                        <th>{content.Date[language]}</th>
                        <th></th>
                        <th></th>
                    </tr>
                </thead>
                <tbody className={styles.tbody}>
                    {documents && documents.map((elem) => {
                        const client = getClientById(elem.client_id);
                        return (
                            <tr>
                                <td>{elem.id}</td>
                                <td>{`${client.name} (${client.companyName})`}</td>
                                <td>{new Date(elem.date).toLocaleDateString()}</td>
                                <td onClick={() => { setEdit(elem.id) }} className={styles.editBtn}>{content.Edit[language]}</td>
                                <td onClick={() => { deleteDocElement(elem.id as number) }} className={styles.deleteBtn}>{content.Delete[language]}</td>
                            </tr>
                        )
                    })}
                    <tr>
                        <td className={styles.addBtn}
                            colSpan={5}
                            onClick={() => { createNewDoc() }}>{content.AddNew[language]}</td>
                    </tr>
                </tbody>
            </table>
        }
    </div >;
}

export default Incoming;