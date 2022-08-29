package com.example.cinestarticketsproject;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

@Dao
public interface UserDao {
    @Insert
    void registerUser(UserEntity userEntity);

    @Query("SELECT * from users where username= (:username) and password= (:password)")
            UserEntity login(String username, String password);



    @Query("SELECT * FROM users WHERE username = :username LIMIT 1")
    public UserEntity getUserByUsername(String username);
}
