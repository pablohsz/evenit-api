package br.pucgo.edu.evenitapi.dao;

import br.pucgo.edu.evenitapi.model.Categoria;
import org.springframework.data.repository.CrudRepository;

public interface CategoriaDao extends CrudRepository<Categoria, Long> {
}
