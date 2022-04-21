package com.example.ECommerceHN.repository;

import com.example.ECommerceHN.repository.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
