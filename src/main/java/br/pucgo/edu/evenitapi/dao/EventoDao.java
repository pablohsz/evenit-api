package br.pucgo.edu.evenitapi.dao;

import br.pucgo.edu.evenitapi.model.Evento;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;
import java.util.List;

public interface EventoDao extends CrudRepository<Evento, Long> {

    List<Evento> findAllByDataInicialGreaterThanEqualAndDataFinalLessThanEqualOrderByDataInicialAsc(LocalDate dataInicial, LocalDate dataFinal);

}
