package pe.gafahsoft.colegio.web;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.apache.commons.beanutils.BeanUtils;
import org.primefaces.context.RequestContext;

import pe.gafahsoft.colegio.modelo.Hora;
import pe.gafahsoft.colegio.util.Constantes;
@ManagedBean
@ViewScoped
public class HoraBean extends GeneralBean<Hora> {
	private static final long serialVersionUID = 819129076732939420L;

	private List<Hora> listadoHoras = new ArrayList<>();

	private Hora hora = new Hora();

	private String mantenimientoHora = "/mantenimiento/hora/crudHora";

	public HoraBean() {
		buscar();
		
	}

	public void agregar() {
		hora = new Hora();
		try {
			RequestContext context = RequestContext.getCurrentInstance();
			context.execute("PF('dialogoAgregarHora').show();");
			setDisableAgregar(false);
			setDisableModificar(true);
			setDisableEstado(true);
		} catch (Exception e) {
			e.printStackTrace();
			// log.error("Error en irMostrarMantenimientoMaestro(): " + e);
		}

	}

	public void modificar(Hora parametro) {
		Hora hora = new Hora();
		try {
		BeanUtils.copyProperties(hora, parametro);
		setHora(hora);
		setDisableAgregar(true);
		setDisableModificar(false);
		setDisableEstado(false);
		
			RequestContext context = RequestContext.getCurrentInstance();
			context.execute("PF('dialogoAgregarHora').show();");

		} catch (Exception e) {
			e.printStackTrace();
			
		}
	}

	public void buscar() {
		Hora hora = new Hora();
		hora.setOpcion(Constantes.BUSCAR_TODOS);
		setListadoHoras(getGeneraServiceRemote().listar(hora));
	}

	public void grabar() {
		RequestContext context = RequestContext.getCurrentInstance();
		hora.setOpcion(Constantes.INSERTAR);
		try {
			Integer i = getGeneraServiceRemote().grabar(hora);

			evaluarResultado(i);
			
			context.execute("PF('dialogoAgregarHora').hide();");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	public void actualizar() {
		RequestContext context = RequestContext.getCurrentInstance();
		hora.setOpcion(Constantes.ACTUALIZAR);
		try {
			Integer i = getGeneraServiceRemote().grabar(hora);
			buscar();
			evaluarResultado(i);
			context.execute("PF('dialogoAgregarHora').hide();");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	

	public List<Hora> getListadoHoras() {
		return listadoHoras;
	}

	public void setListadoHoras(List<Hora> listadoHoras) {
		this.listadoHoras = listadoHoras;
	}

	public Hora getHora() {
		return hora;
	}

	public void setHora(Hora hora) {
		this.hora = hora;
	}

	public String getMantenimientoHora() {
		return mantenimientoHora;
	}

	public void setMantenimientoHora(String mantenimientoHora) {
		this.mantenimientoHora = mantenimientoHora;
	}



	
}
