package com.example.exemploTransacao.models;

public class Transacao {
    private String remetente;
    private String destinatario;
    private Double valor;
    private Boolean status;

    public Transacao(String remetente, String destinatario, Double valor, Boolean status) {
        this.remetente = remetente;
        this.destinatario = destinatario;
        this.valor = valor;
        this.status = status;
    }

    public Transacao() {

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

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}
