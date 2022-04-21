package com.example.ECommerceHN.repository;

import com.example.ECommerceHN.repository.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
