package com.org.Generation.GeekStation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.org.Generation.GeekStation.exceptions.UserNotFoundException;
import com.org.Generation.GeekStation.model.UserEntity;
import com.org.Generation.GeekStation.service.UserService;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST})
public class UserController {
	
	private final UserService userService;
	
	@Autowired
	public UserController(UserService usersService) {
		this.userService = usersService;
	}
	
	//Mapear el metodo getAll()
	
	@GetMapping("/users")
	public List<UserEntity> getUsers(){
		return this.userService.getAll();
	}
	
	//Mapear el metodo createUser() de manera sencialla
	// @RequestBody me permite solicitar el cuerpo (atributos) del Objeto 
	
	@PostMapping("/new-user")
	public ResponseEntity <UserEntity>createUser(@RequestBody UserEntity newUser) {
		if (this.userService.findByEmail(newUser.getEmail()) != null ) { 
			return new ResponseEntity<>(HttpStatus.CONFLICT); 
			} 
			return ResponseEntity.status(HttpStatus.CREATED).body(this.userService.createUser(newUser)); 
			}
	//mapear el metodo deleteById
	@DeleteMapping("/delete-user/{id}")
	public void deleteUser(@PathVariable(name = "id") Long id) {
	this.userService.deleteUser(id);
	}
	
	
	// Mapear el método updateUser 
	@PutMapping("/update-user/{id}")
	public ResponseEntity<?> updateUser(@RequestBody UserEntity user, @PathVariable(name = "id") Long id) {
	try {
	return ResponseEntity.ok(this.userService.updateUser(user, id));
	} catch (UserNotFoundException e) {
	return ResponseEntity.notFound().build();
	}
	}
	
	@GetMapping("/users/email/{email}")
	public ResponseEntity<UserEntity> findByEmail(@PathVariable (name = "email") String email) {
	if (this.userService.findByEmail(email) == null) {
	return ResponseEntity.notFound().build();
	}
	return ResponseEntity.ok(this.userService.findByEmail(email)); 
	}
	
	}
	
	
	
	
	


