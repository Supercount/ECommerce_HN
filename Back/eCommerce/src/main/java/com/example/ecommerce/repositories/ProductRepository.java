package com.example.ecommerce.repositories;

import com.example.ecommerce.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ecommerce.entities.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query("select p from Product p where p.name = :name")
    Category getRing(@Param("name") String name);

    List<Product> findByCategory(Category category);

}
