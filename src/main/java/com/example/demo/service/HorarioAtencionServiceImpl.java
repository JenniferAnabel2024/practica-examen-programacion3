package com.example.demo.service;
//ORDENES CONCRETAS-IMPLMENTACIOn / HABLA CON LA BASE DE DATOS, USA AL REPOSITORIO
//USA AL MAPPY
import com.example.demo.dto.response.HorarioAtencionResponseDto;
import com.example.demo.entity.HorarioAtencion;
import com.example.demo.repository.HorarioAtencionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import com.example.demo.mapper.HorarioAtencionMapper;
import com.example.demo.entity.HorarioAtencion;


@Service
public class HorarioAtencionServiceImpl implements HorarioAtencionService {

	
	
    @Autowired
    private HorarioAtencionRepository horarioRepository;
    @Autowired
    private  HorarioAtencionMapper horarioMapper;
    
    @Override
    public List<HorarioAtencionResponseDto> buscarTodos() {
    	  List<HorarioAtencion> entidades = horarioRepository.findAll(); 
          
          return entidades.stream()
                  .map(entidad -> horarioMapper.toResponseDto(entidad)) 
                  .collect(Collectors.toList());
    }

    @Override
    public HorarioAtencionResponseDto guardar(HorarioAtencion horario) {
    	HorarioAtencion entidadGuardada = horarioRepository.save(horario);      
    	return horarioMapper.toResponseDto(entidadGuardada);
    }

    @Override
    public void eliminar(Long id) {
        horarioRepository.deleteById(id);
    }

    @Override
    public HorarioAtencionResponseDto buscarPorId(Long id) {
    	HorarioAtencion entidad = horarioRepository.findById(id).orElse(null);
        if (entidad == null) {
            return null;
        }
     // 3. Si todo está bien, la convertimos a DTO y la devolvemos
        return horarioMapper.toResponseDto(entidad);
        
    }
    
    public List <HorarioAtencionResponseDto> buscarPorPrioridad(int prioridad) {
    	List<HorarioAtencion> entidades = horarioRepository.findByPrioridad(prioridad);        return entidades.stream()
                .map(horarioMapper::toResponseDto)
                .collect(Collectors.toList());
    }
    @Override 
    //altaprioridad
    public List<HorarioAtencionResponseDto> buscarAltaPrioridad() {
        List<HorarioAtencion> entidades = horarioRepository.findByPrioridadGreaterThanEqual(4); 
        
        return entidades.stream()
                .map(entidad -> horarioMapper.toResponseDto(entidad)) 
                .collect(Collectors.toList());
    }

    @Override
    //baja prioridad
    public List<HorarioAtencionResponseDto> buscarBajaPrioridad() {
       
        List<HorarioAtencion> entidades = horarioRepository.findByPrioridadLessThanEqual(2); 
        
        return entidades.stream()
                .map(entidad -> horarioMapper.toResponseDto(entidad)) 
                .collect(Collectors.toList());
    }
    
    
    //STRING
    @Override
    public List<HorarioAtencionResponseDto> buscaralias(String alias) {
        
    	List<HorarioAtencion> entidades = horarioRepository.findByAliasContainingIgnoreCase(  alias);        
        return entidades.stream()
                .map(entidad -> horarioMapper.toResponseDto(entidad)) 
                .collect(Collectors.toList());
    }
    
    //STRING
    @Override 
 //NOMBRE IGUAL IGUAL QUE EN SERVIVE.JAVA AGREGABDOLE EL PUBLIC DELANTE.
   public  List<HorarioAtencionResponseDto> buscarporespecial(String especial) {
    	List<HorarioAtencion> entidades = horarioRepository.findByEspecialContainingIgnoreCase(especial);
        return entidades.stream()
                .map(entidad -> horarioMapper.toResponseDto(entidad)) 
                .collect(Collectors.toList());
    
    
}
}