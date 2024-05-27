package eliandracardoso.exercicio7.Models;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "transacoes")
public class Transacao {
    @Id
    private ObjectId id;

    @NotNull(message="A transação deve ter um recebedor!")
    private String recebedor;

    @NotNull(message="A transação deve ter um pagador!")
    private String pagador;

    @Positive(message="O valor da transação deve ser maior que 0!")
    private double quantidade;

    public Transacao(String recebedor, String pagador, double quantidade) {
        this.recebedor = recebedor;
        this.pagador = pagador;
        this.quantidade = quantidade;
    }

    public String getRecebedor() {
        return recebedor;
    }

    public void setRecebedor(String recebedor) {
        this.recebedor = recebedor;
    }

    public String getPagador() {
        return pagador;
    }

    public void setPagador(String pagador) {
        this.pagador = pagador;
    }

    public double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(double quantidade) {
        this.quantidade = quantidade;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }
}
