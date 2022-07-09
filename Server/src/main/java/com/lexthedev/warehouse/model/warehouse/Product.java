package com.lexthedev.warehouse.model.warehouse;

import com.lexthedev.warehouse.constants.ProductType;
import com.lexthedev.warehouse.entity.warehouse.ProductEntity;

public class Product {
    private Long id;
    private String title;
    private ProductType type;

    public static Product toModel(ProductEntity product){
        Product model = new Product();
        model.setId(product.getId());
        model.setTitle(product.getTitle());
        model.setType(product.getType());
        return model;
    }

    public Product() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ProductType getType() {
        return type;
    }

    public void setType(ProductType type) {
        this.type = type;
    }
}
