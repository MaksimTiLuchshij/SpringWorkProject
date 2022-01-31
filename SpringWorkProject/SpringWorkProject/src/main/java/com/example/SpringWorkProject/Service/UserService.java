package com.example.SpringWorkProject.Service;

import com.example.SpringWorkProject.Entity.UserEntity;
import com.example.SpringWorkProject.Exception.UserAlreadyExistException;
import com.example.SpringWorkProject.Exception.UserNotFoundException;
import com.example.SpringWorkProject.Model.UserModel;
import com.example.SpringWorkProject.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;

    public UserEntity registration(UserEntity user) throws UserAlreadyExistException {
        if(userRepo.findUserByName(user.getName()) == null){
            return userRepo.save(user);
        }
        //Ошибку нужно не вернуть(return), а бросить (throw)
        else throw  new UserAlreadyExistException("Пользователь с таким именем уже существует");
    }

    public UserModel getOne(Long id) throws UserNotFoundException {
        UserEntity user = userRepo.findById(id).get();
        if(user == null){
            throw new UserNotFoundException("Пользователь не найден");
        }
        return UserModel.toModel(user);
    }

    public Long deleteUser(Long id){
        userRepo.deleteById(id);
        return id;
    }
}
