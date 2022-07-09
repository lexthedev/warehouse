package com.lexthedev.warehouse.repository;

import com.lexthedev.warehouse.entity.TodoEntity;
import org.springframework.data.repository.CrudRepository;

public interface TodoRepo extends CrudRepository<TodoEntity, Long> {
}
