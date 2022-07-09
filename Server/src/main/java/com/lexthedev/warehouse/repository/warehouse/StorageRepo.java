package com.lexthedev.warehouse.repository.warehouse;

import com.lexthedev.warehouse.entity.warehouse.ProductEntity;
import com.lexthedev.warehouse.entity.warehouse.StorageEntity;
import org.springframework.data.repository.CrudRepository;

public interface StorageRepo extends CrudRepository<StorageEntity, Long> {
    ProductEntity findByCellName(String cellName);
}
