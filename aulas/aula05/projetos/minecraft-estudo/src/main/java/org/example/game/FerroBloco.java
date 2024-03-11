package org.example.game;

public class FerroBloco extends Bloco {
    @Override
    public Item destruir() {
        Item item = new Item("Ferro");
        return item;
    }
}
