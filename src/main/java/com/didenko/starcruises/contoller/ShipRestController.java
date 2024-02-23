package com.didenko.starcruises.contoller;

import com.didenko.starcruises.service.ShipService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RequiredArgsConstructor
@RequestMapping(("/api/v1/ship"))
@RestController
public class ShipRestController {

    private final ShipService shipService;

    @GetMapping("/image/{shipId}")
    public byte[] findImage(@PathVariable("shipId") Long id){
        return shipService.findShipImage(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }


}
