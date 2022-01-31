package com.example.SpringWorkProject.Controller;
//Логика по обработке HTTP-запросов

import com.example.SpringWorkProject.Entity.UserEntity;
import com.example.SpringWorkProject.Exception.UserAlreadyExistException;
import com.example.SpringWorkProject.Exception.UserNotFoundException;
import com.example.SpringWorkProject.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//Spring понимает, что это контроллер
@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping
    public ResponseEntity registration(@RequestBody UserEntity user){
        try {
            userService.registration(user);
            return ResponseEntity.ok("Пользователь успешно сохранен");
        }
        //Отлавливаем созданную ошибку и пишем ее с помощью getMessage
        catch (UserAlreadyExistException e){
            return  ResponseEntity.badRequest().body(e.getMessage());
        }
        catch (Exception e){
            return  ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity getOneUser(@PathVariable Long id){
        try {
            return ResponseEntity.ok(userService.getOne(id));
        }
        catch (UserNotFoundException e){
            return  ResponseEntity.badRequest().body(e.getMessage());
        }
        catch (Exception e){
            return  ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity deleteUser(@PathVariable Long id){
        try {
            return ResponseEntity.ok(userService.deleteUser(id));
        }
        catch (Exception e){
            return  ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
