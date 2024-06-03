package com.didenko.starcruises.repository;

import com.didenko.starcruises.entity.Cruise;
import com.didenko.starcruises.entity.CrusieState;
import com.querydsl.core.types.Predicate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CruiseRepository extends JpaRepository<Cruise, Long>,
        QuerydslPredicateExecutor<Cruise> {

    List<Cruise> findAll(Predicate predicate);

    @Modifying
    @Query("update Cruise c set c.state = :cruiseState where c.id = :cruiseId")
    void setStateByCruiseId(Long cruiseId, CrusieState cruiseState);
}