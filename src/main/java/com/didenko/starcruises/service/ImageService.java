package com.didenko.starcruises.service;

import com.didenko.starcruises.entity.ClientDocument;
import com.didenko.starcruises.repository.ClientDocumentRepository;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Optional;

import static java.nio.file.StandardOpenOption.*;

@RequiredArgsConstructor
@Service
public class ImageService {

    private final ClientDocumentRepository clientDocumentRepository;

    private final String cruiseImagePath = "E:\\Programming\\Intellij Projects\\star-cruises\\images\\cruise-images";
    private final String clientDocumentPath = "E:\\Programming\\Intellij Projects\\star-cruises\\images\\client-documents";
    private final String shipImagePath = "E:\\Programming\\Intellij Projects\\star-cruises\\images\\ship-images";

    @SneakyThrows
    public void uploadCrusieImage(String imagePath, InputStream content){
        Path fullPath = Path.of(cruiseImagePath, imagePath);

        try(content) {
            Files.createDirectories(fullPath.getParent());
            Files.write(fullPath, content.readAllBytes(), CREATE, TRUNCATE_EXISTING);
        }
    }

    @SneakyThrows
    public void uploadShipImage(String imagePath, InputStream content){
        Path fullPath = Path.of(shipImagePath, imagePath);

        try(content) {
            Files.createDirectories(fullPath.getParent());
            Files.write(fullPath, content.readAllBytes(), CREATE, TRUNCATE_EXISTING);
        }
    }

    @SneakyThrows
    public void uploadClientDocument(String imagePath, InputStream content){
        Path fullPath = Path.of(clientDocumentPath, imagePath);

        try(content) {
            Files.createDirectories(fullPath.getParent());
            Files.write(fullPath, content.readAllBytes(), CREATE, TRUNCATE_EXISTING);
        }
    }

    @SneakyThrows
    public Optional<byte[]> getCruiseImage(String imagePath){
        Path fullPath = Path.of(cruiseImagePath, imagePath);

        return Files.exists(fullPath)
                ? Optional.of(Files.readAllBytes(fullPath))
                : Optional.empty();
    }

    @SneakyThrows
    public Optional<byte[]> getShipImage(String imagePath){
        Path fullPath = Path.of(shipImagePath, imagePath);

        return Files.exists(fullPath)
                ? Optional.of(Files.readAllBytes(fullPath))
                : Optional.empty();
    }

    @SneakyThrows
    public Optional<byte[]> getClientDocument(String imagePath){
        Path fullPath = Path.of(clientDocumentPath, imagePath);

        return Files.exists(fullPath)
                ? Optional.of(Files.readAllBytes(fullPath))
                : Optional.empty();
    }

    public void deleteClientDocumentById(Long documentId){
        clientDocumentRepository.deleteById(documentId);
    }
    @SneakyThrows
    public void deleteClientDocument(ClientDocument document){
        Path fullPath = Path.of(clientDocumentPath, document.getName());
        Files.deleteIfExists(fullPath);
        clientDocumentRepository.delete(document);
    }

    public Optional<ClientDocument> findClientDocumentById(Long documentId){
        return clientDocumentRepository.findById(documentId);
    }

    public Optional<byte[]> getClientDocumentById(Long documentId){
        return clientDocumentRepository.findById(documentId)
                .map(ClientDocument::getName)
                .flatMap(this::getClientDocument);
    }


}
