package com.example.demo.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.dto.request.HorarioAtencionRequestDto;
import com.example.demo.dto.response.HorarioAtencionResponseDto;
import com.example.demo.entity.HorarioAtencion;
import com.example.demo.mapper.HorarioAtencionMapper;
import com.example.demo.service.HorarioAtencionService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/horarioAtencion")
public class HorarioAtencionController {

    @Autowired
    private HorarioAtencionService horarioService; 

    @Autowired
    private HorarioAtencionMapper mapper;

    // 1. LISTAR TODOS
    @GetMapping
    public ResponseEntity<List<HorarioAtencionResponseDto>> listarTodos() {
        List<HorarioAtencion> entidades = horarioService.buscarTodos();
        return ResponseEntity.ok(entidades.stream().map(mapper::toResponseDto).toList());
    }

    // 2. BUSCAR POR ID
    @GetMapping("/{id}")
    public ResponseEntity<HorarioAtencionResponseDto> obtenerPorId(@PathVariable Long id) {
        HorarioAtencion entidad = horarioService.buscarPorId(id);
        if (entidad == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(mapper.toResponseDto(entidad));
    }
     
    // 3. CREAR (POST)
    @PostMapping
    public ResponseEntity<HorarioAtencionResponseDto> guardar(@Valid @RequestBody HorarioAtencionRequestDto dto) throws Exception {
        HorarioAtencion entity = mapper.fromDto(dto);
        HorarioAtencion guardado = horarioService.guardar(entity);
        return ResponseEntity.status(HttpStatus.CREATED).body(mapper.toResponseDto(guardado));
    }

    // 4. ELIMINAR
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable Long id) {
        try {
            horarioService.eliminar(id);
            return ResponseEntity.ok("Eliminado correctamente ID: " + id);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontró el ID");
        }
    }

    // 5. BUSCAR POR ALIAS (STRING)
    @GetMapping("/buscar-alias")
    public ResponseEntity<?> buscarporalias(@RequestParam(required = false) String texto) {
        if (texto == null || texto.trim().isEmpty()) {
            return ResponseEntity.status(400).body("{\"errors\": [\"El alias es obligatorio\"]}");
        }
        List<HorarioAtencion> resultados = horarioService.buscaralias(texto);
        return ResponseEntity.ok(resultados.stream().map(mapper::toResponseDto).toList());
    }

    // 6. BUSCAR POR LIBRE (BOOLEAN PRIMITIVO)
    @GetMapping("/buscar-libre")
    public ResponseEntity<?> buscarporlibre(@RequestParam(required = false) Boolean libre) {
        if (libre == null) {
            return ResponseEntity.status(400).body("{\"errors\": [\"Debe indicar si está libre o no\"]}");
        }
        List<HorarioAtencion> resultados = horarioService.buscarporlibre(libre);
        return ResponseEntity.ok(resultados.stream().map(mapper::toResponseDto).toList());
    }

    // 7. BUSCAR POR CONSULTORIO (INTEGER OBJETO)
    @GetMapping("/buscar-numeroconsultorio")
    public ResponseEntity<?> buscarnumeroconsultorio(@RequestParam(required = false) Integer numeroconsultorio) {
        if (numeroconsultorio == null) {
            return ResponseEntity.status(400).body("{\"errors\": [\"Número de consultorio obligatorio\"]}");
        }
        List<HorarioAtencion> resultados = horarioService.buscarnumeroconsultorio(numeroconsultorio);
        return ResponseEntity.ok(resultados.stream().map(mapper::toResponseDto).toList());
    }

    // 8. BUSCAR POR NRO (INT PRIMITIVO)
    @GetMapping("/buscar-nroconsultorio")
    public ResponseEntity<?> buscarnroconsultorio(@RequestParam(required = false, defaultValue = "0") int nro) {
        if (nro <= 0) {
            return ResponseEntity.status(400).body("{\"errors\": [\"Debe ser un número mayor a 0\"]}");
        }
        List<HorarioAtencion> resultados = horarioService.buscarnroconsultorio(nro);
        return ResponseEntity.ok(resultados.stream().map(mapper::toResponseDto).toList());
    }
}

/* =============================================================================
  🚀 GUÍA DE COMANDOS POSTMAN
  =============================================================================
  GET String:  localhost:8080/horarioAtencion/buscar-alias?texto=Guardia
  GET Boolean: localhost:8080/horarioAtencion/buscar-libre?libre=true
  GET Integer: localhost:8080/horarioAtencion/buscar-numeroconsultorio?numeroconsultorio=101
  GET Int:     localhost:8080/horarioAtencion/buscar-nroconsultorio?nro=5
  =============================================================================
  
*/