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

    private String previousName;

    public ShipCreateEditDto() {
        seats = new ArrayList<>();
        addSeat(new SeatCreateEditDto());
    }

    @Builder.Default
    private List<SeatCreateEditDto> seats = new ArrayList<>();

    public void addSeat(SeatCreateEditDto seatCreateDto){
        this.seats.add(seatCreateDto);
    }

}
