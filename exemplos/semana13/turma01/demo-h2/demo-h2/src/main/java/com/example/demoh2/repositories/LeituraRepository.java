package com.example.demoh2.repositories;

import com.example.demoh2.models.Leitura;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface LeituraRepository extends JpaRepository<Leitura, UUID> {
}
