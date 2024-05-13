package eliandracardoso.exercicio7.Models;

public class Transacao {
    private String recebedor;
    private String pagador;
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
}
