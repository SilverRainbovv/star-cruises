package com.didenko.starcruises.validator;


import com.didenko.starcruises.dto.ShipCreateEditDto;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ShipCreateEditDtoValidator implements ConstraintValidator<ShipCreateDto,
        ShipCreateEditDto> {

    @Override
    public boolean isValid(ShipCreateEditDto ship, ConstraintValidatorContext context) {
        return ship.getSeats().stream().noneMatch(seat -> seat.getLastSeatNumber() < seat.getFirstSeatNumber());
    }
}
