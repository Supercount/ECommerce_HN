package com.example.ecommerce;

import com.example.ecommerce.entities.Category;
import com.example.ecommerce.entities.ColorEnum;
import com.example.ecommerce.entities.Product;
import com.example.ecommerce.entities.Role;
import com.example.ecommerce.entities.RoleNameEnum;
import com.example.ecommerce.entities.User;
import com.example.ecommerce.repositories.CategoryRepository;
import com.example.ecommerce.repositories.ProductRepository;
import com.example.ecommerce.repositories.RoleRepository;
import com.example.ecommerce.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class ECommerceApplication {

	@Autowired
	ProductRepository productRepository;
	@Autowired
	CategoryRepository categoryRepository;
	@Autowired
	UserRepository userRepository;
	@Autowired
	RoleRepository roleRepository;

	public static void main(String[] args) {
		SpringApplication.run(ECommerceApplication.class, args);
	}



	@Bean
	@Transactional
	CommandLineRunner commandLineRunner(ProductRepository productRepository, CategoryRepository categoryRepository, UserRepository userRepositor, RoleRepository roleRepository){
		return new CommandLineRunner() {
			@Override
			public void run(String... args) throws Exception {
				List<Product> products = new ArrayList<>();
				List<Category> categories = new ArrayList<>();
				List<User> users = new ArrayList<>();
				List<Role> roles = new ArrayList<>();

				//Add categories into DB
				Category collier = new Category("Collier");
				Category bague = new Category("Bague");
				Category ensemble = new Category("Ensemble");
				Category gourmette = new Category("Gourmette");
				categories.add(collier);
				categories.add(bague);
				categories.add(ensemble);
				categories.add(gourmette);
				categoryRepository.saveAll(categories);
				
				//Add products into DB
				products.add(new Product("Nom bague","Description Bague",190, ColorEnum.BLANC,categoryRepository.getById(1l),"Image"));
				products.add(new Product("Nom gourmette","Description gourmette",190, ColorEnum.JAUNE,categoryRepository.getById(2l),"Image"));
				products.add(new Product("Nom chaine","Description chaine",190, ColorEnum.ROSE,categoryRepository.getById(3l),"Image"));
				products.add(new Product("Nom ensemble","Description ensemble",190, ColorEnum.BLANC,categoryRepository.getById(4l),"Image"));
				productRepository.saveAll(products);
				
				//Add roles into DB
				Role roleAdmin= new Role(RoleNameEnum.ROLE_ADMIN);
				Role roleUser= new Role(RoleNameEnum.ROLE_USER);
				roles.add(roleAdmin);
				roles.add(roleUser);
				roleRepository.saveAll(roles);
				
				//Add users into DB
				//Add admins but first add existing roles
				List<Role> adminAndSimpleUser=Arrays.asList(roleAdmin,roleUser);
				List<Role> adminOnly=Arrays.asList(roleAdmin);
				List<Role> userOnly=Arrays.asList(roleUser);
				
				User admin1=new User("root1", "root1","firstname1", "lastname1","email@com", adminAndSimpleUser);
				User admin2=new User("root2", "root2","firstname2", "lastname2","email@com", adminAndSimpleUser);
				User admin3=new User("root3", "root3","firstname3", "lastname3","email@com", adminOnly);
				User user4=new User("user4", "user4","firstname4", "lastname4","email@com", adminAndSimpleUser);
				User user5=new User("user5", "user5","firstname5", "lastname5","email@com", adminAndSimpleUser);
				User user6=new User("user6", "user6","firstname6", "lastname6","email@com", adminOnly);
				User user7=new User("user7", "user7", "firstname7", "lastname7","email@com",userOnly);
				
				users.add(admin1);
				users.add(admin2);
				users.add(admin3);
				users.add(user4);
				users.add(user5);
				users.add(user6);
				users.add(user7);
				
				userRepository.saveAll(users);
				
			}
		};
	}

}
