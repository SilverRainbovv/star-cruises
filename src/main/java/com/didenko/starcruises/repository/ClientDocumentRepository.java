package com.didenko.starcruises.repository;

import com.didenko.starcruises.entity.ClientDocument;
import com.didenko.starcruises.entity.ClientDocumentState;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClientDocumentRepository extends JpaRepository<ClientDocument, Long> {

    public List<ClientDocument> findAllByState(ClientDocumentState state);

}
