package com.lexthedev.warehouse.model;

import com.lexthedev.warehouse.entity.TodoEntity;

public class Todo {
    private Long id;
    private String title;
    private Boolean completed;
    private String description;

    public static Todo toModel(TodoEntity todo){
        Todo model = new Todo();
        model.setId(todo.getId());
        model.setTitle(todo.getTitle());
        model.setCompleted(todo.getCompleted());
        model.setDescription(todo.getDescription());
        return model;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Todo() {
    }
}
