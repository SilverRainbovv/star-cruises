package com.didenko.starcruises.service;

import com.didenko.starcruises.entity.Client;
import com.didenko.starcruises.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ClientService {

    private final ClientRepository clientRepository;

    public Optional<Client> findById(Long clientId) {
        return clientRepository.findById(clientId);
    }
}
