package br.pucgo.edu.evenitapi.service;

import br.pucgo.edu.evenitapi.dao.EventoDao;
import br.pucgo.edu.evenitapi.dao.UsuarioDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EventoService {

    @Autowired
    private EventoDao eventoDao;


}
