package pe.gafahsoft.colegio.web;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.faces.view.ViewScoped;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.primefaces.context.RequestContext;

import pe.gafahsoft.colegio.bean.MatriculadoBean;
import pe.gafahsoft.colegio.modelo.Alumno;
import pe.gafahsoft.colegio.modelo.Apoderado;
import pe.gafahsoft.colegio.modelo.Maestra;
import pe.gafahsoft.colegio.modelo.Matricula;
import pe.gafahsoft.colegio.util.Constantes;

@ManagedBean
@ViewScoped
public class MatriculaBean extends GeneralBean<Matricula> {

	
	private static final long serialVersionUID = -3064135550904292021L;
	private Apoderado padre = new Apoderado();
	private Apoderado madre = new Apoderado();
	private Matricula matricula = new Matricula();
	private Alumno alumno = new Alumno();

	
	private Alumno parametro = new Alumno();

//	private List<Alumno> listadoAlumno = new ArrayList<>();
//	private List<Matricula> listadoMatricula = new ArrayList<>();
	private List<MatriculadoBean> matriculados = new ArrayList<>();
	

	private String manteAlumno = "/matricula/registroAlumno";
	private Maestra nivel = new Maestra();
	private Maestra grado = new Maestra();
//	private List<SelectItem> grados  = new ArrayList<>();

	public MatriculaBean() {
//		setEstadoCivil(buscarMaestra(Constantes.COD_TABLA_ESTADO_CIVIL));
//		buscar();
//		setMatriculados(new ArrayList<>());
		
		setEstados(buscarMaestra(Constantes.COD_TABLA_ESTADO));
		setNiveles(buscarMaestra(Constantes.COD_TABLA_NIVELES));
	}
	
	public void buscarGrados() {
		if (getNivel().getMaesId() != null) {
			List<Maestra> lista = buscarMaestra(getNivel().getMaesId());
			List<SelectItem> items = new ArrayList<>();
//			setGrados(new ArrayList<>());
			if (CollectionUtils.isNotEmpty(lista)) {
				for (Maestra maes : lista) {
					SelectItem item = getSelectItem();
					item.setValue(maes.getMaesId());
					item.setLabel(
							StringUtils.trim(maes.getValor() + " " + StringUtils.defaultString(maes.getDescCorta())));
					items.add(item);
//					items.add(new SelectItem(maes,maes.getValor() + " " + StringUtils.defaultString(maes.getDescCorta())));
//					lstComboTipoDocumento.add(new SelectItem(bMaestroTipo.getCodTipo() + "", bMaestroTipo.getDesTipo()));
//					getGrados().add(new SelectItem(maes.getMaesId() + "",StringUtils.defaultString(maes.getDescCorta());
				}
				setGrados(items);
			}
		}
	}

	

	public void grabarPadre() {
		System.out.println("llega padre " + padre);

		padre.setSexo(Constantes.MASCULINO);
		padre.setTipoPers(Constantes.PADRE);

		int x = 0;
		if (StringUtils.isNotEmpty(padre.getDniApod())) {
			padre.setDniAlum(alumno.getDniAlum());
			x = getGeneraServiceRemote().grabar(padre);

		}

		evaluarResultado(x, " del Padre ");

	}

	public void grabarMadre() {

		madre.setSexo(Constantes.FEMENINO);
		madre.setTipoPers(Constantes.MADRE);

		int x = 0;

		if (StringUtils.isNotEmpty(madre.getDniApod())) {
			madre.setDniAlum(alumno.getDniAlum());
			getGeneraServiceRemote().grabar(madre);

		}

		evaluarResultado(x, " de la Madre ");

	
	}
	
	public String irModificar(MatriculadoBean matriculado) {
		setEstadoCivil(buscarMaestra(Constantes.COD_TABLA_ESTADO_CIVIL));
		
		Alumno filtro = new Alumno();
		filtro.setDniAlum(matriculado.getDni());
		filtro.setOpcion(Constantes.BUSCAR_POR_DNI_ALUMNO);
		List<Alumno> listAlumno = getGeneraServiceRemote().listar(filtro);
		
		if(CollectionUtils.isNotEmpty(listAlumno)){
		getNivel().setMaesId(matriculado.getNivelPadre());	
		getMatricula().setNivel(matriculado.getNivel());	
		setAlumno(listAlumno.get(0));
		Apoderado apoderado = new Apoderado();
		apoderado.setDniAlum(getAlumno().getDniAlum());
		apoderado.setOpcion(Constantes.BUSCAR_POR_DNI_ALUMNO);
		
		List<Apoderado> padres = getGeneraServiceRemote().listar(apoderado);
		
		if(CollectionUtils.isNotEmpty(padres) && padres.size() == 1 || padres.size() == 2){
			for(int i=0; i < padres.size();i++){
				if(padres.get(i).getTipoPers()==Constantes.PADRE){
					setPadre(padres.get(i));
				}else{
					setMadre(padres.get(i));
				}
			}
		}
		
		}
//		try {
//			FacesContext.getCurrentInstance().getExternalContext().redirect("registroMatricula.xhtml");
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		FacesContext.getCurrentInstance().getExternalContext().getFlash().put("alumno", alumno );
//		FacesContext.getCurrentInstance().getExternalContext().getFlash().put("padre", padre );
//		FacesContext.getCurrentInstance().getExternalContext().getFlash().put("madre", madre );
//		return "/pages/searchResult?faces-redirect=true";
		return manteAlumno;
	}
	
	public String irRegistro() {
		setNivel(new Maestra());
		return manteAlumno;
	}

	@Override
	public void agregar() {

		alumno = new Alumno();
		
		try {
			RequestContext context = RequestContext.getCurrentInstance();
			context.execute("PF('dialogoAgregarAlumno').show();");
			setDisableAgregar(false);
			setDisableModificar(true);
			setDisableEstado(true);
		} catch (Exception e) {
			e.printStackTrace();
			// log.error("Error en irMostrarMantenimientoMaestro(): " + e);
		}

	}

	@Override
	public void modificar(Matricula parametro) {
//		Alumno nAlumno = new Alumno();
//		try {
//			BeanUtils.copyProperties(nAlumno, parametro);
//			setAlumno(nAlumno);
//			setDisableAgregar(true);
//			setDisableModificar(false);
//			setDisableEstado(false);
//
//			RequestContext context = RequestContext.getCurrentInstance();
//			context.execute("PF('dialogoAgregarAlumno').show();");
//
//			List<Alumno> lista = getGeneraServiceRemote().listar(alumno);
//
//		} catch (Exception e) {
//			e.printStackTrace();
//
//		}

	}

	@Override
	public void buscar() {
		List<MatriculadoBean> lista = getGeneraServiceRemote().listarMatriculados(parametro);
		if(CollectionUtils.isEmpty(lista)){
			lista = new ArrayList<>();
		}
		setMatriculados(lista);

	}

//	public void buscarAsistencia() {
//
//		setListadoAlumno(new ArrayList<>());
//
//	}

	@Override
	public void grabar() {

		int i = 0;
		try {
			List<Alumno> listaExis = consultarExistencia();

			if (CollectionUtils.isEmpty(listaExis)) {
				// Grabar alumno
				alumno.setOpcion(Constantes.INSERTAR);
				i = getGeneraServiceRemote().grabar(alumno);

				if (i == 1) {
					i = 0;

					matricula.setDniAlum(alumno.getDniAlum());
					matricula.setAnio(String.valueOf(Calendar.getInstance().get(Calendar.YEAR)));
					 matricula.setCodColegio(getUsuario().getCodColegio());
					matricula.setNivel(alumno.getNivel());
					i = getGeneraServiceRemote().grabar(matricula);

					if (i == 1) {
						Apoderado padre = new Apoderado();
						padre.setDniAlum(matricula.getDniAlum());
						padre.setSexo(Constantes.MASCULINO);
						padre.setTipoPers(Constantes.PADRE);

						// apoderados[0] = padre;
						setPadre(padre);
						System.out.println("padre " + padre);
						Apoderado madre = new Apoderado();
						madre.setSexo(Constantes.FEMENINO);
						madre.setDniAlum(matricula.getDniAlum());
						madre.setTipoPers(Constantes.MADRE);

						setMadre(madre);
						// apoderados[1] = madre;
						System.out.println("madre " + madre);
					}
					// }
				}
				evaluarResultado(i);

			} else {
				FacesContext.getCurrentInstance().addMessage("msgs",
						new FacesMessage(FacesMessage.SEVERITY_INFO, "Alumno ya se encuentra registrado", ""));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void cerrar() {
		RequestContext context = RequestContext.getCurrentInstance();
		context.execute("PF('dialogoAgregarAlumno').hide();");
		buscar();
	}

	public List<Alumno> consultarExistencia() {
		alumno.setOpcion(Constantes.BUSCAR_POR_DNI_ALUMNO);
		List<Alumno> lista = getGeneraServiceRemote().listar(alumno);
		return lista;
	}

	@Override
	public void actualizar() {

	}

	public String getManteAlumno() {
		return manteAlumno;
	}

	public void setManteAlumno(String manteAlumno) {
		this.manteAlumno = manteAlumno;
	}

//	public List<Alumno> getListadoAlumno() {
//		return listadoAlumno;
//	}
//
//	public void setListadoAlumno(List<Alumno> listadoAlumno) {
//		this.listadoAlumno = listadoAlumno;
//	}

	public Alumno getAlumno() {
		return alumno;
	}

//	public List<Matricula> getListadoMatricula() {
//		return listadoMatricula;
//	}
//
//	public void setListadoMatricula(List<Matricula> listadoMatricula) {
//		this.listadoMatricula = listadoMatricula;
//	}

	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}

	public Alumno getParametro() {
		return parametro;
	}

	public void setParametro(Alumno parametro) {
		this.parametro = parametro;
	}

	public Apoderado getPadre() {
		return padre;
	}

	public void setPadre(Apoderado padre) {
		this.padre = padre;
	}

	public Apoderado getMadre() {
		return madre;
	}

	public void setMadre(Apoderado madre) {
		this.madre = madre;
	}

	public Matricula getMatricula() {
		return matricula;
	}

	public void setMatricula(Matricula matricula) {
		this.matricula = matricula;
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

//	public List<SelectItem> getGrados() {
//		return grados;
//	}
//
//	public void setGrados(List<SelectItem> grados) {
//		this.grados = grados;
//	}

	public List<MatriculadoBean> getMatriculados() {
		return matriculados;
	}

	public void setMatriculados(List<MatriculadoBean> matriculados) {
		this.matriculados = matriculados;
	}


}
