package com.example.ecommerce.services;

import java.util.Arrays;
import java.util.List;

import com.example.ecommerce.entities.Role;
import com.example.ecommerce.entities.RoleNameEnum;
import com.example.ecommerce.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.ecommerce.controllers_models.AddUser;
import com.example.ecommerce.entities.User;
import com.example.ecommerce.repositories.UserRepository;

import javax.transaction.Transactional;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RoleRepository roleRepository;
	@Autowired
	private PasswordEncoder passwordEncoder;


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

	public boolean checkUsernameExist(String username) {
		return userRepository.existsByUsername(username);
	}

	@Transactional
	public User signup(String username, String password) {
		Role roleUser = roleRepository.findByRoleName(RoleNameEnum.ROLE_USER);
		List<Role> roleList = Arrays.asList(roleUser);

		User u = new User(username, passwordEncoder.encode(password), roleList);
		return userRepository.save(u);
	}
	
	
}
