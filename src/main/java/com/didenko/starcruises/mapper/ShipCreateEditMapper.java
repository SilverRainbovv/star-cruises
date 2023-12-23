//package com.didenko.starcruises.mapper;
//
//import com.didenko.starcruises.dto.ShipCreateEditDto;
//import com.didenko.starcruises.entity.Seat;
//import com.didenko.starcruises.entity.SeatClass;
//import com.didenko.starcruises.entity.Ship;
//import com.didenko.starcruises.entity.Vacancy;
//
//import java.math.BigDecimal;
//import java.util.ArrayList;
//import java.util.List;
//
//public class ShipCreateEditMapper implements Mapper<ShipCreateEditDto, Ship> {
//    @Override
//    public Ship mapFrom(ShipCreateEditDto shipDto) {
//
//        Ship ship = Ship.builder()
//                .name(shipDto.getName())
//                .build();
//
//        List<Seat> seats = new ArrayList<>();
//        int totalSeats = 0;
//
//        int interiorSeats = shipDto.getInteriorSeatNumber();
//        if (interiorSeats > 0) {
//            seats.addAll(createSeats(totalSeats, interiorSeats, SeatClass.INTERIOR, ship, shipDto.getInteriorSeatPrice()));
//        }
//        int
//
//
//        return null;
//    }
//
//    List<Seat> createSeats(int startNumber, int seatsQuantity, SeatClass seatClass, Ship ship, BigDecimal seatPrice){
//        List<Seat> seats = new ArrayList<>();
//        for (int i = startNumber; i <= seatsQuantity + startNumber; i++) {
//            seats.add(Seat.builder()
//                    .ship(ship)
//                    .price(seatPrice)
//                    .number(Integer.toString(i))
//                    .vacancy(Vacancy.VACANT)
//                    .seatClass(seatClass)
//                    .build());
//        }
//        return seats;
//    }
//
//}
