package com.example.demosemana14.security;

import com.example.demosemana14.dtos.LoginRequestDto;
import com.example.demosemana14.dtos.LoginResponseDto;
import com.example.demosemana14.dtos.RegisterDto;
import com.example.demosemana14.dtos.UserDto;
import com.example.demosemana14.models.User;
import com.example.demosemana14.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AuthenticationService {
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    UserRepository userRepository;
    @Autowired
    TokenService tokenService;

    @Transactional(readOnly = true)
    public LoginResponseDto login(LoginRequestDto loginRequestDto) throws AuthenticationException{
        Authentication usernamePassword = new UsernamePasswordAuthenticationToken(
            loginRequestDto.username(),
            loginRequestDto.password()
        );
        Authentication auth = authenticationManager.authenticate(usernamePassword);
        User user = (User) auth.getPrincipal();
        String token = tokenService.generateToken(user.getUsername());
        return new LoginResponseDto(token);
    }

    @Transactional
    public UserDto register(RegisterDto registerDto) {
        User user = new User();
        user.setUsername(registerDto.username());
        user.setEmail(registerDto.email());
        user.setPassword(new BCryptPasswordEncoder().encode(registerDto.password()));
        User savedUser = userRepository.save(user);
        return new UserDto(savedUser.getUsername(), savedUser.getEmail());
    }
}
