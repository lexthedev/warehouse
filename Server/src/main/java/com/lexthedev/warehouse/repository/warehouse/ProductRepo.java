package com.lexthedev.warehouse.repository.warehouse;

import com.lexthedev.warehouse.entity.warehouse.ProductEntity;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepo extends CrudRepository<ProductEntity, Long> {
    ProductEntity findByTitle(String title);
}
