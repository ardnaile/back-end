package eliandracardoso.exercicio7.Repositories;

import eliandracardoso.exercicio7.Models.Transacao;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TransacaoRepository extends MongoRepository<Transacao, ObjectId> {
}
