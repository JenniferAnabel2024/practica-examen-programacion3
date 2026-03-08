package com.example.demo.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
//La Entidad es el plano para construir la tabla en la base de datos (como el SQL).

@Entity
@Table (name = "horario_atencion")
public class HorarioAtencion extends BaseEntityPractica {
@ManyToOne
@JoinColumn (name = "medico_id",  referencedColumnName = "id", nullable = false)
// si quiero que no sea nulo (nullable = false)dentro del @JoinColumn
private Medico medico;
private String diaSemana;
private String horaInicio;
private String horaFin;
private int prioridad;
private String especial;
@NotNull
private String alias;
@NotNull 
private boolean libre;
@NotNull
private Integer numeroconsultorio;


public HorarioAtencion () {}
public HorarioAtencion ( Long id, Medico medico,String diaSemana, String HoraInicio, String HoraFin, int prioridad, String alias, String especial, boolean libre, Integer numeroconsultorio) {
	super(id); // Llama al ID de BaseEntity
    this.medico = medico;
    this.diaSemana = diaSemana;
    this.horaInicio = horaInicio;
    this.horaFin = horaFin;
    this.prioridad = prioridad;
    this.alias = alias;
    this.especial = especial;
    this.libre = libre;
    this.numeroconsultorio = numeroconsultorio;
}
//Getters y setters
//Para generarlos opción Source y Elegír  Generate Getters and Setters
// EL GET LE PIDE EL DATO A LA VARIABLE PRIVADA Y ES LA PUERTA DE SALIDA AL MAPPER


public String getEspecial() {
	return especial;
}
public void setEspecial(String especial) {
	this.especial = especial;
}
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
public int getPrioridad() {
    return prioridad;
}
public void setPrioridad (int prioridad) {
	this.prioridad =prioridad;
}
public String getAlias() {
    return alias;
}
public void setAlias (String alias) {
	this.alias =alias;
}
public boolean isLibre() {
	return libre;
}
public void setLibre(boolean libre) {
	this.libre = libre;
}
public Integer getNumeroconsultorio() {
	return numeroconsultorio;
}
public void setNumeroconsultorio(Integer numeroconsultorio) {
	this.numeroconsultorio = numeroconsultorio;
}

}
