package com.lexthedev.warehouse.repository.warehouse;

import com.lexthedev.warehouse.entity.warehouse.GoodsEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface GoodsRepo extends CrudRepository<GoodsEntity, Long> {
    List<GoodsEntity> findByIdIn(List<Long> ids);
}
