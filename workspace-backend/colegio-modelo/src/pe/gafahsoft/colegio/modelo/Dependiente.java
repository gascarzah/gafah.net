package pe.gafahsoft.colegio.modelo;

import pe.gafahsoft.colegio.bean.Comun;

public class Dependiente extends Comun{
	
	private static final long serialVersionUID = 1617434074139679483L;
	private Integer dependId;
	private Integer alumId;
	private Integer apodId;

	public Integer getAlumId() {
		return alumId;
	}
	public void setAlumId(Integer alumId) {
		this.alumId = alumId;
	}
	public Integer getApodId() {
		return apodId;
	}
	public void setApodId(Integer apodId) {
		this.apodId = apodId;
	}
	public Integer getDependId() {
		return dependId;
	}
	public void setDependId(Integer dependId) {
		this.dependId = dependId;
	}
	
	
	
}
