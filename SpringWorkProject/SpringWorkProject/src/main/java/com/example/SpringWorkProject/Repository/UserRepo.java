package com.example.SpringWorkProject.Repository;

import com.example.SpringWorkProject.Entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

//в скобках указываем сущность, с которой будет работать репозиторий, а вторым - тип идентификатора
public interface UserRepo extends CrudRepository<UserEntity, Long> {
    UserEntity findUserByName(String username);
}
