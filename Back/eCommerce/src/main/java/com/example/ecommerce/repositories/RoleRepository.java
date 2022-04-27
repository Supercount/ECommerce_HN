package com.example.ecommerce.repositories;

import com.example.ecommerce.entities.RoleNameEnum;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ecommerce.entities.Role;



@Repository
@Transactional
public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByRoleName(RoleNameEnum role);
}

