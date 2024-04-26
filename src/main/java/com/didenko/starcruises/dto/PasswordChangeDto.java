package com.didenko.starcruises.dto;

import com.didenko.starcruises.validator.PasswordChangeDtoValidator;
import jakarta.validation.constraints.Min;
import lombok.Data;

@PasswordChangeDtoValidator
@Data
public class PasswordChangeDto {

    private Long userId;

    private String oldPassword;
    @Min(7)
    private String newPassword;
    @Min(7)
    private String repeatNewPassword;

}
