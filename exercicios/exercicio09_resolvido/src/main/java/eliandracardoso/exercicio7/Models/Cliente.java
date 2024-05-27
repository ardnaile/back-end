package eliandracardoso.exercicio7.Models;

import org.springframework.data.annotation.*;

import java.util.UUID;

// @Entity
// @Table(name = "clientes")
public class Cliente {
    // @Id
    // @GeneratedValue(strategy = GenerationType.UUID)
    // private UUID id;
    private String nome;
    private double saldo;
    private String senha;

    public Cliente(String nome, double saldo, String senha) {
        this.nome = nome;
        this.saldo = saldo;
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
