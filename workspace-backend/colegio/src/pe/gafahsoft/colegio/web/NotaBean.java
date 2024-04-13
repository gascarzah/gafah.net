package pe.gafahsoft.colegio.web;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import pe.gafahsoft.colegio.modelo.Area;
import pe.gafahsoft.colegio.modelo.Capacidad;
import pe.gafahsoft.colegio.modelo.Nota;

@ManagedBean(name="notaHandle")
@ViewScoped
public class NotaBean extends GeneralBean<NotaBean> {

	private static final long serialVersionUID = 1926934776491701473L;

	private Nota nota = new Nota();
	private List<Area> areas= new ArrayList<>();
	private List<Capacidad> capacidades= new ArrayList<>();
	
	@Override
	public void agregar() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modificar(NotaBean parametro) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void buscar() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void grabar() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actualizar() {
		// TODO Auto-generated method stub
		
	}

	public List<Area> getAreas() {
		return areas;
	}

	public void setAreas(List<Area> areas) {
		this.areas = areas;
	}

	public List<Capacidad> getCapacidades() {
		return capacidades;
	}

	public void setCapacidades(List<Capacidad> capacidades) {
		this.capacidades = capacidades;
	}

	public Nota getNota() {
		return nota;
	}

	public void setNota(Nota nota) {
		this.nota = nota;
	}
	
	

}
