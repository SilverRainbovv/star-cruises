package com.didenko.starcruises.dto;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class PortCreateEditDto {

    private Long id;

    @NotBlank
    private String name;

    @Future
    private String visitDate;

}
