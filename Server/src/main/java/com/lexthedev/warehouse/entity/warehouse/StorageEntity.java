package com.lexthedev.warehouse.entity.warehouse;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "storage")
public class StorageEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String cellName;
//    @OneToOne(mappedBy = "cell")
    @OneToMany
    @JoinColumn(name = "goods_id")
    private List<GoodsEntity> goods;
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

    public StorageEntity() {
    }

}
