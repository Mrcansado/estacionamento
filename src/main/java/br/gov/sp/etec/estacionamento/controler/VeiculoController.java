package br.gov.sp.etec.estacionamento.controler;

import br.gov.sp.etec.estacionamento.model.Veiculo;
import br.gov.sp.etec.estacionamento.service.VeiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/veiculo")
public class VeiculoController {

    @Autowired
    VeiculoService service;

    @PostMapping("/cadastrar")
    public String cadastrar(Veiculo veiculo) {
        service.CadastrarVeiculo(veiculo);
        return "redirect:/painel";
    }

    @GetMapping("/cadastrar-veiculo")
    public String registrarEntrada() {
        return "efetuar";
    }

    @GetMapping("/registrar-saida")
    public String registrarSaida(Model model) {
        model.addAttribute("veiculos", service.listarEstacionados());
        return "registrar-saida";
    }

    @PostMapping("/saida/{id}")
    public String efetuarSaida(@PathVariable Long id) {
        service.registrarSaida(id);
        return "redirect:/painel";
    }
}
