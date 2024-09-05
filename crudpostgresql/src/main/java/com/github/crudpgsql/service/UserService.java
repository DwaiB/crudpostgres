package com.github.crudpgsql.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.crudpgsql.exception.UserNotFoundException;
import com.github.crudpgsql.model.User;
import com.github.crudpgsql.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository repository;
	
	public List<User> getAllUsers(){
		return repository.findAll();
	}
	public User getUserById(long id) {
		return repository.findById(id).orElseThrow(()-> new UserNotFoundException("User Not Found"));
	}
	public void deleteUser(long id) {
		repository.deleteById(id);
	}
	public void saveUser(User user) {
		repository.save(user);
	}
}
