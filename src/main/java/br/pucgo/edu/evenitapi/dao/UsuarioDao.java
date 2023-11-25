package br.pucgo.edu.evenitapi.dao;

import br.pucgo.edu.evenitapi.model.Usuario;
import org.springframework.data.repository.CrudRepository;

public interface UsuarioDao extends CrudRepository<Usuario, String> {
}
