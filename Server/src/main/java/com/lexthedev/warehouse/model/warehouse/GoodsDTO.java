package com.lexthedev.warehouse.model.warehouse;

import org.springframework.stereotype.Service;

@Service
public class GoodsDTO {

    private Long id;
    private Long product_id;
    private Integer value;
    private Long cell_id;

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

    //    public GoodsEntity toEntity(GoodsDTO goodsDTO){
//        GoodsEntity goods = new GoodsEntity();
//        goods.setId(goods.getId());
//        goods.setProduct(productRepo.findById(goodsDTO.getProduct_id()).get());
//        goods.setCell(storageRepo.findById(goodsDTO.getCell_id()).get());
//        return goods;
//    }
//    public GoodsEntity toEntity() {
//        GoodsEntity goods = new GoodsEntity();
//        goods.setId(this.getId());
//        goods.setValue(this.value);
//        goods.setProduct(productRepo.findById(this.getProduct_id()).get());
//        goods.setCell(storageRepo.findById(this.getCell_id()).get());
//        return goods;
//    }
}
