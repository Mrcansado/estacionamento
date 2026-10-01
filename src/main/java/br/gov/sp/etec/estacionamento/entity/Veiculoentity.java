package br.gov.sp.etec.estacionamento.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDateTime;

@Entity
@Table(name = "tb_veiculo")
public class Veiculoentity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String placa;
    private String modelo;
    private String cor;
    private String observacoes;
    private LocalDateTime horaentrada;
    private LocalDateTime horasaida;
    private Boolean estacionado;

    public Boolean getEstacionado() {
        return estacionado;
    }

    public void setEstacionado(Boolean estacionado) {
        this.estacionado = estacionado;
    }

    public LocalDateTime getHorasaida() {
        return horasaida;
    }

    public void setHorasaida(LocalDateTime horasaida) {
        this.horasaida = horasaida;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }
}
