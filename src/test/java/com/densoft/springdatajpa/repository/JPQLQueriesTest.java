package com.densoft.springdatajpa.repository;

import com.densoft.springdatajpa.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class JPQLQueriesTest {
    @Autowired
    private ProductRepository productRepository;

    @Test
    void findByNameOrDescriptionJPQLIndexParamMethod() {
        Product product = productRepository.findByNameOrDescriptionJPQLIndexParam("Product Two","Product two desc");
        System.out.println(product);
    }


    @Test
    void findByNameOrDescriptionJPQLNamedParamMethod() {
        Product product = productRepository.findByNameOrDescriptionJPQLNamedParam("Product Two","Product two desc");
        System.out.println(product);
    }
}
