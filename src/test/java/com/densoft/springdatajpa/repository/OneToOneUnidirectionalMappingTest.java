package com.densoft.springdatajpa.repository;

import com.densoft.springdatajpa.entity.Address;
import com.densoft.springdatajpa.entity.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

@SpringBootTest
public class OneToOneUnidirectionalMappingTest {

    @Autowired
    private OrderRepository orderRepository;

    @Test
    void saveOrderMethod() {
        Order order = new Order();
        order.setOrderTrackingNumber("100ABC");
        order.setTotalQuantity(5);
        order.setStatus("IN PROGRESS");
        order.setTotalPrice(new BigDecimal(1000));

        Address address = new Address();
        address.setCity("Nairobi");
        address.setStreet("Limuru");
        address.setState("Kiambu");
        address.setCountry("Kenya");
        address.setZipCode("411047");
        order.setBillingAddress(address);

        orderRepository.save(order);
    }

    @Test
    void getOrder() {
        Order order = orderRepository.findById(2L).get();
        System.out.println(order);
    }


    @Test
    void updateOrderMethod() {
        Order order = orderRepository.findById(2L).get();
        order.setStatus("DELIVERED");
        order.getBillingAddress().setZipCode("411048");
        orderRepository.save(order);
    }

    @Test
    void deleteOrderMethod() {
        orderRepository.deleteById(1L);
    }
}
