package com.example.SpringWorkProject.Service;

import com.example.SpringWorkProject.Entity.ToDoEntity;
import com.example.SpringWorkProject.Entity.UserEntity;
import com.example.SpringWorkProject.Model.ToDo;
import com.example.SpringWorkProject.Repository.ToDoRepo;
import com.example.SpringWorkProject.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ToDoService {
    @Autowired
    private ToDoRepo todoRepo;
    @Autowired
    private UserRepo userRepo;

    public ToDo createTodo(ToDoEntity todo, Long userId) {
        UserEntity user = userRepo.findById(userId).get();
        todo.setUser(user);
        return ToDo.toModel(todoRepo.save(todo));
    }

    public ToDo complete(Long id) {
        ToDoEntity todo = todoRepo.findById(id).get();
        todo.setCompleted(!todo.getCompleted());
        return ToDo.toModel(todoRepo.save(todo));
    }
}