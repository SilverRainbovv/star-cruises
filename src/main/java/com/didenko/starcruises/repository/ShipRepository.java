package com.didenko.starcruises.repository;

import com.didenko.starcruises.entity.Ship;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ShipRepository extends JpaRepository<Ship, Long>, CrudRepository<Ship, Long> {

    Optional<Ship> findByName(String name);

}
