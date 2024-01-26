package com.didenko.starcruises.repository;

import com.didenko.starcruises.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LoginRepository extends JpaRepository<User, Long> {

    Optional<User> findUserByEmailAndPassword(String email, String password);

    Optional<User> findByEmail(String email);

}
