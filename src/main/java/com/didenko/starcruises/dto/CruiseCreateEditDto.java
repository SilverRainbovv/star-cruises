package com.didenko.starcruises.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Data
@Builder
public class CruiseCreateEditDto {

    private Long id;

    public CruiseCreateEditDto(){
        ports = new ArrayList<>();
        ports.add(new PortCreateEditDto());
    }

    private String ship;

    private String description;

    private List<PortCreateEditDto> ports;

    private MultipartFile image;

    public void addPort(PortCreateEditDto portCreateEditDto){
        ports.add(portCreateEditDto);
    }

}
