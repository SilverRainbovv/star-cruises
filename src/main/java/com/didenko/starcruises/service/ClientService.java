package com.didenko.starcruises.service;

import com.didenko.starcruises.dto.ClientReadDto;
import com.didenko.starcruises.entity.Client;
import com.didenko.starcruises.entity.ClientDocument;
import com.didenko.starcruises.mapper.ClientReadDtoMapper;
import com.didenko.starcruises.repository.ClientRepository;
import com.didenko.starcruises.repository.DocumentRepository;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class ClientService {

    private final ClientRepository clientRepository;
    private final ClientReadDtoMapper clientReadDtoMapper;
    private final DocumentRepository documentRepository;
    private final ImageService imageService;

    public Optional<ClientReadDto> findById(Long clientId) {
        return clientRepository.findById(clientId).map(clientReadDtoMapper::mapFrom);
    }

    @Transactional(readOnly = false)
    public void update(ClientReadDto clientReadDto) {
        Client client = clientRepository.findById(clientReadDto.getId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        Client updatedClient = clientReadDtoMapper.mapFrom(clientReadDto);

        List<String> documentsToBeInserted = compareDocuments(client.getDocuments(), updatedClient.getDocuments(), client);

        clientReadDto.getClientDocumentDtos().stream().filter(doc -> documentsToBeInserted.contains(doc.getName()))
                        .forEach(document -> uploadDocument(document.getMultipartFile()));

        clientRepository.save(client);
    }

    private List<String> compareDocuments(List<ClientDocument> oldDocuments, List<ClientDocument> newDocuments, Client client) {
        List<String> oldDocNames = oldDocuments.stream().map(ClientDocument::getName).toList();
        List<String> updatedDocNames = newDocuments.stream().map(ClientDocument::getName).toList();
        List<ClientDocument> toBeRemoved = oldDocuments.stream().filter(doc -> !updatedDocNames.contains(doc.getName())).toList();
        List<ClientDocument> toBeInserted = newDocuments.stream().filter(doc -> !oldDocNames.contains(doc.getName())).toList();

        documentRepository.deleteAll(toBeRemoved);
        client.removeAll(toBeRemoved);
        toBeInserted.forEach(document -> document.setClient(client));

        return toBeInserted.stream().map(ClientDocument::getName).toList();
    }

    @SneakyThrows
    private void uploadDocument(MultipartFile document){
        if (document != null && !document.isEmpty())
            imageService.uploadClientDocument(document.getOriginalFilename(), document.getInputStream());
    }
}