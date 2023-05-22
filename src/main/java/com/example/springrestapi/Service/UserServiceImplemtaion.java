package com.example.springrestapi.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springrestapi.Model.User;
import com.example.springrestapi.Repostory.UserRepostory;

@Service
public class UserServiceImplemtaion implements UserService {

	@Autowired
	private UserRepostory userRepo;
	
	@Override
	public String saveUser(User user) {
		userRepo.save(user);
		return "Saved Successfully";
	}

	@Override
	public User findById(Integer id) {
		Optional<User> user = userRepo.findById(id);
		if(user.isPresent()) {
			return user.get();
		}
		return null;
	}

	@Override
	public List<User> findAll() {
		List<User> user = userRepo.findAll();
		System.out.println("Getting Data from DB"+ user);
		return user;
	}

	@Override
	public String deleteById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

}
