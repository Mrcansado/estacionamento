package br.gov.sp.etec.estacionamento.controler;

import br.gov.sp.etec.estacionamento.service.VeiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PainelController {

    @Autowired
    VeiculoService service;

    @GetMapping("/painel")
    public String painel(Model model) {
        model.addAttribute("veiculos", service.listarEstacionados());
        return "painel";
    }
}
