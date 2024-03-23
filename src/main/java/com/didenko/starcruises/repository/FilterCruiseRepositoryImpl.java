package com.didenko.starcruises.repository;

import com.didenko.starcruises.entity.Cruise;
import com.didenko.starcruises.querydsl.CruiseFilter;
import com.didenko.starcruises.querydsl.QPredicates;
import com.querydsl.jpa.impl.JPAQuery;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.didenko.starcruises.entity.QCruise.*;

@Repository
@RequiredArgsConstructor
public class FilterCruiseRepositoryImpl {

    private final EntityManager entityManager;

    public List<Cruise> findAllByFilter(CruiseFilter filter) {

        var predicates = QPredicates.builder()
                .add(filter.shipName(), cruise.ship.name::containsIgnoreCase)
                .add(filter.departureDate(), cruise.firstPort.visitDate::after)
                .add(filter.departurePort(), cruise.firstPort.name::containsIgnoreCase)
                .add(filter.duration(), dur -> cruise.duration.between(dur.minNights, dur.maxNights))
                .build();

        return new JPAQuery<Cruise>(entityManager)
                .select(cruise)
                .from(cruise)
                .where(predicates)
                .fetch();
    }

}
