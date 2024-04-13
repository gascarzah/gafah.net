package pe.gafahsoft.colegio.modelo;

import java.util.Date;

import pe.gafahsoft.colegio.bean.Comun;

public class Cita extends Comun {

	private static final long serialVersionUID = -2986529763881222139L;

	private Integer citaId;
	private Integer profeId;
	public Integer getProfeId() {
		return profeId;
	}

	public void setProfeId(Integer profeId) {
		this.profeId = profeId;
	}

	private Integer empId;

	private Integer matriId;

	private Date fecCita;

	private String envioMail;

	public Integer getCitaId() {
		return citaId;
	}

	public void setCitaId(Integer citaId) {
		this.citaId = citaId;
	}

	public Integer getEmpId() {
		return empId;
	}

	public void setEmpId(Integer empId) {
		this.empId = empId;
	}

	public Integer getMatriId() {
		return matriId;
	}

	public void setMatriId(Integer matriId) {
		this.matriId = matriId;
	}

	public Date getFecCita() {
		return fecCita;
	}

	public void setFecCita(Date fecCita) {
		this.fecCita = fecCita;
	}

	public String getEnvioMail() {
		return envioMail;
	}

	public void setEnvioMail(String envioMail) {
		this.envioMail = envioMail;
	}

	

}