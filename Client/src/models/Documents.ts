import { IGoods } from "./Goods";

export interface IDocument {
    id?: number,
    client_id: number;
    date: string,
    type: string,
    goods: IGoods[]
}