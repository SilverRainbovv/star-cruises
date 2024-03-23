package com.didenko.starcruises.repository;

import com.didenko.starcruises.entity.Cruise;
import com.querydsl.core.types.Predicate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CruiseRepository extends JpaRepository<Cruise, Long>,
        QuerydslPredicateExecutor<Cruise> {

    Page<Cruise> findCruiseByShipName(String shipName, Pageable pageable);

    List<Cruise> findAll(Predicate predicate);
}
