package com.example.pontefitnez.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.pontefitnez.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    List <Cliente> findByDniContaining(String dni);
}
