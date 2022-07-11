package com.lexthedev.warehouse.model.warehouse;

import org.springframework.stereotype.Service;

@Service
public class GoodsDTO {

    private Long id;
    private Long product_id;
    private Integer value;
    private Long cell_id;
    private Long transaction_id;

    public Long getTransaction_id() {
        return transaction_id;
    }

    public void setTransaction_id(Long transaction_id) {
        this.transaction_id = transaction_id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Long product_id) {
        this.product_id = product_id;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public Long getCell_id() {
        return cell_id;
    }

    public void setCell_id(Long cell_id) {
        this.cell_id = cell_id;
    }

    public GoodsDTO() {
    }
}
