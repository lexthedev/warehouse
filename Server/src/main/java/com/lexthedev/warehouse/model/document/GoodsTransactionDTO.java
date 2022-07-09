package com.lexthedev.warehouse.model.document;

import com.lexthedev.warehouse.constants.GoodsTransactionType;
import com.lexthedev.warehouse.model.warehouse.GoodsDTO;

import java.util.Date;
import java.util.List;

public class GoodsTransactionDTO {
    private Long id;
    private Date date;
    private GoodsTransactionType type;
    private List<GoodsDTO> goods;
    private Long client_id;

    public Long getClient_id() {
        return client_id;
    }

    public void setClient_id(Long client_id) {
        this.client_id = client_id;
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

    public List<GoodsDTO> getGoods() {
        return goods;
    }

    public void setGoods(List<GoodsDTO> goods) {
        this.goods = goods;
    }

    public GoodsTransactionType getType() {
        return type;
    }

    public void setType(GoodsTransactionType type) {
        this.type = type;
    }

    public GoodsTransactionDTO() {
    }
}
