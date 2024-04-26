package com.didenko.starcruises.service;

import com.didenko.starcruises.dto.ClientReadDto;
import com.didenko.starcruises.dto.PasswordChangeDto;
import com.didenko.starcruises.entity.Client;
import com.didenko.starcruises.entity.ClientDocument;
import com.didenko.starcruises.entity.ClientDocumentState;
import com.didenko.starcruises.entity.User;
import com.didenko.starcruises.mapper.ClientReadDtoMapper;
import com.didenko.starcruises.repository.ClientRepository;
import com.didenko.starcruises.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class ClientService {

    private final ClientRepository clientRepository;
    private final ClientReadDtoMapper clientReadDtoMapper;
    private final ImageService imageService;
    private final UserRepository userRepository;

    public Optional<ClientReadDto> findClientReadDtoById(Long clientId) {
        return clientRepository.findById(clientId).map(clientReadDtoMapper::mapFrom);
    }

    /**
     * Returns Client entity
     * Used by TicketService to bind ticket to the existing client
     */
    public Optional<Client> findClientEntityById(Long clientId) {
        return clientRepository.findById(clientId);
    }

    @Transactional(readOnly = false)
    public void update(ClientReadDto clientReadDto) {

        if (clientReadDto.getNewDocument().isPresent()) {
            Client client = clientRepository.findById(clientReadDto.getId())
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

            MultipartFile newDocument = clientReadDto.getNewDocument().get();

            if (!newDocument.isEmpty()) {
                ClientDocument clientDocument = ClientDocument.builder()
                        .state(ClientDocumentState.PENDING)
                        .name(newDocument.getOriginalFilename())
                        .build();

                clientDocument.setClient(client);

                uploadDocument(newDocument);
            }

            clientRepository.save(client);
        }
    }

    @SneakyThrows
    public void uploadDocument(MultipartFile document) {
        if (!document.isEmpty()) {
            imageService.uploadClientDocument(document.getOriginalFilename(), document.getInputStream());
        }
    }

    @Transactional(readOnly = false)
    public void tryChangePassword(User user, PasswordChangeDto passwordChangeDto) {
        user.setPassword("{noop}" + passwordChangeDto.getNewPassword());
        userRepository.save(user);
    }
}
