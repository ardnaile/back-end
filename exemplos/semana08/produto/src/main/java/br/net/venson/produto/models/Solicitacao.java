package br.net.venson.produto.models;

public class Solicitacao {
    private String produto;
    private String remetente;
    private String destinatario;

    public Solicitacao(String produto, String remetente, String destinatario) {
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

    public String getRemetente() {
        return remetente;
    }

    public void setRemetente(String remetente) {
        this.remetente = remetente;
    }

    public String getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }
}
