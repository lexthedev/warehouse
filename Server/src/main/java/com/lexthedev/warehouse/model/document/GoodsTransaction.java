package com.lexthedev.warehouse.model.document;

import com.lexthedev.warehouse.constants.GoodsTransactionType;
import com.lexthedev.warehouse.entity.document.GoodsTransactionEntity;
import com.lexthedev.warehouse.entity.warehouse.ClientEntity;
import com.lexthedev.warehouse.entity.warehouse.GoodsEntity;

import java.util.Date;
import java.util.List;

public class GoodsTransaction {
    private Long id;
    private Date date;
    private GoodsTransactionType type;
    private List<GoodsEntity> goods;
    private ClientEntity client;

    public ClientEntity getClient() {
        return client;
    }

    public void setClient(ClientEntity client) {
        this.client = client;
    }

    public static GoodsTransaction toModel(GoodsTransactionEntity goodsTransaction) {
        GoodsTransaction model = new GoodsTransaction();
        model.setId(goodsTransaction.getId());
        model.setDate(goodsTransaction.getDate());
        model.setGoods(goodsTransaction.getGoods());
        model.setType(goodsTransaction.getType());
        model.setClient(goodsTransaction.getClient());
        return model;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public GoodsTransactionType getType() {
        return type;
    }

    public void setType(GoodsTransactionType type) {
        this.type = type;
    }

    public List<GoodsEntity> getGoods() {
        return goods;
    }

    public void setGoods(List<GoodsEntity> goods) {
        this.goods = goods;
    }

    public GoodsTransaction() {
    }
}
