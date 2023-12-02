package com.didenko.starcruises.service;

import com.didenko.starcruises.dto.UserLoginDto;
import com.didenko.starcruises.dto.UserReadDto;
import com.didenko.starcruises.entity.Role;
import com.didenko.starcruises.entity.User;
import com.didenko.starcruises.mapper.ClientReadDtoMapper;
import com.didenko.starcruises.mapper.UserReadDtoMapper;
import com.didenko.starcruises.repository.ClientRepository;
import com.didenko.starcruises.repository.LoginRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class LoginService {

    private final LoginRepository loginRepository;
    private final ClientRepository clientRepository;
    private final UserReadDtoMapper userReadDtoMapper;
    private final ClientReadDtoMapper clientReadDtoMapper;

   public Optional<UserReadDto> attemptLogin(UserLoginDto loginDto) {
        Optional<User> maybeUser = loginRepository
                .findUserByEmailAndPassword(loginDto.getEmail(), loginDto.getPassword());

        if (maybeUser.isPresent()) {
            User user = maybeUser.get();

            return user.getRole().equals(Role.ADMIN)
                    ? Optional.of(userReadDtoMapper.mapFrom(user))
                    : clientRepository.findByUserEmail(user.getEmail())
                    .map(clientReadDtoMapper::mapFrom);
        }
        return Optional.empty();
    }
}