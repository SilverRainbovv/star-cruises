package com.didenko.starcruises.service;

import com.didenko.starcruises.entity.ClientDocument;
import com.didenko.starcruises.entity.ClientDocumentState;
import com.didenko.starcruises.repository.ClientDocumentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ClientDocumentService {

    private final ClientDocumentRepository clientDocumentRepository;
    private final ImageService imageService;

    public List<ClientDocument> findAllDocumentsByState(ClientDocumentState state) {
        return clientDocumentRepository.findAllByState(state);
    }

    public void changeDocumentState(String state, Long documentId){

        Optional<ClientDocument> clientDocument = imageService.findClientDocumentById(documentId);
        if (clientDocument.isEmpty()) throw new ResponseStatusException(HttpStatus.NOT_FOUND);

        ClientDocumentState newState = switch (state) {
            case "reject" -> ClientDocumentState.REJECTED;
            case "approve" -> ClientDocumentState.APPROVED;
            default -> clientDocument.get().getState();
        };

        clientDocument.get().setState(newState);
        clientDocumentRepository.save(clientDocument.get());
    }
}
