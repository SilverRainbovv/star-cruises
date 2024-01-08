package com.didenko.starcruises.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Data
@Builder
public class CruiseCreateEditDto {

    public CruiseCreateEditDto(){
        ports = new ArrayList<>();
        ports.add(new PortCreateEditDto());
    }

    private String ship;

    private String description;

    private List<PortCreateEditDto> ports;

    public void addPort(PortCreateEditDto portCreateEditDto){
        ports.add(portCreateEditDto);
    }

}
