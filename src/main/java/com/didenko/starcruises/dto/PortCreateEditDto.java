package com.didenko.starcruises.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class PortCreateEditDto {

    private String name;

    private LocalDate visitDate;

}
