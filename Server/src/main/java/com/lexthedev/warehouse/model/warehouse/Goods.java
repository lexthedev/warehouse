package com.lexthedev.warehouse.model.warehouse;

import com.lexthedev.warehouse.entity.document.GoodsTransactionEntity;
import com.lexthedev.warehouse.entity.warehouse.GoodsEntity;
import com.lexthedev.warehouse.entity.warehouse.ProductEntity;
import com.lexthedev.warehouse.entity.warehouse.StorageEntity;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class Goods {
    private Long id;
    private ProductEntity product;
    private Integer value;
    private StorageEntity cell;
    @ManyToOne
    @JoinColumn(name = "goods_transaction_id")
    private GoodsTransactionEntity goodsTransaction;

    public static Goods toModel(GoodsEntity goodsEntity) {
        Goods model = new Goods();
        model.setId(goodsEntity.getId());
        model.setCell(goodsEntity.getCell());
        model.setProduct(goodsEntity.getProduct());
        model.setValue(goodsEntity.getValue());
        return model;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ProductEntity getProduct() {
        return product;
    }

    public void setProduct(ProductEntity product) {
        this.product = product;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public StorageEntity getCell() {
        return cell;
    }

    public void setCell(StorageEntity cell) {
        this.cell = cell;
    }

    public Goods() {
    }
}
