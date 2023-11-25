package br.pucgo.edu.evenitapi.service;

import br.pucgo.edu.evenitapi.dao.CategoriaDao;
import br.pucgo.edu.evenitapi.dao.EventoDao;
import br.pucgo.edu.evenitapi.dao.UsuarioDao;
import br.pucgo.edu.evenitapi.model.Categoria;
import br.pucgo.edu.evenitapi.model.Evento;
import br.pucgo.edu.evenitapi.model.Usuario;
import br.pucgo.edu.evenitapi.model.dto.EventoDto;
import br.pucgo.edu.evenitapi.model.dto.UsuarioDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Component
public class EventoService {

    @Autowired
    private EventoDao eventoDao;

    @Autowired
    private CategoriaService categoriaService;

    @Autowired
    private UsuarioService usuarioService;


    public List<Evento> listarEventos() {
        return (List<Evento>) eventoDao.findAll();
    }

    public Optional<Evento> buscarEvento(Long id) {
        return eventoDao.findById(id);
    }

    public List<Evento> listarEventosPorData(LocalDate dataInicial, LocalDate dataFinal) {
        return eventoDao.findAllByDataInicialGreaterThanEqualAndDataFinalLessThanEqual(dataInicial, dataFinal);
    }

    public EventoDto salvarEvento(EventoDto eventoDto) {
        Evento evento = conversorDto(eventoDto);
        evento = eventoDao.save(evento);
        return new EventoDto(evento);
    }

    public void deletarEvento(Long id) {
        eventoDao.deleteById(id);
    }

    private Evento conversorDto(EventoDto eventoDto){
        var categoriaBuscada = categoriaService.buscarCategoria(eventoDto.getCategoria());
        var usuarioBuscado = usuarioService.buscarUsuario(eventoDto.getUsuario());
        Evento evento = new Evento(eventoDto);
        evento.setCategoria(categoriaBuscada.get());
        evento.setUsuario(usuarioBuscado.get());

        return evento;
    }

}
