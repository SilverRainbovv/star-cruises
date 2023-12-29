package com.didenko.starcruises.dto;

import lombok.Data;
import java.util.ArrayList;
import java.util.List;

@Data
public class CruiseCreateEditDto {

    public CruiseCreateEditDto(){
        ports = new ArrayList<>();
        ports.add(new PortCreateEditDto());
    }

    private String ship;

    private List<PortCreateEditDto> ports;

    public void addPort(PortCreateEditDto portCreateEditDto){
        ports.add(portCreateEditDto);
    }

}
