package br.gov.sp.etec.estacionamento.service;

import br.gov.sp.etec.estacionamento.entity.UsuarioEntity;
import br.gov.sp.etec.estacionamento.model.Usuario;
import br.gov.sp.etec.estacionamento.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService{

    @Autowired
    UsuarioRepository repository;

    @Override
    public String cadastrarUsuario(Usuario usuario) {
        UsuarioEntity usuarioEntity = new UsuarioEntity();
        usuarioEntity.setNome(usuario.getNome());
        usuarioEntity.setCpf(usuario.getCpf());
        usuarioEntity.setEmail(usuario.getEmail());
        usuarioEntity.setNascimento(usuario.getData_de_nascimento());
        usuarioEntity.setTelefone(usuario.getTelefone());
        usuarioEntity.setSenha(usuario.getSenha());

        repository.save(usuarioEntity);
        return "usuario cadastrado com sucesso";
    }

    @Override
    public List<Usuario> listarUsuarios() {
        return List.of();
    }

    @Override
    public String atualizarUsuario(Usuario usuario) {
        return "";
    }

    @Override
    public String deletarUsuario(Long id) {
        return "";
    }

    @Override
    public Usuario BuscaUsuarioPorEmail(String email) {
        UsuarioEntity entity = repository.findByEmail(email);
        if (entity == null) {
            return null;
        }
        Usuario user = toUsuario(entity);
        return user;
    } // private o q é
    //estudar mappring

    private Usuario toUsuario(UsuarioEntity entity){
        Usuario usuario = new Usuario();
        usuario.setEmail(entity.getEmail());
        usuario.setNome(entity.getNome());
        usuario.setCpf(entity.getCpf());
        usuario.setData_de_nascimento(entity.getNascimento());
        usuario.setTelefone(entity.getTelefone());
        usuario.setSenha(entity.getSenha());



        return usuario;
    }
}
