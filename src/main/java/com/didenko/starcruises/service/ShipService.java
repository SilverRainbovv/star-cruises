package com.didenko.starcruises.service;

import com.didenko.starcruises.dto.ShipCreateEditDto;
import com.didenko.starcruises.dto.ShipReadDto;
import com.didenko.starcruises.entity.Cruise;
import com.didenko.starcruises.entity.Seat;
import com.didenko.starcruises.entity.Ship;
import com.didenko.starcruises.mapper.ShipCreateEditDtoMapper;
import com.didenko.starcruises.mapper.ShipReadDtoMapper;
import com.didenko.starcruises.repository.SeatRepository;
import com.didenko.starcruises.repository.ShipRepository;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

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
    private final ImageService imageService;

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
        ship.setCruises(updatedShip.getCruises());
        ship.setName(updatedShip.getName());
        ship.setImage(updatedShip.getImage() == null ? ship.getImage() : updatedShip.getImage());

        uploadImage(shipCreateEditDto.getImage());

        shipRepository.save(ship);
    }

    public List<ShipReadDto> findAll() {
        List<Ship> ships = shipRepository.findAll();
        return ships.stream().map(readDtoMapper::mapFrom).toList();
    }

    public void compareSeats (List<Seat> oldSeats, List<Seat> newSeats, Ship ship){
        List<Seat> toBeRemoved = oldSeats.stream().filter(seat -> !newSeats.contains(seat)).toList();
        List<Seat> toBeInserted = newSeats.stream().filter(seat -> !oldSeats.contains(seat)).toList();

        seatRepository.deleteAll(toBeRemoved);
        ship.removeSeats(toBeRemoved);
        toBeInserted.forEach(seat -> seat.setShip(ship));
    }

    public Optional<byte[]> findShipImage(Long id){
        return shipRepository.findById(id)
                .map(Ship::getImage)
                .filter(StringUtils::hasText)
                .flatMap(imageService::getShipImage);
    }

    @SneakyThrows
    private void uploadImage(MultipartFile image) {
        if (image != null && !image.isEmpty())
            imageService.uploadShipImage(image.getOriginalFilename(), image.getInputStream());
    }

}
