package com.densoft.springdatajpa.repository;

import com.densoft.springdatajpa.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

@SpringBootTest
public class NamedQueriesTest {
    @Autowired
    private ProductRepository productRepository;

    @Test
    void namedJPQLQuery() {
        Product product = productRepository.findByPrice(new BigDecimal(200));
        System.out.println(product);
    }

    @Test
    void namedJPQLQueries() {
        List<Product> products = productRepository.findAllOrderByNameDesc();
        products.forEach(System.out::println);
    }

    @Test
    void namedNativeSQLQuery() {
        Product product = productRepository.findByDescription("Product three desc");
        System.out.println(product);
    }


    @Test
    void namedNativeSQLQueries() {
        List<Product> products = productRepository.findAllOrderByNameAsc();
        products.forEach(System.out::println);
        Product product = productRepository.findByDescription("Product three desc");
        System.out.println(product);
    }
}
