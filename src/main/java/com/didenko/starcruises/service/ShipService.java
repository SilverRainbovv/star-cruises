package com.didenko.starcruises.service;

import com.didenko.starcruises.dto.ShipCreateEditDto;
import com.didenko.starcruises.mapper.ShipCreateEditMapper;
import com.didenko.starcruises.repository.ShipRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@RequiredArgsConstructor
@Service
public class ShipService {

    private final ShipCreateEditMapper mapper;
    private final ShipRepository shipRepository;

    @Transactional(readOnly = false)
    public void save(ShipCreateEditDto shipCreateEditDto){
        shipRepository.save(mapper.mapFrom(shipCreateEditDto));
        System.out.println();
    }

}
