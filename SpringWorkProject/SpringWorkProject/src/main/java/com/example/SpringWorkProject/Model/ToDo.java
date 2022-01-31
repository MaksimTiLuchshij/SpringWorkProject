package com.example.SpringWorkProject.Model;

import com.example.SpringWorkProject.Entity.ToDoEntity;

public class ToDo {
    private Long id;
    private String title;
    private Boolean completed;

    public static ToDo toModel(ToDoEntity entity) {
        ToDo model = new ToDo();
        model.setId(entity.getId());
        model.setCompleted(entity.getCompleted());
        model.setTitle(entity.getTitle());
        return model;
    }

    public ToDo() {
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
}