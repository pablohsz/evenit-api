package br.pucgo.edu.evenitapi.controller;


import br.pucgo.edu.evenitapi.service.RelatorioService;
import jakarta.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.time.LocalDate;

@RestController
@RequestMapping("/relatorio")
public class RelatorioController {

    @Autowired
    private RelatorioService relatorioService;


    @GetMapping("/pdf")
    public void getRelatorioDeEventos(HttpServletResponse response) throws JRException, IOException {

        var jasperPrint = relatorioService.exportarRelatorio();
        // Exporta o relatório para PDF
        JasperExportManager.exportReportToPdfStream(jasperPrint, response.getOutputStream());

        // Define o tipo de conteúdo da resposta
        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition", "inline; filename=relatorio_filmes_avaliados.pdf");
    }

    @GetMapping("/pdf/data")
    public void getRelatorioDeEventosFiltrados(@RequestParam("inicio") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate dataInicial,
                                               @RequestParam("fim") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate dataFinal, HttpServletResponse response) throws JRException, IOException {

        var jasperPrint = relatorioService.exportarRelatorio(dataInicial, dataFinal);
        JasperExportManager.exportReportToPdfStream(jasperPrint, response.getOutputStream());
        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition", "inline; filename=relatorio_filmes_avaliados.pdf");
    }

}
