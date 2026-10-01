package br.gov.sp.etec.estacionamento.service;

import br.gov.sp.etec.estacionamento.entity.Veiculoentity;
import br.gov.sp.etec.estacionamento.model.Veiculo;
import br.gov.sp.etec.estacionamento.repository.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class VeiculoServiceImpl implements VeiculoService {

    @Autowired
    VeiculoRepository repository;

    @Override
    public void CadastrarVeiculo(Veiculo veiculo) {
        repository.save(toEntity(veiculo));
    }

    @Override
    public List<Veiculo> listaveiculos() {
        return toListVeiculo(repository.findAll());
    }

    @Override
    public List<Veiculo> listarEstacionados() {
        return toListVeiculo(repository.findByHorasaidaIsNull());
    }

    @Override
    public boolean deletarveiculo(Long id) {
        if (!repository.existsById(id)) {
            return false;
        }
        repository.deleteById(id);
        return true;
    }

    @Override
    public Veiculoentity atualizarVeiculo(Veiculoentity veiculo) {
        return repository.save(veiculo);
    }

    @Override
    public boolean registrarSaida(Long id) {
        Optional<Veiculoentity> encontrado = repository.findById(id);
        if (encontrado.isEmpty()) {
            return false;
        }
        Veiculoentity entity = encontrado.get();
        if (entity.getHorasaida() != null) {
            return false; // saída já registrada
        }
        entity.setHorasaida(LocalDateTime.now());
        entity.setEstacionado(false);
        repository.save(entity);
        return true;
    }

    private Veiculoentity toEntity(Veiculo veiculo) {
        Veiculoentity entity = new Veiculoentity();
        entity.setPlaca(veiculo.getPlaca());
        entity.setCor(veiculo.getCor());
        entity.setModelo(veiculo.getModelo());
        entity.setObservacoes(veiculo.getObservacoes());
        entity.setHoraentrada(LocalDateTime.now());
        entity.setEstacionado(true);
        return entity;
    }

    private Veiculo toVeiculo(Veiculoentity entity) {
        Veiculo veiculo = new Veiculo();
        veiculo.setId(entity.getId());
        veiculo.setPlaca(entity.getPlaca());
        veiculo.setCor(entity.getCor());
        veiculo.setModelo(entity.getModelo());
        veiculo.setObservacoes(entity.getObservacoes());
        veiculo.setHoraentrada(entity.getHoraentrada());
        return veiculo;
    }

    private List<Veiculo> toListVeiculo(List<Veiculoentity> entities) {
        List<Veiculo> veiculos = new ArrayList<>();
        for (Veiculoentity entity : entities) {
            veiculos.add(toVeiculo(entity));
        }
        return veiculos;
    }
}
