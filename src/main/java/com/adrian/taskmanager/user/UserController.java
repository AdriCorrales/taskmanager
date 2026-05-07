package com.adrian.taskmanager.user;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
public class UserController {
	private UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	//GET /users
	@GetMapping(path = "/users")
	public List<User> getAllUsers() {
		return userService.findAll();
	}
	
	//GET /users/{id}
	@GetMapping(path = "/users/{id}")
	public User getUser(@PathVariable int id) {
		return userService.findById(id);
	}
	
	//POST /users
	@PostMapping(path = "/users")
	public User createUser(@Valid @RequestBody User user) {
		return userService.save(user);
	}
	
	//DELETE /users/{id}
	@DeleteMapping(path = "/users/{id}")
	public void deleteUser(@PathVariable int id) {
		userService.delete(id);
	}
}
