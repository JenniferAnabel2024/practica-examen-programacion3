package com.example.demo.mapper;

import org.springframework.stereotype.Component;
import com.example.demo.dto.request.HorarioAtencionRequestDto;
import com.example.demo.dto.response.HorarioAtencionResponseDto;
import com.example.demo.entity.HorarioAtencion;
import com.example.demo.entity.Medico;
import com.example.demo.service.MedicoService;

@Component
public class HorarioAtencionMapper {

    private final MedicoService medicoService;

    public HorarioAtencionMapper(MedicoService medicoService) {
        this.medicoService = medicoService;
    }

    // 📩 FROM DTO: De la web a la Base de Datos (Para Guardar/Crear)
    public HorarioAtencion fromDto(HorarioAtencionRequestDto requestDTO) throws Exception {
        if (requestDTO == null) return null;

        HorarioAtencion horarioEntity = new HorarioAtencion();

        // Buscamos el objeto médico real usando el ID que vino en el Request
        if (requestDTO.getMedicoId() != null) {
            Medico medico = medicoService.buscarPorId(requestDTO.getMedicoId());
            if (medico != null) {
                horarioEntity.setMedico(medico);
            }
        }

        // Mapeo de campos simples
        horarioEntity.setDiaSemana(requestDTO.getDiaSemana());
        horarioEntity.setHoraInicio(requestDTO.getHoraInicio());
        horarioEntity.setHoraFin(requestDTO.getHoraFin());
        horarioEntity.setPrioridad(requestDTO.getPrioridad());
        horarioEntity.setAlias(requestDTO.getAlias());
        horarioEntity.setEspecial(requestDTO.getEspecial());
        
        // BOOLEAN: Recordá que en el DTO se usa isLibre()
        horarioEntity.setLibre(requestDTO.isLibre());
        
        // NÚMEROS: Integer e int
        horarioEntity.setNumeroconsultorio(requestDTO.getNumeroconsultorio());
        horarioEntity.setNroconsultorio(requestDTO.getNroconsultorio());

        return horarioEntity;
    }

    // 📤 TO DTO: De la Base de Datos a la web (Para Mostrar)
    public HorarioAtencionResponseDto toResponseDto(HorarioAtencion horarioEntity) {
        if (horarioEntity == null) return null;

        HorarioAtencionResponseDto responseDTO = new HorarioAtencionResponseDto();

        responseDTO.setId(horarioEntity.getId());
        responseDTO.setDiaSemana(horarioEntity.getDiaSemana());
        responseDTO.setHoraInicio(horarioEntity.getHoraInicio());
        responseDTO.setHoraFin(horarioEntity.getHoraFin());
        responseDTO.setPrioridad(horarioEntity.getPrioridad());
        responseDTO.setAlias(horarioEntity.getAlias());
        responseDTO.setEspecial(horarioEntity.getEspecial());
        
        // BOOLEAN: Mantenemos la consistencia
        responseDTO.setLibre(horarioEntity.isLibre());
        
        responseDTO.setNumeroconsultorio(horarioEntity.getNumeroconsultorio());
        responseDTO.setNroconsultorio(horarioEntity.getNroconsultorio());

        // Para la respuesta, devolvemos solo el ID del médico para no sobrecargar de datos
        if (horarioEntity.getMedico() != null) {
            responseDTO.setMedicoId(horarioEntity.getMedico().getId());
        }
        
        return responseDTO;
    }
}