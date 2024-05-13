package eliandramcardoso.aula0605.models;

import java.util.Date;

public class Livro {
    private String titulo;
    private String genero;
    private Integer paginas;
    private Date dt_lancamento;
    private Autor autor;

    public Livro(String titulo, String genero, Integer paginas, Date dt_lancamento, Autor autor){
        this.titulo = titulo;
        this.genero = genero;
        this.paginas = paginas;
        this.dt_lancamento = dt_lancamento;
        this.autor = autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Integer getPaginas() {
        return paginas;
    }

    public void setPaginas(Integer paginas) {
        this.paginas = paginas;
    }

    public Date getDt_lancamento() {
        return dt_lancamento;
    }

    public void setDt_lancamento(Date dt_lancamento) {
        this.dt_lancamento = dt_lancamento;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }
}
