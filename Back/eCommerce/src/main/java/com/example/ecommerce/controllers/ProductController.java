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
@RequestMapping("/api/products")
@Transactional
public class ProductController {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping("/all")
    public ResponseEntity<?> getProducts(){
        System.out.println("ENTRY GETPRODUCTS");
        List<Product> products = this.productRepository.findAll();

        return ResponseEntity
                .ok()
                .body(products);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getProduct(@PathVariable("id") Long id){
        System.out.println("ENTRY GETPRODUCT");
        Product product = this.productRepository.getById(id);

        System.out.println(product);

        return ResponseEntity
                .ok()
                .body(product);
    }



    @GetMapping("/necklace")
    public ResponseEntity<?> getNeck(){
        List<Product> products = this.productRepository.findByCategory(categoryRepository.getCategoryByName("Collier"));

        return ResponseEntity
                .ok()
                .body(products);
    }

    @GetMapping("/chain")
    public ResponseEntity<?> getChain(){
        List<Product> products = this.productRepository.findByCategory(categoryRepository.getCategoryByName("Bracelet"));

        return ResponseEntity
                .ok()
                .body(products);
    }

    @GetMapping("/ring")
    public ResponseEntity<?> getRing(){
        List<Product> products = this.productRepository.findByCategory(categoryRepository.getCategoryByName("Bague"));

        return ResponseEntity
                .ok()
                .body(products);
    }

    @GetMapping("/set")
    public ResponseEntity<?> getSet(){
            List<Product> products = this.productRepository.findByCategory(categoryRepository.getCategoryByName("Ensemble"));

        return ResponseEntity
                .ok()
                .body(products);

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
