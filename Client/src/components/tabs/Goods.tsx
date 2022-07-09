import React, { useEffect, useState } from 'react';
import styles from '../../App.module.scss';
import { IGoods, IGoodsEntity } from "../../models/Goods";
import { IProduct } from '../../models/Products';
import { ICell } from '../../models/Storage';
import Goodservice from '../../services/GoodsService';
import ProductService from '../../services/ProductService';
import StorageService from '../../services/StorageService';

function Goods() {

    const [goods, setGoods] = useState([] as IGoodsEntity[]);
    const [products, setProducts] = useState([] as IProduct[]);
    const [cells, setCells] = useState([] as ICell[]);
    const [addNew, setAddNew] = useState(false);
    const [editId, setEditId] = useState(-1 as number);
    useEffect(() => { getAll(); }, []);

    function getAll(): void {
        Goodservice.getAll().then((data: IGoodsEntity[]) => {
            if (data) {
                console.log('data', data);
                setGoods(data)
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
            product_id: Number(editFields[0].textContent) | Number((editFields[0] as HTMLInputElement).value) as number,
            value: Number(editFields[1].textContent) as number,
            cell_id: Number(editFields[2].textContent) | Number((editFields[2] as HTMLInputElement).value) as number
        } as IGoods
        if (id < 0) { //new
            Goodservice.create(data).then((data) => {
                refreshState();
            })
        } else {
            Goodservice.edit({ ...data, id: id }).then((data) => {
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
        Goodservice.delete(id).then((data) => {
            refreshState();
        });
    }

    function getProductList(id: number): JSX.Element {
        return (
            <select contentEditable={true}
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

    return <div className={styles.interactive}>
        <table className={styles.dataTable}>
            <thead className={styles.theader}>
                <tr>
                    <th>Product</th>
                    <th>Value</th>
                    <th>Cell</th>
                    <th></th>
                    <th></th>
                </tr>
            </thead>
            <tbody className={styles.tbody}>
                {goods && goods.map(elem => {
                    const id = elem.id;
                    let showEdit = editId < 0;
                    let thisEdit = editId === id;
                    let buttonText = '';
                    if (showEdit) {
                        buttonText = 'Edit';
                    }
                    if (thisEdit) {
                        buttonText = 'Save';
                    }
                    return (
                        <tr className={styles.tr} key={id}>
                            <td className={thisEdit ? "openEditor" : ''}>
                                {thisEdit ? getProductList(id as number) : <div>{elem.product?.title}</div>}
                            </td>
                            <td className={thisEdit ? "openEditor" : ''}><div contentEditable={thisEdit}>{elem.value}</div></td>
                            <td className={thisEdit ? "openEditor" : ''}>
                                {thisEdit ? getCellList(id as number) : <div>{elem.cell?.cellName}</div>}
                            </td>
                            <td className={styles.editBtn}
                                onClick={() => {
                                    if (showEdit) { setEdit(id) } else { saveEdit(id) };
                                }}>{buttonText}</td>
                            {thisEdit
                                ? <td onClick={cancelEdit} className={styles.deleteBtn}>cancel</td>
                                : <td onClick={() => { deleteElement(id as number) }} className={styles.deleteBtn}>Delete</td>}
                        </tr>
                    )
                })}
                {!addNew && <tr>
                    <td className={styles.addBtn}
                        colSpan={5}
                        onClick={() => { setAddNew(true) }}>Add new</td>
                </tr>}
                {addNew && <tr className={styles.tr} key={0}>
                    <td className='openEditor'><div contentEditable={"true"}></div></td>
                    <td className='openEditor'><div contentEditable={"true"}></div></td>
                    <td className='openEditor'><div contentEditable={"true"}></div></td>
                    <td onClick={() => { saveEdit(-1) }} className={styles.editBtn}>Save</td>
                    <td onClick={cancelEdit} className={styles.deleteBtn}>cancel</td>
                </tr>}
            </tbody>
        </table>
    </div >;
}

export default Goods;