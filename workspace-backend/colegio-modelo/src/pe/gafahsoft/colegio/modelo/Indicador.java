package pe.gafahsoft.colegio.modelo;

import pe.gafahsoft.colegio.bean.Comun;

public class Indicador extends Comun{

	private static final long serialVersionUID = -1795888614853738165L;
	
	private Integer areaId; 
	private Integer capacidadId; 
	private Integer nivel;
	
	private String valor;
	
	public Integer getAreaId() {
		return areaId;
	}
	public void setAreaId(Integer areaId) {
		this.areaId = areaId;
	}
	public Integer getCapacidadId() {
		return capacidadId;
	}
	public void setCapacidadId(Integer capacidadId) {
		this.capacidadId = capacidadId;
	}
	public Integer getNivel() {
		return nivel;
	}
	public void setNivel(Integer nivel) {
		this.nivel = nivel;
	}
	public String getValor() {
		return valor;
	}
	public void setValor(String valor) {
		this.valor = valor;
	} 
	
	
}
