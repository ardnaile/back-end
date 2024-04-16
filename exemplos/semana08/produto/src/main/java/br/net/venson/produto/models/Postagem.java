package br.net.venson.produto.models;

public class Postagem {
    private String produto;
    private Endereco remetente;
    private Endereco destinatario;

    public Postagem(String produto, Endereco remetente, Endereco destinatario) {
        this.produto = produto;
        this.remetente = remetente;
        this.destinatario = destinatario;
    }

    public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }

    public Endereco getRemetente() {
        return remetente;
    }

    public void setRemetente(Endereco remetente) {
        this.remetente = remetente;
    }

    public Endereco getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(Endereco destinatario) {
        this.destinatario = destinatario;
    }
}
