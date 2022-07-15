export const ROOT_URL: string = "http://localhost:8080";
export enum TABS {
    Products = 'Products',
    Clients = 'Clients',
    Storage = 'Storage',
    Incoming = 'Incoming',
    Outcoming = 'Outcoming',
    Goods = 'Goods'
}
export enum LANGUAGES {
    EN = 'EN',
    RU = 'RU'
}

export type textContent = {
    [s: string]: Record<string, string>;
}