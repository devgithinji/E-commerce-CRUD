package com.densoft.springdatajpa.repository;

import com.densoft.springdatajpa.entity.Role;
import com.densoft.springdatajpa.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class ManyToManyUnidirectionalTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    void saveUser() {
        User user = new User("Dennis", "Githinji", "wakahiad@gmail.com", "password");
        Role admin = new Role("ROLE_ADMIN");
        Role customer = new Role("ROLE_CUSTOMER");

        user.getRoles().addAll(List.of(admin, customer));

        userRepository.save(user);
    }

    @Test
    void updateUser() {
        User user = userRepository.findById(1L).get();
        user.setFirstName("testusr");
        user.setEmail("testusr@gmail.com");

        user.getRoles().add(new Role("ROLE_USER"));

        userRepository.save(user);
    }

    @Test
    void fetchUser() {
        User user = userRepository.findById(1L).get();
        System.out.println(user);
    }

    @Test
    void deleteUser() {
        userRepository.deleteById(1L);
    }

}
