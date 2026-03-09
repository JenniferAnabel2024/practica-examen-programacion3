package com.example.demo.repository;
//MISMO NOMBRE QUE EN LA ENTIDAD RESPETANDO MAYUSCULAS Y MINUSCULAS 
import com.example.demo.entity.HorarioAtencion; // Importamos la entidad

import org.springframework.data.jpa.repository.JpaRepository; // La herramienta de Spring

import org.springframework.stereotype.Repository; // El sello de Repository

import java.util.List;

@Repository

public interface HorarioAtencionRepository extends JpaRepository<HorarioAtencion, Long>{

	List<HorarioAtencion> findByPrioridad(int prioridad);
	
	// Los "mágicos" 
	//todos los horarios cuya prioridad Mayor o Igual
    List<HorarioAtencion> findByPrioridadGreaterThanEqual(Integer prioridad);
    
    //todos los horarios cuya prioridad Menor o igual 
    List<HorarioAtencion> findByPrioridadLessThanEqual(Integer prioridad);
    
    //Un numero medio ejemplo: List<HorarioAtencion> findByPrioridad(3);
    // No imporatn las mayusculas, palabras claves.
    List<HorarioAtencion> findByAliasContainingIgnoreCase(String texto);
    
    //PRIMERA LETRA DESPUES DEL FINDBY VA CON "MAYUSCULA" ESPECIAL Y CONTAINIG SOLO PARA STRING
    List<HorarioAtencion> findByEspecialContainingIgnoreCase(String texto);
    
    //BOOLEAN

    List<HorarioAtencion> findByLibre(Boolean libre);
    
    List<HorarioAtencion> findByNumeroconsultorio(Integer numeroconsultorio);
    
    List<HorarioAtencion> findBynroconsultorio(int numeroconsultorio);
    
}