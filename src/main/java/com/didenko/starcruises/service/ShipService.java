package com.didenko.starcruises.service;

import com.didenko.starcruises.dto.ShipCreateEditDto;
import com.didenko.starcruises.dto.ShipReadDto;
import com.didenko.starcruises.entity.Ship;
import com.didenko.starcruises.mapper.ShipCreateEditMapper;
import com.didenko.starcruises.mapper.ShipReadDtoMapper;
import com.didenko.starcruises.repository.ShipRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class ShipService {

    private final ShipCreateEditMapper createEditDoMapper;
    private final ShipReadDtoMapper readDtoMapper;
    private final ShipRepository shipRepository;

    @Transactional(readOnly = false)
    public void save(ShipCreateEditDto shipCreateEditDto){
        shipRepository.save(createEditDoMapper.mapFrom(shipCreateEditDto));
        System.out.println();
    }

    public List<ShipReadDto> findAll() {
        List<Ship> ships = shipRepository.findAll();
        return ships.stream().map(readDtoMapper::mapFrom).toList();
    }
}
