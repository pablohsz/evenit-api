package br.pucgo.edu.evenitapi.controller;


import br.pucgo.edu.evenitapi.model.Evento;
import br.pucgo.edu.evenitapi.model.dto.EventoDto;
import br.pucgo.edu.evenitapi.service.EventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/eventos")
public class EventoController {

    @Autowired
    private EventoService eventoService;

    @GetMapping
    public List<EventoDto> listarEventos() {
        var eventos = eventoService.listarEventos();
        return converterEventoDto(eventos);
    }

    @GetMapping("/data")
    public List<EventoDto> listarEventosPorData(@RequestParam("inicio") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate dataInicial,
                                             @RequestParam("fim") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate dataFinal) {
        var eventos = eventoService.listarEventosPorData(dataInicial, dataFinal);
        return converterEventoDto(eventos);
    }

    @GetMapping("{id}")
    public ResponseEntity<Object> getEvento(@PathVariable Long id) {
        Optional<Evento> eventoBuscado = eventoService.buscarEvento(id);
        if (eventoBuscado.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        var evento = eventoBuscado.get();
        return ResponseEntity.status(HttpStatus.OK).body(evento);
    }

    @PostMapping
    public ResponseEntity<Object> criarEvento(@RequestBody EventoDto evento) {
        evento = eventoService.salvarEvento(evento);
        return ResponseEntity.status(HttpStatus.CREATED).body(evento);
    }

    @PatchMapping
    public ResponseEntity<Object> atualizarEvento(@RequestBody EventoDto evento) {
        evento = eventoService.salvarEvento(evento);
        return ResponseEntity.status(HttpStatus.OK).body(evento);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Object> deletarEvento(@PathVariable Long id) {
        eventoService.deletarEvento(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    private List<EventoDto> converterEventoDto(List<Evento> eventos){
        List<EventoDto> eventosDto = new ArrayList<>();
        EventoDto eventoDto;
        for(Evento evento : eventos){
            eventoDto = new EventoDto(evento);
            eventosDto.add(eventoDto);
        }
        return eventosDto;
    }

}
