package com.example.ECommerceHN.repository;


import com.example.ECommerceHN.repository.entity.Role;
import com.example.ECommerceHN.repository.entity.RoleEnum;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends CrudRepository<Role, Long> {
    Role findByName(RoleEnum role);
}
