package com.densoft.springdatajpa.repository;

import com.densoft.springdatajpa.entity.Product;
import com.densoft.springdatajpa.entity.ProductCategory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;


@SpringBootTest
class ProductCategoryRepositoryTest {

    @Autowired
    private ProductCategoryRepository productCategoryRepository;

    @Test
    void saveProductCategory() {
        ProductCategory productCategory = new ProductCategory("books", "books description");
        //product one
        Product productOne = new Product();
        productOne.setName("Core Java");
        productOne.setPrice(new BigDecimal(10000));
        productOne.setImageUrl("imageOne");
        productOne.setSku("ABCD");
        productOne.setCategory(productCategory);
        productCategory.getProducts().add(productOne);

        //product two
        Product productTwo = new Product();
        productTwo.setName("Effective Java");
        productTwo.setPrice(new BigDecimal(20000));
        productTwo.setImageUrl("imageTwo");
        productTwo.setSku("ABCDE");
        productTwo.setCategory(productCategory);
        productCategory.getProducts().add(productTwo);


        productCategoryRepository.save(productCategory);

    }

    @Test
    @Transactional
    void fetchProductCategory() {
        ProductCategory category = productCategoryRepository.findById(1L).get();
        System.out.println(category);
        System.out.println(category.getProducts());
    }


}