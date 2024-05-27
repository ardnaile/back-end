package eliandracardoso.exercicio7.Mappers;

import eliandracardoso.exercicio7.DTO.ClienteDto;
import eliandracardoso.exercicio7.Models.Cliente;

public class ClienteMapper {
    public ClienteDto toDto(Cliente cliente){
        ClienteDto dto = new ClienteDto(
                cliente.getNome(),
                cliente.getSaldo()
        );
        return dto;
    }
}
