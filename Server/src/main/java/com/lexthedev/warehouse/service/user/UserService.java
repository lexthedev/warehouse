package com.lexthedev.warehouse.service.user;

import com.lexthedev.warehouse.entity.user.UserEntity;
import com.lexthedev.warehouse.exceptions.UserAlreadyExistsException;
import com.lexthedev.warehouse.exceptions.UserNotFoundException;
import com.lexthedev.warehouse.model.user.User;
import com.lexthedev.warehouse.repository.user.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    public UserEntity registration(UserEntity user) throws UserAlreadyExistsException {
        String username = user.getUsername();
        if (userRepo.findByUsername(username) != null) {
            throw new UserAlreadyExistsException("User with username '" + username + "' has already created!");
        }
        return userRepo.save(user);
    }

    public User getOne(Long id) throws UserNotFoundException {
        UserEntity user = userRepo.findById(id).get();
        if (user == null) {
            throw new UserNotFoundException("user not found");
        } else {
            return User.toModel(user);
        }
    }

    public List<User> getAll() {
        Iterable<UserEntity> users = userRepo.findAll();
        List<User> result = new ArrayList<User>();
        users.forEach(user -> result.add(User.toModel(user)));

        return result;
    }

    public Long delete(Long id) {
        userRepo.deleteById(id);
        return id;
    }
}
