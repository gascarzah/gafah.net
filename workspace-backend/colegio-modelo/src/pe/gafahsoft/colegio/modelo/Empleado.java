package pe.gafahsoft.colegio.modelo;

import pe.gafahsoft.colegio.bean.Persona;

public class Empleado extends Persona {

	private static final long serialVersionUID = -4344978860915888573L;

	private Integer empId;

	private Integer cursoId;

	public Integer getEmpId() {
		return empId;
	}

	public void setEmpId(Integer empId) {
		this.empId = empId;
	}

	public Integer getCursoId() {
		return cursoId;
	}

	public void setCursoId(Integer cursoId) {
		this.cursoId = cursoId;
	}

	
}