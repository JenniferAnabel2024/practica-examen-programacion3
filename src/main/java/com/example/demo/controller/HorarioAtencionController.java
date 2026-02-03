package com.example.demo.controller;

import java.util.List;
import java.util.stream.Collectors;

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
    private HorarioAtencionService horarioService; // Tu interfaz

    @Autowired
    private HorarioAtencionMapper mapper;

    // 1. Obtener todos
    @GetMapping
    public ResponseEntity<List<HorarioAtencionResponseDto>> listarTodos() {
        List<HorarioAtencion> lista = horarioService.buscarTodos();
        List<HorarioAtencionResponseDto> dtos = lista.stream()
                .map(mapper::toResponseDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(dtos);
    }

    // 2. Obtener por ID
    @GetMapping("/{id}")
    public ResponseEntity<HorarioAtencionResponseDto> obtenerPorId(@PathVariable Long id) {
        HorarioAtencion horario = horarioService.buscarPorId(id);
        if (horario == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(mapper.toResponseDto(horario));
    }

    // 3. Crear (POST)
    @PostMapping
    public ResponseEntity<HorarioAtencionResponseDto> guardar(@Valid @RequestBody HorarioAtencionRequestDto dto) throws Exception {
        HorarioAtencion entity = mapper.fromDto(dto);
        HorarioAtencion nuevo = horarioService.guardar(entity);
        return ResponseEntity.status(HttpStatus.CREATED).body(mapper.toResponseDto(nuevo));
    }

    // 4. Eliminar
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable Long id) {
        try {
            horarioService.eliminar(id);
            return ResponseEntity.ok("Eliminado correctamente");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontró el ID");
        }
    }
}