package pe.gafahsoft.colegio.modelo;

import pe.gafahsoft.colegio.bean.Comun;

public class Horario extends Comun {

	private static final long serialVersionUID = -2255978397665879292L;

	private Integer horarioId;
	private Integer profeId;
	public Integer getProfeId() {
		return profeId;
	}

	public void setProfeId(Integer profeId) {
		this.profeId = profeId;
	}

	private Integer nivel;

	private Integer horaId;

	private Integer empId;

	private Integer dia;

	

	public Integer getHorarioId() {
		return horarioId;
	}

	public void setHorarioId(Integer horarioId) {
		this.horarioId = horarioId;
	}



	public Integer getNivel() {
		return nivel;
	}

	public void setNivel(Integer nivel) {
		this.nivel = nivel;
	}

	public Integer getHoraId() {
		return horaId;
	}

	public void setHoraId(Integer horaId) {
		this.horaId = horaId;
	}

	public Integer getEmpId() {
		return empId;
	}

	public void setEmpId(Integer empId) {
		this.empId = empId;
	}

	public Integer getDia() {
		return dia;
	}

	public void setDia(Integer dia) {
		this.dia = dia;
	}



}