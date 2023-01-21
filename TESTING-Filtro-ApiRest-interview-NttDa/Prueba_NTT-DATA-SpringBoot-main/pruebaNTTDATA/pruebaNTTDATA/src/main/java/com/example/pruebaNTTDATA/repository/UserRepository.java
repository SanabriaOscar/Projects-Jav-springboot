package com.example.pruebaNTTDATA.repository;

import com.example.pruebaNTTDATA.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    @Query("SELECT p FROM User p WHERE p.name LIKE %?1%" +
            "OR p.dateAge LIKE %?1% ")
    public List<User> searchUser(String filter);
}
