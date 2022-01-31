package com.example.SpringWorkProject.Model;

import com.example.SpringWorkProject.Entity.UserEntity;

public class UserModel {
    private Long id;
    private String username;

    public static UserModel toModel(UserEntity entity){
        UserModel model = new UserModel();
        model.setId(entity.getId());
        model.setUsername(entity.getName());
        return model;
    }

    public UserModel() {
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
