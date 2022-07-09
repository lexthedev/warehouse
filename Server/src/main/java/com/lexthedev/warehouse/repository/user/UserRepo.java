package com.lexthedev.warehouse.repository.user;

import com.lexthedev.warehouse.entity.user.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends CrudRepository<UserEntity, Long> {
    UserEntity findByUsername(String username);
}
