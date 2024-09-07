package com.sadio.gestion_de_stock;

import com.sadio.gestion_de_stock.model.Category;
import com.sadio.gestion_de_stock.model.Produit;
import com.sadio.gestion_de_stock.model.User;
import com.sadio.gestion_de_stock.repository.CategoryRepository;
import com.sadio.gestion_de_stock.repository.ProduitRepository;
import com.sadio.gestion_de_stock.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

@SpringBootApplication
public class ResGestionDeStockApplication {

    public static void main(String[] args) {
        SpringApplication.run(ResGestionDeStockApplication.class, args);

    }

    @Bean
    public CommandLineRunner categorySeeder(CategoryRepository categoryRepository){

        return args -> {

            Category category = Category.builder()
                    .name("Electronic")
                    .build();

            Category category1 = Category.builder()
                    .name("Alimentaire")
                    .build();

            categoryRepository.saveAll(Arrays.asList(category, category1));

        };
    }

    /*@Bean
    public CommandLineRunner userSeeder(UserRepository userRepository){

        return args -> {
            User user = User.builder()
                    .name("sadio")
                    .email("sadio@gmail.com")
                    .password("admin")
                    .build();

            userRepository.save(user);
        };
    }
*/
    @Bean
    public CommandLineRunner productSeeder(ProduitRepository produitRepository){

        return args -> {

            Produit produit = Produit.builder()
                    .name("Iphone")
                    .quantite(4L)
                    .category(Category.builder()
                            .id(1L)
                            .build())
                    .build();

            Produit produit1 = new Produit();

            produit1.setName("Lait");
            produit1.setQuantite(4L);
            produit1.setCategory(Category.builder()
                            .id(2L)
                    .build());

            produitRepository.saveAll(Arrays.asList(produit, produit1));

        };

    }

}
