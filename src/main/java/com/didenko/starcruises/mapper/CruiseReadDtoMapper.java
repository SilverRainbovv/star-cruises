package com.didenko.starcruises.mapper;

import com.didenko.starcruises.dto.CruiseReadDto;
import com.didenko.starcruises.entity.Cruise;
import com.didenko.starcruises.entity.Port;
import com.didenko.starcruises.entity.Seat;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
public class CruiseReadDtoMapper implements Mapper<Cruise, CruiseReadDto> {

    @Override
    public CruiseReadDto mapFrom(Cruise object) {

        Port firstPort;
        Port lastPort;
        Optional<Object> lowestPrice = object.getShip().getSeats().stream()
                .map(Seat::getPrice).min(BigDecimal::compareTo)
                .map(BigDecimal::toString);

        List<Port> ports = object.getPorts();
        ports.sort(Comparator.comparing(Port::getVisitDate));
        firstPort = ports.remove(0);
        lastPort = ports.get(ports.size() - 1);

        return CruiseReadDto.builder()
                .id(object.getId())
                .description(object.getDescription())
                .shipName(object.getShip().getName())
                .duration(firstPort.getVisitDate().until(lastPort.getVisitDate()).getDays())
                .firstPort(firstPort.getName())
                .lastPort(lastPort.getName())
                .firstPortDate(firstPort.getVisitDate())
                .lastPortDate(lastPort.getVisitDate())
                .intermediatePorts(ports.stream().map(Port::getName).collect(Collectors.joining(", ")))
                .startingPrice(lowestPrice.get().toString())
                .image(object.getImage())
                .build();
    }
}
