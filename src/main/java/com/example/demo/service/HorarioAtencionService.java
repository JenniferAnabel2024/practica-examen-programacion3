package com.example.demo.service;
import com.example.demo.entity.HorarioAtencion;
import java.util.List;

public interface HorarioAtencionService {
	List<HorarioAtencion> buscarTodos();
    HorarioAtencion guardar(HorarioAtencion horario);
    void eliminar(Long id);
    HorarioAtencion buscarPorId(Long id);
}
