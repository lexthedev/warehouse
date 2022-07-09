import { IGoods, IGoodsEntity } from "../models/Goods";
import axios from "axios";
import { ROOT_URL } from "../constants/defaults";

export default class GoodsService {

    private static POSTFIX: string = "/goods";

    public static async getAll(): Promise<IGoodsEntity[]> {
        const url = ROOT_URL + GoodsService.POSTFIX + "/all";
        let response = await axios.get(url)

        return response.data
    }

    public static async create(data: IGoods): Promise<any> {
        const url = ROOT_URL + GoodsService.POSTFIX;
        let response = await axios.post(url, data)

        return response.data
    }

    public static async edit(data: IGoods): Promise<any> {
        const url = ROOT_URL + GoodsService.POSTFIX;
        let response = await axios.put(url, data)

        return response.data
    }

    public static async delete(id: number): Promise<any> {
        const url = ROOT_URL + GoodsService.POSTFIX + "?id=" + id;
        let response = await axios.delete(url)

        return response.data
    }

}