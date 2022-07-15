import { LANGUAGES, textContent } from "./defaults";

export const content: textContent = {
    heading: {
        [LANGUAGES.RU]: 'НОВЫЙ СКЛАД',
        [LANGUAGES.EN]: 'TOTALLY NEW WAREHOUSE'
    },
    //
    languageButton: {
        [LANGUAGES.RU]: 'Language',
        [LANGUAGES.EN]: 'Язык'
    },
    //
    Products: {
        [LANGUAGES.RU]: 'Продукция',
        [LANGUAGES.EN]: 'Products'
    },
    Clients: {
        [LANGUAGES.RU]: 'Клиенты',
        [LANGUAGES.EN]: 'Clients'
    },
    Storage: {
        [LANGUAGES.RU]: 'Ячейки',
        [LANGUAGES.EN]: 'Storage'
    },
    Incoming: {
        [LANGUAGES.RU]: 'Входящие',
        [LANGUAGES.EN]: 'Incoming'
    },
    Outcoming: {
        [LANGUAGES.RU]: 'Исходяшие',
        [LANGUAGES.EN]: 'Outcoming'
    },
    Goods: {
        [LANGUAGES.RU]: 'Товары',
        [LANGUAGES.EN]: 'Goods'
    },
    //
    Name: {
        [LANGUAGES.RU]: 'Имя',
        [LANGUAGES.EN]: 'Name'
    },
    Type: {
        [LANGUAGES.RU]: 'Тип',
        [LANGUAGES.EN]: 'Type'
    },
    CompanyName: {
        [LANGUAGES.RU]: 'Название компании',
        [LANGUAGES.EN]: 'Company name'
    },
    Phone: {
        [LANGUAGES.RU]: 'Телефон',
        [LANGUAGES.EN]: 'Phone'
    },
    Email: {
        [LANGUAGES.RU]: 'Почта',
        [LANGUAGES.EN]: 'Email'
    },
    CellName: {
        [LANGUAGES.RU]: 'Имя ячейки',
        [LANGUAGES.EN]: 'Cell name'
    },
    Id: {
        [LANGUAGES.RU]: 'Номер',
        [LANGUAGES.EN]: 'Id'
    },
    Client: {
        [LANGUAGES.RU]: 'Клиент',
        [LANGUAGES.EN]: 'Client'
    },
    Date: {
        [LANGUAGES.RU]: 'Дата',
        [LANGUAGES.EN]: 'Date'
    },
    Product: {
        [LANGUAGES.RU]: 'Продукт',
        [LANGUAGES.EN]: 'Product'
    },
    Value: {
        [LANGUAGES.RU]: 'Количество',
        [LANGUAGES.EN]: 'Value'
    },
    Cell: {
        [LANGUAGES.RU]: 'Ячейка',
        [LANGUAGES.EN]: 'Cell'
    },
    //
    Save: {
        [LANGUAGES.RU]: 'Сохранить',
        [LANGUAGES.EN]: 'Save'
    },
    Edit: {
        [LANGUAGES.RU]: 'Изменить',
        [LANGUAGES.EN]: 'Edit'
    },
    Delete: {
        [LANGUAGES.RU]: 'Удалить',
        [LANGUAGES.EN]: 'Delete'
    },
    Cancel: {
        [LANGUAGES.RU]: 'Отменить',
        [LANGUAGES.EN]: 'Cancel'
    },
    AddNew: {
        [LANGUAGES.RU]: 'Добавить',
        [LANGUAGES.EN]: 'Add new'
    },
    //
    NUTRITION: {
        [LANGUAGES.RU]: 'Питание',
        [LANGUAGES.EN]: 'Nutrition'
    },
    HOUSEHOLD: {
        [LANGUAGES.RU]: 'Для дома',
        [LANGUAGES.EN]: 'Household'
    },
    CONSTRUCTIONS: {
        [LANGUAGES.RU]: 'Строительные',
        [LANGUAGES.EN]: 'Constructions'
    },
    //
    HelpText: {
        [LANGUAGES.RU]:
            `<h3>Центр помощи приложения склад.</h3>
                <br />
                <div>Это приоржение служит для облегчения работы складских служащих. Ниже - информация для помощи в работе с приложением.</div>
                <br />
                <strong>Как использовать данное приложение:</strong>
                <br />
                <p>Нажимая на вкладки сверху вы можете переключаться между представлениями окружения.</p>
                <p>Вы можете добавлять, изменять или удалять некоторые элементы на сервере, нажимая на соответствующие кнопки.</p>
                <p><i>Продукция</i> - вкладка со списком продукции. Содержит в себе все виды продуктов.</p>
                <p><i>Клиенты</i> - вкладка со списком клиентов. Содержит в себе клиентские имена, название компании, телефон и почту.</p>
                <p><i>Ячейки</i> - вкладка со списком имён ячеек.</p>
                <p><i>Входящие</i> / <i>Исходящие</i> - вкладки, названия которых соответствуют направлениям движения товаров покупка (входящие) или продажа (исходящие) товаров.</p>
                <p><i>Товары</i> - последняя вкладка, содержит в себе список движений товаров в документах, как описано выше.</p>`,
        [LANGUAGES.EN]:
            `<h3>Help center for warehouse app.</h3>
                <br />
                <div>This app needs to make life of warehouse workers easier and happy. There are some info to help you use this app.</div>
                <br />
                <strong>How to use this app:</strong>
                <br />
                <p>By clicking on tabs at the top of this app you may change work environment.</p>
                <p>You may add, edit or delete some of it and save changes on the server using the buttons with the same text in it.</p>
                <p><i>Products</i> - tab for products list. It contains name and type of each product.</p>
                <p><i>Clients</i> - tab with list of our clients. It consist of clients's company name, name, phone and email addresses.</p>
                <p><i>Storage</i> - tab consists only of cell names.</p>
                <p><i>Incoming</i> / <i>Outcoming</i> - tabs that show such as its names direction's documents, we create when we buy (income) or sell (outcome) some goods.</p>
                <p><i>Goods</i> - the final tab, that shows us report of goods movements created by documents on previous tab.</p>`
    },
}
