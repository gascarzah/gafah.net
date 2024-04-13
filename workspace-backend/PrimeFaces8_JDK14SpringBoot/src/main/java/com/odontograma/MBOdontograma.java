package com.odontograma;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

//import org.apache.commons.collections.CollectionUtils;
//import org.apache.commons.lang3.StringUtils;
//import org.apache.log4j.Logger;
//import org.primefaces.context.RequestContext;
//import org.primefaces.event.SelectEvent;
//
//import pe.gob.essalud.hise.bean.BAtencionMedicaSesion;
//import pe.gob.essalud.hise.bean.BDescPieza;
//import pe.gob.essalud.hise.bean.BOdontograma;
//import pe.gob.essalud.hise.bean.BOdontogramaDet;
//import pe.gob.essalud.hise.bean.BOdontogramaList;
//import pe.gob.essalud.hise.bean.BOdontogramaProcedimiento;
//import pe.gob.essalud.hise.bean.BPiezasMarcadas;
//import pe.gob.essalud.hise.bean.BProcedimientoResultado;
//import pe.gob.essalud.hise.bean.BProcedimientoSalud;
//import pe.gob.essalud.hise.bean.BUsuarioSesion;
//import pe.gob.essalud.hise.cexter.service.IOdontogramaService;
//import pe.gob.essalud.hise.cexter.service.impl.NOdontogramaImpl;
//import pe.gob.essalud.hise.maestr.service.IMantAdmCitasProcedimientoSaludService;
//import pe.gob.essalud.hise.maestr.service.impl.NMantAdmCitasProcedimientoSaludImpl;
//import pe.gob.essalud.hise.utilit.UConstante;
//import pe.gob.essalud.hise.utilit.UConstruirCadena;
//import pe.gob.essalud.hise.utilit.UWebUtil;

/**
 * Interfaz para el uso del odontograma
 * @author giovanni.ascarza
 * @version 1.0 - 19/04/2016
 */

@ManagedBean
@ViewScoped
public class MBOdontograma 
//extends UWebUtil 
{

//	private static final Logger LOGGER = Logger.getLogger(MBOdontograma.class);
//
//	private IOdontogramaService iOdontogramaService;
//	private BOdontograma bOdontograma;
//	private long codPersona;
//	private BUsuarioSesion bUsuarioSesion = new BUsuarioSesion();
//	private FacesContext context = FacesContext.getCurrentInstance();
//	HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
//	private Set<Integer> posPiezasFinales = new HashSet<>();
//	private BOdontogramaDet[] arrayOdontogramaDet;
//	private List<BOdontograma> listaOdontograma = new ArrayList<>();
//	private List<BOdontogramaDet> listaOdontogramaDet = new ArrayList<>();
//	private BAtencionMedicaSesion bAtencionMedicaSesion;
//	private List<BOdontogramaProcedimiento> listaOdontoProc = new ArrayList<>();
//	private List<BProcedimientoSalud> listadoProcedimientoOdontologico = new ArrayList<>();
//	private boolean grabado = false;
//	private List<BOdontograma> listaSesionesOdontograma = new ArrayList<>();
//	private String pOdontogramaHistorico = "/paginas/conext/registroAtenciones/odontogramaHistorico";
//	private BPiezasMarcadas piezasHistoricas = new BPiezasMarcadas();
//	private List<BOdontogramaDet> listaPiezaDetalle = new ArrayList<>();
//	private BOdontograma selectedOdontograma;
//
//	private List<BOdontogramaDet> listaDetalleSesiones = new ArrayList<>();
//
//	private String sPiezaMarcada;
//	private String sCaraMarcada;
//	private String sColorMarcada;
//	private String sPiezaMarcadaInicial;
//	private String sCaraMarcadaInicial;
//	private String sColorMarcadaInicial;
//
//	private String piezaMarcadaDetalle;
//	private String vcodProced;
//	private String vdesProced;
//	private String codProcedimiento;
//	private String desProcedimiento;
//	private long   cantProc;
//
//	private long actoMedico;
//	private long codCentro;
//	private String usuario;
//	private String usuarioIp;
//
//	private String alertaMensaje;
//
//	private long optIpb;
//	private long optEc;
//	private long optFcch;
//	private long optRe;
//
//	private boolean flagOdontograma;
//	HttpSession session;
//	private BOdontogramaList bResultado=new BOdontogramaList();
//	
//	
//	public MBOdontograma() {
//		
//		this.setCodPersona(Long.parseLong((String) request.getAttribute("codigoPersona")));
//		session = getSession(false);
//		if(session==null){
//			session = getSession(true);
//		}
//		
//		if(session.getAttribute("bUsuarioSesion") == null){
//			LOGGER.warn("usuario ya no se encuentra logeado dentro de la session ");
//		}else{
//			bUsuarioSesion = (BUsuarioSesion) session.getAttribute("bUsuarioSesion");
//		}
//		arrayOdontogramaDet = new BOdontogramaDet[UConstante.getPosiDentales().length];
//		this.setCodCentro(Long.parseLong(bUsuarioSesion.getCentro()));
//		this.setUsuario(bUsuarioSesion.getUsuario());
//		this.setUsuarioIp(bUsuarioSesion.getIpUsuario());
//		
//		verOdontograma();
//	}
//
//	private void verificarActoMedico(){
//		bAtencionMedicaSesion = (BAtencionMedicaSesion) session.getAttribute("bAtencionMedicSesion");
//		
//		if(bAtencionMedicaSesion!=null){
//			this.setActoMedico(Long.parseLong(bAtencionMedicaSesion.getActMedico()));
//			}
//	}
//	
//	private void getObtenerMapaDental() {
//
//		for (int i = 0; i < UConstante.getPosiDentales().length; i++) {
//			String pieza = UConstante.getPosiDentales()[i];
//			BOdontogramaDet odontogramaDet = getOdontogramaDetalle();
//			odontogramaDet.setCodPieza(pieza);
//			arrayOdontogramaDet[i] = odontogramaDet;
//		}
//		
//	}
//
//	private BOdontogramaDet getOdontogramaDetalle(){
//		return new BOdontogramaDet();
//	}
//	
//	public void grabarOdontograma() {
//		iOdontogramaService = new NOdontogramaImpl();
//		verificarActoMedico();
//		getObtenerMapaDental();
//				
//		/** valores del odontograma*/
//		bOdontograma = new BOdontograma();
//		bOdontograma.setCodPersona(this.getCodPersona());
//
//		/** actomedico aun por ver*/
//		bOdontograma.setNumActo(this.getActoMedico());
//
//		/** centro asistencial*/
//		bOdontograma.setCodCentro(this.getCodCentro());
//		// setear valores de auditoria
//		bOdontograma.setUsrReg(this.getUsuario());
//		bOdontograma.setMaqIp(this.getUsuarioIp());
//		bOdontograma.setUsrMod(this.getUsuario());
//		bOdontograma.setFecAtencion(convertirDateFecha(new Date()));
//		//26052016 IPB EC FCCH RE
//		obtenerOpcionesOdontograma();
//		/** seteando valores para el odontograma*/
//		getValoresOdontograma();
//
//		/** valores para el detalle del odontograma*/
//		obtenerValoresDientes();
//
//		String pPiezasMarcadas = obtenerParametroServidor("vPiezasMarcadas");
//		String[] vMarcadas = StringUtils.split(pPiezasMarcadas, "|");
//
//		// setear las piezas marcadas
//		StringBuilder stb = new StringBuilder();
//		List<BOdontogramaDet> lista = obtenerPiezasUnicasMarcadas(vMarcadas);
//
//		//agregando las piezas que solo tienen una observacion llenada sin marcas 24052016
//		List<BDescPieza> listObsrv = getSoloPiezaConObservacion(); // mejora 24052016
//
//		List<String> listPiezasFinales = new ArrayList<>();
//		for (BOdontogramaDet odon : lista) {
//			if (odon.getCodIdePza() != null) {
//				obtenerDescPieza(odon,listObsrv); //agregado 26052016
//				String valores = odon.getCodPieza() + ";" + odon.getCodIdePza() + ";" + odon.getCodEstOclusal() + ";"
//						+ odon.getCodEstLingual() + ";" + odon.getCodEstDistal() + ";" + odon.getCodEstVestibular()	+ ";" 
//						+ odon.getCodEstMesial() + ";" + odon.getCodEstRaizSup() + ";" + odon.getCodEstRaizInf() + 
//						";"+ StringUtils.defaultString(odon.getDesEstPza()) //desEstPza//agregado 24052016
//						+ ";|";
//				
//				
//				stb.append(valores);
//				listPiezasFinales.add(odon.getCodPieza());
//			}
//
//		}
//
//		//Agrega observaciones llenas sin marcar 24052016
//		if(CollectionUtils.isNotEmpty(listObsrv)){
//			StringBuilder cadFinal = new StringBuilder();
//				for(int i=0; i<listObsrv.size();i++){
//					listPiezasFinales.add(listObsrv.get(i).getCodigo());
//					cadFinal.append(formarCadena(listObsrv.get(i).getCodigo(), listObsrv.get(i).getDesc()));
//				}
//			stb.append(cadFinal.toString());
//		}
//
//
//				
//				
//		String valoresEliminados = this.obtenerPiezasDepuradas(bResultado, listPiezasFinales);
//		stb.append(valoresEliminados);
//
//		bOdontograma.setPiezaDental(stb.toString());
//
//		// discriminante decide si se graba o se modifica
//		// odontograma que se encuentra en base de datos
//		List<BOdontograma> lOdontogramaRecuperado = bResultado.getListaOdontograma();
//		
//		if (CollectionUtils.isNotEmpty(lOdontogramaRecuperado)) {
//			BOdontograma bOdontogramaRecuperado = lOdontogramaRecuperado.get(0);
//
//			if (bOdontogramaRecuperado.getCodTipoOdo() == 1) {
//				bOdontogramaRecuperado.setCodTipoOdo(2);
//				bOdontograma.setOpcion(UConstante.INSERTAR);
//			} else {
//
//				if (bOdontogramaRecuperado.getNumActo() == bOdontograma.getNumActo()) {
//					bOdontograma.setNumOdonto(bOdontogramaRecuperado.getNumOdonto());
//
//					bOdontograma.setOpcion(UConstante.ACTUALIZAR);
//				} else {
//					bOdontograma.setOpcion(UConstante.INSERTAR);
//				}
//			}
//		} else {
//			bOdontograma.setOpcion(UConstante.INSERTAR);
//		}
//
//		int resultado = 0;
//		if (CollectionUtils.isNotEmpty(lista)) {
//
//			resultado = iOdontogramaService.grabarOdontograma(bOdontograma);
//
//			setGrabado(true);
//			if (resultado == 0) {
//				FacesContext.getCurrentInstance().addMessage("msgs",
//						new FacesMessage(FacesMessage.SEVERITY_INFO, "Se grabo con exito", ""));
//
//				/////////// obtener los datos de los procedimientos realizados
//				BOdontogramaProcedimiento bOdonProc = new BOdontogramaProcedimiento();
//				bOdonProc.setCodPersona(this.getCodPersona());
//				bOdonProc.setNumOdonto(bOdontograma.getNumOdonto());
//				// recuperar lista de piezas con
//				// procedimientos
//				// setear el odontograma que se ha grabado
//				this.getListaOdontograma().add(bOdontograma);
//
//			} else {
//				FacesContext.getCurrentInstance().addMessage("msgs",
//						new FacesMessage(FacesMessage.SEVERITY_ERROR, "Problemas al grabar", ""));
//			}
//		} else {
//			FacesContext.getCurrentInstance().addMessage("msgs",
//					new FacesMessage(FacesMessage.SEVERITY_WARN, "No tiene ningun diente marcado", ""));
//		}
//
//	}
//
//	private List<BDescPieza> getSoloPiezaConObservacion(){
//		List<BDescPieza> lista = new ArrayList<>();
//		
//		for(int i=0; i<UConstante.getPosiDentales().length ; i++){
//			String pieza = UConstante.getPosiDentales()[i];
//			String observPieza = StringUtils.defaultString(obtenerParametroServidor(pieza));
//			if(StringUtils.isNotEmpty(observPieza)){
//				lista.add(getDescPza(pieza, observPieza));
//			}
//		}
//		return lista;
//	}
//	
//	
//	private void obtenerOpcionesOdontograma() {
//		String ipb = StringUtils.defaultString(obtenerParametroServidor("IPB"));
//		String ec = StringUtils.defaultString(obtenerParametroServidor("EC"));
//		String fcch = StringUtils.defaultString(obtenerParametroServidor("FCCH"));
//		String re = StringUtils.defaultString(obtenerParametroServidor("RE"));
//		
//		String nipb = StringUtils.isNotBlank(ipb)?ipb:UConstante.CERO;
//		String nec = StringUtils.isNotBlank(ec)?ec:UConstante.CERO;
//		String nfcch = StringUtils.isNotBlank(fcch)?fcch:UConstante.CERO;
//		String nre =StringUtils.isNotBlank(re)?re:UConstante.CERO;
//		
//		bOdontograma.setCodPlacaBacte(Long.parseLong(nipb));
//		bOdontograma.setCodExpCaries(Long.parseLong(nec));
//		bOdontograma.setCodFrecConsumo(Long.parseLong(nfcch));
//		bOdontograma.setCodRieEstoma(Long.parseLong(nre));
//	}
//
//	private void obtenerDescPieza(BOdontogramaDet odonMar, List<BDescPieza> lstObsrv) {
//		
//			
//			for (int x=0; x < lstObsrv.size();x++) {
//				BDescPieza obsrv = lstObsrv.get(x);
//				if(StringUtils.equals(odonMar.getCodPieza(), obsrv.getCodigo())){
//					odonMar.setDesEstPza(obsrv.getDesc());
//					lstObsrv.remove(x);
//					break;
//				}
//			}
//	}
//
//	private String obtenerPiezasDepuradas(BOdontogramaList bLista, List<String> listPiezasFinales) {
//		List<BOdontogramaDet> listOdonDetGral = bLista.getListaOdontoDetalle();
//		for (String codPieza : listPiezasFinales) {
//			for (BOdontogramaDet odonDetGral : listOdonDetGral) {
//				if (StringUtils.equals(codPieza, odonDetGral.getCodPieza()) /*|| StringUtils.isEmpty(odonDetGral.getDesEstPza())*/) {//se agrego segunda condicion 
//					listOdonDetGral.remove(odonDetGral);
//					break;
//				}
//			}
//		}
//
//		String eliminados = "";
//
//		if (CollectionUtils.isNotEmpty(listOdonDetGral)) {
//
//			for (BOdontogramaDet odon : listOdonDetGral) {
//				eliminados += odon.getCodPieza() + ";E;0;0;0;0;0;0;0;|";
//			}
//
//		}
//		return eliminados;
//	}
//
//	private long obtenerNumPiezas(String contaPiezas){
//		
//		return StringUtils.isNotEmpty(StringUtils.defaultString(contaPiezas))
//				? Long.parseLong(contaPiezas) : 0;
//	}
//	
//	private void getValoresOdontograma() {
//
//		String cPerCariada = obtenerParametroServidor("cPerCariada");
//		String cResCariada = obtenerParametroServidor("cResCariada");
//		String cPerObturada = obtenerParametroServidor("cPerObturada");
//		String cResObturada = obtenerParametroServidor("cResObturada");
//		String cPerPerdida = obtenerParametroServidor("cPerPerdida");
//		String cResPerdida = obtenerParametroServidor("cResPerdida");
//		String cPerProtesis = obtenerParametroServidor("cPerProtesis");
//		String cResProtesis = obtenerParametroServidor("cResProtesis");
//		String cPerPorExtraer = obtenerParametroServidor("cPerPorExtraer");
//		String cResPorExtraer = obtenerParametroServidor("cResPorExtraer");
//		String cPerFracturada = obtenerParametroServidor("cPerFracturada");
//		String cResFracturada = obtenerParametroServidor("cResFracturada");
//		String cPerTotal = obtenerParametroServidor("cPerTotal");
//		String cResTotal = obtenerParametroServidor("cResTotal");
//
//		long lPerPorExtraer = obtenerNumPiezas(cPerPorExtraer); 
//		long lResPorExtraer = obtenerNumPiezas(cResPorExtraer); 
//		long lPerProtesis = obtenerNumPiezas(cPerProtesis); 
//		long lResProtesis = obtenerNumPiezas(cResProtesis); 
//		long lPerPerdida = obtenerNumPiezas(cPerPerdida); 
//		long lResPerdida = obtenerNumPiezas(cResPerdida); 
//		long lPerObturada = obtenerNumPiezas(cPerObturada);
//		long lResObturada = obtenerNumPiezas(cResObturada);
//		long lPerCariada = obtenerNumPiezas(cPerCariada); 
//		long lResCariada = obtenerNumPiezas(cResCariada); 
//		long lPerFracturada = obtenerNumPiezas(cPerFracturada);
//		long lResFracturada = obtenerNumPiezas(cResFracturada);
//		long lPerTotal = obtenerNumPiezas(cPerTotal); 
//		long lResTotal = obtenerNumPiezas(cResTotal); 
//
//		bOdontograma.setNumPzaPeext(lPerPorExtraer);
//		bOdontograma.setNumPzaDeext(lResPorExtraer);
//		bOdontograma.setNumPzaPepro(lPerProtesis);
//		bOdontograma.setNumPzaDepro(lResProtesis);
//		bOdontograma.setNumPzaPeper(lPerPerdida);
//		bOdontograma.setNumPzaDeper(lResPerdida);
//		bOdontograma.setNumPzaPeobt(lPerObturada);
//		bOdontograma.setNumPzaDeobt(lResObturada);
//		bOdontograma.setNumPzaPecar(lPerCariada);
//		bOdontograma.setNumPzaDecar(lResCariada);
//		bOdontograma.setNumPzaPefra(lPerFracturada);
//		bOdontograma.setNumPzaDefra(lResFracturada);
//
//		if (lPerTotal > 0) {
//			bOdontograma.setNumPzaTotal(lPerTotal);
//		} else {
//			if (lResTotal > 0) {
//				bOdontograma.setNumPzaTotal(lPerTotal);
//			}
//		}
//
//	}
//
//	private void obtenerValoresDientes() {
//		// obteniendo el detalle de las piezas dentales
//		String pDientes = obtenerParametroServidor("vDientes");
//		String[] vDientes = StringUtils.split(pDientes, "|");// lados del diente marcados
//		for (int i = 0; i < vDientes.length; i++) {
//
//			String datos = vDientes[i];
//			
//			// separar la cadena en valores dentales
//			String codigoPieza = datos.substring(0, 3);
//			String pieza = datos.substring(3, 4);
//			String color = datos.substring(4, datos.length());
//			
//			if(!StringUtils.equals(color, "undefined")){
//				Long colorPieza = Long.parseLong(color);
//				setPiezasMarcadas(codigoPieza, pieza, colorPieza);
//			}
//		}
//	}
//
//	private List<BOdontogramaDet> obtenerPiezasUnicasMarcadas(String[] vMarcadas) {
//		List<BOdontogramaDet> listaPiezas = new ArrayList<>();
//
//		for (Integer valor : posPiezasFinales) {
//
//			for (int z = 0; z < vMarcadas.length; z++) {
//				String mark = vMarcadas[z];
//				String piezaUnica = mark.substring(0, 3);
//				String lado = mark.substring(3, 4);
//				if (piezaUnica.equals(arrayOdontogramaDet[valor].getCodPieza())) {
//					arrayOdontogramaDet[valor].setCodIdePza(lado);
//					break;
//				}
//			}
//
//			listaPiezas.add(arrayOdontogramaDet[valor]);
//		}
//
//		return listaPiezas;
//	}
//
//	private void setPiezasMarcadas(String codigoPieza, String pieza, Long valorPieza) {
//
//		for (int i = 0; i < arrayOdontogramaDet.length; i++) {
//			if (codigoPieza.equals(arrayOdontogramaDet[i].getCodPieza())) {
//				// arreglo seteo el valor que llega
//				switch (pieza) {
//				case UConstante.OCLUSAL:
//					arrayOdontogramaDet[i].setCodEstOclusal(valorPieza);
//					break;
//				case UConstante.LINGUAL :
//					arrayOdontogramaDet[i].setCodEstLingual(valorPieza);
//					break;
//				case UConstante.DISTAL :
//					arrayOdontogramaDet[i].setCodEstDistal(valorPieza);
//					break;
//				case UConstante.VESTIBULAR: 
//					arrayOdontogramaDet[i].setCodEstVestibular(valorPieza);
//					break;
//				case UConstante.MESIAL :
//					arrayOdontogramaDet[i].setCodEstMesial(valorPieza);
//					break;
//				case UConstante.RAIZ_SUPERIOR :
//					arrayOdontogramaDet[i].setCodEstRaizSup(valorPieza);
//					break;
//				case UConstante.RAIZ_INFERIOR: 
//					arrayOdontogramaDet[i].setCodEstRaizInf(valorPieza);
//					break;
//				default:
//					break;
//				
//				}
//				posPiezasFinales.add(i);
//					
//			}
//
//		}
//
//	}
//
//	/**
//	 * Obtiene ultimo cronograma guardado, si no tiene ninguna pieza marcada
//	 * quiere decir que es nuevo odontograma, el cual se mostrar� vacio
//	 */
//	public void obtenerUltimoOdontograma() {
//		iOdontogramaService = new NOdontogramaImpl();
//		BOdontograma vBOdontograma = new BOdontograma();
//		vBOdontograma.setCodPersona(this.getCodPersona());
//		vBOdontograma.setCodCentro(this.getCodCentro());
//		bResultado = iOdontogramaService.obtenerOdontograma(vBOdontograma);//llama por primera vez
//
//		obtenerListados(bResultado);
//
//		// obtener ultimo odontograma si se va a modificar
//		if (bResultado.getListaOdontograma().size() == 1) {
//			setFlagOdontograma(true); //valido para mostrar el odontograma en la impresion - 04082016
//			//setear ultimas opciones IPB EC FCCH RE
//			setUltimasOpciones(bResultado.getListaOdontograma().get(0));
//			if (CollectionUtils.isNotEmpty(bResultado.getListaOdontoDetalle())) {
//				BPiezasMarcadas piezas = obtenerPiezas(bResultado.getListaOdontoDetalle());
//				obtenerPiezasFinales(piezas);
//			} else {
//				// carga odontograma vacio
//				getObtenerMapaDental(); // arrayOdontogramaDet llenado
//			}
//		} else {
//			limpiarVariables();
//			getObtenerMapaDental();
//		}
//	}
//
//	private void setUltimasOpciones(BOdontograma bOdontograma) {
//			setOptIpb(bOdontograma.getCodPlacaBacte());
//			setOptEc(bOdontograma.getCodExpCaries());
//			setOptFcch(bOdontograma.getCodFrecConsumo());
//			setOptRe(bOdontograma.getCodRieEstoma());
//	}
//
//	
//
//
//	public void limpiarVariables() {
//		setsPiezaMarcadaInicial("");
//		setsCaraMarcada("");
//		setsColorMarcada("");
//		setsPiezaMarcadaInicial("");
//		setsCaraMarcadaInicial("");
//		setsColorMarcadaInicial("");
//
//		setPiezaMarcadaDetalle("");
//		setVcodProced("");
//		setVdesProced("");
//		setCodProcedimiento("");
//		setDesProcedimiento("");
//		
//		
//
//	}
//	
//	
//	public void obtenerListados(BOdontogramaList bResultado) {
//
//		List<BOdontograma> lOdontograma = bResultado.getListaOdontograma();
//		List<BOdontogramaDet> lOdontogramaDet = bResultado.getListaOdontoDetalle();
//
//		if (lOdontograma.size() == 1) {
//			this.setListaOdontograma(lOdontograma);
//			if (CollectionUtils.isNotEmpty(lOdontogramaDet)) {
//				this.setListaOdontogramaDet(lOdontogramaDet);
//			}
//		}
//	}
//
//	private void armarlados(UConstruirCadena cadenas, BOdontogramaDet piezaDental){
//		// primeros marcados
//		switch (piezaDental.getCodIdePza()) {
//		
//		case UConstante.VESTIBULAR:
//			cadenas.construirPiezaInicial(piezaDental.getCodPieza(), UConstante.VESTIBULAR, piezaDental.getCodEstVestibular());
//			
//			cadenas.validaVestibular(piezaDental);
//			cadenas.validaOclusal(piezaDental);
//			cadenas.validaLingual(piezaDental);
//			cadenas.validaDistal(piezaDental);
//			cadenas.validaMesial(piezaDental);
//			cadenas.validaRaizSuperior(piezaDental);
//			cadenas.validaRaizInferior(piezaDental);
//			break;
//
//		case UConstante.OCLUSAL:
//			cadenas.construirPiezaInicial(piezaDental.getCodPieza(), UConstante.OCLUSAL, piezaDental.getCodEstOclusal());
//			
//			cadenas.validaOclusal(piezaDental);
//			cadenas.validaVestibular(piezaDental);
//			cadenas.validaLingual(piezaDental);
//			cadenas.validaDistal(piezaDental);
//			cadenas.validaMesial(piezaDental);
//			cadenas.validaRaizSuperior(piezaDental);
//			cadenas.validaRaizInferior(piezaDental);
//			break;
//
//		case UConstante.LINGUAL:
//			cadenas.construirPiezaInicial(piezaDental.getCodPieza(), UConstante.LINGUAL, piezaDental.getCodEstLingual());
//			
//			cadenas.validaLingual(piezaDental);
//			cadenas.validaOclusal(piezaDental);
//			cadenas.validaVestibular(piezaDental);
//			cadenas.validaDistal(piezaDental);
//			cadenas.validaMesial(piezaDental);
//			cadenas.validaRaizSuperior(piezaDental);
//			cadenas.validaRaizInferior(piezaDental);
//			break;
//
//		case UConstante.DISTAL:
//			cadenas.construirPiezaInicial(piezaDental.getCodPieza(), UConstante.DISTAL, piezaDental.getCodEstDistal());
//			
//			cadenas.validaDistal(piezaDental);
//			cadenas.validaLingual(piezaDental);
//			cadenas.validaOclusal(piezaDental);
//			cadenas.validaVestibular(piezaDental);
//			cadenas.validaMesial(piezaDental);
//			cadenas.validaRaizSuperior(piezaDental);
//			cadenas.validaRaizInferior(piezaDental);
//
//			break;
//
//		case UConstante.MESIAL:
//			cadenas.construirPiezaInicial(piezaDental.getCodPieza(), UConstante.MESIAL, piezaDental.getCodEstMesial());
//			
//			cadenas.validaMesial(piezaDental);
//			cadenas.validaDistal(piezaDental);
//			cadenas.validaLingual(piezaDental);
//			cadenas.validaOclusal(piezaDental);
//			cadenas.validaVestibular(piezaDental);
//			cadenas.validaRaizSuperior(piezaDental);
//			cadenas.validaRaizInferior(piezaDental);
//			
//			break;
//
//		case UConstante.RAIZ_SUPERIOR:
//			cadenas.construirPiezaInicial(piezaDental.getCodPieza(), UConstante.RAIZ_SUPERIOR, piezaDental.getCodEstRaizSup());
//			
//			cadenas.validaRaizSuperior(piezaDental);
//			cadenas.validaMesial(piezaDental);
//			cadenas.validaDistal(piezaDental);
//			cadenas.validaLingual(piezaDental);
//			cadenas.validaOclusal(piezaDental);
//			cadenas.validaVestibular(piezaDental);
//			cadenas.validaRaizInferior(piezaDental);
//			
//			break;
//
//
//		case UConstante.RAIZ_INFERIOR:
//			cadenas.construirPiezaInicial(piezaDental.getCodPieza(), UConstante.RAIZ_INFERIOR, piezaDental.getCodEstRaizInf());
//			
//			cadenas.validaRaizInferior(piezaDental);
//			cadenas.validaRaizSuperior(piezaDental);
//			cadenas.validaMesial(piezaDental);
//			cadenas.validaDistal(piezaDental);
//			cadenas.validaLingual(piezaDental);
//			cadenas.validaOclusal(piezaDental);
//			cadenas.validaVestibular(piezaDental);	
//			break;
//
//		default:
//			break;
//		}
//	}
//	
//	
//	public BPiezasMarcadas obtenerPiezas(List<BOdontogramaDet> lOdontogramaDet) {
//		
//		Map<String,Object> piezasRequest = UWebUtil.getRequestMap();
//		// //obtener ultimo odontograma si se va a modificar
//		setGrabado(true);
//		UConstruirCadena cadenas = new UConstruirCadena();
//		for (BOdontogramaDet piezaDental : lOdontogramaDet) { 
//			
//				//IMPORTANTE, EN ESTE METODO SE ARMAN LOS LADOS DE LAS PIEZAS
//				armarlados(cadenas, piezaDental);
//
//				
//				//marcarObservaciones
//				if(StringUtils.isNotEmpty(piezaDental.getDesEstPza())){
//					piezasRequest.put(piezaDental.getCodPieza(), piezaDental.getDesEstPza());// llenado de observaciones 25082016
//				}
//		}
//		
//		String piezaMarcada = cadenas.getStbPiezaMarcada().toString();
//		String caraMarcada = cadenas.getStbCaraMarcada().toString();
//		String coloreMarcada = cadenas.getStbColorMarcado().toString();
//		String piezaMarcadaInicial = cadenas.getStbPiezaMarcadaInicial().toString();
//		String caraMarcadaInicial = cadenas.getStbCaraMarcadaInicial().toString();
//		String colorMarcadaInicial = cadenas.getStbColorMarcadoInicial().toString(); 
//
//		String pPiezaMarcada = piezaMarcada.substring(0, piezaMarcada.length() - 1);
//		String pCaraMarcada = caraMarcada.substring(0, caraMarcada.length() - 1);
//		String pColoreMarcada = coloreMarcada.substring(0, coloreMarcada.length() - 1);
//		String pPiezaMarcadaInicial = piezaMarcadaInicial.substring(0, piezaMarcadaInicial.length() - 1);
//		String pCaraMarcadaInicial = caraMarcadaInicial.substring(0, caraMarcadaInicial.length() - 1);
//		String pColorMarcadaInicial = colorMarcadaInicial.substring(0, colorMarcadaInicial.length() - 1);
//
//		BPiezasMarcadas piezas = new BPiezasMarcadas();
//		piezas.setPiezaMarcada(pPiezaMarcada);
//		piezas.setCaraMarcada(pCaraMarcada);
//		piezas.setColoreMarcada(pColoreMarcada);
//		piezas.setPiezaMarcadaInicial(pPiezaMarcadaInicial);
//		piezas.setCaraMarcadaInicial(pCaraMarcadaInicial);
//		piezas.setColorMarcadaInicial(pColorMarcadaInicial);
//		return piezas;
//	}
//
//	public void obtenerPiezasFinales(BPiezasMarcadas piezas) {
//		// envio de parametros al javascript
//		setsPiezaMarcada(StringUtils.trim(StringUtils.defaultString(piezas.getPiezaMarcada())));
//		setsCaraMarcada(StringUtils.trim(StringUtils.defaultString(piezas.getCaraMarcada())));
//		setsColorMarcada(StringUtils.trim(StringUtils.defaultString(piezas.getColoreMarcada())));
//		setsPiezaMarcadaInicial(StringUtils.trim(StringUtils.defaultString(piezas.getPiezaMarcadaInicial())));
//		setsCaraMarcadaInicial(StringUtils.trim(StringUtils.defaultString(piezas.getCaraMarcadaInicial())));
//		setsColorMarcadaInicial(StringUtils.trim(StringUtils.defaultString(piezas.getColorMarcadaInicial())));
//	}
//
//	// obtenerProcedimientos
//	public void obtenerProcedimientoPieza() {
//		String codPieza = obtenerParametroServidor("dienteId");
//		BOdontogramaProcedimiento odontoProc = new BOdontogramaProcedimiento();
//
//		odontoProc.setCodPersona(this.getCodPersona());
//		odontoProc.setCodPieza(codPieza);
//		List<BOdontograma> lOdontograma = getListaOdontograma();
//		long numOdon = 0;
//		if (CollectionUtils.isNotEmpty(lOdontograma)) {
//			numOdon = lOdontograma.get(0).getNumOdonto();
//			odontoProc.setNumOdonto(numOdon);
//		}
//
//		setPiezaMarcadaDetalle(codPieza);
//
//		if (isGrabado()) {
//
//			// obtener procedimientos
//			List<BOdontogramaProcedimiento> listaProcedimiento = obtenerProcedimientos(odontoProc);
//			if (CollectionUtils.isNotEmpty(listaProcedimiento)) {
//				setListaOdontoProc(listaProcedimiento);
//			} else {
//				setListaOdontoProc(new ArrayList<BOdontogramaProcedimiento>());
//			}
//
//			RequestContext vContext = RequestContext.getCurrentInstance();
//			vContext.execute("PF('detPieza').show();");
//			setCodProcedimiento("");
//			setDesProcedimiento("");
//			setCantProc(1);
//		} else {
//			FacesContext.getCurrentInstance().addMessage("msgs",
//					new FacesMessage(FacesMessage.SEVERITY_WARN, "Debe de registrar 1 odontograma", ""));
//		}
//
//	}
//
//	public void adicionarProcedimiento() {
//		BOdontograma odont = getListaOdontograma().get(0);
//		BOdontogramaProcedimiento bOdontogramaProcedimiento = new BOdontogramaProcedimiento();
//		bOdontogramaProcedimiento.setCodPieza(getPiezaMarcadaDetalle());
//		bOdontogramaProcedimiento.setCodCps(codProcedimiento);
//		bOdontogramaProcedimiento.setCantProc(cantProc);
//		bOdontogramaProcedimiento.setCodPersona(odont.getCodPersona());
//		bOdontogramaProcedimiento.setNumOdonto(odont.getNumOdonto());
//		
//		if(cantProc!=0){
//			
//			if (StringUtils.isNotEmpty(codProcedimiento)) {
//
//			List<BOdontogramaProcedimiento> listaProcedimiento = obtenerProcedimientos(bOdontogramaProcedimiento);//llamada a listaprocedimiento
//			if (CollectionUtils.isNotEmpty(listaProcedimiento)) {
//				FacesContext.getCurrentInstance().addMessage("msgs",
//						new FacesMessage(FacesMessage.SEVERITY_WARN, "Ya existe un procedimiento para esta pieza dental", ""));
//			} else {
//				bOdontogramaProcedimiento.setOpcion(UConstante.INSERTAR);
//				String flag = mantenimientoProcedimiento(bOdontogramaProcedimiento);
//
//				if (!flag.equals("0")) {
//					FacesContext.getCurrentInstance().addMessage("msgs",
//							new FacesMessage(FacesMessage.SEVERITY_WARN, "Observaci�n",flag ));
//				} else {
//
//					setCodProcedimiento("");
//					setDesProcedimiento("");
//					setCantProc(1);
//					FacesContext.getCurrentInstance().addMessage("msgs",
//							new FacesMessage(FacesMessage.SEVERITY_INFO, "Se adicion� procedimiento correctamente", ""));
//
//					// Nueva busqueda
//					refrescarListadoProcedimientos(bOdontogramaProcedimiento);
//
//				}
//			}
//
//		} else {
//			FacesContext.getCurrentInstance().addMessage("msgs",
//					new FacesMessage(FacesMessage.SEVERITY_WARN, "No puede ingresar un Procedimiento vacio", ""));
//		}
//      }else{
//    	  FacesContext.getCurrentInstance().addMessage("msgs",
//					new FacesMessage(FacesMessage.SEVERITY_WARN, "Aviso:", "La Cantidad debe ser mayor a Cero"));		
//      }
//	}
//
//	private String mantenimientoProcedimiento(BOdontogramaProcedimiento procedimiento){
//		iOdontogramaService = new NOdontogramaImpl();
//		return  iOdontogramaService.mantenimientoProcedimiento(procedimiento);
//		
//	}
//	
//	public void eliminarProcedimiento(BOdontogramaProcedimiento procedimiento) {
//		
//		procedimiento.setOpcion(UConstante.ELIMINAR);
//		String flag = mantenimientoProcedimiento(procedimiento);
//
//		if (!flag.equals("0")) {
//			FacesContext.getCurrentInstance().addMessage("msgs",
//					new FacesMessage(FacesMessage.SEVERITY_ERROR, "No se pudo eliminar el procedimiento", ""));
//		} else {
//
//			setCodProcedimiento("");
//			setDesProcedimiento("");
//
//			FacesContext.getCurrentInstance().addMessage("msgs",
//					new FacesMessage(FacesMessage.SEVERITY_INFO, "Se elimino correctamente", ""));
//
//			refrescarListadoProcedimientos(procedimiento);
//		}
//	}
//
//	public void refrescarListadoProcedimientos(BOdontogramaProcedimiento procedimiento) {
//		
//		// Nueva busqueda
//		BOdontogramaProcedimiento parametros = new BOdontogramaProcedimiento();
//		parametros.setCodPieza(procedimiento.getCodPieza());
//		parametros.setCodPersona(procedimiento.getCodPersona());
//		parametros.setNumOdonto(procedimiento.getNumOdonto());
//		List<BOdontogramaProcedimiento> listaActualizada = obtenerProcedimientos(parametros);
//		this.setListaOdontoProc(listaActualizada);
//	}
//	
//	private List<BOdontogramaProcedimiento> obtenerProcedimientos(BOdontogramaProcedimiento parametros){
//		iOdontogramaService = new NOdontogramaImpl();
//		return iOdontogramaService.obtenerProcedimientos(parametros);
//		
//	}
//
//	public void continuarOdontograma() {
//		RequestContext vContext = RequestContext.getCurrentInstance();
//		vContext.execute("PF('dialogAlertaCerrarOdontograma').hide();");
//	}
//
//	public void cerrarOdontograma() {
//		RequestContext vContext = RequestContext.getCurrentInstance();
//		vContext.execute("PF('dialogOdontograma').hide();");
//		vContext.execute("PF('dialogAlertaCerrarOdontograma').hide();");
//	}
//
//	public void alertaCerrarOdontograma() {
//		
//		BProcedimientoResultado parametros = new BProcedimientoResultado();
//		List<BOdontograma> vListaOdontograma = getListaOdontograma();
//		RequestContext vContext = RequestContext.getCurrentInstance();
//
//		if (CollectionUtils.isNotEmpty(vListaOdontograma)) {
//			BOdontograma odonto = vListaOdontograma.get(0);
//			parametros.setNumOdonto(odonto.getNumOdonto());
//			parametros.setCodPersona(odonto.getCodPersona());
//
//			BProcedimientoResultado result = obtenerPiezaProcdimiento(parametros);
//
//			if (result.getIndica() > 0) {
//				setAlertaMensaje(result.getPiezas());
//				vContext.execute("PF('dialogAlertaCerrarOdontograma').show();");
//			} else {
//				vContext.execute("PF('dialogOdontograma').hide();");
//			}
//		} else {
//			vContext.execute("PF('dialogOdontograma').hide();");
//		}
//	}
//
//	private BProcedimientoResultado obtenerPiezaProcdimiento(BProcedimientoResultado parametros){
//		iOdontogramaService = new NOdontogramaImpl();
//		BProcedimientoResultado result = iOdontogramaService.obtenerPiezaProcdimiento(parametros);
//		return result;
//	}
//	
//	public void mostrarOdontograma() {
//
//		obtenerUltimoOdontograma();
//		RequestContext vContext = RequestContext.getCurrentInstance();
//		vContext.execute("PF('dialogOdontograma').show();");
//	}
//
//	public void verOdontograma() {
//		obtenerUltimoOdontograma();
//	}
//	
//	public void mostrarHistorico(BOdontograma bHOdontograma) {
//		iOdontogramaService = new NOdontogramaImpl();
//		bResultado = iOdontogramaService.obtenerOdontograma(bHOdontograma);
//
//		// obtener ultimo odontograma si se va a modificar
//		if (bResultado.getListaOdontograma().size() == 1) {
//
//			if (!bResultado.getListaOdontoDetalle().isEmpty()) {
//				BPiezasMarcadas piezas = obtenerPiezas(bResultado.getListaOdontoDetalle());
//				setPiezasHistoricas(piezas);
//			}
//		}
//
//		RequestContext vContext = RequestContext.getCurrentInstance();
//		vContext.execute("PF('dialogOdontogramaHistorico').show();");
//
//	}
//
//	public void irVentanaProcedimientosOdontologicos() {
//		vcodProced="";
//		vdesProced = "";
//		setListadoProcedimientoOdontologico(new ArrayList<BProcedimientoSalud>());
//		RequestContext vContext = RequestContext.getCurrentInstance();
//		vContext.execute("PF('dialogProcedimientoOdonto').show();");
//	
//	}
//
//	public void buscarProcedimiento() {
//		List<BProcedimientoSalud> listaProcedimientoSaludTemp = new ArrayList<BProcedimientoSalud>();
//		try {
//			BProcedimientoSalud bProcedimientoSalud = new BProcedimientoSalud();
//			bProcedimientoSalud.setCodCps(vcodProced);
//			bProcedimientoSalud.setDesCps(vdesProced);
//			bProcedimientoSalud.setOpcion(UConstante.OPCION_MAESTRO_TIPO_TRES);
//			IMantAdmCitasProcedimientoSaludService iMantAdminCitasProcedimientoSaludService = new NMantAdmCitasProcedimientoSaludImpl();
//			listaProcedimientoSaludTemp = iMantAdminCitasProcedimientoSaludService.cargarListadoProcedimientos(bProcedimientoSalud);
//			setListadoProcedimientoOdontologico(listaProcedimientoSaludTemp);
//		} catch (Exception e) {
//			LOGGER.error("Error en buscarProcedimiento(): " + e.getMessage(), e);
//		}
//	}
//
//	public void seleccionarProcedimiento() {
//
//		final String codProc = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("codProc");
//		final String desProc = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("desProc");
//
//		this.codProcedimiento = codProc;
//		this.desProcedimiento = desProc;
//		try {
//			RequestContext vContext = RequestContext.getCurrentInstance();
//			vContext.execute("PF('dialogProcedimientoOdonto').hide();");
//		} catch (Exception e) {
//			LOGGER.error("Error en seleccionarProcedimiento(): " + e.getMessage(), e);
//		}
//	}
//
//	public void obtenerPiezaDetalle(SelectEvent event) {
//		iOdontogramaService = new NOdontogramaImpl();
//		BOdontograma odontograma = (BOdontograma) event.getObject();
//		List<BOdontogramaDet> listaDetSesiones = iOdontogramaService.obtenerOdontogramaSesionesDetalle(odontograma);
//		this.setListaDetalleSesiones(listaDetSesiones);
//	}
//
//	public BOdontograma getSelectedOdontograma() {
//		return selectedOdontograma;
//	}
//
//	public void setSelectedOdontograma(BOdontograma selectedOdontograma) {
//		this.selectedOdontograma = selectedOdontograma;
//	}
//
//	public void verSesiones() {
//		iOdontogramaService = new NOdontogramaImpl();
//		BOdontograma vBOdontograma = new BOdontograma();
//		vBOdontograma.setCodPersona(this.getCodPersona());
//		vBOdontograma.setCodCentro(this.getCodCentro());
//
//		List<BOdontograma> lista = iOdontogramaService.obtenerOdontogramaSesionesList(vBOdontograma);
//		setListaSesionesOdontograma(lista);
//
//		RequestContext vContext = RequestContext.getCurrentInstance();
//		vContext.execute("PF('dialogSesiones').show();");
//	}
//
//	
//	public void cerrarProcedimientoPieza() {
//		RequestContext vContext = RequestContext.getCurrentInstance();
//		vContext.execute("PF('detPieza').hide();");
//	}
//	
//	
//	private String formarCadena(String posi,String obsrv){
//		
//		
//		return posi+ UConstante.DIENTE_BUENO+obsrv+";|";
//	}
//	
//	
//
//		
//	public BDescPieza getDescPza(String codigo,String desc){
//		BDescPieza desPza = new BDescPieza();
//		desPza.setCodigo(codigo);
//		desPza.setDesc(desc);
//		return desPza;
//	}
//
//	
//	public List<BOdontograma> getListaOdontograma() {
//		return listaOdontograma;
//	}
//
//	public void setListaOdontograma(List<BOdontograma> listaOdontograma) {
//		this.listaOdontograma = listaOdontograma;
//	}
//
//	public List<BOdontogramaDet> getListaOdontogramaDet() {
//		return listaOdontogramaDet;
//	}
//
//	public void setListaOdontogramaDet(List<BOdontogramaDet> listaOdontogramaDet) {
//		this.listaOdontogramaDet = listaOdontogramaDet;
//	}
//
//	public String getsPiezaMarcada() {
//		return sPiezaMarcada;
//	}
//
//	public void setsPiezaMarcada(String sPiezaMarcada) {
//		this.sPiezaMarcada = sPiezaMarcada;
//	}
//
//	public String getsCaraMarcada() {
//		return sCaraMarcada;
//	}
//
//	public void setsCaraMarcada(String sCaraMarcada) {
//		this.sCaraMarcada = sCaraMarcada;
//	}
//
//	public String getsColorMarcada() {
//		return sColorMarcada;
//	}
//
//	public void setsColorMarcada(String sColorMarcada) {
//		this.sColorMarcada = sColorMarcada;
//	}
//
//	public String getsPiezaMarcadaInicial() {
//		return sPiezaMarcadaInicial;
//	}
//
//	public void setsPiezaMarcadaInicial(String sPiezaMarcadaInicial) {
//		this.sPiezaMarcadaInicial = sPiezaMarcadaInicial;
//	}
//
//	public String getsCaraMarcadaInicial() {
//		return sCaraMarcadaInicial;
//	}
//
//	public void setsCaraMarcadaInicial(String sCaraMarcadaInicial) {
//		this.sCaraMarcadaInicial = sCaraMarcadaInicial;
//	}
//
//	public String getsColorMarcadaInicial() {
//		return sColorMarcadaInicial;
//	}
//
//	public void setsColorMarcadaInicial(String sColorMarcadaInicial) {
//		this.sColorMarcadaInicial = sColorMarcadaInicial;
//	}
//
//	public String getPiezaMarcadaDetalle() {
//		return piezaMarcadaDetalle;
//	}
//
//	public void setPiezaMarcadaDetalle(String piezaMarcadaDetalle) {
//		this.piezaMarcadaDetalle = piezaMarcadaDetalle;
//	}
//
//	public List<BOdontogramaProcedimiento> getListaOdontoProc() {
//		return listaOdontoProc;
//	}
//
//	public void setListaOdontoProc(List<BOdontogramaProcedimiento> listaOdontoProc) {
//		this.listaOdontoProc = listaOdontoProc;
//	}
//
//	public List<BProcedimientoSalud> getListadoProcedimientoOdontologico() {
//		return listadoProcedimientoOdontologico;
//	}
//
//	public void setListadoProcedimientoOdontologico(List<BProcedimientoSalud> listadoProcedimientoOdontologico) {
//		this.listadoProcedimientoOdontologico = listadoProcedimientoOdontologico;
//	}
//
//	public String getCodProcedimiento() {
//		return codProcedimiento;
//	}
//
//	public void setCodProcedimiento(String codProcedimiento) {
//		this.codProcedimiento = codProcedimiento;
//	}
//
//	public String getDesProcedimiento() {
//		return desProcedimiento;
//	}
//
//	public void setDesProcedimiento(String desProcedimiento) {
//		this.desProcedimiento = desProcedimiento;
//	}
//
//	public boolean isGrabado() {
//		return grabado;
//	}
//
//	public void setGrabado(boolean grabado) {
//		this.grabado = grabado;
//	}
//
//	public List<BOdontograma> getListaSesionesOdontograma() {
//		return listaSesionesOdontograma;
//	}
//
//	public void setListaSesionesOdontograma(List<BOdontograma> listaSesionesOdontograma) {
//		this.listaSesionesOdontograma = listaSesionesOdontograma;
//	}
//
//	public String getpOdontogramaHistorico() {
//		return pOdontogramaHistorico;
//	}
//
//	public void setpOdontogramaHistorico(String pOdontogramaHistorico) {
//		this.pOdontogramaHistorico = pOdontogramaHistorico;
//	}
//
//	public BPiezasMarcadas getPiezasHistoricas() {
//		return piezasHistoricas;
//	}
//
//	public void setPiezasHistoricas(BPiezasMarcadas piezasHistoricas) {
//		this.piezasHistoricas = piezasHistoricas;
//	}
//
//	public List<BOdontogramaDet> getListaPiezaDetalle() {
//		return listaPiezaDetalle;
//	}
//
//	public void setListaPiezaDetalle(List<BOdontogramaDet> listaPiezaDetalle) {
//		this.listaPiezaDetalle = listaPiezaDetalle;
//	}
//
//	public List<BOdontogramaDet> getListaDetalleSesiones() {
//		return listaDetalleSesiones;
//	}
//
//	public void setListaDetalleSesiones(List<BOdontogramaDet> listaDetalleSesiones) {
//		this.listaDetalleSesiones = listaDetalleSesiones;
//	}
//
//	public String getUsuario() {
//		return usuario;
//	}
//
//	public void setUsuario(String usuario) {
//		this.usuario = usuario;
//	}
//
//	public String getUsuarioIp() {
//		return usuarioIp;
//	}
//
//	public void setUsuarioIp(String usuarioIp) {
//		this.usuarioIp = usuarioIp;
//	}
//
//	public long getCodPersona() {
//		return codPersona;
//	}
//
//	public void setCodPersona(long codPersona) {
//		this.codPersona = codPersona;
//	}
//
//	public long getCodCentro() {
//		return codCentro;
//	}
//
//	public void setCodCentro(long codCentro) {
//		this.codCentro = codCentro;
//	}
//
//	public long getActoMedico() {
//		return actoMedico;
//	}
//
//	public void setActoMedico(long actoMedico) {
//		this.actoMedico = actoMedico;
//	}
//
//	public String getVcodProced() {
//		return vcodProced;
//	}
//
//	public void setVcodProced(String vcodProced) {
//		this.vcodProced = vcodProced;
//	}
//
//	public String getVdesProced() {
//		return vdesProced;
//	}
//
//	public void setVdesProced(String vdesProced) {
//		this.vdesProced = vdesProced;
//	}
//
//	public String getAlertaMensaje() {
//		return alertaMensaje;
//	}
//
//	public void setAlertaMensaje(String alertaMensaje) {
//		this.alertaMensaje = alertaMensaje;
//	}
//
//	public long getOptIpb() {
//		return optIpb;
//	}
//
//	public void setOptIpb(long optIpb) {
//		this.optIpb = optIpb;
//	}
//
//	public long getOptEc() {
//		return optEc;
//	}
//
//	public void setOptEc(long optEc) {
//		this.optEc = optEc;
//	}
//
//	public long getOptFcch() {
//		return optFcch;
//	}
//
//	public void setOptFcch(long optFcch) {
//		this.optFcch = optFcch;
//	}
//
//	public long getOptRe() {
//		return optRe;
//	}
//
//	public void setOptRe(long optRe) {
//		this.optRe = optRe;
//	}
//
//	public boolean isFlagOdontograma() {
//		return flagOdontograma;
//	}
//
//	public void setFlagOdontograma(boolean flagOdontograma) {
//		this.flagOdontograma = flagOdontograma;
//	}
//
//	public long getCantProc() {
//		return cantProc;
//	}
//
//	public void setCantProc(long cantProc) {
//		this.cantProc = cantProc;
//	}

	
}
