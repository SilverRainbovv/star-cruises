package com.didenko.starcruises.repository;

import com.didenko.starcruises.entity.Seat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface SeatRepository extends JpaRepository<Seat, Long> {
    List<Seat> findAllByShipId(Long id);

    @Query("select seats from Seat seats " +
            "join seats.ship ship " +
            "where ship.id = (select shi.id from Cruise c " +
            "join c.ship shi where c.id = :cruiseId)")
    List<Seat> findAllByCruiseId(Long cruiseId);

    Optional<Seat> findFirstByShipIdAndSeatGroup(Long shipId, Integer seatGroup);}
