package com.example.ECommerceHN;

import com.example.ECommerceHN.repository.ProductRepository;
import com.example.ECommerceHN.repository.CategoryRepository;
import com.example.ECommerceHN.repository.entity.ColorEnum;
import com.example.ECommerceHN.repository.entity.Product;
import com.example.ECommerceHN.repository.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class ECommerceApplication {

	@Autowired
	ProductRepository productRepository;
	@Autowired
	CategoryRepository categoryRepository;

	public static void main(String[] args) {
		SpringApplication.run(ECommerceApplication.class, args);
	}



	@Bean
	@Transactional
	CommandLineRunner commandLineRunner(ProductRepository productRepository, CategoryRepository categoryRepository){
		return new CommandLineRunner() {
			@Override
			public void run(String... args) throws Exception {
				List<Product> products = new ArrayList<>();
				List<Category> categories = new ArrayList<>();

				Category collier = new Category("Collier");
				Category bague = new Category("Bague");
				Category ensemble = new Category("Ensemble");
				Category gourmette = new Category("Gourmette");
				categories.add(collier);
				categories.add(bague);
				categories.add(ensemble);
				categories.add(gourmette);

				categoryRepository.saveAll(categories);

				products.add(new Product("Nom bague","Description Bague",190, ColorEnum.BLANC,categoryRepository.getById(1l),"Image"));
				products.add(new Product("Nom gourmette","Description gourmette",190, ColorEnum.JAUNE,categoryRepository.getById(2l),"Image"));
				products.add(new Product("Nom chaine","Description chaine",190, ColorEnum.ROSE,categoryRepository.getById(3l),"Image"));
				products.add(new Product("Nom ensemble","Description ensemble",190, ColorEnum.BLANC,categoryRepository.getById(4l),"Image"));
				productRepository.saveAll(products);
			}
		};
	}

}
