import { IClient } from "./Clients"
import { IProduct } from "./Products"
import { ICell } from "./Storage"

export interface IGoods {
    id?: number,
    value: number,
    product_id: number,
    cell_id: number
}

export interface IGoodsEntity {
    id?: number,
    value: number,
    product: IProduct,
    cell: ICell,
    transactionType: string
}
