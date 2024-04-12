package com.didenko.starcruises.service;

import com.didenko.starcruises.dto.SeatCreateEditDto;
import com.didenko.starcruises.dto.ShipCreateEditDto;
import com.didenko.starcruises.dto.ShipReadDto;
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
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class ShipService {

    private final ShipCreateEditDtoMapper createEditDoMapper;
    private final ShipReadDtoMapper readDtoMapper;
    private final ShipRepository shipRepository;
    private final SeatService seatService;
    private final ImageService imageService;
    private final SeatRepository seatRepository;

    public Optional<ShipCreateEditDto> findById(Long id){
        Optional<Ship> ship = shipRepository.findById(id);
        return ship.map(createEditDoMapper::mapFrom);
    }

    public List<ShipReadDto> findAll() {
        List<Ship> ships = shipRepository.findAll();
        return ships.stream().map(readDtoMapper::mapFrom).toList();
    }

    @Transactional(readOnly = false)
    public Ship save(ShipCreateEditDto shipCreateEditDto){
        Ship ship;
        Optional<Ship> maybeShip = shipRepository.findByName(shipCreateEditDto.getPreviousName());
        Ship updatedShip = createEditDoMapper.mapFrom(shipCreateEditDto);
        if (maybeShip.isEmpty()){
            ship = Ship.builder()
                    .name(updatedShip.getName())
                    .build();
            updatedShip.getSeats().forEach(seat -> seat.setShip(ship));
            ship.setImage(updatedShip.getImage() == null ? ship.getImage() : updatedShip.getImage());
            uploadImage(shipCreateEditDto.getImage());
            return shipRepository.save(ship);
        } else {
            ship = maybeShip.get();
            ship.setName(updatedShip.getName());
            ship.setImage(updatedShip.getImage() == null ? ship.getImage() : updatedShip.getImage());
            uploadImage(shipCreateEditDto.getImage());
            return shipRepository.save(ship);
        }
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