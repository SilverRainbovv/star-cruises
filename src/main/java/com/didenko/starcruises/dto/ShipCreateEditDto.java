package com.didenko.starcruises.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import java.util.ArrayList;
import java.util.List;
@AllArgsConstructor
@Data
@Builder
public class ShipCreateEditDto {

    private String name;

    public ShipCreateEditDto() {
        seats = new ArrayList<>();
        addSeat(new SeatCreateDto());
    }

    @Builder.Default
    private List<SeatCreateDto> seats = new ArrayList<>();

    public void addSeat(SeatCreateDto seatCreateDto){
        this.seats.add(seatCreateDto);
    }

}
