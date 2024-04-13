package pe.gafahsoft.colegio.bean;

import java.util.Date;

public class MatriculadoBean extends Comun {

	private static final long serialVersionUID = 4841608636111622010L;
	private Integer matriId;
	private String alumno;
	private String sexo;
	private Date fecNaci;
	private String anio;
	private String dni;
	private Integer nivel;
	private Integer nivelPadre;
	private String apeMate;
	private String apePate;
	private String nombres;
	private Integer alumId;
	
	public Integer getMatriId() {
		return matriId;
	}
	public void setMatriId(Integer matriId) {
		this.matriId = matriId;
	}
	public String getAlumno() {
		return alumno;
	}
	public void setAlumno(String alumno) {
		this.alumno = alumno;
	}
	
	public Date getFecNaci() {
		return fecNaci;
	}
	public void setFecNaci(Date fecNaci) {
		this.fecNaci = fecNaci;
	}
	public String getAnio() {
		return anio;
	}
	public void setAnio(String anio) {
		this.anio = anio;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public Integer getNivel() {
		return nivel;
	}
	public void setNivel(Integer nivel) {
		this.nivel = nivel;
	}
	public Integer getNivelPadre() {
		return nivelPadre;
	}
	public void setNivelPadre(Integer nivelPadre) {
		this.nivelPadre = nivelPadre;
	}
	public String getApeMate() {
		return apeMate;
	}
	public void setApeMate(String apeMate) {
		this.apeMate = apeMate;
	}
	public String getApePate() {
		return apePate;
	}
	public void setApePate(String apePate) {
		this.apePate = apePate;
	}
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	public Integer getAlumId() {
		return alumId;
	}
	public void setAlumId(Integer alumId) {
		this.alumId = alumId;
	}
	
	
	
}
