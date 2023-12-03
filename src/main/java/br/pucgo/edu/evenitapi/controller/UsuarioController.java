package br.pucgo.edu.evenitapi.controller;

import br.pucgo.edu.evenitapi.model.Usuario;
import br.pucgo.edu.evenitapi.model.dto.UsuarioDto;
import br.pucgo.edu.evenitapi.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public List<Usuario> listarUsuarios(){
        return usuarioService.listarUsuarios();
    }

    @GetMapping("/{username}")
    public ResponseEntity<Object> buscarUsuario(@PathVariable String username) {
        Optional<Usuario> usuarioBuscado = usuarioService.buscarUsuario(username);
        if(usuarioBuscado.isEmpty()){
            return ResponseEntity.status(HttpStatus.OK).build();
        } else return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }


    @PostMapping
    public ResponseEntity<Object> criarUsuario(@RequestBody Usuario usuario) {
        usuario = usuarioService.criarUsuario(usuario);
        usuario.setSenha("");
        return ResponseEntity.status(HttpStatus.CREATED).body(usuario);
    }

    @PostMapping("/login")
    public ResponseEntity<Object> validaEntrada(@RequestBody UsuarioDto usuario) {
        var usuarioValidado = usuarioService.verificaCredenciais(usuario);
        usuarioValidado.setSenha("");
        if (usuarioValidado != null) {
            return ResponseEntity.status(HttpStatus.OK).body(usuarioValidado);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @PatchMapping
    public ResponseEntity<Object> atualizarUsuario(@RequestBody Usuario usuario) {
        usuario = usuarioService.criarUsuario(usuario);
        usuario.setSenha("");
        return ResponseEntity.status(HttpStatus.CREATED).body(usuario);
    }
}
