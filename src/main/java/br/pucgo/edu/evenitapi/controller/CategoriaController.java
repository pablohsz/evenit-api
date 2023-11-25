package br.pucgo.edu.evenitapi.controller;


import br.pucgo.edu.evenitapi.model.Categoria;
import br.pucgo.edu.evenitapi.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping
    public List<Categoria> listarTodasCategorias() {
        return categoriaService.listarCategorias();
    }

    @GetMapping("{id}")
    public ResponseEntity<Object> buscarCategoria(@PathVariable Long id) {
        Optional<Categoria> categoriaBuscada = categoriaService.buscarCategoria(id);
        if (categoriaBuscada.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        var categoria = categoriaBuscada.get();
        return ResponseEntity.status(HttpStatus.OK).body(categoria);
    }

    @PostMapping
    public ResponseEntity<Object> criarCategoria(@RequestBody Categoria categoria) {
        categoria = categoriaService.salvarCategoria(categoria);
        return ResponseEntity.status(HttpStatus.CREATED).body(categoria);
    }

    @PatchMapping
    public ResponseEntity<Object> atualizarCategoria(@RequestBody Categoria categoria) {
        categoria = categoriaService.salvarCategoria(categoria);
        return ResponseEntity.status(HttpStatus.OK).body(categoria);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Object> deletarCategoria(@PathVariable Long id){
        categoriaService.deletarCategoria(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
