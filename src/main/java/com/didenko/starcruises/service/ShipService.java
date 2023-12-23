package com.didenko.starcruises.service;

import com.didenko.starcruises.dto.ShipCreateEditDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ShipService {

//    private final ShipCreateEditMapper mapper;

    public ShipCreateEditDto createNewShip(){
        return new ShipCreateEditDto();
    }

}
