package com.example.exemplolivros.models;

import java.util.Date;

public class Livro {
    private String titulo;
    private String genero;
    private Integer paginas;
    private Date dataLancamento;
    private Autor autor;

    public Livro(String titulo, String genero, Integer paginas, Date dataLancamento, Autor autor) {
        this.titulo = titulo;
        this.genero = genero;
        this.paginas = paginas;
        this.dataLancamento = dataLancamento;
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

    public Date getDataLancamento() {
        return dataLancamento;
    }

    public void setDataLancamento(Date dataLancamento) {
        this.dataLancamento = dataLancamento;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }
}
