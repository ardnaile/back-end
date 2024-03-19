package org.example;

public class Main {
    public static void main(String[] args) {
        try {
            Jogador[] jogadores = JogadorGerador.gerarJogadores(3); // Gerando o array jogadores por meio do método gerarJogadores
            for (Jogador jogador : jogadores) { // for (type variableName : arrayName)
                                                // lê-se: para cada jogador do array jogadores
                System.out.println(jogador.getDescricao()); // Chama o método getDescricao()
            }
        } catch (Exception e) {
            System.err.println("Ocorreu um erro ao gerar os jogadores: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
