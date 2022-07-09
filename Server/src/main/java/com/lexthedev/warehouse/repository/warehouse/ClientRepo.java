package com.lexthedev.warehouse.repository.warehouse;

import com.lexthedev.warehouse.entity.warehouse.ClientEntity;
import org.springframework.data.repository.CrudRepository;

public interface ClientRepo extends CrudRepository<ClientEntity, Long> {
}
