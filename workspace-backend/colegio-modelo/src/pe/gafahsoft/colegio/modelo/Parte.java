package pe.gafahsoft.colegio.modelo;

import java.util.Date;

import pe.gafahsoft.colegio.bean.Comun;

public class Parte extends Comun {

	private static final long serialVersionUID = -1705814846774916682L;

	private Integer parteId;

	private Integer horarioId;

	private Date fecParte;

	private String temaDia;

	private String conteTemaDia;

	private String observ;

	

	public Integer getParteId() {
		return parteId;
	}

	public void setParteId(Integer parteId) {
		this.parteId = parteId;
	}

	public Integer getHorarioId() {
		return horarioId;
	}

	public void setHorarioId(Integer horarioId) {
		this.horarioId = horarioId;
	}

	public Date getFecParte() {
		return fecParte;
	}

	public void setFecParte(Date fecParte) {
		this.fecParte = fecParte;
	}

	public String getTemaDia() {
		return temaDia;
	}

	public void setTemaDia(String temaDia) {
		this.temaDia = temaDia;
	}

	public String getConteTemaDia() {
		return conteTemaDia;
	}

	public void setConteTemaDia(String conteTemaDia) {
		this.conteTemaDia = conteTemaDia;
	}

	public String getObserv() {
		return observ;
	}

	public void setObserv(String observ) {
		this.observ = observ;
	}

}