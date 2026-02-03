package com.example.demo.dto.response;

public class HorarioAtencionResponseDto {

    private Long id;
    private Long medicoId; // Para mostrar el ID del médico vinculado
    private String diaSemana;
    private String horaInicio;
    private String horaFin;
    private Integer version; // Lo agregamos por si el profe lo pide como en el original

    // Constructor vacío
    public HorarioAtencionResponseDto() {}

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getMedicoId() { return medicoId; }
    public void setMedicoId(Long medicoId) { this.medicoId = medicoId; }

    public String getDiaSemana() { return diaSemana; }
    public void setDiaSemana(String diaSemana) { this.diaSemana = diaSemana; }

    public String getHoraInicio() { return horaInicio; }
    public void setHoraInicio(String horaInicio) { this.horaInicio = horaInicio; }

    public String getHoraFin() { return horaFin; }
    public void setHoraFin(String horaFin) { this.horaFin = horaFin; }

    public Integer getVersion() { return version; }
    public void setVersion(Integer version) { this.version = version; }
}