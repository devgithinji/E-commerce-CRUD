package com.densoft.springdatajpa.repository;

import com.densoft.springdatajpa.entity.Address;
import com.densoft.springdatajpa.entity.Order;
import com.densoft.springdatajpa.entity.OrderItem;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

@SpringBootTest
public class OneToManyMappingTest {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private ProductRepository productRepository;

    //save order along with its order items
    @Test
    void saveOrderMethod() {
        Order order = new Order();
        order.setOrderTrackingNumber("100ABC");
        order.setStatus("In Progress");


        //create order item one
        OrderItem orderItemOne = new OrderItem();
        orderItemOne.setProduct(productRepository.findById(1L).get());
        orderItemOne.setQuantity(2);
        orderItemOne.setPrice(orderItemOne.getProduct().getPrice().multiply(new BigDecimal(2)));
        orderItemOne.setOrder(order);
        order.getOrderItems().add(orderItemOne);

        //create order item two
        OrderItem orderItemTwo = new OrderItem();
        orderItemTwo.setProduct(productRepository.findById(2L).get());
        orderItemTwo.setQuantity(3);
        orderItemTwo.setPrice(orderItemTwo.getProduct().getPrice().multiply(new BigDecimal(2)));
        order.getOrderItems().add(orderItemTwo);
        orderItemTwo.setOrder(order);

        order.setTotalPrice(order.getTotalAmount());
        order.setTotalQuantity(2);

        Address address = new Address();
        address.setCity("Nairobi");
        address.setStreet("Limuru");
        address.setState("Kiambu");
        address.setCountry("Kenya");
        address.setZipCode("411047");

        order.setBillingAddress(address);
        address.setOrder(order);

        orderRepository.save(order);
    }

    @Test
    void fetchOrderMethod() {
        Order order = orderRepository.findById(1L).get();
        System.out.println(order);
    }

    @Test
    void deleteOrderMethod() {
        orderRepository.deleteById(1L);
    }
}
