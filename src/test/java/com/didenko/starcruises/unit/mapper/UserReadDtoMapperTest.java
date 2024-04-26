package com.didenko.starcruises.unit.mapper;

import com.didenko.starcruises.dto.UserReadDto;
import com.didenko.starcruises.entity.Role;
import com.didenko.starcruises.entity.User;
import com.didenko.starcruises.mapper.UserReadDtoMapper;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserReadDtoMapperTest {

    private final UserReadDtoMapper mapper = new UserReadDtoMapper();

    private static final User USER = User.builder()
            .id(1L)
            .role(Role.ADMIN)
            .password("very_secure_password")
            .email("email@gmail.com")
            .build();
    private static final UserReadDto USER_READ_DTO_MAPPED = UserReadDto.builder()
            .id(1L)
            .role(Role.ADMIN)
            .email("email@gmail.com")
            .build();

    @Test
    void mapFrom() {
        var result = mapper.mapFrom(USER);

        assertEquals(USER_READ_DTO_MAPPED, result);
    }
}