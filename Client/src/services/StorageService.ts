import { ICell } from "../models/Storage";
import axios from "axios";
import { ROOT_URL } from "../constants/defaults";

export default class StorageService {

    private static POSTFIX: string = "/storage";

    public static async getAll(): Promise<ICell[]> {
        const url = ROOT_URL + StorageService.POSTFIX + "/all";
        let response = await axios.get(url)

        return response.data
    }

    public static async create(data: ICell): Promise<any> {
        const url = ROOT_URL + StorageService.POSTFIX;
        let response = await axios.post(url, data)

        return response.data
    }

    public static async edit(data: ICell): Promise<any> {
        const url = ROOT_URL + StorageService.POSTFIX;
        let response = await axios.put(url, data)

        return response.data
    }

    public static async delete(id: number): Promise<any> {
        const url = ROOT_URL + StorageService.POSTFIX + "?id=" + id;
        let response = await axios.delete(url)

        return response.data
    }

}