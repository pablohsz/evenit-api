package br.pucgo.edu.evenitapi.service;


import br.pucgo.edu.evenitapi.dao.CategoriaDao;
import br.pucgo.edu.evenitapi.model.Categoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CategoriaService {

    @Autowired
    private CategoriaDao categoriaDao;

    public List<Categoria> getAllCategorias(){
        return (List<Categoria>) categoriaDao.findAll();
    }

}
