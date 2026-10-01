package br.gov.sp.etec.estacionamento.controler;

import br.gov.sp.etec.estacionamento.model.Usuario;
import br.gov.sp.etec.estacionamento.service.UsuarioService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginControler {

    private static final Logger log = LoggerFactory.getLogger(LoginControler.class);

    @Autowired
    UsuarioService service;

    @GetMapping("/")
    public String index() {
        return "login";
    }

    @GetMapping("/cadastro")
    public String cadastro() {
        return "cadastro";
    }

    @PostMapping("/efetuar_cadastro")
    public String efetuar_cadastro(Usuario usuario, Model model) {
        if (service.BuscaUsuarioPorEmail(usuario.getEmail()) != null) {
            model.addAttribute("erro", "Já existe um usuário cadastrado com este e-mail.");
            return "cadastro";
        }
        log.info("Cadastrando usuário: {}", usuario);
        service.cadastrarUsuario(usuario);
        return "cadastro-success";
    }

    @PostMapping("/autenticar")
    public String autenticar(String email, String senha) {
        Usuario usuario = service.BuscaUsuarioPorEmail(email);
        if (usuario != null && senha != null && senha.equals(usuario.getSenha())) {
            return "redirect:/painel";
        }
        return "erro";
    }
}
