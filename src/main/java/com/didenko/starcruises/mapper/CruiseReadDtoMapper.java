package com.didenko.starcruises.mapper;

import com.didenko.starcruises.dto.CruiseReadDto;
import com.didenko.starcruises.entity.Cruise;
import com.didenko.starcruises.entity.Port;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CruiseReadDtoMapper implements Mapper<Cruise, CruiseReadDto> {

    @Override
    public CruiseReadDto mapFrom(Cruise object) {
        List< Port> ports = object.getPorts();
        ports.sort(Comparator.comparing(Port::getVisitDate));
        Port firstPort = ports.remove(0);
        Port lastPort = ports.remove(ports.size() - 1);

        return CruiseReadDto.builder()
                .id(object.getId())
                .shipName(object.getShip().getName())
                .firstPort(firstPort.getName())
                .lastPort(lastPort.getName())
                .firstPortDate(firstPort.getVisitDate())
                .lastPortDate(lastPort.getVisitDate())
                .intermediatePorts(ports.stream().map(Port::getName).collect(Collectors.joining(" ")))
                .build();
    }
}
