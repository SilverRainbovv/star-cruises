package com.didenko.starcruises.validator;

import com.didenko.starcruises.dto.ClientCreateEditDto;
import com.didenko.starcruises.repository.ClientRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;

@RequiredArgsConstructor
public class ClientValidator implements ConstraintValidator<Client, ClientCreateEditDto> {

    private final ClientRepository repository;

    @Override
    public boolean isValid(ClientCreateEditDto client, ConstraintValidatorContext context) {
        return repository.findByUserEmail(client.getEmail()).isEmpty()
                && client.getBirthdate().isAfter(LocalDate.of(1900, 1, 1));
    }
}
