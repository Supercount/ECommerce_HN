package com.example.ecommerce.controllers;

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

import com.example.ecommerce.controllers_models.AddUser;
import com.example.ecommerce.entities.User;
import com.example.ecommerce.services.UserService;

@RestController
@CrossOrigin(value = "*")
@RequestMapping("/api/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/users")
	public ResponseEntity<?> showAllUsers() {

		try {
			List<User> listUsers= this.userService.listAllUsers();
			return ResponseEntity.ok().body(listUsers);
		 	}
		catch (Exception e) {
							return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
							} 
		     
	}
	
	@PostMapping("/users/new_user")
	public ResponseEntity<?> addNewUSer(@RequestBody AddUser dto){
		try {
			User newUSer= new User();
			newUSer.setUsername(dto.getUsername());
			if (dto.getPassword().isEmpty()) {
				newUSer.setPassword("test");
			}
			newUSer.setPassword(dto.getPassword());
			newUSer.setFirstName(dto.getFirstName());
			newUSer.setLastName(dto.getLastName());
			newUSer.setRoleList(dto.getRoleList());
			this.userService.addUser(newUSer);
			return showAllUsers();			
			} 
		catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@PutMapping("users/{id}")
	public ResponseEntity<?> editUser(@RequestBody AddUser dto)
	{
		System.out.println("edit user entry "+dto);
		try {
			User userEdited= this.userService.updateUser(dto.getId(), dto);
			return ResponseEntity.ok().body(userEdited);		
			
	} catch (Exception e) {
		System.out.println(e.getMessage());
		return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
		     
	}
	
	@DeleteMapping("users/{id}")
	public ResponseEntity<?> deleteUser(@PathVariable("id") Long id)
	
	{System.out.println("delete entry"+id);
		
		try {
			this.userService.deleteUser(id);
			return new ResponseEntity<>(HttpStatus.OK);		
			
	} catch (Exception e) {
		return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
		     
	}
	

}
