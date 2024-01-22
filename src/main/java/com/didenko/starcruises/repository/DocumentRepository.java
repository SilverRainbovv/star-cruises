package com.didenko.starcruises.repository;

import com.didenko.starcruises.entity.ClientDocument;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocumentRepository extends JpaRepository<ClientDocument, Long> {
}
