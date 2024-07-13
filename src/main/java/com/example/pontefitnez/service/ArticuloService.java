package com.example.pontefitnez.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.pontefitnez.model.Articulo;
import com.example.pontefitnez.repository.ArticuloRepository;

@Service
public class ArticuloService {

    @Autowired
    private ArticuloRepository articuloRepository;

    public List<Articulo> getAllArticulos() {
        return articuloRepository.findAll();
    }

    public Articulo getArticuloById(Long id) {
        return articuloRepository.findById(id).orElse(null);
    }

    public Articulo saveArticulo(Articulo articulo) {
        return articuloRepository.save(articulo);
    }

    public void deleteArticulo(Long id) {
        articuloRepository.deleteById(id);
    }

    public List <Articulo> findByNombreContaining(String nombre) {
        return articuloRepository.findByNombreContaining(nombre);
    }
    public Articulo findByNombre(String nombre) {
        return articuloRepository.findByNombre(nombre);
    }
    public Articulo updateArticulo(Articulo articulo) {
        return articuloRepository.save(articulo);
    }
}
