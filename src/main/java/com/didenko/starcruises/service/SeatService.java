package com.didenko.starcruises.service;

import com.didenko.starcruises.dto.SeatReadDto;
import com.didenko.starcruises.entity.Seat;
import com.didenko.starcruises.mapper.SeatReadDtoMapper;
import com.didenko.starcruises.repository.SeatRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class SeatService {

    private final SeatRepository seatRepository;
    private final SeatReadDtoMapper mapper;

    public List<SeatReadDto> findSeatsByCruiseId(Long cruiseId){

        List<Seat> seats = seatRepository.findAllByCruiseId(cruiseId);

        return mapper.mapFrom(seats);
    }

    public Optional<Seat> findVacantSeatByShipIdAndSeatGroup(Long shipId, Integer seatGroup) {
        return seatRepository.findFirstByShipIdAndSeatGroup(shipId, seatGroup);
    }

    @Transactional(readOnly = false)
    public void removeSeatsByIds(List<Long> seatIds){
        seatRepository.deleteAllByIdInBatch(seatIds);
    }
}
