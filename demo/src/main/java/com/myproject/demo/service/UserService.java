package com.myproject.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myproject.demo.entity.User;
import com.myproject.demo.repositories.UserRepositories;



@Service
public class UserService {
	
	@Autowired
	private UserRepositories userRepository;

	
	public void createUser(String firstname, String lastname) {
		User user = new User();
		user.setFirstname(firstname);
		user.setLastname(lastname);
		userRepository.save(user);
		
	}
	
	public void editUser(Integer id, String lastname) {
		User user = userRepository.findById(id).get();
		user.setLastname(lastname);
		userRepository.save(user);
		
	}
	
	public User findUser(Integer id) {
		User user = userRepository.findById(id).get();
		return user;
		
	}
	
	public List<User> findUserByName(String name) {
		List<User> list = new ArrayList<User>();
		list.addAll(userRepository.findByFirstname(name));
		return list;
		
	}
	
	public void deleteUser(Integer id) {
		userRepository.deleteById(id);
		
	}


}
