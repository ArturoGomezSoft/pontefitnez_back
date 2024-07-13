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
import com.example.pontefitnez.model.Reposicion;
import com.example.pontefitnez.repository.ReposicionRepository;

@Service
public class ReposicionService {

    @Autowired
    private ReposicionRepository reposicionRepository;

    public List<Reposicion> getAllReposicions() {
        return reposicionRepository.findAll();
    }

    public Reposicion getReposicionById(Long id) {
        return reposicionRepository.findById(id).orElse(null);
    }

    public List<Reposicion> findByFechaHoy() {
        LocalDate today = LocalDate.now();
        LocalDateTime startOfDay = today.atStartOfDay();
        LocalDateTime endOfDay = today.atTime(LocalTime.MAX);

        return reposicionRepository.findByFecha_horaBetween(startOfDay, endOfDay);
    }

    public List<Reposicion> findBySemanaActual() {
        LocalDate today = LocalDate.now();
        LocalDateTime startOfWeek = today.with(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY)).atStartOfDay();
        LocalDateTime endOfWeek = today.with(TemporalAdjusters.nextOrSame(DayOfWeek.SUNDAY)).atTime(LocalTime.MAX);

        return reposicionRepository.findByFecha_horaBetween(startOfWeek, endOfWeek);
    }

    public List<Reposicion> findByMesActual() {
        LocalDate today = LocalDate.now();
        LocalDateTime startOfMonth = today.withDayOfMonth(1).atStartOfDay();
        LocalDateTime endOfMonth = today.withDayOfMonth(YearMonth.from(today).lengthOfMonth()).atTime(LocalTime.MAX);

        return reposicionRepository.findByFecha_horaBetween(startOfMonth, endOfMonth);
    }

    public Reposicion saveReposicion(Reposicion reposicion) {
        return reposicionRepository.save(reposicion);
    }

    public void deleteReposicion(Long id) {
        reposicionRepository.deleteById(id);
    }

    public Reposicion createReposicion(Reposicion reposicion) {
        return reposicionRepository.save(reposicion);
    }
}
