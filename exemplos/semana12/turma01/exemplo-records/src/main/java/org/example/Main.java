package org.example;

public class Main {
    public static void main(String[] args) {
        Pessoa pessoa = new Pessoa();
        pessoa.setNome("meu nome");
        pessoa.setIdade(80);

        PessoaDto pessoaDto = new PessoaDto(
            "meu nome no dto",
                70
        );

        System.out.println(pessoaDto.nome());
    }
}