package com.densoft.springdatajpa.repository;

import com.densoft.springdatajpa.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@SpringBootTest
public class QueryMethodTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    void findByName() {
        Product product = productRepository.findByName("Product One");
        System.out.println(product);
    }

    @Test
    void findById() {
        Product product = productRepository.findById(7L).get();
        System.out.println(product);
    }

    @Test
    void findByNameOrDescMethod() {
        List<Product> products = productRepository.findByNameOrDescription("Product One", "Product One desc");
        products.forEach(System.out::println);
    }


    @Test
    void findByNameAndDescMethod() {
        List<Product> products = productRepository.findByNameAndDescription("Product One", "Product One desc");
        products.forEach(System.out::println);
    }

    @Test
    void findDistinctByName() {
        Product product = productRepository.findDistinctByName("Product One");
        System.out.println(product);
    }

    @Test
    void findPriceGreaterThan() {
        List<Product> products = productRepository.findByPriceGreaterThan(new BigDecimal(100));
        products.forEach(System.out::println);
    }


    @Test
    void findPriceLessThan() {
        List<Product> products = productRepository.findByPriceLessThan(new BigDecimal(200));
        products.forEach(System.out::println);
    }

    @Test
    void findByNameContainingMethod() {
        List<Product> products = productRepository.findByNameContaining("Product");
        products.forEach(System.out::println);
    }

    @Test
    void findByNameLikeMethod() {
        List<Product> products = productRepository.findByNameLike("Product One");
        products.forEach(System.out::println);
    }

    @Test
    void findByPriceBetween() {
        List<Product> products = productRepository.findByPriceBetween(new BigDecimal(200), new BigDecimal(300));
        products.forEach(System.out::println);
    }

    @Test
    void findByDateCreatedBetween() {
        LocalDateTime startDate = LocalDateTime.of(2022, 4, 7, 16, 38, 20);
        LocalDateTime endDate = LocalDateTime.of(2022, 4, 7, 16, 40, 45);
        List<Product> products = productRepository.findByDateCreatedBetween(startDate, endDate);
        products.forEach(System.out::println);
    }

    @Test
    void findByNameInMethod(){
        List<Product> products = productRepository.findByNameIn(List.of("Product One", "Product Two"));
        products.forEach(System.out::println);
    }

    @Test
    void findFirst2ByOrderByNameAscMethod(){
        List<Product> products = productRepository.findFirst2ByOrderByNameAsc();
        products.forEach(System.out::println);
    }

    @Test
    void findTop2ByOrderByPriceDescMethod(){
        List<Product> products = productRepository.findTop2ByOrderByPriceDesc();
        products.forEach(System.out::println);
    }
}
