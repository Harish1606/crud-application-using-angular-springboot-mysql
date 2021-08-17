package com.cts.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.cts.demo.model.User;
import com.cts.demo.repository.userRepository;

@CrossOrigin
@RestController
public class userController {

	@Autowired
	private userRepository repo;
	
	@GetMapping("/get")
	public List<User> getAllUsers(){
		return repo.findAll();
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<User> getUser(@PathVariable(value="id") Integer Id) throws ResourceNotFoundException{
		User user=repo.findById(Id).orElseThrow(()->new ResourceNotFoundException("User not found"));
		return ResponseEntity.ok().body(user);
	}
	
	@PostMapping("/post")
	public User addUser(@RequestBody User user) throws Exception{
		return repo.save(user);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<User> updateUser(@PathVariable(value="id") Integer Id,@RequestBody User user) throws ResourceNotFoundException{
		User obj=repo.findById(Id).orElseThrow(()->new ResourceNotFoundException("User not found"));
		obj.setEmail_id(user.getEmail_id());
		obj.setUser_name(user.getUser_name());
		obj.setMobile_no(user.getMobile_no());
		obj.setQualification(user.getQualification());
		final User updatedUser=repo.save(obj);
		return ResponseEntity.ok(updatedUser);
	}
	
	@DeleteMapping("/delete/{id}")
	public Map<String,Boolean> deleteUser(@PathVariable(value="id") Integer Id) throws ResourceNotFoundException{
		User user=repo.findById(Id).orElseThrow(()->new ResourceNotFoundException("User not Found"));
		repo.delete(user);
		Map<String,Boolean> response=new HashMap<>();
		response.put("Deleted", Boolean.TRUE);
		return response;
	}
}
