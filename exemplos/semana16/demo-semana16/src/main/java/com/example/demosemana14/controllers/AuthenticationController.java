package com.example.demosemana14.controllers;

import com.example.demosemana14.dtos.LoginRequestDto;
import com.example.demosemana14.dtos.LoginResponseDto;
import com.example.demosemana14.dtos.RegisterDto;
import com.example.demosemana14.dtos.UserDto;
import com.example.demosemana14.security.AuthenticationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {
    @Autowired
    AuthenticationService authenticationService;

    @PostMapping("/login")
    @ResponseStatus(HttpStatus.OK)
    public LoginResponseDto login(@RequestBody @Valid LoginRequestDto authenticationDto) {
        return authenticationService.login(authenticationDto);
    }

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public UserDto register(@RequestBody @Valid RegisterDto registerDto) {
        return authenticationService.register(registerDto);
    }
}
