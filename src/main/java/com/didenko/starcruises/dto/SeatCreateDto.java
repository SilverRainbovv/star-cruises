package com.didenko.starcruises.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SeatCreateDto {

    private Integer index;

    private String seatClass;

    private String seatNumber;

    private String seatPrice;

}
