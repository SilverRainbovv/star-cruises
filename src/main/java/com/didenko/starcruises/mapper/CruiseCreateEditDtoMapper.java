package com.didenko.starcruises.mapper;

import com.didenko.starcruises.dto.CruiseCreateEditDto;
import com.didenko.starcruises.entity.Cruise;
import com.didenko.starcruises.entity.Ship;
import com.didenko.starcruises.repository.ShipRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
@RequiredArgsConstructor
@Component
public class CruiseCreateEditDtoMapper implements Mapper<CruiseCreateEditDto, Cruise> {

    private final ShipRepository shipRepository;
    private final PortCreateEditDtoMapper portCreateEditDtoMapper;

    @Override
    public Cruise mapFrom(CruiseCreateEditDto cruiseDto) {

        Ship ship = shipRepository.findByName(cruiseDto.getShip());
        Cruise cruise = new Cruise();

        cruiseDto.getPorts().stream().map(portCreateEditDtoMapper::mapFrom)
                .forEach(port -> port.setCruise(cruise));
        cruise.setShip(ship);

        return cruise;
    }
}
