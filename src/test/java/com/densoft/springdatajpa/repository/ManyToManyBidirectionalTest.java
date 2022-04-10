package com.densoft.springdatajpa.repository;

import com.densoft.springdatajpa.entity.Role;
import com.densoft.springdatajpa.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
public class ManyToManyBidirectionalTest {

    @Autowired
    private RoleRepository roleRepository;

    @Test
    void saveRole() {
        User user = new User("Dennis", "Githinji", "wakahiad@gmail.com", "password");
        User admin = new User("Admin", "User", "admin@gmail.com", "admin");
        Role roleAdmin = new Role("ROLE_ADMIN");

        roleAdmin.getUsers().addAll(List.of(user, admin));

        user.getRoles().add(roleAdmin);
        admin.getRoles().add(roleAdmin);

        roleRepository.save(roleAdmin);
    }

    @Test
    @Transactional
    void fetchRole() {
        List<Role> roles = roleRepository.findAll();
        roles.forEach(role -> {
            System.out.println(role.getName());
            role.getUsers().forEach(user -> {
                System.out.println(user.getFirstName());
            });
        });
    }
}
