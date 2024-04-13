package pe.gafahsoft.colegio.modelo;

import pe.gafahsoft.colegio.bean.Persona;

public class Apoderado extends Persona {

	private static final long serialVersionUID = -8804768941500146393L;
	private String apodId;
	private String dniAlum;
	private String dniApod;

	private Integer alumId;
	
	private String ocupacion;
	public String getApodId() {
		return apodId;
	}

	public void setApodId(String apodId) {
		this.apodId = apodId;
	}

	private String centroTrabajo;
	private String telefTrabajo;
	private String anexoTrabajo;
	private String emailTrabajo;
	private String direcTrabajo;

	private Integer viveConHijo;
	
	public String getOcupacion() {
		return ocupacion;
	}

	public void setOcupacion(String ocupacion) {
		this.ocupacion = ocupacion;
	}

	public String getCentroTrabajo() {
		return centroTrabajo;
	}

	public void setCentroTrabajo(String centroTrabajo) {
		this.centroTrabajo = centroTrabajo;
	}

	public String getTelefTrabajo() {
		return telefTrabajo;
	}

	public void setTelefTrabajo(String telefTrabajo) {
		this.telefTrabajo = telefTrabajo;
	}

	public String getAnexoTrabajo() {
		return anexoTrabajo;
	}

	public void setAnexoTrabajo(String anexoTrabajo) {
		this.anexoTrabajo = anexoTrabajo;
	}

	public String getEmailTrabajo() {
		return emailTrabajo;
	}

	public void setEmailTrabajo(String emailTrabajo) {
		this.emailTrabajo = emailTrabajo;
	}

	public String getDirecTrabajo() {
		return direcTrabajo;
	}

	public void setDirecTrabajo(String direcTrabajo) {
		this.direcTrabajo = direcTrabajo;
	}

	public String getDniAlum() {
		return dniAlum;
	}

	public void setDniAlum(String dniAlum) {
		this.dniAlum = dniAlum;
	}

	public String getDniApod() {
		return dniApod;
	}

	public void setDniApod(String dniApod) {
		this.dniApod = dniApod;
	}

	public Integer getViveConHijo() {
		return viveConHijo;
	}

	public void setViveConHijo(Integer viveConHijo) {
		this.viveConHijo = viveConHijo;
	}

	public Integer getAlumId() {
		return alumId;
	}

	public void setAlumId(Integer alumId) {
		this.alumId = alumId;
	}

}