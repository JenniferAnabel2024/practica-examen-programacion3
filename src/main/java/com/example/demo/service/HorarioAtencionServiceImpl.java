package com.example.demo.service;

import com.example.demo.entity.HorarioAtencion;
import com.example.demo.repository.HorarioAtencionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class HorarioAtencionServiceImpl implements HorarioAtencionService {

    @Autowired
    private HorarioAtencionRepository horarioRepository;

    @Override
    public List<HorarioAtencion> buscarTodos() {
        return horarioRepository.findAll();
    }

    @Override
    public HorarioAtencion guardar(HorarioAtencion horario) {
        return horarioRepository.save(horario);
    }

    @Override
    public void eliminar(Long id) {
        horarioRepository.deleteById(id);
    }

    @Override
    public HorarioAtencion buscarPorId(Long id) {
        return horarioRepository.findById(id).orElse(null);
    }

    // --- MÉTODOS DE BÚSQUEDA (Solo Entidades) ---

    @Override
    public List<HorarioAtencion> buscarPorPrioridad(int prioridad) {
        return horarioRepository.findByPrioridad(prioridad);
    }

    @Override
    public List<HorarioAtencion> buscarAltaPrioridad() {
        return horarioRepository.findByPrioridadGreaterThanEqual(4);
    }

    @Override
    public List<HorarioAtencion> buscarBajaPrioridad() {
        return horarioRepository.findByPrioridadLessThanEqual(2);
    }

    @Override
    public List<HorarioAtencion> buscaralias(String alias) {
        return horarioRepository.findByAliasContainingIgnoreCase(alias);
    }

    @Override
    public List<HorarioAtencion> buscarporespecial(String especial) {
        return horarioRepository.findByEspecialContainingIgnoreCase(especial);
    }

    @Override
    public List<HorarioAtencion> buscarporlibre(Boolean libre) {
        return horarioRepository.findByLibre(libre);
    }

    @Override
    public List<HorarioAtencion> buscarnumeroconsultorio(Integer numeroConsultorio) {
        return horarioRepository.findByNumeroconsultorio(numeroConsultorio);
    }

    @Override
    public List<HorarioAtencion> buscarnroconsultorio(int nroconsultorio) {
        return horarioRepository.findBynroconsultorio(nroconsultorio);
    }
}