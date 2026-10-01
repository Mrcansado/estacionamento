package br.gov.sp.etec.estacionamento.model;

import java.time.LocalDateTime;

public class Veiculo {

    private Long id;
    private String placa;
    private String modelo;
    private String cor;
    private String observacoes;
    private LocalDateTime horaentrada;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getHoraentrada() {
        return horaentrada;
    }

    public void setHoraentrada(LocalDateTime horaentrada) {
        this.horaentrada = horaentrada;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }
}
