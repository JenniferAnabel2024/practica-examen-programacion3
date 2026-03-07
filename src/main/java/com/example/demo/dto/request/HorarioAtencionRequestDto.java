package com.example.demo.dto.request;
import java.lang.invoke.StringConcatFactory;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
//ACTUA COMO: filtro entre el mundo exterior (el usuario) y nuestro modelo de datos interno (la Entidad).Evita exponer la estructura real de la base de datos.
//APLICA LAS REGLAS ANTES DE QUE LOS DATOS LLEGUEN AL SERVICE
//Su función principal es transportar únicamente los datos necesarios para una operación específica
public class HorarioAtencionRequestDto {
	
	@NotBlank (message = "El alias no debe ser nulo")
	@Size (min = 4, max = 30, message = "El alias debe contener minimo 4 caraceteres y maximo 30")
	private String alias;
	
	@NotNull(message = "La prioridad no debe ser nula")
    @Min(value = 1, message = "La prioridad debe estar entre 1 y 5")
    @Max(value = 5, message = "La prioridad debe estar entre 1 y 5")
    private Integer prioridad;
	
    @NotNull(message = "El ID del médico es obligatorio")
    private Long medicoId;

    @NotBlank(message = "Debes indicar el día de la semana")
    private String diaSemana;

    @NotBlank(message = "La hora de inicio es obligatoria")
    @Pattern(regexp = "^([01]\\d|2[0-3]):([0-5]\\d)$", message = "Formato de hora inválido (HH:mm)")
    private String horaInicio;

    
    //NOT BLANK SOLO PARA TEXTO
    @NotBlank(message = "La hora de fin es obligatoria")
    @Pattern(regexp = "^([01]\\d|2[0-3]):([0-5]\\d)$", message = "Formato de hora inválido (HH:mm)")
    private String horaFin;
    
    @NotNull (message = "Lo especial no debe ser nulo")
    @Size (min = 4, max = 30, message = "Lo especial  debe contener minimo 4 caraceteres y maximo 30")
    //NO OLVIDAR ESCRIBIR AQUIIII LA VARIABLEEE!!
    private String especial;
    
    @NotNull (message = "El campo no debe quedar libre ")
    private boolean libre;
    
    
    
    // Constructores
    public HorarioAtencionRequestDto() {}

    

	



	// Getters y Setters
    public Long getMedicoId() { return medicoId; }
    public void setMedicoId(Long medicoId) { this.medicoId = medicoId; }
    public String getDiaSemana() { return diaSemana; }
    public void setDiaSemana(String diaSemana) { this.diaSemana = diaSemana; }
    public String getHoraInicio() { return horaInicio; }
    public void setHoraInicio(String horaInicio) { this.horaInicio = horaInicio; }
    public String getHoraFin() { return horaFin; }
    public void setHoraFin(String horaFin) { this.horaFin = horaFin; }
    public Integer getPrioridad() { return prioridad; }
    public void setPrioridad(Integer prioridad) { this.prioridad = prioridad; }
   
    public String getAlias () {return alias;}
    public void setAlias (String alias) { this.alias = alias;}
    
    public String getEspecial() {
		return especial;
	}

	public void setEspecial(String especial) {
		this.especial = especial;
	}
	public boolean isLibre() {
		return libre;
	}

	public void setLibre(boolean libre) {
		this.libre = libre;
	}
    }
