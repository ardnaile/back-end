package org.example.jogo;

public class FerroBloco extends Bloco {
    @Override
    public Item destruir() {
        Item item = new Item();
        item.setNome("Minério de Ferro");
        return item;
    }

    public Item destruir(int numero) {
        System.out.println("Destruiu 5 blocos");
        return null;
    }
}
