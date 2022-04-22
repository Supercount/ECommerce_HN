package com.example.ecommerce.entities;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="Roles")

public class Role {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	// cette annotation permet de stocker le roleName entant que String en base 
	@Enumerated(EnumType.STRING)
	private RoleNameEnum roleName;

	public Role() {
	}

	public Role(RoleNameEnum roleName) {
		this.roleName = roleName;
	}

	public RoleNameEnum getRoleName() {
		return roleName;
	}

	public void setRoleName(RoleNameEnum roleName) {
		this.roleName = roleName;
	}
	
	
	
}
