package com.didenko.starcruises.service;

import com.didenko.starcruises.entity.ClientDocument;
import com.didenko.starcruises.repository.DocumentRepository;
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

    private final DocumentRepository documentRepository;

    private final String cruiseImagePath = "D:\\Intellij Projects\\star-cruises\\images";
    private final String clientDocumentPath = "D:\\Intellij Projects\\star-cruises\\client-documents";

    @SneakyThrows
    public void uploadCrusieImage(String imagePath, InputStream content){
        Path fullPath = Path.of(cruiseImagePath, imagePath);

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
    public Optional<byte[]> getClientDocument(String imagePath){
        Path fullPath = Path.of(clientDocumentPath, imagePath);

        return Files.exists(fullPath)
                ? Optional.of(Files.readAllBytes(fullPath))
                : Optional.empty();
    }

    public void deleteClientDocumentById(Long documentId){
        documentRepository.deleteById(documentId);
    }
    @SneakyThrows
    public void deleteClientDocument(ClientDocument document){
        Path fullPath = Path.of(clientDocumentPath, document.getName());
        Files.deleteIfExists(fullPath);
        documentRepository.delete(document);
    }

    public Optional<ClientDocument> findClientDocumentById(Long documentId){
        return documentRepository.findById(documentId);
    }


}
