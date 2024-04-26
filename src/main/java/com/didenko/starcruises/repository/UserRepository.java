package com.didenko.starcruises.repository;

import com.didenko.starcruises.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
