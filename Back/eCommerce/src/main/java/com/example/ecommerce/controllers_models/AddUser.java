package com.example.ecommerce.controllers_models;

import java.util.List;

import com.example.ecommerce.entities.Role;


public class AddUser {

	private String username;	
	private String password;
	private String firstName;
	private String lastName;
	private String email;
	private List<Role> roleList;
	
	
	public AddUser() {

	}


	public AddUser(String username, String password, String firstName, String lastName, String email,List<Role> roleList) {
		super();
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.roleList = roleList;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public List<Role> getRoleList() {
		return roleList;
	}


	public void setRoleList(List<Role> roleList) {
		this.roleList = roleList;
	}
	
	

}
