package com.example.ECommerceHN.repository.entity;

import javax.persistence.*;

@Entity
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Enumerated(EnumType.STRING)
    private RoleEnum name;

    public Role(RoleEnum name) {
        this.name = name;
    }

    public Role() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public RoleEnum getName() {
        return name;
    }

    public void setName(RoleEnum name) {
        this.name = name;
    }
}