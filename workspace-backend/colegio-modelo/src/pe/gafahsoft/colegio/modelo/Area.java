package pe.gafahsoft.colegio.modelo;

import pe.gafahsoft.colegio.bean.Comun;


public class Area extends Comun {
	private static final long serialVersionUID = 1L;
	private int areaId;
	private String curso;
	public int getAreaId() {
		return areaId;
	}
	public void setAreaId(int areaId) {
		this.areaId = areaId;
	}
	public String getCurso() {
		return curso;
	}
	public void setCurso(String curso) {
		this.curso = curso;
	}
	

}