package br.gov.sp.etec.estacionamento.service;

import br.gov.sp.etec.estacionamento.entity.Veiculoentity;
import br.gov.sp.etec.estacionamento.model.Veiculo;

import java.util.List;

public interface VeiculoService {

    void CadastrarVeiculo(Veiculo veiculo);

    List<Veiculo> listaveiculos();

    List<Veiculo> listarEstacionados();

    boolean deletarveiculo(Long id);

    Veiculoentity atualizarVeiculo(Veiculoentity veiculo);

    boolean registrarSaida(Long id);
}
