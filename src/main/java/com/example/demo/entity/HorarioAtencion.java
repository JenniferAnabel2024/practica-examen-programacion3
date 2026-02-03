package com.example.demo.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity
@Table (name = "horario_atencion")
public class HorarioAtencion extends BaseEntity {
@ManyToOne
@JoinColumn (name = "medico_id",  referencedColumnName = "id")

private Medico medico;
private String diaSemana;
private String horaInicio;
private String horaFin;

public HorarioAtencion () {}
public HorarioAtencion ( Long id, Medico medico,String diaSemana, String HoraInicio, String HoraFin) {
	super(id); // Llama al ID de BaseEntity
    this.medico = medico;
    this.diaSemana = diaSemana;
    this.horaInicio = horaInicio;
    this.horaFin = horaFin;
}
//Getters y setters
//Para generarlos opción Source y Elegír  Generate Getters and Setters

public Medico getMedico() {
	
	return medico;
}
public void setMedico(Medico medico) {
	this.medico = medico;
}
public String getDiaSemana() {
	return diaSemana;
}
public void setDiaSemana(String diaSemana) {
	this.diaSemana = diaSemana;
}
public String getHoraInicio() {
	return horaInicio;
}
public void setHoraInicio(String horaInicio) {
	this.horaInicio = horaInicio;
}
public String getHoraFin() {
	return horaFin;
}
public void setHoraFin(String horaFin) {
	this.horaFin = horaFin;
}

}
