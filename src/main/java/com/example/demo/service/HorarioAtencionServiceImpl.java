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
        // Buscamos por ID y si no existe devolvemos null
        return horarioRepository.findById(id).orElse(null);
    }
}