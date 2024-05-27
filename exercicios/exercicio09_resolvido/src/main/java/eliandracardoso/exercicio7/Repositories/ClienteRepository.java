package eliandracardoso.exercicio7.Repositories;

import eliandracardoso.exercicio7.Models.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ClienteRepository extends JpaRepository<Cliente, UUID> {
}
