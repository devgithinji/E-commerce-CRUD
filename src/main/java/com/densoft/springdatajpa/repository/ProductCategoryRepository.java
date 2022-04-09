package com.densoft.springdatajpa.repository;

import com.densoft.springdatajpa.entity.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Long> {

}
