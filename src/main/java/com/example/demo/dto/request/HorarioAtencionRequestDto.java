package com.example.demo.dto.request;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public class HorarioAtencionRequestDto {

    @NotNull(message = "El ID del médico es obligatorio")
    private Long medicoId;

    @NotBlank(message = "Debes indicar el día de la semana")
    private String diaSemana;

    @NotBlank(message = "La hora de inicio es obligatoria")
    @Pattern(regexp = "^([01]\\d|2[0-3]):([0-5]\\d)$", message = "Formato de hora inválido (HH:mm)")
    private String horaInicio;

    @NotBlank(message = "La hora de fin es obligatoria")
    @Pattern(regexp = "^([01]\\d|2[0-3]):([0-5]\\d)$", message = "Formato de hora inválido (HH:mm)")
    private String horaFin;

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
}