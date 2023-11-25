package br.pucgo.edu.evenitapi.service;

import br.pucgo.edu.evenitapi.dao.EventoDao;
import br.pucgo.edu.evenitapi.model.Evento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Component
public class EventoService {

    @Autowired
    private EventoDao eventoDao;

    public List<Evento> listarEventos(){
        return (List<Evento>) eventoDao.findAll();
    }

    public Optional<Evento> buscarEvento(Long id){
        return eventoDao.findById(id);
    }

    public List<Evento> listarEventosPorData(LocalDate dataInicial, LocalDate dataFinal){
        return eventoDao.findAllByDataInicialGreaterThanEqualAndDataFinalLessThanEqual(dataInicial, dataFinal);
    }

    public Evento salvarEvento(Evento evento){
        return eventoDao.save(evento);
    }

    public void deletarEvento(Long id){
        eventoDao.deleteById(id);
    }

}
