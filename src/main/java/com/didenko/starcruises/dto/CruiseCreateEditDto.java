package com.didenko.starcruises.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(exclude = "ports")
@AllArgsConstructor
@Data
@Builder
public class CruiseCreateEditDto {

    private Long id;

    public CruiseCreateEditDto(){
        ports = new ArrayList<>();
        ports.add(new PortCreateEditDto());
    }

    @NotEmpty
    private String ship;

    @NotBlank
    private String description;

    @Size(min = 2)
    private List<PortCreateEditDto> ports;

    private MultipartFile image;

    private String cruiseState;

    public void addPort(PortCreateEditDto portCreateEditDto){
        ports.add(portCreateEditDto);
    }
}
