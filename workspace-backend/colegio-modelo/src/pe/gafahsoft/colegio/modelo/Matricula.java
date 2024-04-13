package pe.gafahsoft.colegio.modelo;

import java.util.Date;

public class Matricula extends Alumno {

	private static final long serialVersionUID = 2149910415567157640L;

	private Integer matriId;

	private Integer alumId;

	private Integer nivel;

	private Date fecMatri;

	private String observ;

	

	public Integer getMatriId() {
		return matriId;
	}

	public void setMatriId(Integer matriId) {
		this.matriId = matriId;
	}

	public Integer getAlumId() {
		return alumId;
	}

	public void setAlumId(Integer alumId) {
		this.alumId = alumId;
	}



	public Integer getNivel() {
		return nivel;
	}

	public void setNivel(Integer nivel) {
		this.nivel = nivel;
	}

	public Date getFecMatri() {
		return fecMatri;
	}

	public void setFecMatri(Date fecMatri) {
		this.fecMatri = fecMatri;
	}

	public String getObserv() {
		return observ;
	}

	public void setObserv(String observ) {
		this.observ = observ;
	}



	
}