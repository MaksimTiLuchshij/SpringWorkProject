package com.example.SpringWorkProject.Entity;

import javax.persistence.*;

@Entity
public class ToDoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private Boolean completed;
    //Это поле указываем в mappedBy, чтобы связать сущности
    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    public ToDoEntity() {
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }
}
