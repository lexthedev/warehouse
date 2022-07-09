package com.lexthedev.warehouse.model;

import com.lexthedev.warehouse.constants.ProductType;

public class Settings {
    private ProductType[]  productTypes;

    public Settings() {
    }

    public ProductType[] getProductTypes() {
        return productTypes;
    }

    public void setProductTypes(ProductType[] productTypes) {
        this.productTypes = productTypes;
    }
}
