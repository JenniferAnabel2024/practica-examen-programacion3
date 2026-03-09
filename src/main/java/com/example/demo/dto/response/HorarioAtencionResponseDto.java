package com.example.demo.dto.response;

public class HorarioAtencionResponseDto {

    private Long id;
    private Long medicoId; // Para mostrar el ID del médico vinculado
    private String diaSemana;
    private String horaInicio;
    private String horaFin;
    private Integer version;
    private Integer prioridad;
    private String alias;
    private String especial;
    private boolean libre;
    private Integer numeroconsultorio;
    private int nroconsultorio;
    
    
   
	
	public String getEspecial() {
		return especial;}

	

	// Constructor vacío
    public HorarioAtencionResponseDto() {}

    // Getters y Setters // El GET (La salida)    // El SET (La entrada)

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
    
    //INTEGER
    public Integer getVersion() { return version; }
    public void setVersion(Integer version) { this.version = version; }
    
    //INTEGER
    public Integer getPrioridad() { return prioridad; }
    public void setPrioridad(Integer prioridad) { this.prioridad = prioridad;}
    
    //STRING
    public String getAlias() {return alias;}
    public void setAlias (String alias) {this.alias = alias;}
    
    //BOOLEAN 
    public void setEspecial(String especial) {this.especial = especial;}

	public void setLibre(boolean libre) {this.libre = libre;}
    
	 public Integer getNumeroconsultorio() {
			return numeroconsultorio;}

		public void setNumeroconsultorio( Integer numeroconsultorio) {this.numeroconsultorio = numeroconsultorio;}



		public int getNroconsultorio() {return nroconsultorio;}



		public void setNroconsultorio(int nroconsultorio) {this.nroconsultorio = nroconsultorio;}
		
		
    
}