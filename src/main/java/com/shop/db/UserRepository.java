package com.shop.db;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shop.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
