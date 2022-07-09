import { IClient } from "../models/Clients";
import axios from "axios";
import { ROOT_URL } from "../constants/defaults";

export default class ClientService {

    private static POSTFIX: string = "/clients";

    public static async getAll(): Promise<IClient[]> {
        const url = ROOT_URL + ClientService.POSTFIX + "/all";
        let response = await axios.get(url)

        return response.data
    }

    public static async create(data: IClient): Promise<any> {
        const url = ROOT_URL + ClientService.POSTFIX;
        let response = await axios.post(url, data)

        return response.data
    }

    public static async edit(data: IClient): Promise<any> {
        const url = ROOT_URL + ClientService.POSTFIX;
        let response = await axios.put(url, data)

        return response.data
    }

    public static async delete(id: number): Promise<any> {
        const url = ROOT_URL + ClientService.POSTFIX + "?id=" + id;
        let response = await axios.delete(url)

        return response.data
    }

}