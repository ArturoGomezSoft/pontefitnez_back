package com.example.pontefitnez.controller;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.pontefitnez.model.Articulo;
import com.example.pontefitnez.model.Reposicion;
import com.example.pontefitnez.service.ArticuloService;
import com.example.pontefitnez.service.ReposicionService;

@RestController
@RequestMapping("/api/reposicions")
@CrossOrigin(origins = "*")
public class ReposicionController {

    @Autowired
    private ReposicionService reposicionService;

    @Autowired
    private ArticuloService articuloService;

    @GetMapping
    public List<Reposicion> getAllReposicions() {
        return reposicionService.getAllReposicions();
    }

    @GetMapping("/{id}")
    public Reposicion getReposicionById(@PathVariable Long id) {
        return reposicionService.getReposicionById(id);
    }

    @GetMapping("/manana")
    public List<Reposicion> findByFechaManana() {
        return reposicionService.findByFechaManana();
    }

    @GetMapping("/tarde")
    public List<Reposicion> findByFechaTarde() {
        return reposicionService.findByFechaTarde();
    }

    @GetMapping("/hoy")
    public List<Reposicion> findByFechaHoy() {
        return reposicionService.findByFechaHoy();
    }

    @GetMapping("/semana")
    public List<Reposicion> findBySemanaActual() {
        return reposicionService.findBySemanaActual();
    }

    @GetMapping("/mes")
    public List<Reposicion> findByMesActual() {
        return reposicionService.findByMesActual();
    }

    @PutMapping("/{id}")
    public Reposicion updateReposicion(@PathVariable Long id, @RequestBody Reposicion reposicion) {
        reposicion.setId(id);
        return reposicionService.saveReposicion(reposicion);
    }

    @DeleteMapping("/{id}")
    public void deleteReposicion(@PathVariable Long id) {
        reposicionService.deleteReposicion(id);
    }

    @PostMapping
    public Reposicion createReposicion(@RequestBody Reposicion reposicion) {
        Articulo articulo = articuloService.findByNombre(reposicion.getNombre());
        
        if (articulo.getStock() < reposicion.getCantidad()) {
            throw new RuntimeException("Stock insuficiente");
        }
        articulo.setStock(articulo.getStock() + reposicion.getCantidad());
        articuloService.updateArticulo(articulo);
        reposicion.setCosto(reposicion.getCosto() * reposicion.getCantidad());
        reposicion.setFecha_hora(ZonedDateTime.now(ZoneId.of("America/Lima")).toLocalDateTime());
        return reposicionService.createReposicion(reposicion);
    }
}
