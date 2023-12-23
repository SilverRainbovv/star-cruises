package com.didenko.starcruises.service;

import com.didenko.starcruises.dto.CruiseReadDto;
import com.didenko.starcruises.mapper.CruiseReadDtoMapper;
import com.didenko.starcruises.repository.CruiseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CruiseService {

    private final CruiseRepository cruiseRepository;
    private final CruiseReadDtoMapper mapper;

    public List<CruiseReadDto> allCruises(){
        return cruiseRepository.findAll().stream().map(mapper::mapFrom).toList();
    }


}
