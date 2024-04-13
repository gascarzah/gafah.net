package pe.gafahsoft.colegio.modelo;

import pe.gafahsoft.colegio.bean.Comun;

public class Colegio extends Comun {

	private static final long serialVersionUID = 1953046053337422649L;

	

	private String descCorta;

	private String descLarga;

	private Integer habilitado;



	public String getDescCorta() {
		return descCorta;
	}

	public void setDescCorta(String descCorta) {
		this.descCorta = descCorta;
	}

	public String getDescLarga() {
		return descLarga;
	}

	public void setDescLarga(String descLarga) {
		this.descLarga = descLarga;
	}

	public Integer getHabilitado() {
		return habilitado;
	}

	public void setHabilitado(Integer habilitado) {
		this.habilitado = habilitado;
	}



}