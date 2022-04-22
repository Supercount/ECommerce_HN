package com.example.ecommerce.repositories;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.ecommerce.entities.Category;

@Repository
@Transactional
public interface CategoryRepository extends JpaRepository<Category, Long> {
	   @Query("select c from Category c where c.name = :name")
	    Category getCategoryByName(@Param("name") String name);
}

