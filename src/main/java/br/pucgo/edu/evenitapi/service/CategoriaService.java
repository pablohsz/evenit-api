package br.pucgo.edu.evenitapi.service;


import br.pucgo.edu.evenitapi.dao.CategoriaDao;
import br.pucgo.edu.evenitapi.model.Categoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class CategoriaService {

    @Autowired
    private CategoriaDao categoriaDao;

    public List<Categoria> listarCategorias() {
        return (List<Categoria>) categoriaDao.findAll();
    }

    public Optional<Categoria> buscarCategoria(Long id) {
        return categoriaDao.findById(id);
    }

    public Categoria salvarCategoria(Categoria categoria){
        return categoriaDao.save(categoria);
    }

    public void deletarCategoria(Long id){
        categoriaDao.deleteById(id);
    }

}
