package com.example.springrestapi.Repostory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springrestapi.Model.User;

@Repository
public interface UserRepostory  extends JpaRepository<User, Integer>{

}
