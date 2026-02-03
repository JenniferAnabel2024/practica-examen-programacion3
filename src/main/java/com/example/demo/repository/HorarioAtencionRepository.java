package com.example.demo.repository;
import com.example.demo.entity.HorarioAtencion; // Importamos la entidad
import org.springframework.data.jpa.repository.JpaRepository; // La herramienta de Spring
import org.springframework.stereotype.Repository; // El sello de Repository

@Repository
public interface HorarioAtencionRepository extends JpaRepository<HorarioAtencion, Long>{

}
