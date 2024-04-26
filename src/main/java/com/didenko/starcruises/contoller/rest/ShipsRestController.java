package com.didenko.starcruises.contoller.rest;

import com.didenko.starcruises.dto.ShipReadDto;
import com.didenko.starcruises.service.ShipService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/api/v1/ships")
@RestController
public class ShipsRestController {

    private final ShipService shipService;

//    @Cacheable("ships")
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ShipReadDto> shipsPage(){

        return shipService.findAll();
    }

}
