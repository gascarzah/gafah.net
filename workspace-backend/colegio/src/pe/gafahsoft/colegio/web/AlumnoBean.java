package pe.gafahsoft.colegio.web;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.primefaces.context.RequestContext;

import pe.gafahsoft.colegio.bean.MatriculadoBean;
import pe.gafahsoft.colegio.modelo.Alumno;
import pe.gafahsoft.colegio.modelo.Apoderado;
import pe.gafahsoft.colegio.modelo.Dependiente;
import pe.gafahsoft.colegio.modelo.Indicador;
import pe.gafahsoft.colegio.modelo.Maestra;
import pe.gafahsoft.colegio.modelo.Matricula;
import pe.gafahsoft.colegio.modelo.Nota;
import pe.gafahsoft.colegio.util.Constantes;
import pe.gafahsoft.colegio.util.UWebUtil;

@ManagedBean
@ViewScoped
public class AlumnoBean extends GeneralBean<Alumno> {

	private static final long serialVersionUID = 839410248736708522L;

	private Alumno parametro = new Alumno();
	private Alumno alumpar = new Alumno();
	private String tituloModificar;
	private String tituloAgregar;

	// private List<SelectItem> grados = new ArrayList<>();
	private List<MatriculadoBean> matriculados = new ArrayList<>();

	// private String manteAlumno = "/matricula/registroMatricula";
	private String manteAlumno = "/matricula/registroAlumno";
	private String manteApoderado = "/matricula/registroApoderado";
//	private String pbuscarAlumno = "/matricula/buscarDatosAlumno";
	private Maestra nivel = new Maestra();
	private Maestra grado = new Maestra();
	private Alumno alumno = new Alumno();

	// private Apoderado padre = new Apoderado();
	// private Apoderado madre = new Apoderado();
	private Apoderado apoderado = new Apoderado();
	private Matricula matricula = new Matricula();

	private boolean filaMatricula;

	private int btnGrabar;

	public AlumnoBean() {
		// setEstadoCivil(buscarMaestra(Constantes.COD_TABLA_ESTADO_CIVIL));
		 buscar();
		// setMatriculados(new ArrayList<>());

		setEstados(buscarMaestra(Constantes.COD_TABLA_ESTADO));
		setNiveles(buscarMaestra(Constantes.COD_TABLA_NIVELES));
	}

	public void buscarGrados() {
		if (getNivel().getMaesId() != null) {
			List<Maestra> lista = buscarMaestra(getNivel().getMaesId());
			List<SelectItem> items = new ArrayList<>();

			if (CollectionUtils.isNotEmpty(lista)) {
				for (Maestra maes : lista) {
					SelectItem item = getSelectItem();
					item.setValue(maes.getMaesId());
					item.setLabel(
							StringUtils.trim(maes.getValor() + " " + StringUtils.defaultString(maes.getDescCorta())));
					items.add(item);

				}
				setGrados(items);
			
			}
		}
	}

	public String irRegistro() {

		return manteAlumno;
	}

	@Override
	public void agregar() {
		UWebUtil util = new UWebUtil();
		String flag = util.obtenerParametroServidor("habilitar");
		setFilaMatricula(Boolean.parseBoolean(flag));

		if (isFilaMatricula()) {
			setTituloAgregar("AGREGAR MATRICULA");
			setBtnGrabar(Constantes.GRABAR_MATRICULA);
		} else {
			setTituloAgregar("AGREGAR ALUMNO");
			setBtnGrabar(Constantes.GRABAR_ALUMNO);
		}

		alumno = new Alumno();
		alumno.setOpcion(Constantes.INSERTAR);
		nivel = new Maestra();
		try {
			RequestContext context = RequestContext.getCurrentInstance();
			context.execute("PF('dialogoAgregarAlumno').show();");
			setDisableAgregar(false);
			setDisableModificar(true);
			setDisableEstado(true);
		} catch (Exception e) {
			// e.printStackTrace();
			// log.error("Error en irMostrarMantenimientoMaestro(): " + e);
		}

	}

	@Override
	public void modificar(Alumno parametro) {
		// TODO Auto-generated method stub

	}

	public void irModificar(MatriculadoBean matriculado) {
		UWebUtil util = new UWebUtil();
		String flag = util.obtenerParametroServidor("habilitar");
		setFilaMatricula(Boolean.parseBoolean(flag));

		if (isFilaMatricula()) {
			setTituloAgregar("MODIFICAR MATRICULA");
			setBtnGrabar(Constantes.MODIFICAR_MATRICULA);
		} else {
			setTituloAgregar("MODIFICAR ALUMNO");
			setBtnGrabar(Constantes.MODIFICAR_ALUMNO);
		}

		setEstadoCivil(buscarMaestra(Constantes.COD_TABLA_ESTADO_CIVIL));
		Alumno filtro = new Alumno();
		filtro.setDniAlum(matriculado.getDni());
		filtro.setOpcion(Constantes.BUSCAR_POR_DNI_ALUMNO);
		List<Alumno> listAlumno = getGeneraServiceRemote().listar(filtro);
		
		try {
			if (CollectionUtils.isNotEmpty(listAlumno)) {
				Alumno alumno = listAlumno.get(0);
				getNivel().setMaesId(matriculado.getNivelPadre());
				getMatricula().setNivel(matriculado.getNivel());	
				alumno.setNivel(matriculado.getNivel());
				alumno.setOpcion(Constantes.ACTUALIZAR);
				setAlumno(alumno);
			}

			setDisableAgregar(true);
			setDisableModificar(false);
			setDisableEstado(false);

			RequestContext context = RequestContext.getCurrentInstance();
			context.execute("PF('dialogoAgregarAlumno').show();");

		} catch (Exception e) {
			// e.printStackTrace();

		}

	}


	public void cerrarDialog(){
		UWebUtil util = new UWebUtil();
		String result = util.obtenerParametroServidor("cerrar");
		RequestContext context = RequestContext.getCurrentInstance();
		String dialog ="";
		if(result.equals("1")){
			dialog = "'dialogoAgregarAlumno'";
			if(!isFilaMatricula()){
				System.out.println("entro 1");
				buscarAlumno();
			}else{
				System.out.println("entro 2");
				buscar();
			}
		}else if(result.equals("2")){
			dialog = "'dialogoAgregarApoderado'";
			
		}
		context.execute("PF("+dialog+").hide();");
	}
	
	@Override
	public void buscar() {
		parametro.setAnio(String.valueOf(Calendar.getInstance().get(Calendar.YEAR)));
		parametro.setCodColegio(getUsuario().getCodColegio());
		setMatriculados(getGeneraServiceRemote().listarMatriculados(parametro));

	}
	
	public void buscarAlumno() {

		setMatriculados(getGeneraServiceRemote().listarAlumnos(parametro));

	}
	
	public void buscarApoderado() {
		
		Apoderado parametro = new Apoderado();
		try {
			BeanUtils.copyProperties(parametro, apoderado);
		
		parametro.setOpcion(Constantes.BUSCAR_POR_DNI_APODERADO_TIP_APO);
//		parametro.setDniApod(apoderado.getDni());
//		parametro.setTipoPers(apoderado.getTipoPers());
		List<Apoderado> apoderados = getGeneraServiceRemote().listar(parametro);
		if(CollectionUtils.isNotEmpty(apoderados)){
			Apoderado apod = apoderados.get(0);
			apod.setAlumId(apoderado.getAlumId());
			setApoderado(apod);
			
		}else{
			FacesContext.getCurrentInstance().addMessage("msgs",
					new FacesMessage(FacesMessage.SEVERITY_WARN, "El apoderado que intenta buscar no existe ", ""));
		}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}

	public List<Alumno> consultarExistencia() {
		Alumno filtro = new Alumno();
		filtro.setDniAlum(alumno.getDniAlum());
		filtro.setOpcion(Constantes.BUSCAR_POR_DNI_ALUMNO);
		List<Alumno> lista = getGeneraServiceRemote().listar(filtro);
		return lista;
	}

	public void grabarApoderado() {

		Apoderado filtro = new Apoderado();
		Dependiente dependiente = new Dependiente();
		filtro.setDniApod(apoderado.getDniApod());

		filtro.setOpcion(Constantes.BUSCAR_POR_DNI_APODERADO);

		List<Apoderado> apoderados = getGeneraServiceRemote().listar(filtro);

		if (CollectionUtils.isNotEmpty(apoderados)) {
			apoderado.setOpcion(Constantes.ACTUALIZAR);
			
		} else {
			System.out.println("llega padre " + apoderado);
			apoderado.setOpcion(Constantes.INSERTAR);
			
			
		}

		String mensaje="";
		if(apoderado.getTipoPers().equals(Constantes.PADRE)){
			mensaje = " del Padre";
		}else{
			mensaje = " de la Madre";
		}
		
		int x = getGeneraServiceRemote().grabar(apoderado);
		evaluarResultado(x, mensaje);

		List<Apoderado> actual = getGeneraServiceRemote().listar(filtro);
		
		if(CollectionUtils.isNotEmpty(actual)){
			dependiente.setApodId(Integer.parseInt(actual.get(0).getApodId()));
			dependiente.setAlumId(apoderado.getAlumId());
		}
		
		//actualizar o grabar en tabla dependiente
		dependiente.setOpcion(Constantes.BUSCAR_POR_ID_ALUM_ID_APOD);
		List<Dependiente> listDep =getGeneraServiceRemote().listar(dependiente);
		if(CollectionUtils.isNotEmpty(listDep)){
			dependiente.setOpcion(Constantes.ACTUALIZAR);
		}else{
			dependiente.setOpcion(Constantes.INSERTAR);
		}
		int w = getGeneraServiceRemote().grabar(dependiente);
		System.out.println("grabo en dependiente "+w);
	}


	private Matricula ubicarMatricula(Matricula paramMatricula){
		paramMatricula.setOpcion(Constantes.BUSCAR_MATRICULA_POR_ANIO);
		paramMatricula.setAnio(String.valueOf(Calendar.getInstance().get(Calendar.YEAR)));
//		paramMatricula.setDniAlum(filtro.getDniAlum());
		paramMatricula.setEstado(Constantes.ACTIVO);
		List<Matricula> listMatri = getGeneraServiceRemote().listar(paramMatricula);
		
		Matricula matricula = null;
		if(!listMatri.isEmpty()){
			matricula = listMatri.get(0);
		}
		
		return matricula;
	}
	
	
	private void grabarComplemente(Matricula matricula){
		Indicador paramInd = new Indicador();
		paramInd.setNivel(alumno.getNivel());
		paramInd.setOpcion(Constantes.BUSCAR_POR_NIVEL);
		List<Indicador> listInd = getGeneraServiceRemote().listar(paramInd);
		int result = 0;
		
		if(CollectionUtils.isNotEmpty(listInd)){
			result = grabarBimestre(listInd, matricula);
			
			evaluarResultado(result);
			buscar();
		}else{
			FacesContext.getCurrentInstance().addMessage("msgs",
					new FacesMessage(FacesMessage.SEVERITY_WARN, "No hay indicadores para esta seccion ", ""));
		}
	}
	
	private void grabarMateria(Matricula objMatricula, int i){
		Matricula paramMatricula = new Matricula();
		try {
			BeanUtils.copyProperties(paramMatricula, objMatricula);
		
		if(paramMatricula.getOpcion() == Constantes.INSERTAR && i == 1){
			Matricula matricula = ubicarMatricula(paramMatricula);
//			paramMatricula.setOpcion(Constantes.BUSCAR_MATRICULA_POR_ANIO);
//			paramMatricula.setAnio(String.valueOf(Calendar.getInstance().get(Calendar.YEAR)));
////			paramMatricula.setDniAlum(filtro.getDniAlum());
//			paramMatricula.setEstado(Constantes.ACTIVO);
//			List<Matricula> listMatri = getGeneraServiceRemote().listar(paramMatricula);
//			
//			Matricula matricula = null;
//			if(!listMatri.isEmpty()){
//				matricula = listMatri.get(0);
//			}
			
//			Indicador paramInd = new Indicador();
//			paramInd.setNivel(alumno.getNivel());
//			paramInd.setOpcion(Constantes.BUSCAR_POR_NIVEL);
//			List<Indicador> listInd = getGeneraServiceRemote().listar(paramInd);
//			int result = 0;
//			
//			if(CollectionUtils.isNotEmpty(listInd)){
//				result = grabarBimestre(listInd, matricula);
//				
//				evaluarResultado(result);
//				buscar();
//			}else{
//				FacesContext.getCurrentInstance().addMessage("msgs",
//						new FacesMessage(FacesMessage.SEVERITY_WARN, "No hay indicadores para esta seccion ", ""));
//			}
			grabarComplemente(matricula);
			
		}else{
			System.out.println("no se nota ");
			Matricula matricula = ubicarMatricula(paramMatricula);
			eliminarMatricula(matricula);
			grabarComplemente(matricula);
		}
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

private void eliminarMatricula(Matricula matricula) {
	Nota nota = new Nota();
	nota.setMatriId(matricula.getMatriId());
	nota.setOpcion(Constantes.ELIMINAR);
	getGeneraServiceRemote().eliminar(nota);
	}

//	private int grabarBimestre(List<Indicador> listInd, Matricula matricula, int bimestre){
	private int grabarBimestre(List<Indicador> listInd, Matricula matricula){
		int result = 0;
		for(int x=0 ; x< listInd.size(); x++){
			Indicador indicador = listInd.get(x);
			Nota nota = new Nota();
			nota.setNivel(indicador.getNivel());
			nota.setAreaId(indicador.getAreaId());
			nota.setCapacidadId(indicador.getCapacidadId());
			nota.setDniAlum(matricula.getDniAlum());
			nota.setMatriId(matricula.getMatriId());
			nota.setOpcion(Constantes.INSERTAR);
//			nota.setBimestre(bimestre);
			result = getGeneraServiceRemote().grabar(nota);
			
			if(result == 0){
				break;
			}
		}
		return result;
	}

	
	public void grabarMatricula() {
		int i = 0;
		
		try {
//			Matricula matricula = null;
			Matricula filtro = new Matricula();
			filtro.setDniAlum(alumno.getDniAlum());
//			filtro.setTipoPers(tipoApoderado);
			filtro.setAlumId(alumno.getAlumId());
			filtro.setOpcion(Constantes.BUSCAR_MATRICULA_DNI_ALUMNO);
			
			List<Matricula> matriculas = getGeneraServiceRemote().listar(filtro);
			if(CollectionUtils.isEmpty(matriculas)){
				matricula.setOpcion(Constantes.INSERTAR);
			}else{
				matricula.setOpcion(Constantes.ACTUALIZAR);
				matricula.setMatriId(matriculas.get(0).getMatriId());
			}
			 matricula.setCodColegio(getUsuario().getCodColegio());
			matricula.setAlumId(alumno.getAlumId());
			matricula.setDniAlum(alumno.getDniAlum());
			matricula.setAnio(String.valueOf(Calendar.getInstance().get(Calendar.YEAR)));
			matricula.setNivel(alumno.getNivel());
			i = getGeneraServiceRemote().grabar(matricula);
						
			grabarMateria(matricula, i);
			
		} catch (Exception e) {
			 e.printStackTrace();
		}

	}

	public void grabarAlumno() {
		int i = 0;
		try {

			if (alumno.getOpcion() == Constantes.INSERTAR) {

				List<Alumno> listaExis = consultarExistencia();

				if (CollectionUtils.isEmpty(listaExis)) {

					i = getGeneraServiceRemote().grabar(alumno);
					
					evaluarResultado(i);
					buscarAlumno();

				} else {
					FacesContext.getCurrentInstance().addMessage("msgs",
							new FacesMessage(FacesMessage.SEVERITY_INFO, "Alumno ya se encuentra registrado", ""));
				}
			} else {

				i = getGeneraServiceRemote().grabar(alumno);

				evaluarResultado(i);
				buscarAlumno();
			}

		} catch (Exception e) {
			 e.printStackTrace();
		}

	}

	@Override
	public void grabar() {

		if (getBtnGrabar() == Constantes.GRABAR_MATRICULA || getBtnGrabar() == Constantes.MODIFICAR_MATRICULA) {

			grabarMatricula();

		} else if (getBtnGrabar() == Constantes.GRABAR_ALUMNO || getBtnGrabar() == Constantes.MODIFICAR_ALUMNO) {

			grabarAlumno();

		}

	}

	@Override
	public void actualizar() {

	}

	public void irApoderado(MatriculadoBean matriculado) {
		setEstadoCivil(buscarMaestra(Constantes.COD_TABLA_ESTADO_CIVIL));
		UWebUtil util = new UWebUtil();
		int tipoApoderado = Integer.parseInt(util.obtenerParametroServidor("apoderado"));
		Apoderado filtro = new Apoderado();
		filtro.setDniAlum(matriculado.getDni());
		filtro.setTipoPers(tipoApoderado);
		
		filtro.setOpcion(Constantes.BUSCAR_TIPO_APODERADO_Y_DNI_ALUMNO);
		
		List<Apoderado> apoderados = getGeneraServiceRemote().listar(filtro);
		Apoderado apoderado  = new Apoderado();
		apoderado.setDniAlum(matriculado.getDni());
		apoderado.setAlumId(matriculado.getAlumId());
		
		if(CollectionUtils.isNotEmpty(apoderados)){
			apoderado = apoderados.get(0);
			if (tipoApoderado == Constantes.PADRE) {
				setTituloAgregar("Registrar Padre");

			} else {
				setTituloAgregar("Registrar Madre");

			}
		}else{
//			apoderado = new Apoderado();
//			apoderado.setDniAlum(matriculado.getDni());
//			apoderado.setAlumId(matriculado.getAlumId());
			if (tipoApoderado == Constantes.PADRE) {
				setTituloAgregar("Registrar Padre");
				apoderado.setSexo(Constantes.MASCULINO);
				
			} else {
				setTituloAgregar("Registrar Madre");
				apoderado.setSexo(Constantes.FEMENINO);
			}
		}
		apoderado.setTipoPers(tipoApoderado);
		setApoderado(apoderado);
		
		

		setDisableAgregar(true);
		setDisableModificar(false);
		setDisableEstado(false);

		RequestContext context = RequestContext.getCurrentInstance();
		context.execute("PF('dialogoAgregarApoderado').show();");

	}
	
	public void buscarDatosAlumno(){
		String dniAlumno = alumno.getDniAlum();
		System.out.println("dni "+dniAlumno);
	
		Alumno parametros = new Alumno();
		parametros.setOpcion(Constantes.BUSCAR_POR_DNI_ALUMNO);
		parametros.setEstado(Constantes.ACTIVO);	
		parametros.setDniAlum(dniAlumno);
		List<Alumno> results = getGeneraServiceRemote().listar(parametros);
	
		if(!results.isEmpty() && results.size()==1){
			Alumno objAlumno = results.get(0);
			setAlumno(objAlumno);
		}else{
			FacesContext.getCurrentInstance().addMessage("msgs",
					new FacesMessage(FacesMessage.SEVERITY_WARN, "Alumno no se encuentra registrado", ""));
		}
		
//		RequestContext context = RequestContext.getCurrentInstance();
//		context.execute("PF('dialogoBuscar').show();");
		
	}

	public List<Alumno> completeText(String name) {
		List<Alumno> lista = new ArrayList<>();

		Alumno parametros = new Alumno();
		parametros.setOpcion(Constantes.BUSCAR_TODOS);
		parametros.setEstado(Constantes.ACTIVO);

		List<Alumno> results = getGeneraServiceRemote().listar(parametros);
		for (Alumno alumno : results) {
			if (alumno.getApePate().startsWith(name)) {
				lista.add(alumno);

			}

		}

		return lista;
	}
	     
	public void listarAlumnos(String filtro){
		List<Alumno> lista = new ArrayList<>();

		Alumno parametros = new Alumno();
		parametros.setOpcion(Constantes.BUSCAR_TODOS);
		parametros.setEstado(Constantes.ACTIVO);

		List<Alumno> results = getGeneraServiceRemote().listar(parametros);
	}
	
	public String getManteAlumno() {
		return manteAlumno;
	}

	public void setManteAlumno(String manteAlumno) {
		this.manteAlumno = manteAlumno;
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

	public List<MatriculadoBean> getMatriculados() {
		return matriculados;
	}

	public void setMatriculados(List<MatriculadoBean> matriculados) {
		this.matriculados = matriculados;
	}

	public Alumno getParametro() {
		return parametro;
	}

	public void setParametro(Alumno parametro) {
		this.parametro = parametro;
	}

	public Alumno getAlumno() {
		return alumno;
	}

	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}

	// public Apoderado getPadre() {
	// return padre;
	// }
	//
	// public void setPadre(Apoderado padre) {
	// this.padre = padre;
	// }
	//
	// public Apoderado getMadre() {
	// return madre;
	// }
	//
	// public void setMadre(Apoderado madre) {
	// this.madre = madre;
	// }

	public Matricula getMatricula() {
		return matricula;
	}

	public void setMatricula(Matricula matricula) {
		this.matricula = matricula;
	}

	public boolean isFilaMatricula() {
		return filaMatricula;
	}

	public void setFilaMatricula(boolean filaMatricula) {
		this.filaMatricula = filaMatricula;
	}

	public String getTituloModificar() {
		return tituloModificar;
	}

	public void setTituloModificar(String tituloModificar) {
		this.tituloModificar = tituloModificar;
	}

	public String getTituloAgregar() {
		return tituloAgregar;
	}

	public void setTituloAgregar(String tituloAgregar) {
		this.tituloAgregar = tituloAgregar;
	}

	public int getBtnGrabar() {
		return btnGrabar;
	}

	public void setBtnGrabar(int btnGrabar) {
		this.btnGrabar = btnGrabar;
	}

	public Apoderado getApoderado() {
		return apoderado;
	}

	public void setApoderado(Apoderado apoderado) {
		this.apoderado = apoderado;
	}

	public String getManteApoderado() {
		return manteApoderado;
	}

	public void setManteApoderado(String manteApoderado) {
		this.manteApoderado = manteApoderado;
	}

	public Alumno getAlumpar() {
		return alumpar;
	}

	public void setAlumpar(Alumno alumpar) {
		this.alumpar = alumpar;
	}

//	public String getPbuscarAlumno() {
//		return pbuscarAlumno;
//	}
//
//	public void setPbuscarAlumno(String pbuscarAlumno) {
//		this.pbuscarAlumno = pbuscarAlumno;
//	}

}
