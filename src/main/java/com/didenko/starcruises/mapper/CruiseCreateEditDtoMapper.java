package com.didenko.starcruises.mapper;

import com.didenko.starcruises.dto.CruiseCreateEditDto;
import com.didenko.starcruises.dto.PortCreateEditDto;
import com.didenko.starcruises.entity.Cruise;
import com.didenko.starcruises.entity.Port;
import com.didenko.starcruises.entity.Ship;
import com.didenko.starcruises.repository.ShipRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Component
public class CruiseCreateEditDtoMapper implements Mapper<CruiseCreateEditDto, Cruise> {

    private final ShipRepository shipRepository;
    private final PortCreateEditDtoMapper portCreateEditDtoMapper;

    @Override
    public Cruise mapFrom(CruiseCreateEditDto cruiseDto) {

        Ship ship = shipRepository.findByName(cruiseDto.getShip()).get();
        Cruise cruise = new Cruise();

        Optional.ofNullable(cruiseDto.getImage())
                .filter(file -> !file.isEmpty())
                .ifPresent(image -> cruise.setImage(image.getOriginalFilename()));

        List<Port> ports = cruiseDto.getPorts().stream().map(portCreateEditDtoMapper::mapFrom).toList();
                ports.forEach(port -> port.setCruise(cruise));
        cruise.setShip(ship);
        cruise.setDescription(cruiseDto.getDescription());
        cruise.setFirstPort(ports.stream().min(Comparator.comparing(Port::getVisitDate)).get());
        cruise.setLastPort(ports.stream().max(Comparator.comparing(Port::getVisitDate)).get());
        cruise.setDuration(cruise.getFirstPort().getVisitDate().until(cruise.getLastPort().getVisitDate()).getDays());

        return cruise;
    }

    public CruiseCreateEditDto mapFrom(Cruise cruise){

        List<PortCreateEditDto> ports = cruise.getPorts().stream().map(portCreateEditDtoMapper::mapFrom).toList();

        return CruiseCreateEditDto.builder()
                .id(cruise.getId())
                .description(cruise.getDescription())
                .ship(cruise.getShip().getName())
                .ports(ports)
                .build();
    }
}
