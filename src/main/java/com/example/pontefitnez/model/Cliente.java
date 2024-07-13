package com.example.pontefitnez.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String dni;
    private String nombres;
    private String apellidos;
    private String celular;
    private LocalDateTime fecha_nac;
    private LocalDateTime fecha_ini;
    private LocalDateTime fecha_fin;
//BckCamps
    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getCelular() {
		return celular;
	}
	public void setCelular(String celular) {
		this.celular = celular;
	}
	public LocalDateTime getFecha_nac() {
		return fecha_nac;
	}
	public void setFecha_nac(LocalDateTime fecha_nac) {
		this.fecha_nac = fecha_nac;
	}
	public LocalDateTime getFecha_ini() {
		return fecha_ini;
	}
	public void setFecha_ini(LocalDateTime fecha_ini) {
		this.fecha_ini = fecha_ini;
	}
	public LocalDateTime getFecha_fin() {
		return fecha_fin;
	}
	public void setFecha_fin(LocalDateTime fecha_fin) {
		this.fecha_fin = fecha_fin;
	}
//BckGetSet
}
