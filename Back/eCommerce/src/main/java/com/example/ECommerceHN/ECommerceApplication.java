package com.example.ECommerceHN;

import com.example.ECommerceHN.repository.ProductRepository;
import com.example.ECommerceHN.repository.TypeRepository;
import com.example.ECommerceHN.repository.entity.EnumColor;
import com.example.ECommerceHN.repository.entity.Product;
import com.example.ECommerceHN.repository.entity.Type;
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
	TypeRepository typeRepository;

	public static void main(String[] args) {
		SpringApplication.run(ECommerceApplication.class, args);
	}



	@Bean
	@Transactional
	CommandLineRunner commandLineRunner(ProductRepository productRepository, TypeRepository typeRepository){
		return new CommandLineRunner() {
			@Override
			public void run(String... args) throws Exception {
				List<Product> products = new ArrayList<>();
				List<Type> types = new ArrayList<>();

				Type collier = new Type("Collier");
				Type bague = new Type("Bague");
				Type bracelet = new Type("Bracelet");
				Type boucles = new Type("Boucles d'oreilles");
				Type piercing = new Type("Piercing");
				types.add(collier);
				types.add(bague);
				types.add(bracelet);
				types.add(boucles);
				types.add(piercing);
				typeRepository.saveAll(types);

				products.add(new Product("product1","description product 1",90, EnumColor.PINK,typeRepository.getById(1l), ""));
				products.add(new Product("product2","description product 2",190, EnumColor.PINK,typeRepository.getById(2l), ""));
				products.add(new Product("product3","description product 3",290, EnumColor.PINK,typeRepository.getById(2l), ""));
				products.add(new Product("product4","description product 4",390, EnumColor.PINK,typeRepository.getById(2l), ""));
				products.add(new Product("product5","description product 5",70, EnumColor.PINK,typeRepository.getById(3l), ""));
				products.add(new Product("product6","description product 6",99.99, EnumColor.PINK,typeRepository.getById(4l), ""));
				products.add(new Product("product7","description product 7",120, EnumColor.WHITE,typeRepository.getById(5l), ""));

				productRepository.saveAll(products);
			}
		};
	}

}
