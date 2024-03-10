package com.didenko.starcruises.repository;

import com.didenko.starcruises.entity.Cruise;
import com.didenko.starcruises.entity.SearchOptions;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CruiseRepository extends JpaRepository<Cruise, Long> {

    List<Cruise> findCruiseByShipName(String shipName);

}
