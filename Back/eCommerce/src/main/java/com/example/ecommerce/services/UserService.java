package com.example.ecommerce.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ecommerce.controllers_models.AddUser;
import com.example.ecommerce.entities.User;
import com.example.ecommerce.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	//Users List
	public List<User> listAllUsers() {
		
		return (List<User>) userRepository.findAll();
	}
	
	
	//Add new User
	public void addUser(User newUser)
	{
		this.userRepository.save(newUser);
	}
	
	// Get User
	
	public User getUser(Long id) {
		return this.userRepository.getById(id);
	}
	
	// Update User
	
	public User updateUser(Long id, AddUser editUser) {
		User userToEdit= this.userRepository.getById(id);
		userToEdit.setUsername(editUser.getUsername());
		userToEdit.setPassword(editUser.getPassword());
		userToEdit.setFirstName(editUser.getFirstName());
		userToEdit.setLastName(editUser.getLastName());
		userToEdit.setRoleList(editUser.getRoleList());
		return userToEdit;
	}
	
	// Delete User
	public void deleteUser(Long id) {
		 this.userRepository.deleteById(id);
	}
	
	// Delete User
	public void deleteAllUsers() {
		 this.userRepository.deleteAll();
	}
	
	
}
