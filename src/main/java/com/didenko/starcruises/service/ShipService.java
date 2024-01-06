package com.didenko.starcruises.service;

import com.didenko.starcruises.dto.ShipCreateEditDto;
import com.didenko.starcruises.dto.ShipReadDto;
import com.didenko.starcruises.entity.Seat;
import com.didenko.starcruises.entity.Ship;
import com.didenko.starcruises.mapper.ShipCreateEditDtoMapper;
import com.didenko.starcruises.mapper.ShipReadDtoMapper;
import com.didenko.starcruises.repository.SeatRepository;
import com.didenko.starcruises.repository.ShipRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class ShipService {

    private final ShipCreateEditDtoMapper createEditDoMapper;
    private final ShipReadDtoMapper readDtoMapper;
    private final ShipRepository shipRepository;
    private final SeatRepository seatRepository;

    public Optional<ShipCreateEditDto> findById(Long id){
        Optional<Ship> ship = shipRepository.findById(id);
        return ship.map(createEditDoMapper::mapFrom);
    }

    @Transactional(readOnly = false)
    public void save(ShipCreateEditDto shipCreateEditDto){
        Ship ship = shipRepository.findByName(shipCreateEditDto.getPreviousName()).orElse(new Ship());
        Ship updatedShip = createEditDoMapper.mapFrom(shipCreateEditDto);
        ship.setName(ship.getName());
        compareSeats(ship.getSeats(), updatedShip.getSeats(), ship);
//        seats.forEach(seat -> seat.setShip(ship));
        ship.setCruises(updatedShip.getCruises());
        ship.setName(updatedShip.getName());
        shipRepository.save(ship);
    }

    public List<ShipReadDto> findAll() {
        List<Ship> ships = shipRepository.findAll();
        return ships.stream().map(readDtoMapper::mapFrom).toList();
    }

    public void compareSeats (List<Seat> oldSeats, List<Seat> newSeats, Ship ship){
        List<Seat> toBeRemoved = oldSeats.stream().filter(seat -> !newSeats.contains(seat)).toList();
        List<Seat> toBeInserted = newSeats.stream().filter(seat -> !oldSeats.contains(seat)).toList();
//        List<Seat> remainingSeats = newSeats.stream().filter(oldSeats::contains).toList();

        seatRepository.deleteAll(toBeRemoved);
        ship.removeSeats(toBeRemoved);
        toBeInserted.forEach(seat -> seat.setShip(ship));
    }
}
