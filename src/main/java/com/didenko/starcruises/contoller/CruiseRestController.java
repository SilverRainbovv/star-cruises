package com.didenko.starcruises.contoller;

import com.didenko.starcruises.service.CruiseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RequiredArgsConstructor
@RequestMapping("/api/v1/cruises")
@RestController
public class CruiseRestController {

    private final CruiseService cruiseService;

    @GetMapping("/image/{cruiseId}")
    public byte[] findImage(@PathVariable("cruiseId") Long id){
        return cruiseService.findCruiseImage(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

}
