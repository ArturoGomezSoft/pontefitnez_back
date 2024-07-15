package com.example.pontefitnez.service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.YearMonth;
import java.time.temporal.TemporalAdjusters;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.pontefitnez.model.Venta;
import com.example.pontefitnez.repository.VentaRepository;

@Service
public class VentaService {

    @Autowired
    private VentaRepository ventaRepository;

    public List<Venta> getAllVentas() {
        return ventaRepository.findAll();
    }

    public Venta getVentaById(Long id) {
        return ventaRepository.findById(id).orElse(null);
    }

    public List<Venta> findByFechaManana() {
        LocalDate today = LocalDate.now();
        LocalDateTime startOfDay = today.atTime(6, 0);
        LocalDateTime endOfDay = today.atTime(14, 0);

        return ventaRepository.findByFecha_horaBetween(startOfDay, endOfDay);
    }

    public List<Venta> findByFechaTarde() {
        LocalDate today = LocalDate.now();
        LocalDateTime startOfDay = today.atTime(14, 0);
        LocalDateTime endOfDay = today.atTime(22, 0);

        return ventaRepository.findByFecha_horaBetween(startOfDay, endOfDay);
    }

    public List<Venta> findByFechaHoy() {
        LocalDate today = LocalDate.now();
        LocalDateTime startOfDay = today.atStartOfDay();
        LocalDateTime endOfDay = today.atTime(LocalTime.MAX);

        return ventaRepository.findByFecha_horaBetween(startOfDay, endOfDay);
    }

    public List<Venta> findBySemanaActual() {
        LocalDate today = LocalDate.now();
        LocalDateTime startOfWeek = today.with(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY)).atStartOfDay();
        LocalDateTime endOfWeek = today.with(TemporalAdjusters.nextOrSame(DayOfWeek.SUNDAY)).atTime(LocalTime.MAX);

        return ventaRepository.findByFecha_horaBetween(startOfWeek, endOfWeek);
    }

    public List<Venta> findByMesActual() {
        LocalDate today = LocalDate.now();
        LocalDateTime startOfMonth = today.withDayOfMonth(1).atStartOfDay();
        LocalDateTime endOfMonth = today.withDayOfMonth(YearMonth.from(today).lengthOfMonth()).atTime(LocalTime.MAX);

        return ventaRepository.findByFecha_horaBetween(startOfMonth, endOfMonth);
    }

    public Venta saveVenta(Venta venta) {
        return ventaRepository.save(venta);
    }

    public void deleteVenta(Long id) {
        ventaRepository.deleteById(id);
    }

    public Venta createVenta(Venta venta) {
        return ventaRepository.save(venta);
    }
}
