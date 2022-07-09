package com.lexthedev.warehouse.entity.warehouse;

import com.lexthedev.warehouse.entity.document.GoodsTransactionEntity;

import javax.persistence.*;

@Entity
@Table(name = "goods")
public class GoodsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    private ProductEntity product;
    private Integer value;
    @ManyToOne
    @JoinColumn(name = "cell_id")
    private StorageEntity cell;
    @ManyToOne
    @JoinColumn(name = "transaction_id")
    private GoodsTransactionEntity transaction;

    public GoodsTransactionEntity getTransaction() {
        return transaction;
    }

    public void setTransaction(GoodsTransactionEntity transaction) {
        this.transaction = transaction;
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

    public GoodsEntity() {
    }
}
