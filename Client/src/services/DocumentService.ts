import axios from "axios";
import { ROOT_URL } from "../constants/defaults";
import { IDocument } from "../models/Documents";

export default class DocumentService {

    private static POSTFIX: string = "/goodsTransactions";

    public static async getAll(): Promise<IDocument[]> {
        const url = ROOT_URL + DocumentService.POSTFIX + "/all";
        let response = await axios.get(url)

        return response.data
    }

    public static async getAllIncome(): Promise<IDocument[]> {
        const url = ROOT_URL + DocumentService.POSTFIX + "/all/income";
        let response = await axios.get(url)

        return response.data
    }

    public static async getAllOutcome(): Promise<IDocument[]> {
        const url = ROOT_URL + DocumentService.POSTFIX + "/all/outcome";
        let response = await axios.get(url)

        return response.data
    }

    public static async create(data: IDocument): Promise<any> {
        const url = ROOT_URL + DocumentService.POSTFIX;
        let response = await axios.post(url, data)

        return response.data
    }

    public static async edit(data: IDocument): Promise<any> {
        const url = ROOT_URL + DocumentService.POSTFIX;
        let response = await axios.post(url, data)

        return response.data;
    }

    public static async delete(id: number): Promise<any> {
        const url = ROOT_URL + DocumentService.POSTFIX + "?id=" + id;
        let response = await axios.delete(url)

        return response.data
    }

}