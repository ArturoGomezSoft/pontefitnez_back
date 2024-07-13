package com.example.pontefitnez.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.pontefitnez.model.Membresia;
import com.example.pontefitnez.service.MembresiaService;

@RestController
@RequestMapping("/api/membresias")
@CrossOrigin(origins = "*")
public class MembresiaController {

    @Autowired
    private MembresiaService membresiaService;

    @GetMapping
    public List<Membresia> getAllMembresias() {
        return membresiaService.getAllMembresias();
    }

    @GetMapping("/{id}")
    public Membresia getMembresiaById(@PathVariable Long id) {
        return membresiaService.getMembresiaById(id);
    }

    @PostMapping
    public Membresia createMembresia(@RequestBody Membresia membresia) {
        return membresiaService.saveMembresia(membresia);
    }

    @PutMapping("/{id}")
    public Membresia updateMembresia(@PathVariable Long id, @RequestBody Membresia membresia) {
        membresia.setId(id);
        return membresiaService.saveMembresia(membresia);
    }

    @DeleteMapping("/{id}")
    public void deleteMembresia(@PathVariable Long id) {
        membresiaService.deleteMembresia(id);
    }
}
