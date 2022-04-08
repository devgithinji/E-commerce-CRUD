package com.densoft.springdatajpa.repository;

import com.densoft.springdatajpa.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {


    /* Returns the found product entry by using its name as search
     criteria. if no product is found, this method returns null
    */
    Product findByName(String name);

    /*
    Returns an optional which contains the found product
    entry by using its id as search criteria. if no product entry
    is found, this method returns and empty Optional
    */
    Optional<Product> findById(Long id);

    /*
    Returns a found list of product entries whose title or description is given
    as a method parameter. If no product entries is found, this method
    returns an empty list
    */
    List<Product> findByNameOrDescription(String name, String description);

    /*
   Returns a found list of product entries whose title and description is given
   as a method parameter. If no product entries is found, this method
   returns an empty list
   */
    List<Product> findByNameAndDescription(String name, String description);

    /*
    Return the distinct product entry whose name is given as a method parameter
    if no product entry is found the method returns null.
    */
    Product findDistinctByName(String name);

    /*
    Return the products whose price is greater than given price as the method parameter
    */
    List<Product> findByPriceGreaterThan(BigDecimal price);

    /*
    Return the products whose price is less than given price as the method parameter
    */
    List<Product> findByPriceLessThan(BigDecimal price);

    /*
       Return filtered products that match a given text
    */
    List<Product> findByNameContaining(String name);

    /*
       Return products based on SQL like condition
    */
    List<Product> findByNameLike(String name);

    /*
       Return products whose price between start price and end price
    */
    List<Product> findByPriceBetween(BigDecimal startPrice, BigDecimal endPrice);

    /*
       Return products whose price between start date and end date
    */
    List<Product> findByDateCreatedBetween(LocalDateTime startDate, LocalDateTime endDate);

    /*
       Return list of products based on multiple values
    */
    List<Product> findByNameIn(List<String> names);

    List<Product> findFirst2ByOrderByNameAsc();

    List<Product> findTop2ByOrderByPriceDesc();

    //  Define JPQL query using @Query annotation with index and position parameters
    @Query("SELECT p from Product p where p.name = ?1 or p.description = ?2")
    Product findByNameOrDescriptionJPQLIndexParam(String name, String description);

    //  Define JPQL query using @Query annotation with index and named parameters
    @Query("SELECT p from Product p where p.name = :name or p.description = :description")
    Product findByNameOrDescriptionJPQLNamedParam(@Param("name") String name, @Param("description") String description);

    //Define native SQL query using @Query annotation with index or position parameters
    @Query(value = "select * from products p where p.name = ?1 or p.description = ?2", nativeQuery = true)
    Product findByNameOrDescriptionSQLIndexParam(String name, String description);

    //Define native SQL query using @Query annotation with named parameters
    @Query(value = "select * from products p where p.name = :name or p.description = :description", nativeQuery = true)
    Product findByNameOrDescriptionSQLNamedParam(@Param("name") String name,@Param("description") String description);
}
