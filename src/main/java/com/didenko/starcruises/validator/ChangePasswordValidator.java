package com.didenko.starcruises.validator;

import com.didenko.starcruises.dto.PasswordChangeDto;
import com.didenko.starcruises.repository.UserRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ChangePasswordValidator implements ConstraintValidator<PasswordChangeDtoValidator, PasswordChangeDto> {

    private final UserRepository userRepository;

    @Override
    public boolean isValid(PasswordChangeDto value, ConstraintValidatorContext context) {
        if (value.getOldPassword().isEmpty() || value.getNewPassword().isEmpty() || value.getRepeatNewPassword().isEmpty())
            return false;

        var user = userRepository.findById(value.getUserId());

        return user.get().getPassword().equals("{noop}" + value.getOldPassword())
                && value.getNewPassword().equals(value.getRepeatNewPassword());
    }
}