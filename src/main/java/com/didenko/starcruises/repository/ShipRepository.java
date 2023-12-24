package com.didenko.starcruises.repository;

import com.didenko.starcruises.entity.Ship;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShipRepository extends JpaRepository<Ship, Long> {
}
