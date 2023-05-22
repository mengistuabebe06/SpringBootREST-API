package com.example.springrestapi.Service;

import java.util.List;

import com.example.springrestapi.Model.User;

public interface UserService {

	public String saveUser(User user);
	public User findById(Integer id);
	public List<User> findAll();
	public String deleteById(Integer id);
	
	
}
