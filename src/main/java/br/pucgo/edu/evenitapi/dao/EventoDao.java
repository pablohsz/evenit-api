package br.pucgo.edu.evenitapi.dao;

import br.pucgo.edu.evenitapi.model.Evento;
import org.springframework.data.repository.CrudRepository;

public interface EventoDao extends CrudRepository<Evento, Long> {
}
