package com.example.demoh2.models;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "leituras")
public class Leitura {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String localidade;
    private Integer temperatura;
    private Double vento;
    private Double umidade;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getLocalidade() {
        return localidade;
    }

    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }

    public Integer getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(Integer temperatura) {
        this.temperatura = temperatura;
    }

    public Double getVento() {
        return vento;
    }

    public void setVento(Double vento) {
        this.vento = vento;
    }

    public Double getUmidade() {
        return umidade;
    }

    public void setUmidade(Double umidade) {
        this.umidade = umidade;
    }
}
