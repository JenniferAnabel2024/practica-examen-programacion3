package com.example.demo.service;
import com.example.demo.entity.Medico;
import java.util.List;

public interface MedicoService {
	List<Medico> buscarTodos();
	Medico guardar (Medico medico);
	void eliminar (Long id);
	Medico buscarPorId(Long id);
}

