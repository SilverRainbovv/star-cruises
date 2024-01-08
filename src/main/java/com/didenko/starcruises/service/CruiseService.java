package com.didenko.starcruises.service;

import com.didenko.starcruises.dto.CruiseCreateEditDto;
import com.didenko.starcruises.dto.CruiseReadDto;
import com.didenko.starcruises.mapper.CruiseCreateEditDtoMapper;
import com.didenko.starcruises.mapper.CruiseReadDtoMapper;
import com.didenko.starcruises.repository.CruiseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class CruiseService {

    private final CruiseRepository cruiseRepository;
    private final CruiseReadDtoMapper mapper;
    private final CruiseCreateEditDtoMapper cruiseCreateEditDtoMapper;

    public List<CruiseReadDto> allCruises(){
        return cruiseRepository.findAll().stream().map(mapper::mapFrom).toList();
    }

    @Transactional(readOnly = false)
    public void save(CruiseCreateEditDto cruiseCreateEditDto){
        cruiseRepository.save(cruiseCreateEditDtoMapper.mapFrom(cruiseCreateEditDto));
    }

    public Optional<CruiseCreateEditDto> findById(Long cruiseId) {
        return cruiseRepository.findById(cruiseId).map(cruiseCreateEditDtoMapper::mapFrom);
    }
}
