package com.example.demo.service;
import com.example.demo.entity.Medico;
import com.example.demo.repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.stereotype.Service;
import java.lang.module.FindException;
import java.util.List;

@Service
public class MedicoServiceImpl implements MedicoService {
//Inyeccion de dependencia 	
//medicoRepository: Es el que tiene la fuerza (el acceso a la BD).	
@Autowired
private MedicoRepository medicoRepository;
@Override

public List <Medico> buscarTodos() {
	return medicoRepository.findAll();
			}
@Override
public Medico guardar(Medico medico) {
	return medicoRepository.save(medico);
}
@Override
public void eliminar(Long id) {
	medicoRepository.deleteById(id);
}
@Override
public Medico buscarPorId(Long id) {
    // El repositorio ya trae este método instalado por heredar de JPA
    return medicoRepository.findById(id).orElse(null);
}
}
