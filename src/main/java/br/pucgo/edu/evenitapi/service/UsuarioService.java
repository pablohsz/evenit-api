package br.pucgo.edu.evenitapi.service;

import br.pucgo.edu.evenitapi.dao.UsuarioDao;
import br.pucgo.edu.evenitapi.model.Usuario;
import br.pucgo.edu.evenitapi.model.dto.UsuarioDto;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.Optional;

@Component
public class UsuarioService {

    @Autowired
    private UsuarioDao usuarioDao;

    public Optional<Usuario> buscarUsuario(String username){
        return usuarioDao.findById(username);
    }

    public Usuario criarUsuario(Usuario usuario) {
        var senhaEncriptada = converterSha1Hex(usuario.getSenha());
        usuario.setSenha(senhaEncriptada);
        return usuarioDao.save(usuario);
    }

    public boolean verificaCredenciais(UsuarioDto usuario) {
        Optional<Usuario> usuarioBuscado = usuarioDao.findById(usuario.getUsername());
        if (usuarioBuscado.isEmpty())
            return false;
        String senhaInserida = converterSha1Hex(usuario.getSenha());
        String senhaUsuario = usuarioBuscado.get().getSenha();
        return Objects.equals(senhaInserida, senhaUsuario);
    }


    private String converterSha1Hex(String senha) {
        return DigestUtils.sha1Hex(senha);
    }
}
