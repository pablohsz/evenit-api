package br.pucgo.edu.evenitapi.service;

import br.pucgo.edu.evenitapi.dao.EventoDao;
import br.pucgo.edu.evenitapi.model.Evento;
import br.pucgo.edu.evenitapi.model.dto.EventoRequisicaoDto;
import br.pucgo.edu.evenitapi.model.dto.EventoRespostaDto;
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

    public EventoRespostaDto salvarEvento(EventoRequisicaoDto eventoRequisicaoDto) {
        Evento evento = conversorDto(eventoRequisicaoDto);
        evento = eventoDao.save(evento);
        return new EventoRespostaDto(evento);
    }

    public void deletarEvento(Long id) {
        eventoDao.deleteById(id);
    }

    private Evento conversorDto(EventoRequisicaoDto eventoRequisicaoDto){
        var categoriaBuscada = categoriaService.buscarCategoria(eventoRequisicaoDto.getCategoria());
        var usuarioBuscado = usuarioService.buscarUsuario(eventoRequisicaoDto.getUsuario());
        Evento evento = new Evento(eventoRequisicaoDto);
        evento.setCategoria(categoriaBuscada.get());
        evento.setUsuario(usuarioBuscado.get());

        return evento;
    }

}
