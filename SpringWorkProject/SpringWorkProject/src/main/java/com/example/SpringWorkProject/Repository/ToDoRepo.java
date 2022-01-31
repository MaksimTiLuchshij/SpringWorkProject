package com.example.SpringWorkProject.Repository;

import com.example.SpringWorkProject.Entity.ToDoEntity;
import org.springframework.data.repository.CrudRepository;

public interface ToDoRepo extends CrudRepository<ToDoEntity, Long> {
}
