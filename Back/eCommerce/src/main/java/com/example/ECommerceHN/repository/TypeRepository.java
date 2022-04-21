package com.example.ECommerceHN.repository;

import com.example.ECommerceHN.repository.entity.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface TypeRepository extends JpaRepository<Type, Long> {

    @Query("select t from Type t where t.name = :name")
    Type getTypeByName(@Param("name") String name);

}
