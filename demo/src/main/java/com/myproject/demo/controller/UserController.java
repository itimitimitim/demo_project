package com.myproject.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.myproject.demo.entity.User;
import com.myproject.demo.repositories.UserRepositories;
import com.myproject.demo.service.UserService;

@RestController
public class UserController {
	
	private final UserRepositories userRepository;
	
	@Autowired
	private  UserService userService;
	
	@Autowired
	public UserController(UserRepositories userRepository) {
		this.userRepository = userRepository;
	}
	

	@GetMapping("/users")
	public List<User> user(){
		return userRepository.findAll();
	}
	
	@PostMapping("/createUser")
	public void createUser(@RequestParam("firstname")String firstname,@RequestParam("lastname") String lastname) {
		userService.createUser(firstname, lastname);
	}
	
	@PostMapping("/editUser")
	public void editUser(@RequestParam("id")Integer id,@RequestParam("lastname") String lastname) {
		userService.editUser(id, lastname);
	}
	
	@PostMapping("/findUser")
	public User findUser(@RequestParam("id")Integer id) {
		return userService.findUser(id);
	}
	
	@PostMapping("/findUserByName")
	public List<User> findUserByName(@RequestParam("firstname")String firstname) {
		return userService.findUserByName(firstname);
	}
	
	@DeleteMapping("/deleteUser")
	public void deleteUser(@RequestParam("id")Integer id) {
		userService.deleteUser(id);
	}
	
	
	
}
