package com.example.pruebaNTTDATA.repository;

import com.example.pruebaNTTDATA.model.Task;
import com.example.pruebaNTTDATA.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Integer> {
    @Query("SELECT p FROM Task p WHERE p.name LIKE %?1%")
    public List<Task> searchTask(String filter);
}
