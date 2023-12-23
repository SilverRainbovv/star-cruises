package com.didenko.starcruises.repository;

import com.didenko.starcruises.entity.Cruise;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CruiseRepository extends JpaRepository<Cruise, Long> {

}
