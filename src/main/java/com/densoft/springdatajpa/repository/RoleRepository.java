package com.densoft.springdatajpa.repository;

import com.densoft.springdatajpa.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
