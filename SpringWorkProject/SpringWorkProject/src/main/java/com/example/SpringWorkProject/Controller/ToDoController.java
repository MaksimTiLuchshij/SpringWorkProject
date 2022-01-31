package com.example.SpringWorkProject.Controller;

import com.example.SpringWorkProject.Entity.ToDoEntity;
import com.example.SpringWorkProject.Service.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/todos")
public class ToDoController {
    @Autowired
    private ToDoService toDoService;

    @PostMapping
    public ResponseEntity createTodo(@RequestBody ToDoEntity todo,
                                     @RequestParam Long userId) {
        try {
            return ResponseEntity.ok(toDoService.createTodo(todo, userId));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }

    @PutMapping
    public ResponseEntity completeTodo(@RequestParam Long id) {
        try {
            return ResponseEntity.ok(toDoService.complete(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }
}
