package com.densoft.springdatajpa.repository;

import com.densoft.springdatajpa.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class NativeSQLQueries {

    @Autowired
    private ProductRepository productRepository;

    @Test
    void findByNameOrDescriptionSQLIndexParamMethod(){
        Product product = productRepository.findByNameOrDescriptionSQLIndexParam("Product Two","Product two desc");
        System.out.println(product);
    }

    @Test
    void findByNameOrDescriptionSQLNamedParamMethod(){
        Product product = productRepository.findByNameOrDescriptionSQLNamedParam("Product Two","Product two desc");
        System.out.println(product);
    }
}
