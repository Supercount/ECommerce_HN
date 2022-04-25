package com.example.ecommerce.entities;

public enum RoleNameEnum {
	ROLE_USER("USER"), ROLE_ADMIN("ADMIN");

	private final String role;
	RoleNameEnum(String role){this.role=role;}
	public String getRole(){return this.role;}


}
