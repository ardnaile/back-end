package com.example.demosemana14.services;

import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class CorAleatoriaService {
    public String getCorAleatoria() {
        return new String[]{"branco", "amarelo", "vermelho"}[new Random().nextInt(3)];
    }
}
