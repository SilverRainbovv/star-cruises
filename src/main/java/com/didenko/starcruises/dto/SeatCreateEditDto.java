package com.didenko.starcruises.dto;

import com.didenko.starcruises.entity.SeatClass;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SeatCreateEditDto {

    @NotEmpty
    private Integer seatGroup;

    private SeatClass seatClass;

    @Positive
    private String seatPrice;

    @Positive
    private Integer firstSeatNumber;

    @Positive
    private Integer lastSeatNumber;

    @Positive
    private Integer numberOfPersons;

}
