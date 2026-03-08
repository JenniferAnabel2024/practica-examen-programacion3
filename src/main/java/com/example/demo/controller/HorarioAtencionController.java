package com.example.demo.controller;
//HABLA CON EL SERVICE
//CRITERIOS DE ACEPTACION VAN AQUI 
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
// avisa a Spring que esta clase es un Controlador
@RestController
//Spring ya sabe que todo lo que esté adentro de ese archivo empieza con /horarioAtencion
@RequestMapping("/horarioAtencion")
public class HorarioAtencionController {

	//Autowired es lla Inyección de Dependencias.(necesito usar las funciones de HorarioAtencionService.Inyectamelas, para que pueda usarla)
    @Autowired
    private HorarioAtencionService horarioService; // Tu interfaz, VARIABLE DEL SERVICE.

    @Autowired
    private HorarioAtencionMapper mapper;

    //Se usa para operaciones de lectura que no modifican la base de datos".
    // 1. Obtener todos
    @GetMapping
    public ResponseEntity<List<HorarioAtencionResponseDto>> listarTodos() {
    	return ResponseEntity.ok(horarioService.buscarTodos());
    	
    }

    // 2. Obtener por ID
    @GetMapping("/{id}")
    public ResponseEntity<HorarioAtencionResponseDto> obtenerPorId(@PathVariable Long id) {
        HorarioAtencionResponseDto dto  = horarioService.buscarPorId(id);
        if (dto == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(dto);
    }
     
    //Es cuando el usuario viene con un formulario nuevo para dar de alta algo
    // 3. Crear (POST)
    @PostMapping
    public ResponseEntity<HorarioAtencionResponseDto> guardar(@Valid @RequestBody HorarioAtencionRequestDto dto) throws Exception {
        HorarioAtencion entity = mapper.fromDto(dto);
        HorarioAtencionResponseDto nuevo = horarioService.guardar(entity);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevo);
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
    @GetMapping("/prioridad/{prioridad}")
    public ResponseEntity<List<HorarioAtencionResponseDto>> buscarPorPrioridad(@PathVariable int prioridad) {
        List<HorarioAtencionResponseDto> lista = horarioService.buscarPorPrioridad(prioridad);
        
        return ResponseEntity.ok(lista);
    }
 // 6. Obtener registros de Alta Prioridad (>= 4)
    @GetMapping("/alta-prioridad")
    public ResponseEntity<List<HorarioAtencionResponseDto>> listarAltaPrioridad() {
        // Llamamos al service que ya sabe que "Alta" es >= 4
        List<HorarioAtencionResponseDto> lista = horarioService.buscarAltaPrioridad();
        return ResponseEntity.ok(lista);
    }

    // 7. Obtener registros de Baja Prioridad (<= 2)
    @GetMapping("/baja-prioridad")
    public ResponseEntity<List<HorarioAtencionResponseDto>> listarBajaPrioridad() {
        // Llamamos al service que ya sabe que "Baja" es <= 2
        List<HorarioAtencionResponseDto> lista = horarioService.buscarBajaPrioridad();
        return ResponseEntity.ok(lista);
    }
    //@PutMapping (Editar): (Que también existe) Sería como borrar una palabra y escribir otra. También modifica.
    
    @GetMapping("/buscar-alias")
    public ResponseEntity<?>buscarporalias (@RequestParam(required = false)String texto) {
       if (texto==null || texto.trim().isEmpty()){
    	   return ResponseEntity.status(400)
    			   .body("{\"errors\": [\"texto de busqueda obligatorio\"]}");
       }
       List<HorarioAtencionResponseDto> resultados = horarioService.buscaralias(texto);
       
       return ResponseEntity.ok(resultados);
}
    
    //IGUAL QUE EL SERVICE.IMPL
    //400 ERROR + LISTA VACIA
    @GetMapping("/buscar-especial")

    public ResponseEntity<?>buscarporespecial (@RequestParam(required = false)String texto) {
        if (texto==null || texto.trim().isEmpty()){
     	   return ResponseEntity.status(400)
     			   .body("{\"errors\": [\"texto de busqueda obligatorio\"]}");
        }
        List<HorarioAtencionResponseDto> resultados = horarioService.buscarporespecial(texto);
        
        return ResponseEntity.ok(resultados);
 }

    @GetMapping("/buscar-libre")

    public ResponseEntity<?>buscarporlibre (@RequestParam(required = false)Boolean libre) {
        if (libre==null ){
     	   return ResponseEntity.status(400)
     			   //CAMBIAR EL NOMBRE DEL TEXTO
     			   .body("{\"errors\": [\"Debe contener libre u ocupado\"]}");
        }
        List<HorarioAtencionResponseDto> resultados = horarioService.buscarporlibre(libre);
        
        return ResponseEntity.ok(resultados);
 }

    @GetMapping("/buscar-numeroconsultorio")
    public ResponseEntity<?>buscarnumeroconsultorio (@RequestParam(required = false)Integer numeroconsultorio) {
        if (numeroconsultorio==null ){
     	   return ResponseEntity.status(400)
     			   //CAMBIAR EL NOMBRE DEL TEXTO
     			   .body("{\"errors\": [\"Debe contener un numero de consultorio\"]}");
        }
        List<HorarioAtencionResponseDto> resultados = horarioService.buscarnumeroconsultorio(numeroconsultorio);
        
        return ResponseEntity.ok(resultados);
 }
}



//POSTMAN get string 
//http://localhost:8080/horarioAtencion/buscar-especial?texto=
//http://localhost:8080/horarioAtencion/buscar-especial?texto=Pediatria

//POSTMAN BOOLEAN
//?libre=true	200 OK	La lista de los que tienen 1 en la base.
//?libre=false	200 OK	La lista de los que tienen 0 en la base.
//Nada (vacio)	400 Bad Request	Tu mensaje de error: "El estado de busqueda es obligatorio".