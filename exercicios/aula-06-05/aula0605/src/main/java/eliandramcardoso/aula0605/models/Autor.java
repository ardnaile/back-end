package eliandramcardoso.aula0605.models;

import java.util.Date;

public class Autor {
    private String nome;
    private Date dt_nascimento;
    private String nacionalidade;

    public Autor(String nome, Date dt_nascimento, String nacionalidade){
        this.nome = nome;
        this.dt_nascimento = dt_nascimento;
        this.nacionalidade = nacionalidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDt_nascimento() {
        return dt_nascimento;
    }

    public void setDt_nascimento(Date dt_nascimento) {
        this.dt_nascimento = dt_nascimento;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }
}
