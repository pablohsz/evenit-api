package br.pucgo.edu.evenitapi.controller;


import br.pucgo.edu.evenitapi.model.Categoria;
import br.pucgo.edu.evenitapi.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping
    public List<Categoria> getAllCategories(){
        return categoriaService.getAllCategorias();
    }
}
