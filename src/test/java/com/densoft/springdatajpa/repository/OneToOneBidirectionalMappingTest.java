package com.densoft.springdatajpa.repository;

import com.densoft.springdatajpa.entity.Address;
import com.densoft.springdatajpa.entity.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

@SpringBootTest
public class OneToOneBidirectionalMappingTest {

    @Autowired
    private AddressRepository addressRepository;

    @Test
    void saveAddressMethod() {
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
        address.setOrder(order);

        addressRepository.save(address);
    }

    @Test
    void updateAddressMethod() {
        Address address = addressRepository.findById(1L).get();
        address.setZipCode("411048");

        address.getOrder().setStatus("DELIVERED");
        addressRepository.save(address);

    }

    @Test
    void fetchAddressMethod() {
        Address address = addressRepository.findById(1L).get();
    }

    @Test
    void deleteAddressMethod() {
        addressRepository.deleteById(1L);
    }
}
