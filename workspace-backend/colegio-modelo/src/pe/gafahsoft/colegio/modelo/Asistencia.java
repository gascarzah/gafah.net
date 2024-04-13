package pe.gafahsoft.colegio.modelo;

import java.util.Date;

public class Asistencia extends Alumno {

	private static final long serialVersionUID = 1804465587513138717L;

	private Integer asisId;
	private Integer profeId;
	
	public Integer getProfeId() {
		return profeId;
	}

	public void setProfeId(Integer profeId) {
		this.profeId = profeId;
	}

	private Integer empId;

	private Date fecAsis;

	public Integer getAsisId() {
		return asisId;
	}

	public void setAsisId(Integer asisId) {
		this.asisId = asisId;
	}

	public Integer getEmpId() {
		return empId;
	}

	public void setEmpId(Integer empId) {
		this.empId = empId;
	}

	public Date getFecAsis() {
		return fecAsis;
	}

	public void setFecAsis(Date fecAsis) {
		this.fecAsis = fecAsis;
	}

	
	

}