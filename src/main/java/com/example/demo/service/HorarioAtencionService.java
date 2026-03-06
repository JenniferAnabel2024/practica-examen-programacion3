package com.example.demo.service;
import com.example.demo.entity.HorarioAtencion;
import java.util.List;
import com.example.demo.dto.response.HorarioAtencionResponseDto; // Para que reconozca el DTO
//SERVICE BUSCA EN LA BASE DE DATOS 
public interface HorarioAtencionService {
	List<HorarioAtencionResponseDto> buscarTodos();
    HorarioAtencionResponseDto guardar(HorarioAtencion horario);
    void eliminar(Long id);
    HorarioAtencionResponseDto buscarPorId(Long id);
    List<HorarioAtencionResponseDto> buscarPorPrioridad(int prioridad);
    List<HorarioAtencionResponseDto> buscarAltaPrioridad(); 
    List<HorarioAtencionResponseDto> buscarBajaPrioridad();
    //DEBE SABER QUE BUSCA UN TEXTO
    List <HorarioAtencionResponseDto>buscaralias(String alias);
    //COLOCAMOS NOMBRES MAS HUMANOS Y SIEMPRE RESPONSEDTO.
    List<HorarioAtencionResponseDto> buscarporespecial(String especial);
}
