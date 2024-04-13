package pe.gafahsoft.colegio.modelo;

import pe.gafahsoft.colegio.bean.Persona;

public class Alumno extends Persona {

	private static final long serialVersionUID = -8202564994014602526L;
	private Integer alumId;
	private Integer nivel;
	private Integer flagAsis;
	private String dniAlum;
	
	private String telefEmergencia;
	private String contactEmergencia;
	private Integer segEscolar;
	

	public String getDniAlum() {
		return dniAlum;
	}

	public String getTelefEmergencia() {
		return telefEmergencia;
	}

	public void setTelefEmergencia(String telefEmergencia) {
		this.telefEmergencia = telefEmergencia;
	}

	public String getContactEmergencia() {
		return contactEmergencia;
	}

	public void setContactEmergencia(String contactEmergencia) {
		this.contactEmergencia = contactEmergencia;
	}

	public void setDniAlum(String dniAlum) {
		this.dniAlum = dniAlum;
	}

	
	
	
	public Integer getNivel() {
		return nivel;
	}

	

	public void setNivel(Integer nivel) {
		this.nivel = nivel;
	}

	public Integer getFlagAsis() {
		return flagAsis;
	}

	public void setFlagAsis(Integer flagAsis) {
		this.flagAsis = flagAsis;
	}

	

	public Integer getSegEscolar() {
		return segEscolar;
	}

	public void setSegEscolar(Integer segEscolar) {
		this.segEscolar = segEscolar;
	}

	public Integer getAlumId() {
		return alumId;
	}

	public void setAlumId(Integer alumId) {
		this.alumId = alumId;
	}

	

}