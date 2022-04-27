package com.example.ecommerce.repositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ecommerce.entities.User;

import java.util.Optional;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface UserRepository extends JpaRepository<User, Long>{


    Optional<User> findByUsername(String username);

    Boolean existsByUsername(String username);
}
