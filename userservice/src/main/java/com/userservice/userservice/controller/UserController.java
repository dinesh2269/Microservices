package com.userservice.userservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.userservice.userservice.model.Users;
import com.userservice.userservice.service.UserService;

@RestController
@RequestMapping("/userservice")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@PostMapping
	public ResponseEntity<Users> createUser(@RequestBody Users user){
		return ResponseEntity.ok().body( userService.createOrUpdateUser(user));
	}
	
	@GetMapping
	public ResponseEntity<List<Users>> getHotesl(){
		return ResponseEntity.ok(userService.findAll());
	}
	
}
