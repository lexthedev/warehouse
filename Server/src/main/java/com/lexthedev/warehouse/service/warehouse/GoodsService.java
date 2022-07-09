package com.lexthedev.warehouse.service.warehouse;

import com.lexthedev.warehouse.entity.warehouse.GoodsEntity;
import com.lexthedev.warehouse.exceptions.AlreadyExistsException;
import com.lexthedev.warehouse.exceptions.NotFoundException;
import com.lexthedev.warehouse.model.warehouse.Goods;
import com.lexthedev.warehouse.model.warehouse.GoodsDTO;
import com.lexthedev.warehouse.repository.warehouse.GoodsRepo;
import com.lexthedev.warehouse.repository.warehouse.ProductRepo;
import com.lexthedev.warehouse.repository.warehouse.StorageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GoodsService {
    @Autowired
    GoodsRepo goodsRepo;
    @Autowired
    ProductRepo productRepo;
    @Autowired
    StorageRepo storageRepo;

    public Goods getOne(Long id) throws NotFoundException {
        GoodsEntity product = goodsRepo.findById(id).get();
        if (product == null) {
            throw new NotFoundException("product not found");
        } else {
            return Goods.toModel(product);
        }
    }

    public List<Goods> getAll() {
        Iterable<GoodsEntity> goods = goodsRepo.findAll();
        List<Goods> result = new ArrayList<>();
        goods.forEach(elem -> result.add(Goods.toModel(elem)));

        return result;
    }

    public GoodsEntity create(GoodsEntity goods) throws AlreadyExistsException {
        return goodsRepo.save(goods);
    }

    public GoodsEntity edit(GoodsEntity goods) throws NotFoundException {
        Long id = goods.getId();
        if (goodsRepo.findById(id).isEmpty()) {
            throw new NotFoundException("goods not found");
        }
        return goodsRepo.save(goods);
    }

    public GoodsEntity toEntity(GoodsDTO goodsDTO) {
        GoodsEntity goods = new GoodsEntity();
        goods.setId(goodsDTO.getId());
        goods.setValue(goodsDTO.getValue());
        goods.setProduct(productRepo.findById(goodsDTO.getProduct_id()).get());
        goods.setCell(storageRepo.findById(goodsDTO.getCell_id()).get());
        return goods;
    }
}
