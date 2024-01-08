package com.didenko.starcruises.dto;

import com.didenko.starcruises.entity.SeatClass;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SeatCreateEditDto {

    private Integer seatGroup;

    private SeatClass seatClass;

    private String seatPrice;

    private Integer firstSeatNumber;

    private Integer lastSeatNumber;

}
