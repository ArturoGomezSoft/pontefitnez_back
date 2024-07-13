package com.example.pontefitnez.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.pontefitnez.model.Membresia;
import com.example.pontefitnez.repository.MembresiaRepository;

@Service
public class MembresiaService {

    @Autowired
    private MembresiaRepository membresiaRepository;

    public List<Membresia> getAllMembresias() {
        return membresiaRepository.findAll();
    }

    public Membresia getMembresiaById(Long id) {
        return membresiaRepository.findById(id).orElse(null);
    }

    public Membresia saveMembresia(Membresia membresia) {
        return membresiaRepository.save(membresia);
    }

    public void deleteMembresia(Long id) {
        membresiaRepository.deleteById(id);
    }
}
