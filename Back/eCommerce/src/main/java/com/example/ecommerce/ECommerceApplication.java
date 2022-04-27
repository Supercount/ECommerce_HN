package com.example.ecommerce;

import com.example.ecommerce.repositories.CategoryRepository;
import com.example.ecommerce.repositories.ProductRepository;
import com.example.ecommerce.repositories.RoleRepository;
import com.example.ecommerce.repositories.UserRepository;
import com.example.ecommerce.entities.EnumColor;
import com.example.ecommerce.entities.Product;
import com.example.ecommerce.entities.Role;
import com.example.ecommerce.entities.RoleNameEnum;
import com.example.ecommerce.entities.User;
import com.example.ecommerce.entities.Category;
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
				List<Category> types = new ArrayList<>();
				List<User> users = new ArrayList<>();
				List<Role> roles = new ArrayList<>();

				Category collier = new Category("Collier");
				Category bague = new Category("Bague");
				Category bracelet = new Category("Bracelet");
				Category ensemble = new Category("Ensemble");

				types.add(collier);
				types.add(bague);
				types.add(bracelet);
				types.add(ensemble);
				categoryRepository.saveAll(types);

				products.add(new Product("Bague Sara","Ensemble de bague en argent Sterlling 925, avec des pierres de zircon, bague Sara, bague de promesse de fiançailles,un éclat permanent, pour un look parfait et à un prix adapté.",49, EnumColor.SILVER,categoryRepository.getById(2l), "../../../assets/img/bague/bague1.png"));
				products.add(new Product("Bague Sophia","Baque Sophia est faite pour vos mains, l'anneau offre une finesse et une légèreté facile à porter au quotidien. Les zircons blancs ajoute de l'éclat et de l'élégance à la bague.\n"
						+ "",29, EnumColor.SILVER,categoryRepository.getById(2l), "../../../assets/img/bague/bague2.jpg"));
				products.add(new Product("Bague Soraya","Baque en argent Sterlling 925 plaquée or jaune rehaussera vos looks du quotidien d'un éclat sans pareil grâce à l'association entre ses pierres de zircon et son métal bicolore éclatant. Cette bague polyvalente de style éternité sera toujours du plus bel effet.",39, EnumColor.GOLD,categoryRepository.getById(2l), "../../../assets/img/bague/bague3.png"));
				products.add(new Product("Bague Amel","La bague Amel injecte dans votre look plusieurs doses d'élégance avec 4 anneaux Croisés. Cette bague à la fois classique et moderne dorée à l'or rose. L'anneau du dessus et l'anneau au milieu sont est pavés de pierres de zircon. Une fois que vous aurez mis à votre doigt cette somptueuse bague croisée élégante et glamour, vous ne voudrez plus l'enlever.",55, EnumColor.PINK,categoryRepository.getById(2l), "../../../assets/img/bague/bague4.png"));
				
				
				products.add(new Product("Collier Maessa","le Collier Maessa allie à merveille les styles classique et contemporain. une bague modernisé avec des pierres serties de manière décentrée afin de conférer au bijou une allure totalement unique. Avec sa chaîne à la longueur ajustable, ce collier plaqué Or jaune est le bijou idéal pour apporter la touche finale à votre tenue.",35, EnumColor.GOLD,categoryRepository.getById(1l), "../../../assets/img/collier/collier-gold.png"));
				products.add(new Product("Collier Marwa","le Collier Marwa allie à merveille les styles classique et contemporain. une bague modernisé avec des pierres serties de manière décentrée afin de conférer au bijou une allure totalement unique. Avec sa chaîne à la longueur ajustable, ce collier plaqué Or rose est le bijou idéal pour apporter la touche finale à votre tenue.",35, EnumColor.PINK,categoryRepository.getById(1l), "../../../assets/img/collier/collier-rose.png"));
				products.add(new Product("Collier Ines","Everyday Bijou vous séduira avec cecollier en argent 925, très facile à assortir. Cette cascade de trois chaînes est d'une vraie délicatesse… On craque totalement pour cette pièce, et vous? ",65, EnumColor.SILVER,categoryRepository.getById(1l), "../../../assets/img/collier/collier-silver.png"));

				
				
				products.add(new Product("Ensemble Camelia","Craquez pour cette superbe parure en argent plaquée Or jaune, composée d’un collier avec son pendentif, d’une bague, et de boucles d’oreille, tous ornés de motifs circulaires.",80, EnumColor.GOLD,categoryRepository.getById(4l), "../../../assets/img/ensemble/ensemble-gold.png"));
				products.add(new Product("Ensemble Sana","Craquez pour cette superbe parure en argent plaquée Or rose, composée d’un bracelet, d’une bague, et de boucles d’oreille, tous ornés de pières colorées.",85, EnumColor.PINK,categoryRepository.getById(4l), "../../../assets/img/ensemble/ensemble-rose.png"));
				products.add(new Product("Ensemble Nora","Craquez pour cette superbe parure en argent 925, composée d’une chaîne avec son pendentif et de boucles d’oreille, tous ornés de pières d'un superbe éclat.",69, EnumColor.SILVER,categoryRepository.getById(4l), "../../../assets/img/ensemble/ensemble-silver.png"));

				products.add(new Product("Gourmette Aya","Gourmette Aya en argent à férmeture coullissante, fera toute la différence, quel que soit votre look, ce bracelet est très facile à assortir.",25, EnumColor.GOLD,categoryRepository.getById(3l), "../../../assets/img/gourmette/gourmette-gold.png"));
				products.add(new Product("Gourmette Basma","",25, EnumColor.PINK,categoryRepository.getById(3l), "../../../assets/img/gourmette/gourmette-rose.png"));
				products.add(new Product("Gourmette Joelle","Gourmette Basma en argent 925 plaquée or rose, le motif est mis en valeur par deux chainettes qui se rejoignent en une seule. Bracelet de longueur réglable, cette bague injectera dans votre look une dose d'élegance incomparable.",49, EnumColor.SILVER,categoryRepository.getById(3l), "../../../assets/img/gourmette/gourmette-silver.png"));

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
