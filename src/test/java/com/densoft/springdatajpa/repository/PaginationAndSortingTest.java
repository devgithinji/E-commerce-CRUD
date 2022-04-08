package com.densoft.springdatajpa.repository;

import com.densoft.springdatajpa.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

@SpringBootTest
public class PaginationAndSortingTest {
    @Autowired
    private ProductRepository productRepository;

    @Test
    void pagination() {
        int pageNo = 0;
        int pageSize = 5;

        //create pageable object
        Pageable pageable = PageRequest.of(pageNo, pageSize);

        //findAll method and pass pageable instance
        Page<Product> page = productRepository.findAll(pageable);

        List<Product> products = page.getContent();

        products.forEach(System.out::println);

        //total pages
        int totalPages = page.getTotalPages();
        System.out.println("Total pages " + totalPages);
        //total elements
        long totalElements = page.getTotalElements();
        System.out.println("Total Elements " + totalElements);
        //number of elements
        int numberOfElements = page.getNumberOfElements();
        System.out.println("Number of elements " + numberOfElements);
        //size
        int size = page.getSize();
        System.out.println("Size " + size);
        //last
        boolean isLast = page.isLast();
        System.out.println("Is Last " + isLast);
        //first
        boolean isFirst = page.isFirst();
        System.out.println("Is First " + isFirst);
        //page No
        int currentPageNumber = page.getNumber();
        System.out.println("Current Page Number " + currentPageNumber);
    }

    @Test
    void sorting() {
        String sortBy = "price";
        String sortDir = "desc";

        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();

        List<Product> products = productRepository.findAll(sort);
        products.forEach(System.out::println);
    }

    @Test
    void sortByMultipleFields() {
        String sortBy = "name";
        String sortByDesc = "description";
        String sortDir = "desc";

        Sort sortByName = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
        Sort sortByDescription = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortByDesc).ascending() : Sort.by(sortByDesc).descending();

        Sort sortByGroup = sortByName.and(sortByDescription);
        List<Product> products = productRepository.findAll(sortByGroup);
        products.forEach(System.out::println);
    }

    @Test
    void paginationAndSortingTogether() {
        String sortBy = "price";
        String sortDir = "desc";

        int pageNo = 1;
        int pageSize = 5;

        //sort object
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();

        //pageable object
        Pageable pageable = PageRequest.of(pageNo, pageSize, sort);
        Page<Product> page = productRepository.findAll(pageable);

        List<Product> products = page.getContent();
        products.forEach(System.out::println);


        //total pages
        int totalPages = page.getTotalPages();
        System.out.println("Total pages " + totalPages);
        //total elements
        long totalElements = page.getTotalElements();
        System.out.println("Total Elements " + totalElements);
        //number of elements
        int numberOfElements = page.getNumberOfElements();
        System.out.println("Number of elements " + numberOfElements);
        //size
        int size = page.getSize();
        System.out.println("Size " + size);
        //last
        boolean isLast = page.isLast();
        System.out.println("Is Last " + isLast);
        //first
        boolean isFirst = page.isFirst();
        System.out.println("Is First " + isFirst);
        //page No
        int currentPageNumber = page.getNumber();
        System.out.println("Current Page Number " + currentPageNumber);

    }

}
