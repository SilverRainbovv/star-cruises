package com.didenko.starcruises.service;

import com.didenko.starcruises.dto.ClientCreateEditDto;
import com.didenko.starcruises.entity.Client;
import com.didenko.starcruises.mapper.ClientCreateEditDtoMapper;
import com.didenko.starcruises.repository.ClientRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Transactional
@RequiredArgsConstructor
@Service
public class RegistrationService {

    private final ClientCreateEditDtoMapper mapper;
    private final ClientRepository clientRepository;

    public void register(ClientCreateEditDto clientDto){

        Client client = mapper.mapFrom(clientDto);
        clientRepository.save(client);
    }


}
