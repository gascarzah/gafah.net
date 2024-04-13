package pe.gafahsoft.colegio.service.impl;

import java.util.List;

import pe.gafahsoft.colegio.bean.MatriculadoBean;
import pe.gafahsoft.colegio.dao.AlumnoBeanDAOLocal;
import pe.gafahsoft.colegio.dao.ApoderadoBeanDAOLocal;
import pe.gafahsoft.colegio.dao.AreaBeanDAOLocal;
import pe.gafahsoft.colegio.dao.AsistenciaBeanDAOLocal;
import pe.gafahsoft.colegio.dao.AsistenciaDiariaBeanDAOLocal;
import pe.gafahsoft.colegio.dao.CapacidadBeanDAOLocal;
import pe.gafahsoft.colegio.dao.CitaBeanDAOLocal;
import pe.gafahsoft.colegio.dao.ColegioBeanDAOLocal;
import pe.gafahsoft.colegio.dao.DependienteBeanDAOLocal;
import pe.gafahsoft.colegio.dao.EmpleadoBeanDAOLocal;
import pe.gafahsoft.colegio.dao.HoraBeanDAOLocal;
import pe.gafahsoft.colegio.dao.HorarioBeanDAOLocal;
import pe.gafahsoft.colegio.dao.IndicadorBeanDAOLocal;
import pe.gafahsoft.colegio.dao.MaestraBeanDAOLocal;
import pe.gafahsoft.colegio.dao.MatriculaBeanDAOLocal;
import pe.gafahsoft.colegio.dao.MenuBeanDAOLocal;
import pe.gafahsoft.colegio.dao.NotaBeanDAOLocal;
import pe.gafahsoft.colegio.dao.OpcionMenuBeanDAOLocal;
import pe.gafahsoft.colegio.dao.ParteBeanDAOLocal;
import pe.gafahsoft.colegio.dao.UsuarioBeanDAOLocal;
import pe.gafahsoft.colegio.dao.impl.AlumnoBeanDAO;
import pe.gafahsoft.colegio.dao.impl.ApoderadoBeanDAO;
import pe.gafahsoft.colegio.dao.impl.AreaBeanDAO;
import pe.gafahsoft.colegio.dao.impl.AsistenciaBeanDAO;
import pe.gafahsoft.colegio.dao.impl.AsistenciaDiariaBeanDAO;
import pe.gafahsoft.colegio.dao.impl.CapacidadBeanDAO;
import pe.gafahsoft.colegio.dao.impl.CitaBeanDAO;
import pe.gafahsoft.colegio.dao.impl.ColegioDAO;
import pe.gafahsoft.colegio.dao.impl.DependienteBeanDAO;
import pe.gafahsoft.colegio.dao.impl.EmpleadoBeanDAO;
import pe.gafahsoft.colegio.dao.impl.HoraBeanDAO;
import pe.gafahsoft.colegio.dao.impl.HorarioBeanDAO;
import pe.gafahsoft.colegio.dao.impl.IndicadorDAO;
import pe.gafahsoft.colegio.dao.impl.MaestraBeanDAO;
import pe.gafahsoft.colegio.dao.impl.MatriculaBeanDAO;
import pe.gafahsoft.colegio.dao.impl.MenuBeanDAO;
import pe.gafahsoft.colegio.dao.impl.NotaBeanDAO;
import pe.gafahsoft.colegio.dao.impl.OpcionMenuBeanDAO;
import pe.gafahsoft.colegio.dao.impl.ParteBeanDAO;
import pe.gafahsoft.colegio.dao.impl.UsuarioBeanDAO;
import pe.gafahsoft.colegio.modelo.Alumno;
import pe.gafahsoft.colegio.modelo.Apoderado;
import pe.gafahsoft.colegio.modelo.Area;
import pe.gafahsoft.colegio.modelo.Asistencia;
import pe.gafahsoft.colegio.modelo.AsistenciaDiaria;
import pe.gafahsoft.colegio.modelo.Capacidad;
import pe.gafahsoft.colegio.modelo.Cita;
import pe.gafahsoft.colegio.modelo.Colegio;
import pe.gafahsoft.colegio.modelo.Dependiente;
import pe.gafahsoft.colegio.modelo.Empleado;
import pe.gafahsoft.colegio.modelo.Hora;
import pe.gafahsoft.colegio.modelo.Horario;
import pe.gafahsoft.colegio.modelo.Indicador;
import pe.gafahsoft.colegio.modelo.Maestra;
import pe.gafahsoft.colegio.modelo.Matricula;
import pe.gafahsoft.colegio.modelo.Menu;
import pe.gafahsoft.colegio.modelo.Nota;
import pe.gafahsoft.colegio.modelo.OpcionesMenu;
import pe.gafahsoft.colegio.modelo.Parte;
import pe.gafahsoft.colegio.modelo.Usuario;
import pe.gafahsoft.colegio.service.GeneralServiceRemote;

public class GeneralBeanService implements GeneralServiceRemote {

	AlumnoBeanDAOLocal alumnoBeanDAOLocal;

	ApoderadoBeanDAOLocal apoderadoBeanDAOLocal;

	AsistenciaBeanDAOLocal asistenciaBeanDAOLocal;

	AsistenciaDiariaBeanDAOLocal asistenciaDiariaBeanDAOLocal;

	CitaBeanDAOLocal citaBeanDAOLocal;

	ColegioBeanDAOLocal colegioBeanDAOLocal;

	EmpleadoBeanDAOLocal empleadoBeanDAOLocal;

	HoraBeanDAOLocal horaBeanDAOLocal;

	HorarioBeanDAOLocal horarioBeanDAOLocal;

	MaestraBeanDAOLocal maestraBeanDAOLocal;

	MatriculaBeanDAOLocal matriculaBeanDAOLocal;

	MenuBeanDAOLocal menuBeanDAOLocal;

	NotaBeanDAOLocal notaBeanDAOLocal;

	OpcionMenuBeanDAOLocal opcionMenuBeanDAOLocal;

	ParteBeanDAOLocal parteBeanDAOLocal;

	UsuarioBeanDAOLocal usuarioBeanDAOLocal;

	IndicadorBeanDAOLocal indicadorBeanDAOLocal;

	AreaBeanDAOLocal areaBeanDAOLocal;

	CapacidadBeanDAOLocal capacidadBeanDAOLocal;
	
	DependienteBeanDAOLocal   dependienteBeanDAOLocal;

	/**
	 * Default constructor.
	 */
	public GeneralBeanService() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Alumno> listar(Alumno parametros) {
		alumnoBeanDAOLocal = new AlumnoBeanDAO();
		return alumnoBeanDAOLocal.listar(parametros);
	}

	@Override
	public int grabar(Alumno parametros) {
		alumnoBeanDAOLocal = new AlumnoBeanDAO();
		return alumnoBeanDAOLocal.grabar(parametros);
	}

	@Override
	public List<Apoderado> listar(Apoderado parametros) {
		apoderadoBeanDAOLocal = new ApoderadoBeanDAO();
		return apoderadoBeanDAOLocal.listar(parametros);
	}

	@Override
	public int grabar(Apoderado parametros) {
		apoderadoBeanDAOLocal = new ApoderadoBeanDAO();
		return apoderadoBeanDAOLocal.grabar(parametros);
	}

	@Override
	public List<Asistencia> listar(Asistencia parametros) {
		asistenciaBeanDAOLocal = new AsistenciaBeanDAO();
		return asistenciaBeanDAOLocal.listar(parametros);
	}

	@Override
	public int grabar(Asistencia parametros) {
		asistenciaBeanDAOLocal = new AsistenciaBeanDAO();
		return asistenciaBeanDAOLocal.grabar(parametros);
	}

	@Override
	public List<AsistenciaDiaria> listar(AsistenciaDiaria parametros) {
		asistenciaDiariaBeanDAOLocal = new AsistenciaDiariaBeanDAO();
		return asistenciaDiariaBeanDAOLocal.listar(parametros);
	}

	@Override
	public int grabar(AsistenciaDiaria parametros) {
		asistenciaDiariaBeanDAOLocal = new AsistenciaDiariaBeanDAO();
		return asistenciaDiariaBeanDAOLocal.grabar(parametros);
	}

	@Override
	public List<Cita> listar(Cita parametros) {
		citaBeanDAOLocal = new CitaBeanDAO();
		return citaBeanDAOLocal.listar(parametros);
	}

	@Override
	public int grabar(Cita parametros) {
		citaBeanDAOLocal = new CitaBeanDAO();
		return citaBeanDAOLocal.grabar(parametros);
	}

	@Override
	public List<Colegio> listar(Colegio parametros) {
		colegioBeanDAOLocal = new ColegioDAO();
		return colegioBeanDAOLocal.listar(parametros);
	}

	@Override
	public int grabar(Colegio parametros) {
		colegioBeanDAOLocal = new ColegioDAO();
		return colegioBeanDAOLocal.grabar(parametros);
	}

	@Override
	public List<Empleado> listar(Empleado parametros) {
		empleadoBeanDAOLocal = new EmpleadoBeanDAO();
		return empleadoBeanDAOLocal.listar(parametros);
	}

	@Override
	public int grabar(Empleado parametros) {
		empleadoBeanDAOLocal = new EmpleadoBeanDAO();
		return empleadoBeanDAOLocal.grabar(parametros);
	}

	@Override
	public int grabar(Hora parametros) {
		horaBeanDAOLocal = new HoraBeanDAO();
		return horaBeanDAOLocal.grabar(parametros);
	}

	@Override
	public List<Hora> listar(Hora parametros) {
		horaBeanDAOLocal = new HoraBeanDAO();
		return horaBeanDAOLocal.listar(parametros);
	}

	@Override
	public List<Horario> listar(Horario parametros) {
		horarioBeanDAOLocal = new HorarioBeanDAO();
		return horarioBeanDAOLocal.listar(parametros);
	}

	@Override
	public int grabar(Horario parametros) {
		horarioBeanDAOLocal = new HorarioBeanDAO();
		return horarioBeanDAOLocal.grabar(parametros);
	}

	@Override
	public List<Maestra> buscarOpciones(Maestra parametros) {
		maestraBeanDAOLocal = new MaestraBeanDAO();
		return maestraBeanDAOLocal.buscarOpciones(parametros);
	}

	@Override
	public List<Maestra> listar(Maestra parametros) {
		maestraBeanDAOLocal = new MaestraBeanDAO();
		return maestraBeanDAOLocal.listar(parametros);
	}

	@Override
	public int grabar(Maestra parametros) {
		maestraBeanDAOLocal = new MaestraBeanDAO();
		return maestraBeanDAOLocal.grabar(parametros);
	}

	@Override
	public List<Matricula> listar(Matricula parametros) {
		matriculaBeanDAOLocal = new MatriculaBeanDAO();
		return matriculaBeanDAOLocal.listar(parametros);
	}

	@Override
	public int grabar(Matricula parametros) {
		matriculaBeanDAOLocal = new MatriculaBeanDAO();
		return matriculaBeanDAOLocal.grabar(parametros);
	}

	@Override
	public List<Menu> listar(Menu parametros) {
		menuBeanDAOLocal = new MenuBeanDAO();
		return menuBeanDAOLocal.listar(parametros);
	}

	@Override
	public List<Menu> getObtenerMenuPorPadre(Menu parametros) {
		menuBeanDAOLocal = new MenuBeanDAO();
		return menuBeanDAOLocal.getObtenerMenuPorPadre(parametros);
	}

	@Override
	public int grabar(Menu parametros) {
		menuBeanDAOLocal = new MenuBeanDAO();
		return menuBeanDAOLocal.grabar(parametros);
	}

	@Override
	public List<Nota> listar(Nota parametros) {
		notaBeanDAOLocal = new NotaBeanDAO();
		return notaBeanDAOLocal.listar(parametros);
	}

	@Override
	public int grabar(Nota parametros) {
		notaBeanDAOLocal = new NotaBeanDAO();
		return notaBeanDAOLocal.grabar(parametros);
	}

	@Override
	public List<OpcionesMenu> getOpcionesMenus(OpcionesMenu parametros) {
		opcionMenuBeanDAOLocal = new OpcionMenuBeanDAO();
		return opcionMenuBeanDAOLocal.getOpcionesMenus(parametros);
	}

	@Override
	public List<OpcionesMenu> listar(OpcionesMenu parametros) {
		opcionMenuBeanDAOLocal = new OpcionMenuBeanDAO();
		return opcionMenuBeanDAOLocal.listar(parametros);
	}

	@Override
	public int grabar(OpcionesMenu parametros) {
		opcionMenuBeanDAOLocal = new OpcionMenuBeanDAO();
		return opcionMenuBeanDAOLocal.grabar(parametros);
	}

	@Override
	public List<Parte> listar(Parte parametros) {
		parteBeanDAOLocal = new ParteBeanDAO();
		return parteBeanDAOLocal.listar(parametros);
	}

	@Override
	public int grabar(Parte parametros) {
		parteBeanDAOLocal = new ParteBeanDAO();
		return parteBeanDAOLocal.grabar(parametros);
	}

	@Override
	public List<Usuario> listar(Usuario parametros) {
		usuarioBeanDAOLocal = new UsuarioBeanDAO();
		return usuarioBeanDAOLocal.listar(parametros);
	}

	@Override
	public int grabar(Usuario parametros) {
		usuarioBeanDAOLocal = new UsuarioBeanDAO();
		return usuarioBeanDAOLocal.grabar(parametros);
	}

	@Override
	public List<MatriculadoBean> listarMatriculados(Alumno parametros) {
		matriculaBeanDAOLocal = new MatriculaBeanDAO();
		return matriculaBeanDAOLocal.listarMatriculados(parametros);
	}

	@Override
	public List<Indicador> listar(Indicador parametros) {
		indicadorBeanDAOLocal = new IndicadorDAO();
		return indicadorBeanDAOLocal.listar(parametros);
	}

	@Override
	public int grabar(Indicador parametros) {
		indicadorBeanDAOLocal = new IndicadorDAO();
		return indicadorBeanDAOLocal.grabar(parametros);
	}

	@Override
	public List<Area> listar(Area parametros) {
		areaBeanDAOLocal = new AreaBeanDAO();
		return areaBeanDAOLocal.listar(parametros);
	}

	@Override
	public int grabar(Area parametros) {
		areaBeanDAOLocal = new AreaBeanDAO();
		return areaBeanDAOLocal.grabar(parametros);
	}

	@Override
	public List<Capacidad> listar(Capacidad parametros) {
		capacidadBeanDAOLocal = new CapacidadBeanDAO();
		return capacidadBeanDAOLocal.listar(parametros);
	}

	@Override
	public int grabar(Capacidad parametros) {
		capacidadBeanDAOLocal = new CapacidadBeanDAO();
		return capacidadBeanDAOLocal.grabar(parametros);
	}


	public List<MatriculadoBean> listarAlumnos(Alumno parametro) {
		
			matriculaBeanDAOLocal = new MatriculaBeanDAO();
			return matriculaBeanDAOLocal.listarAlumnos(parametro);
		
	}

	@Override
	public int grabar(Dependiente parametros) {
		dependienteBeanDAOLocal = new DependienteBeanDAO();
		return dependienteBeanDAOLocal.grabar(parametros);
	}

	@Override
	public List<Dependiente> listar(Dependiente parametros) {
		dependienteBeanDAOLocal = new DependienteBeanDAO();
		return dependienteBeanDAOLocal.listar(parametros);
	}

	@Override
	public void eliminar(Nota nota) {
		notaBeanDAOLocal = new NotaBeanDAO();
		notaBeanDAOLocal.eliminar(nota);
		
	}
}
