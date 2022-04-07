package com.densoft.springdatajpa.repository;

import com.densoft.springdatajpa.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    void saveMethod() {
        //create product
        Product product = new Product();
        product.setName("Product Four");
        product.setDescription("Product One desc");
        product.setSku("100ABCDEF");
        product.setPrice(new BigDecimal(100));
        product.setActive(true);
        product.setImageUrl("product-one.jpg");

        //save product
        Product savedProduct = productRepository.save(product);

        //display product info
        System.out.println(savedProduct.getId());
        System.out.println(savedProduct);
    }

    @Test
    void updateMethod() {
        //find an entity by id
        Long id = 1L;
        Product product = productRepository.findById(id).get();

        //update the retrieved entity
        product.setName("updated product one");
        product.setDescription("updated product one description");

        //save the updated entity
        Product updatedProduct = productRepository.save(product);

        //display info
        System.out.println(updatedProduct.getId());
        System.out.println(updatedProduct);
    }

    @Test
    void findByIdMethod() {
        Long id = 1L;

        Product product = productRepository.findById(id).get();

        System.out.println(product);

    }

    @Test
    void saveAllMethod() {
        //prod two
        Product product = new Product();
        product.setName("Product two");
        product.setDescription("Product two desc");
        product.setSku("100ABCD");
        product.setPrice(new BigDecimal(200));
        product.setActive(true);
        product.setImageUrl("product-two.jpg");
        //prod three
        Product productThree = new Product();
        productThree.setName("Product three");
        productThree.setDescription("Product three desc");
        productThree.setSku("100ABCDE");
        productThree.setPrice(new BigDecimal(300));
        productThree.setActive(true);
        productThree.setImageUrl("product-three.jpg");

        List<Product> products = productRepository.saveAll(List.of(product, productThree));

        products.forEach(System.out::println);

    }

    @Test
    void findAllMethod() {
        List<Product> products = productRepository.findAll();
        products.forEach(System.out::println);
    }

    @Test
    void deleteByIdMethod() {
        Long id = 1L;

        productRepository.deleteById(id);
    }

    @Test
    void deleteMethod() {
        Product product = productRepository.findById(2L).get();
        productRepository.delete(product);
    }

    @Test
    void deleteAllMethod() {
        productRepository.deleteAll();
    }

    @Test
    void countMethod() {
        long count = productRepository.count();
        System.out.println(count);
    }

    @Test
    void existsById() {
        boolean result = productRepository.existsById(2L);
        System.out.println(result);
    }


}