package pe.gafahsoft.colegio.modelo;

import pe.gafahsoft.colegio.bean.Comun;

public class Hora extends Comun {

	private static final long serialVersionUID = 410115756366231364L;

	private Integer horaId;

	private String inicio;

	private String fin;

	private Integer horaPedag;

	public Integer getHoraId() {
		return horaId;
	}

	public void setHoraId(Integer horaId) {
		this.horaId = horaId;
	}

	public String getInicio() {
		return inicio;
	}

	public void setInicio(String inicio) {
		this.inicio = inicio;
	}

	public String getFin() {
		return fin;
	}

	public void setFin(String fin) {
		this.fin = fin;
	}

	public Integer getHoraPedag() {
		return horaPedag;
	}

	public void setHoraPedag(Integer horaPedag) {
		this.horaPedag = horaPedag;
	}

	
}