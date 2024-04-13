package pe.gafahsoft.colegio.web;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.apache.commons.beanutils.BeanUtils;
import org.primefaces.context.RequestContext;

import pe.gafahsoft.colegio.modelo.Maestra;
import pe.gafahsoft.colegio.util.Constantes;
@ManagedBean
@ViewScoped
public class MaestraBean extends GeneralBean<Maestra>{

	private static final long serialVersionUID = -861940491576056444L;

	private List<Maestra> listado = new ArrayList<>();

	private Maestra maestra = new Maestra();

	private String mantenimiento = "/mantenimiento/maestra/crudMaestra";

	public MaestraBean() {
		buscar();
		
	}

	public void agregar() {
		maestra = new Maestra();
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

	public void modificar(Maestra parametro) {
		Maestra objeto = new Maestra();
		try {
		BeanUtils.copyProperties(objeto, parametro);
		setMaestra(objeto);
		setDisableAgregar(true);
		setDisableModificar(false);
		setDisableEstado(false);
		
			RequestContext context = RequestContext.getCurrentInstance();
			context.execute("PF('dialogoAgregarMaestra').show();");

		} catch (Exception e) {
			e.printStackTrace();
			
		}
	}

	public void buscar() {
		Maestra objeto = new Maestra();
		objeto.setOpcion(Constantes.BUSCAR_TODOS);
		setListado(getGeneraServiceRemote().listar(objeto));
	}

	public void grabar() {
		RequestContext context = RequestContext.getCurrentInstance();
		maestra.setOpcion(Constantes.INSERTAR);
		try {
			Integer i = getGeneraServiceRemote().grabar(maestra);

			evaluarResultado(i);
			
			context.execute("PF('dialogoAgregarHora').hide();");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	public void actualizar() {
		RequestContext context = RequestContext.getCurrentInstance();
		maestra.setOpcion(Constantes.ACTUALIZAR);
		try {
			Integer i = getGeneraServiceRemote().grabar(maestra);
			buscar();
			evaluarResultado(i);
			context.execute("PF('dialogoAgregarMaestra').hide();");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<Maestra> getListado() {
		return listado;
	}

	public void setListado(List<Maestra> listado) {
		this.listado = listado;
	}

	public Maestra getMaestra() {
		return maestra;
	}

	public void setMaestra(Maestra maestra) {
		this.maestra = maestra;
	}

	public String getMantenimiento() {
		return mantenimiento;
	}

	public void setMantenimiento(String mantenimiento) {
		this.mantenimiento = mantenimiento;
	}

}
