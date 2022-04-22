package com.example.ecommerce.controllers;

import com.example.ecommerce.entities.Product;
import com.example.ecommerce.repositories.CategoryRepository;
import com.example.ecommerce.repositories.ProductRepository;
import com.example.ecommerce.dto.ProductDTO;
import com.example.ecommerce.entities.EnumColor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(value = "*")
@RequestMapping("/api/auth")
@Transactional
public class ProductController {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping("/products")
    public ResponseEntity<?> getProducts(){
        System.out.println("ENTRY GETPRODUCTS");
        List<Product> products = this.productRepository.findAll();

        return ResponseEntity
                .ok()
                .body(products);
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<?> getProduct(@PathVariable("id") Long id){
        System.out.println("ENTRY GETPRODUCT");
        Product product = this.productRepository.getById(id);

        System.out.println(product);

        return ResponseEntity
                .ok()
                .body(product);
    }

    @DeleteMapping("/products/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable("id")Long id){
        System.out.println("ENTRY DELETE");
        try {
            this.productRepository.deleteById(id);
        }catch (Exception e){
            System.out.println("erreur" + e.getMessage());
        }finally {
            return ResponseEntity
                    .ok()
                    .body(id);
        }

    }

    @PostMapping("/products")
    public ResponseEntity<?> addProduct(@RequestBody ProductDTO dto){

        Product product = new Product();
        product.setName(dto.getName());
        product.setColor(EnumColor.valueOf(dto.getColor()));

        product.setDescription(dto.getDescription());
        product.setPrice(dto.getPrice());


        product.setCategory(this.categoryRepository.getCategoryByName(dto.getCategory()));
        product.setPicture(dto.getPicture());
        System.out.println(dto);

        this.productRepository.save(product);
        return ResponseEntity
                .ok()
                .body(dto);
    }

    @PutMapping("/products")
    public ResponseEntity<?> updateProduct(@RequestBody ProductDTO dto){

        Optional<Product> productToUpdate = this.productRepository.findById(dto.getId());
        Product productUpdated;
        if (productToUpdate.isPresent()){
            productUpdated = productToUpdate.get();
            productUpdated.setName(dto.getName());
            productUpdated.setDescription(dto.getDescription());
            productUpdated.setCategory(this.categoryRepository.getCategoryByName(dto.getCategory()));
            productUpdated.setColor(EnumColor.valueOf(dto.getColor()));
            productUpdated.setPrice(dto.getPrice());
            productUpdated.setPicture(dto.getPicture());
            this.productRepository.save(productUpdated);
            return ResponseEntity
                    .ok()
                    .body(productUpdated);
        }else{
            return ResponseEntity
                    .notFound()
                    .build();
        }
    }



}
