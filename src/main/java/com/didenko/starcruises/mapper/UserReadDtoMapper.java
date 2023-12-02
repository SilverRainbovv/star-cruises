package com.didenko.starcruises.mapper;

import com.didenko.starcruises.dto.UserReadDto;
import com.didenko.starcruises.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserReadDtoMapper implements Mapper<User, UserReadDto> {
    @Override
    public UserReadDto mapFrom(User object) {
        return new UserReadDto(
                object.getId(),
                object.getEmail(),
                object.getRole()
        );
    }
}
