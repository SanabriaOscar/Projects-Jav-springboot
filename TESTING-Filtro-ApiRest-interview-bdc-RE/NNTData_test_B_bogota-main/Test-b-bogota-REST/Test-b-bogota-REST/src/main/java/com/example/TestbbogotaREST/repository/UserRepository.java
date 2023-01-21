package com.example.TestbbogotaREST.repository;

import com.example.TestbbogotaREST.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    @Query("SELECT p.firstName, p.secondName, p.firstLastName, p.secondLastName," +
            " p.phoneNumber, p.address FROM User p WHERE p.identification LIKE %?1%")

    public List<User>findUserByIdentification(String identicationFilter);


}
