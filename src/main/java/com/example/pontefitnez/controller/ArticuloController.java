package com.example.pontefitnez.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.pontefitnez.model.Articulo;
import com.example.pontefitnez.service.ArticuloService;

@RestController
@RequestMapping("/api/articulos")
@CrossOrigin(origins = "*")
public class ArticuloController {

    @Autowired
    private ArticuloService articuloService;

    @GetMapping
    public List<Articulo> findAllArticulo() {
        return articuloService.getAllArticulos();
    }
    @GetMapping("/Nombre/{nombre}")
    public Articulo findByNombre(@PathVariable String nombre) {
        return articuloService.findByNombre(nombre);
    }

    @GetMapping("/{id}")
    public Articulo getArticuloById(@PathVariable Long id) {
        return articuloService.getArticuloById(id);
    }

    @PostMapping
    public Articulo createArticulo(@RequestBody Articulo articulo) {
        return articuloService.saveArticulo(articulo);
    }

    @PutMapping("/{id}")
    public Articulo updateArticulo(@PathVariable Long id, @RequestBody Articulo articulo) {
        articulo.setId(id);
        return articuloService.saveArticulo(articulo);
    }

    @DeleteMapping("/{id}")
    public void deleteArticulo(@PathVariable Long id) {
        articuloService.deleteArticulo(id);
    }

    @GetMapping("/NombreContaining/{nombre}")
    public List <Articulo> findByNombreContaining(@PathVariable String nombre) {
        return articuloService.findByNombreContaining(nombre);
    }
}
