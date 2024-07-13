package com.example.pontefitnez.controller;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.pontefitnez.model.Articulo;
import com.example.pontefitnez.model.Venta;
import com.example.pontefitnez.service.ArticuloService;
import com.example.pontefitnez.service.VentaService;

@RestController
@RequestMapping("/api/ventas")
@CrossOrigin(origins = "*")
public class VentaController {

    @Autowired
    private VentaService ventaService;

    @Autowired
    private ArticuloService articuloService;

    @GetMapping
    public List<Venta> getAllVentas() {
        return ventaService.getAllVentas();
    }

    @GetMapping("/{id}")
    public Venta getVentaById(@PathVariable Long id) {
        return ventaService.getVentaById(id);
    }

    @GetMapping("/hoy")
    public List<Venta> findByFechaHoy() {
        return ventaService.findByFechaHoy();
    }

    @GetMapping("/semana")
    public List<Venta> findBySemanaActual() {
        return ventaService.findBySemanaActual();
    }

    @GetMapping("/mes")
    public List<Venta> findByMesActual() {
        return ventaService.findByMesActual();
    }

    @PutMapping("/{id}")
    public Venta updateVenta(@PathVariable Long id, @RequestBody Venta venta) {
        venta.setId(id);
        return ventaService.saveVenta(venta);
    }

    @DeleteMapping("/{id}")
    public void deleteVenta(@PathVariable Long id) {
        ventaService.deleteVenta(id);
    }

    @PostMapping
    public Venta createVenta(@RequestBody Venta venta) {
        Articulo articulo = articuloService.findByNombre(venta.getNombre());
        
        if (articulo.getStock() < venta.getCantidad()) {
            throw new RuntimeException("Stock insuficiente");
        }
        articulo.setStock(articulo.getStock() - venta.getCantidad());
        articuloService.updateArticulo(articulo);
        venta.setCosto(venta.getCosto() * venta.getCantidad());
        venta.setFecha_hora(LocalDateTime.now());
        return ventaService.createVenta(venta);
    }

    @PostMapping("/membresia")
    public Venta createMembresia(@RequestBody Venta venta) {
        venta.setFecha_hora(LocalDateTime.now());
        return ventaService.createVenta(venta);
    }
}
