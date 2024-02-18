package com.didenko.starcruises.dto;

import com.didenko.starcruises.validator.ShipCreateDto;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Data
@Builder
@ShipCreateDto
public class ShipCreateEditDto {

    @NotBlank
    private String name;

    @NotBlank
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
