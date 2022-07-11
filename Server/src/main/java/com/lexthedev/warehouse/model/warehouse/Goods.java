package com.lexthedev.warehouse.model.warehouse;

import com.lexthedev.warehouse.constants.GoodsTransactionType;
import com.lexthedev.warehouse.entity.warehouse.GoodsEntity;
import com.lexthedev.warehouse.entity.warehouse.ProductEntity;
import com.lexthedev.warehouse.entity.warehouse.StorageEntity;

public class Goods {
    private Long id;
    private ProductEntity product;
    private Integer value;
    private StorageEntity cell;
    private Long transaction_id;
    private GoodsTransactionType transactionType;

    public GoodsTransactionType getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(GoodsTransactionType transactionType) {
        this.transactionType = transactionType;
    }

    public Long getTransaction_id() {
        return transaction_id;
    }

    public void setTransaction_id(Long transaction_id) {
        this.transaction_id = transaction_id;
    }
//    @ManyToOne
//    @JoinColumn(name = "goods_transaction_id")
//    private GoodsTransactionEntity goodsTransaction;
//
//    public GoodsTransactionEntity getGoodsTransaction() {
//        return goodsTransaction;
//    }
//
//    public void setGoodsTransaction(GoodsTransactionEntity goodsTransaction) {
//        this.goodsTransaction = goodsTransaction;
//    }

    public static Goods toModel(GoodsEntity goodsEntity) {
        Goods model = new Goods();
        model.setId(goodsEntity.getId());
        model.setCell(goodsEntity.getCell());
        model.setProduct(goodsEntity.getProduct());
        model.setValue(goodsEntity.getValue());
//        model.setGoodsTransaction(goodsEntity.getTransaction());
        model.setTransaction_id(goodsEntity.getTransaction().getId());
        model.setTransactionType(goodsEntity.getTransaction().getType());
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
