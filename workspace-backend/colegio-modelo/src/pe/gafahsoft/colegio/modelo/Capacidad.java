package pe.gafahsoft.colegio.modelo;

import pe.gafahsoft.colegio.bean.Comun;



public class Capacidad extends Comun {

	private static final long serialVersionUID = -5898740921511622455L;
	
	private Integer capacidadId;
	private Integer areaId;
	private String descripcion;
	public Integer getCapacidadId() {
		return capacidadId;
	}
	public void setCapacidadId(Integer capacidadId) {
		this.capacidadId = capacidadId;
	}
	public Integer getAreaId() {
		return areaId;
	}
	public void setAreaId(Integer areaId) {
		this.areaId = areaId;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
	
	
}