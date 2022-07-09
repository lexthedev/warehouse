package com.lexthedev.warehouse.entity.warehouse;

import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.data.repository.CrudRepository;

import javax.persistence.*;

@Entity
@Table(name = "storage")
public class StorageEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String cellName;
//    @OneToOne(mappedBy = "cell")
    @OneToOne
    @JoinColumn(name = "goods_id")
    private GoodsEntity goods;
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

    public GoodsEntity getGoods() {
        return goods;
    }

    public void setGoods(GoodsEntity goods) {
        this.goods = goods;
    }

    public StorageEntity() {
    }

}
