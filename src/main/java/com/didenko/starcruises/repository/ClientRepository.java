package com.didenko.starcruises.repository;

import com.didenko.starcruises.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

    Optional<Client> findByUserEmail(String email);

    @Query("select clients from Client clients " +
            "join clients.tickets tickets  " +
            "where tickets.cruise.id = :cruiseId")
    Set<Client> findAllByTicketsWhereCruiseId(Long cruiseId);

}
