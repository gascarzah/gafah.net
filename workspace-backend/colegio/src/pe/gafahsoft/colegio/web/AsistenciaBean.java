package pe.gafahsoft.colegio.web;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ComponentSystemEvent;
import javax.faces.model.SelectItem;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import pe.gafahsoft.colegio.modelo.Asistencia;
import pe.gafahsoft.colegio.modelo.AsistenciaDiaria;
import pe.gafahsoft.colegio.modelo.Maestra;
import pe.gafahsoft.colegio.util.Constantes;
@ManagedBean
@ViewScoped
public class AsistenciaBean extends GeneralBean<Asistencia> {

	private static final long serialVersionUID = 7648604115694129010L;
	private Asistencia asistencia = new Asistencia();
	List<AsistenciaDiaria> listadoAsistencias = new ArrayList<>();
	private Maestra nivel = new Maestra();
	private Maestra grado = new Maestra();
	
	
	
	public AsistenciaBean() {
		
		System.out.println("x acaf>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
	}

	
	public void initialize(ComponentSystemEvent event) {
		
	    if (!FacesContext.getCurrentInstance().isPostback()) {
	    	 try {					
	    		 	
//					cargarListaConsultorio();
							System.out.println(">>>><<<<<<");
				} catch (Exception e) {
					e.printStackTrace();
				}
	    	
	    }
	}
	
	@Override
	public void agregar() {
		
		
	}

	@Override
	public void modificar(Asistencia parametro) {
		
		
	}



	@Override
	public void grabar() {
		Asistencia asistencia = new Asistencia();
		asistencia.setProfeId(3);
		asistencia.setFecAsis(new Date());
		getGeneraServiceRemote().grabar(asistencia);
		for(int i=0; i<getListadoAsistencias().size();i++){
			AsistenciaDiaria asistenciaDiaria =getListadoAsistencias().get(i); 
//			System.out.println(asistenciaDiaria);
			getGeneraServiceRemote().grabar(asistenciaDiaria);
		}
		
	}

	@Override
	public void actualizar() {
		
		
	}

	@Override
	public void buscar() {
		AsistenciaDiaria parametros = new AsistenciaDiaria();
		parametros.setNivel(asistencia.getNivel());
		parametros.setOpcion(Constantes.BUSCAR_POR_ASISTENCIA);
		setListadoAsistencias(getGeneraServiceRemote().listar(parametros));
		asistencia.setNivel(-1);
	}

	public void buscarGrados(){
		List<Maestra> lista = buscarMaestra(getNivel().getMaesId());
		List<SelectItem> items = new ArrayList<>();
		
		if(CollectionUtils.isNotEmpty(lista)){
			for(Maestra maes : lista){
				SelectItem item = getSelectItem();
				item.setValue(maes.getMaesId());
				item.setLabel(StringUtils.trim(maes.getValor()+ " " + StringUtils.defaultString(maes.getDescCorta())));
				items.add(item);
				
			}
			setGrados(items);
		}
	}

	public List<AsistenciaDiaria> getListadoAsistencias() {
		return listadoAsistencias;
	}

	public void setListadoAsistencias(List<AsistenciaDiaria> listadoAsistencias) {
		this.listadoAsistencias = listadoAsistencias;
	}


	public Maestra getNivel() {
		return nivel;
	}

	public void setNivel(Maestra nivel) {
		this.nivel = nivel;
	}

	public Maestra getGrado() {
		return grado;
	}

	public void setGrado(Maestra grado) {
		this.grado = grado;
	}


	public Asistencia getAsistencia() {
		return asistencia;
	}


	public void setAsistencia(Asistencia asistencia) {
		this.asistencia = asistencia;
	}


	
	
}
