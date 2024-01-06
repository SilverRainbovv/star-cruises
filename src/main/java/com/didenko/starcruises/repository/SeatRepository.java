package com.didenko.starcruises.repository;

import com.didenko.starcruises.entity.Seat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeatRepository extends JpaRepository<Seat, Long> {
}
