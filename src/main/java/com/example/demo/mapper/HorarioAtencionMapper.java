package com.example.demo.mapper;
// A MANO
import org.springframework.stereotype.Component;
import com.example.demo.dto.request.HorarioAtencionRequestDto;
import com.example.demo.dto.response.HorarioAtencionResponseDto;
import com.example.demo.entity.HorarioAtencion;
import com.example.demo.entity.Medico;
import com.example.demo.service.MedicoService;

@Component
public class HorarioAtencionMapper {
	//Declaracion

    private final MedicoService medicoService;
    //Constructor
    
    public HorarioAtencionMapper(MedicoService medicoService) {
        this.medicoService = medicoService;
    }
   //ENTRADA
    //Entrada: Recibe un requestDTO (lo que el usuario envió por internet).(El que CREA o RECIBE)  
    public HorarioAtencion fromDto(HorarioAtencionRequestDto requestDTO) throws Exception {
        if (requestDTO == null) return null;
        //creando una carpeta nueva y vacía.
        HorarioAtencion horarioEntity = new HorarioAtencion();

        if (requestDTO.getMedicoId() != null) {
            Medico medico = medicoService.buscarPorId(requestDTO.getMedicoId());
            if (medico != null) {
                horarioEntity.setMedico(medico);
            }
        }
    //requestDTO.get...(): Estás leyendo lo que el usuario escribió en el formulario (Request)
    //horarioEntity.set...(...): Estás escribiendo ese valor en la carpeta oficial que se va a guardar en la base de datos.    
        horarioEntity.setDiaSemana(requestDTO.getDiaSemana());
        horarioEntity.setHoraInicio(requestDTO.getHoraInicio());
        horarioEntity.setHoraFin(requestDTO.getHoraFin());
        horarioEntity.setPrioridad(requestDTO.getPrioridad());
        horarioEntity.setAlias(requestDTO.getAlias());
        horarioEntity.setEspecial(requestDTO.getEspecial());
        //BOOLEAN VA CON IS NO CON GET 
        horarioEntity.setLibre(requestDTO.isLibre());
        horarioEntity.setNumeroconsultorio(requestDTO.getNumeroconsultorio());

        return horarioEntity;
    }
    //SALIDA
  //Salida: Devuelve un HorarioAtencion (la entidad lista para ir al Repo).(El que MUESTRA AL USUARIO)
    public HorarioAtencionResponseDto toResponseDto(HorarioAtencion horarioEntity) {
        if (horarioEntity == null) return null;
        //CREANDO DTO DE RESPUESTA VACIA
        HorarioAtencionResponseDto responseDTO = new HorarioAtencionResponseDto();
        //La parte de la izquierda (el set) está escribiendo ese dato en el nuevo objeto de respuesta
        //La parte de la derecha (el get) está leyendo el dato que ya existe en la base de datos
        responseDTO.setId(horarioEntity.getId());
        responseDTO.setDiaSemana(horarioEntity.getDiaSemana());
        responseDTO.setHoraInicio(horarioEntity.getHoraInicio());
        responseDTO.setHoraFin(horarioEntity.getHoraFin());
        responseDTO.setPrioridad(horarioEntity.getPrioridad());
        responseDTO.setAlias(horarioEntity.getAlias());
        responseDTO.setEspecial(horarioEntity.getEspecial());
        //BOOLEAN VA CON IS NO CON GET 
        responseDTO.setLibre(horarioEntity.isLibre());
        responseDTO.setNumeroconsultorio(horarioEntity.getNumeroconsultorio());
        
        // Si la entidad tiene un médico, pasamos su ID al DTO de respuesta
        if (horarioEntity.getMedico() != null) {
            responseDTO.setMedicoId(horarioEntity.getMedico().getId());
        }
        
        return responseDTO;
    }
}