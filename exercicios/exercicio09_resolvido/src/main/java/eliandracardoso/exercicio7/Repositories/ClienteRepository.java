package eliandracardoso.exercicio7.Repositories;

import eliandracardoso.exercicio7.Models.Cliente;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface ClienteRepository extends MongoRepository<Cliente, ObjectId> {
    @Query("{ 'nome' : ?0 }")
    Cliente buscaPeloNome(String nome);
}
