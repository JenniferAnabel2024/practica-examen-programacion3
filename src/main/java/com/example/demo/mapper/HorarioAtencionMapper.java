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

    public HorarioAtencion fromDto(HorarioAtencionRequestDto requestDTO) throws Exception {
        if (requestDTO == null) return null;
        HorarioAtencion horarioEntity = new HorarioAtencion();

        if (requestDTO.getMedicoId() != null) {
            Medico medico = medicoService.buscarPorId(requestDTO.getMedicoId());
            if (medico != null) {
                horarioEntity.setMedico(medico);
            }
        }

        horarioEntity.setDiaSemana(requestDTO.getDiaSemana());
        horarioEntity.setHoraInicio(requestDTO.getHoraInicio());
        horarioEntity.setHoraFin(requestDTO.getHoraFin());
        return horarioEntity;
    }

    public HorarioAtencionResponseDto toResponseDto(HorarioAtencion horarioEntity) {
        if (horarioEntity == null) return null;
        HorarioAtencionResponseDto responseDTO = new HorarioAtencionResponseDto();
        
        responseDTO.setId(horarioEntity.getId());
        responseDTO.setDiaSemana(horarioEntity.getDiaSemana());
        responseDTO.setHoraInicio(horarioEntity.getHoraInicio());
        responseDTO.setHoraFin(horarioEntity.getHoraFin());
        
        // ESTA ES LA LÍNEA QUE FALTA:
        // Si la entidad tiene un médico, pasamos su ID al DTO de respuesta
        if (horarioEntity.getMedico() != null) {
            responseDTO.setMedicoId(horarioEntity.getMedico().getId());
        }
        
        return responseDTO;
    }
}