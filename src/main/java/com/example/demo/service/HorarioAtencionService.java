package com.example.demo.service;

import com.example.demo.entity.HorarioAtencion;
import java.util.List;

// El Service ahora solo habla el idioma de las Entidades
public interface HorarioAtencionService {

    List<HorarioAtencion> buscarTodos();
    
    HorarioAtencion guardar(HorarioAtencion horario);
    
    void eliminar(Long id);
    
    HorarioAtencion buscarPorId(Long id);

    // --- MÉTODOS DE BÚSQUEDA ---
    
    List<HorarioAtencion> buscarPorPrioridad(int prioridad);
    
    List<HorarioAtencion> buscarAltaPrioridad(); 
    
    List<HorarioAtencion> buscarBajaPrioridad();
    
    List<HorarioAtencion> buscaralias(String alias);
    
    List<HorarioAtencion> buscarporespecial(String especial);
    
    List<HorarioAtencion> buscarporlibre(Boolean libre);
    
    List<HorarioAtencion> buscarnumeroconsultorio(Integer numeroConsultorio);
    
    List<HorarioAtencion> buscarnroconsultorio(int nroconsultorio);

}