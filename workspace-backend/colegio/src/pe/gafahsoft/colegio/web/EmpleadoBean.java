package pe.gafahsoft.colegio.web;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.apache.commons.beanutils.BeanUtils;
import org.primefaces.context.RequestContext;

import pe.gafahsoft.colegio.modelo.Empleado;

@ManagedBean
@ViewScoped
public class EmpleadoBean extends GeneralBean<Empleado> {
	private static final long serialVersionUID = 819129076732939420L;

	private List<Empleado> listadoEmpleado = new ArrayList<>();

	private Empleado empleado = new Empleado();

	private String mantenimientoEmpleado = "/aula/mantenimientoEmpleado";

	public EmpleadoBean() {
		buscar();
		
	}

	public void agregar() {
		empleado = new Empleado();
		try {
			RequestContext context = RequestContext.getCurrentInstance();
			context.execute("PF('dialogoAgregarAula').show();");
			setDisableAgregar(false);
			setDisableModificar(true);
			setDisableEstado(true);
		} catch (Exception e) {
			e.printStackTrace();
			// log.error("Error en irMostrarMantenimientoMaestro(): " + e);
		}

	}

	public void modificar(Empleado parametro) {
		Empleado empleado = new Empleado();
		
		try {
			
		BeanUtils.copyProperties(empleado, parametro);
		
		setEmpleado(empleado);
		
		setDisableAgregar(true);
		setDisableModificar(false);
		setDisableEstado(false);
		
			RequestContext context = RequestContext.getCurrentInstance();
			context.execute("PF('dialogoAgregarEmpleado').show();");

		} catch (Exception e) {
			e.printStackTrace();
			// log.error("Error en irMostrarMantenimientoMaestro(): " + e);
		}
	}

	public void buscar() {
		Empleado empleado = new Empleado();
		setListadoEmpleado(getGeneraServiceRemote().listar(empleado));
	}

	public void grabar() {
		RequestContext context = RequestContext.getCurrentInstance();
		try {
			Integer i = getGeneraServiceRemote().grabar(empleado);

			evaluarResultado(i);
			
			context.execute("PF('dialogoAgregarEmpleado').hide();");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	public void actualizar() {
		RequestContext context = RequestContext.getCurrentInstance();
		try {
			Integer i = getGeneraServiceRemote().grabar(empleado);
			buscar();
			evaluarResultado(i);
			context.execute("PF('dialogoAgregarEmpleado').hide();");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<Empleado> getListadoEmpleado() {
		return listadoEmpleado;
	}

	public void setListadoEmpleado(List<Empleado> listadoEmpleado) {
		this.listadoEmpleado = listadoEmpleado;
	}

	public Empleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

	public String getMantenimientoEmpleado() {
		return mantenimientoEmpleado;
	}

	public void setMantenimientoEmpleado(String mantenimientoEmpleado) {
		this.mantenimientoEmpleado = mantenimientoEmpleado;
	}





}
