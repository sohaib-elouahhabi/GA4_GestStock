package com.example.gest_stock.Repositories;

import com.example.gest_stock.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User,Integer> {



    Optional<User> findUserByUsername(String username);

    @Query("SELECT u FROM User u WHERE u.username = :username and u.password = :password")
    User getUser(@Param("username") String username, @Param("password") String password);

}
