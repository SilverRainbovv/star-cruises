package com.didenko.starcruises.service;

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

    private final String path = "D:\\Intellij Projects\\star-cruises\\images";

    @SneakyThrows
    public void upload(String imagePath, InputStream content){
        Path fullPath = Path.of(path, imagePath);

        try(content) {
            Files.createDirectories(fullPath.getParent());
            Files.write(fullPath, content.readAllBytes(), CREATE, TRUNCATE_EXISTING);
        }
    }

    @SneakyThrows
    public Optional<byte[]> get(String imagePath){
        Path fullPath = Path.of(path, imagePath);

        return Files.exists(fullPath)
                ? Optional.of(Files.readAllBytes(fullPath))
                : Optional.empty();
    }


}
