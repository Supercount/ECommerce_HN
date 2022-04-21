package com.example.ECommerceHN.Controller;

import com.example.ECommerceHN.repository.ProductRepository;
import com.example.ECommerceHN.repository.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(value = "*")
@RequestMapping("/api")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/products")
    public ResponseEntity<?>getProducts(){
        System.out.println("ENTRY GETPRODUCTS");
        List<Product> products = this.productRepository.findAll();

        return ResponseEntity
                .ok()
                .body(products);
    }



}
