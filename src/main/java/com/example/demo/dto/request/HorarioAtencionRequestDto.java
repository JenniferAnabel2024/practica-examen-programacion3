package com.example.demo.dto.request;

import jakarta.validation.constraints.*;
// Importante: No hace falta el import de StringConcatFactory

public class HorarioAtencionRequestDto {
	
    // --- VALIDACIÓN DE TEXTO (String) ---
    @NotBlank(message = "El alias no debe quedar vacío")
    @Size(min = 4, max = 30, message = "El alias debe tener entre 4 y 30 caracteres")
    private String alias;
    
    @NotBlank(message = "El campo especial es obligatorio")
    private String especial;

    // --- VALIDACIÓN DE NÚMEROS (Integer para que acepte @NotNull) ---
    @NotNull(message = "La prioridad es obligatoria")
    @Min(value = 1, message = "Prioridad mínima es 1")
    @Max(value = 5, message = "Prioridad máxima es 5")
    private Integer prioridad;
    
    @NotNull(message = "El ID del médico es obligatorio")
    private Long medicoId;

    @NotNull(message = "El número de consultorio es obligatorio")
    private Integer numeroconsultorio;

    // --- TIPOS PRIMITIVOS (int y boolean como pidió el profe) ---
    @NotNull(message = "El nro de consultorio no debe ser nulo")
    private int nroconsultorio;

    private boolean libre; // Java lo pone en false por defecto si no viene

    // --- FORMATO DE TEXTO (Regex para horas) ---
    @NotBlank(message = "Debes indicar el día de la semana")
    private String diaSemana;

    @NotBlank(message = "La hora de inicio es obligatoria")
    @Pattern(regexp = "^([01]\\d|2[0-3]):([0-5]\\d)$", message = "Formato HH:mm")
    private String horaInicio;

    @NotBlank(message = "La hora de fin es obligatoria")
    @Pattern(regexp = "^([01]\\d|2[0-3]):([0-5]\\d)$", message = "Formato HH:mm")
    private String horaFin;

    // --- CONSTRUCTORES ---
    public HorarioAtencionRequestDto() {}

    // --- GETTERS Y SETTERS (Todos en minúscula) ---
    public String getAlias() { return alias; }
    public void setAlias(String alias) { this.alias = alias; }

    public String getEspecial() { return especial; }
    public void setEspecial(String especial) { this.especial = especial; }

    public Integer getPrioridad() { return prioridad; }
    public void setPrioridad(Integer prioridad) { this.prioridad = prioridad; }

    public Long getMedicoId() { return medicoId; }
    public void setMedicoId(Long medicoId) { this.medicoId = medicoId; }

    public boolean isLibre() { return libre; }
    public void setLibre(boolean libre) { this.libre = libre; }

    public Integer getNumeroconsultorio() { return numeroconsultorio; }
    public void setNumeroconsultorio(Integer numeroconsultorio) { this.numeroconsultorio = numeroconsultorio; }

    public int getNroconsultorio() { return nroconsultorio; }
    public void setNroconsultorio(int nroconsultorio) { this.nroconsultorio = nroconsultorio; }

    public String getDiaSemana() { return diaSemana; }
    public void setDiaSemana(String diaSemana) { this.diaSemana = diaSemana; }

    public String getHoraInicio() { return horaInicio; }
    public void setHoraInicio(String horaInicio) { this.horaInicio = horaInicio; }

    public String getHoraFin() { return horaFin; }
    public void setHoraFin(String horaFin) { this.horaFin = horaFin; }
}