package com.example.ecommerce.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;



@Entity
@Table(name="Users")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(nullable = false, unique = true, length = 20)
	private String username;
	
	@Column(nullable = false, unique = true , length = 15)
	private String password;
	
	@Column(nullable = false , length = 15, name="First_Name")
	private String firstName;
	
	@Column(nullable = false , length = 15 , name="Last_Name")
	private String lastName;
	
	@Column(nullable = false , length = 15 , name="email")
	private String email;
	
	@ManyToMany
	private List<Role> roleList;

	
	public User() {
	}


	public User(String username, String password, String firstName, String lastName , String email, List<Role> roleList ) {
		this.username = username;
		this.password = password;		
		this.firstName = firstName;
		this.lastName = lastName;
		this.roleList = roleList;
		this.email = email;
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
