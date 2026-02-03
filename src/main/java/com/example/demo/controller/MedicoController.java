package com.example.demo.controller;

import java.util.List;
import com.example.demo.entity.Medico;
import com.example.demo.service.MedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;

@RestController
@RequestMapping ("/api/medico")
public class MedicoController {

	@Autowired
	private MedicoService medicoService;

	
	//OBTENER TODOS LOS MEDICOS
	
@GetMapping

	public ResponseEntity<List<Medico>> listarTodos(){
	List<Medico> medicos = medicoService.buscarTodos();
	if (medicos.isEmpty()){
		return ResponseEntity.noContent().build();
	
	}
	return ResponseEntity.ok(medicos);
}
 //OBTENER UN MEDICO POR ID 
	
	@GetMapping("/{id}")
	
	public ResponseEntity<Medico> ObtenerPorId(@PathVariable Long id){
		Medico medico = medicoService.buscarPorId(id);		
		if (medico==null) {
			return  ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			
		}
		return ResponseEntity.ok(medico);
	}
	
	//Crear medico nuevo 
	@PostMapping
	public ResponseEntity<Medico> guardar(@RequestBody Medico medico){
	Medico nuevoMedico = medicoService.guardar(medico);
	return ResponseEntity.status(HttpStatus.CREATED).body(nuevoMedico);
	}
	
	//Eliminar un medico
	@DeleteMapping ("/{id}")
	public ResponseEntity<String> eliminar (@PathVariable Long id){
		try{
			medicoService.eliminar(id);
			return ResponseEntity.ok("Medico eliminado correctamente por id: "+ id );
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se pudo eliminar el medico");
		}
		}
	}
	



