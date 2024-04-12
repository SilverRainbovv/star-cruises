package com.didenko.starcruises.dto;

import com.didenko.starcruises.validator.ShipCreateDto;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(exclude = "id")
@AllArgsConstructor
@Data
@Builder
@ShipCreateDto
public class ShipCreateEditDto {

    private Long id;

    @NotBlank
    private String name;

    @NotBlank
    private String previousName;

    public ShipCreateEditDto() {
        seats = new ArrayList<>();
        addSeat(new SeatCreateEditDto());
    }

    private MultipartFile image;

    @Builder.Default
    private List<SeatCreateEditDto> seats = new ArrayList<>();

    public void addSeat(SeatCreateEditDto seatCreateDto){
        this.seats.add(seatCreateDto);
    }

}
