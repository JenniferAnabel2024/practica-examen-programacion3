package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;


@Entity
@Table (name ="medicos")
public class Medico extends BaseEntityPractica {
	
    private String nombre;
    private String apellido;
    
	public Medico(Long id) {
		super(id);
	}
	public Medico() {
		
	
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	//  git checkout develop, git fetch , git swich develop , git reset --hard HEAD , git pull, git checkout -b final-marzo-Jennifer;
    // --------------------------------------------------------------------------------------- TRABAJAR 
	// git status, git add uno por uno , git commit -m "" , git oush origin final....


}
