package com.lexthedev.warehouse.service;

import com.lexthedev.warehouse.entity.TodoEntity;
import com.lexthedev.warehouse.entity.user.UserEntity;
import com.lexthedev.warehouse.model.Todo;
import com.lexthedev.warehouse.repository.TodoRepo;
import com.lexthedev.warehouse.repository.user.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoService {

    @Autowired
    private TodoRepo todoRepo;
    @Autowired
    private UserRepo userRepo;

    public Todo createTodo(TodoEntity todo, Long userId) {
        UserEntity user = userRepo.findById(userId).get();
        todo.setUser(user);
        return Todo.toModel(todoRepo.save(todo));
    }

    public Todo completeTodo(Long id) {
        TodoEntity todo = todoRepo.findById(id).get();
        todo.setCompleted(!todo.getCompleted());
        return Todo.toModel(todoRepo.save(todo));
    }
}
