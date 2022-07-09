import { IProduct } from "../models/Products";
import axios from "axios";
import { ROOT_URL } from "../constants/defaults";

export default class ProductService {

    private static POSTFIX: string = "/products";

    public static async getAll(): Promise<IProduct[]> {
        const url = ROOT_URL + ProductService.POSTFIX + "/all";
        let response = await axios.get(url)

        return response.data
    }

    public static async create(data: IProduct): Promise<any> {
        const url = ROOT_URL + ProductService.POSTFIX;
        let response = await axios.post(url, data)

        return response.data
    }

    public static async edit(data: IProduct): Promise<any> {
        const url = ROOT_URL + ProductService.POSTFIX;
        let response = await axios.put(url, data)

        return response.data
    }

    public static async delete(id: number): Promise<any> {
        const url = ROOT_URL + ProductService.POSTFIX + "?id=" + id;
        let response = await axios.delete(url)

        return response.data
    }

}