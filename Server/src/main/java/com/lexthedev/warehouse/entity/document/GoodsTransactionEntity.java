package com.lexthedev.warehouse.entity.document;

import com.lexthedev.warehouse.constants.GoodsTransactionType;
import com.lexthedev.warehouse.entity.user.UserEntity;
import com.lexthedev.warehouse.entity.warehouse.ClientEntity;
import com.lexthedev.warehouse.entity.warehouse.GoodsEntity;
import com.lexthedev.warehouse.model.warehouse.Client;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "goods_transactions")
public class GoodsTransactionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date date;
    private GoodsTransactionType type;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "transaction")
    private List<GoodsEntity> goods;
    //    @JoinColumn(name = "client_id")
    @ManyToOne
    @JoinColumn(name = "client_id")
    private ClientEntity client;

    public ClientEntity getClient() {
        return client;
    }

    public void setClient(ClientEntity client) {
        this.client = client;
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

    public GoodsTransactionEntity() {
    }
}
