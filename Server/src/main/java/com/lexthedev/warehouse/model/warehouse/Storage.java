package com.lexthedev.warehouse.model.warehouse;

import com.lexthedev.warehouse.entity.warehouse.GoodsEntity;
import com.lexthedev.warehouse.entity.warehouse.StorageEntity;

import javax.persistence.ManyToOne;
import java.util.List;

public class Storage {
    private Long id;
    private String cellName;
    private List<GoodsEntity> goods;

    public static Storage toModel(StorageEntity storage){
        Storage model = new Storage();
        model.setId(storage.getId());
        model.setCellName(storage.getCellName());
        model.setGoods(storage.getGoods());
        return model;
    }

    public Storage() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCellName() {
        return cellName;
    }

    public void setCellName(String cellName) {
        this.cellName = cellName;
    }

    public List<GoodsEntity> getGoods() {
        return goods;
    }

    public void setGoods(List<GoodsEntity> goods) {
        this.goods = goods;
    }
}
