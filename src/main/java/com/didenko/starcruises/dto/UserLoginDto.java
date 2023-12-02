package com.didenko.starcruises.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class UserLoginDto {

    private final String email;

    private final String password;

}
