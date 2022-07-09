import { ISettings } from "../models/Settings";
import axios from "axios";
import { ROOT_URL } from "../constants/defaults";

export default class SettingsService {

    private static POSTFIX: string = "/settings";

    public static async getAll(): Promise<ISettings> {
        const url = ROOT_URL + SettingsService.POSTFIX;
        let response = await axios.get(url)

        return response.data
    }
}