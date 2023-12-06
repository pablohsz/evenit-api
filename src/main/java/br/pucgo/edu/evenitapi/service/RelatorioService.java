package br.pucgo.edu.evenitapi.service;

import br.pucgo.edu.evenitapi.model.Evento;
import br.pucgo.edu.evenitapi.model.dto.EventoRelatorioDto;
import br.pucgo.edu.evenitapi.model.dto.EventoRespostaDto;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class RelatorioService {

    @Autowired
    private EventoService eventoService;

    public JasperPrint exportarRelatorio() throws IOException, JRException {
        List<EventoRelatorioDto> eventos = converterParaEventoRelatorioDto(eventoService.listarEventos());
        return gerarRelatorio(eventos);
    }

    public JasperPrint exportarRelatorio(LocalDate dataInicial, LocalDate dataFinal) throws IOException, JRException {
        List<EventoRelatorioDto> eventos = converterParaEventoRelatorioDto(eventoService.listarEventosPorData(dataInicial, dataFinal));
        return gerarRelatorio(eventos);
    }

    private List<EventoRelatorioDto> converterParaEventoRelatorioDto(List<Evento> eventos){
        List<EventoRelatorioDto> eventosConvertidos = new ArrayList<>();
        EventoRelatorioDto eventoRelatorioDto;
        for (Evento evento: eventos){
            eventoRelatorioDto = new EventoRelatorioDto(evento);
            eventosConvertidos.add(eventoRelatorioDto);
        }
        return eventosConvertidos;
    }

    private JasperPrint gerarRelatorio(List<EventoRelatorioDto> eventos) throws IOException, JRException {
        File file = ResourceUtils.getFile("classpath:evenit_report.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(eventos);
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, dataSource);
        return jasperPrint;
    }




}
