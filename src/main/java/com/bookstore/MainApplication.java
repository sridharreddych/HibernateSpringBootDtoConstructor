package com.bookstore;

import com.bookstore.dto.AuthorDto;
import java.util.List;
import com.bookstore.service.BookstoreService;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MainApplication {

    private final BookstoreService bookstoreService;

    public MainApplication(BookstoreService bookstoreService) {
        this.bookstoreService = bookstoreService;
    }

    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class, args);
    }

    @Bean
    public ApplicationRunner init() {
        return args -> {

            List<AuthorDto> authors = bookstoreService.fetchByGenre();

            System.out.println("Number of authors:" + authors.size());

            for (AuthorDto author : authors) {
                System.out.println("Author name: " + author.getName()
                        + " | Age: " + author.getAge());
            }
        };
    }
}


/*
 * DTO Via Constructor And Spring Data Query Builder Mechanism

Description: Fetching more data than needed is prone to performance penalities. Using DTO allows us to extract only the needed data. In this application we rely on constructor and Spring Data Query Builder Mechanism.

Key points:

write a proper constructor in the DTO class
rely on Spring Data Query Builder Mechanism to write the SQL
for using Spring Data Projections check this item
See also:
Dto Via Constructor Expression and JPQL
 */