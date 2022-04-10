package com.densoft.springdatajpa.repository;

import com.densoft.springdatajpa.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
