package com.example.ecommerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;


import com.example.ecommerce.entities.Role;


public interface RoleRepository extends JpaRepository<Role, Long>{

}
