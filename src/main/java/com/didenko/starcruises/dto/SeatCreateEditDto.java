package com.didenko.starcruises.dto;

import com.didenko.starcruises.entity.SeatClass;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SeatCreateEditDto implements Serializable {

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
