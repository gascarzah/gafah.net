package pe.gafahsoft.colegio.web;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.RowEditEvent;

import pe.gafahsoft.colegio.modelo.Area;
import pe.gafahsoft.colegio.modelo.Capacidad;
import pe.gafahsoft.colegio.modelo.Indicador;
import pe.gafahsoft.colegio.modelo.Maestra;
import pe.gafahsoft.colegio.modelo.Nota;
import pe.gafahsoft.colegio.util.Constantes;

@ManagedBean
@ViewScoped
public class IndicadorBean extends GeneralBean<Indicador> {

	private static final long serialVersionUID = -6883265984683003988L;
	private Area area = new Area();
	private Capacidad capacidad = new Capacidad();
	Maestra gradoSec = new Maestra();
	private List<Area> areas = new ArrayList<>();
	private List<Capacidad> capacidades = new ArrayList<>();
	private List<Maestra> niveles = new ArrayList<>();
	private Indicador indicador = new Indicador();
	private int bimestre ;
	private Nota editNota = new Nota();
	private List<Nota> notas = new ArrayList<>();
	
	public List<Nota> getNotas() {
		return notas;
	}

	public void setNotas(List<Nota> notas) {
		this.notas = notas;
	}

	public IndicadorBean(){
		setAreas(buscarArea());
	}
	
	public List<Area> buscarArea(){
		Area area = new Area();
		area.setOpcion(Constantes.BUSCAR_TODOS);
		return getGeneraServiceRemote().listar(area);
	}
	
	public void buscarCapacidad(){
		Capacidad capacidad = new Capacidad();
		capacidad.setOpcion(Constantes.BUSCAR_CAPACIDAD_POR_AREA);
		capacidad.setAreaId(area.getAreaId());
		setCapacidades(getGeneraServiceRemote().listar(capacidad));
		
	}
	
	public void buscarGrado(){
		
		Indicador indicador = new Indicador();
		indicador.setOpcion(Constantes.BUSCAR_NIVEL_POR_CAPACIDAD);
		indicador.setAreaId(area.getAreaId());
		indicador.setCapacidadId(capacidad.getCapacidadId());
		List<Indicador> lista = getGeneraServiceRemote().listar(indicador);
		
		setNiveles(armarNivel(lista));
		
	}
	
	public List<Maestra> armarNivel(List<Indicador> lista){
		List<Maestra> niveles = new ArrayList<>();
		Maestra maestra = null;
		for(int i=0; i < lista.size();  i++){
			Indicador ind = lista.get(i);
			maestra = new Maestra();
			maestra.setMaesId(ind.getNivel());
			maestra.setValor(ind.getValor());
			niveles.add(maestra);
		}
		return niveles;
		
	}
	
	
	
//	public void buscarCapacidad(){
//		Capacidad capacidad = new Capacidad();
//		capacidad.setOpcion(Constantes.BUSCAR_CAPACIDAD_POR_AREA);
//		capacidad.setAreaId(area.getAreaId());
//		
//		List<Capacidad> lista = getGeneraServiceRemote().listar(capacidad);
//		List<SelectItem> items = new ArrayList<>();
//
//		if (CollectionUtils.isNotEmpty(lista)) {
//			for (Capacidad obj : lista) {
//				SelectItem item = getSelectItem();
//				item.setValue(obj.getCapacidadId());
//				item.setLabel(
//						StringUtils.trim(obj.getDesc()));
//				items.add(item);
//
//			}
//			setCapacidades(items);
//		}
//	
//	}
	
	
	@Override
	public void agregar() {
		
		
	}

	@Override
	public void modificar(Indicador parametro) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void buscar() {
		if(area.getAreaId() >0 && capacidad.getCapacidadId() > 0 && getGradoSec().getMaesId()> 0 && getBimestre() > 0){
			Nota nota = new Nota();
			nota.setAreaId(area.getAreaId());
			nota.setCapacidadId(capacidad.getCapacidadId());
			nota.setNivel(getGradoSec().getMaesId());
			nota.setBimestre(getBimestre());
			nota.setAnio("2016");
			nota.setOpcion(Constantes.BUSCAR_POR_INDICADORES);
			
			List<Nota> lista = getGeneraServiceRemote().listar(nota);
			System.out.println("listado indicadores "+lista.size());
			setNotas(lista);
		}else{
			FacesContext.getCurrentInstance().addMessage("msgs",
					new FacesMessage(FacesMessage.SEVERITY_WARN, "Ingrese un filtro de busqueda ", ""));
		}
		
	}
	
	public void calcularPromedioFinal(Nota nota){
		int total = 0;
		setEditNota(nota);
		switch (getBimestre()) {
		case Constantes.BIMESTRE_1:
			total = Math.round((nota.getNota11() + nota.getNota21()+ nota.getNota31() + nota.getNota41())/4);
			nota.setPromFinal1(total);
			nota.setLetraPromFinal1(obtenerLetra(total));
			break;
		case Constantes.BIMESTRE_2:
			total = Math.round((nota.getNota12() + nota.getNota22()+ nota.getNota32() + nota.getNota42())/4);
			nota.setPromFinal2(total);
			nota.setLetraPromFinal2(obtenerLetra(total));
			break;
		case Constantes.BIMESTRE_3:
			total = Math.round((nota.getNota13() + nota.getNota23()+ nota.getNota33() + nota.getNota43())/4);
			nota.setPromFinal3(total);
			nota.setLetraPromFinal3(obtenerLetra(total));
			break;
		case Constantes.BIMESTRE_4:
			total = Math.round((nota.getNota14() + nota.getNota24()+ nota.getNota34() + nota.getNota44())/4);
			nota.setPromFinal4(total);
			nota.setLetraPromFinal4(obtenerLetra(total));
			break;
		default:
			break;
		}
	}
	
	public String obtenerLetra(int nota){
		String letra = "";
		if(nota <= 20 && nota >= 16){
			letra = "AD";
		}else if(nota <= 15 && nota >= 13){ 
			letra = "A";
		}else if(nota <= 12 && nota >= 11){ 
			letra = "B";
		}else{
			letra = "C";
		}
		return letra;
		
	}
	
//	public void calcularLetra(Nota nota){
//		nota.setLetraNota44(obtenerLetra(nota.get));
//	}
	
	public void onRowEdit(RowEditEvent event) {
		 
		 Nota nota = ((Nota) event.getObject());
		 nota.setLetraNota11(obtenerLetra(nota.getNota11()));
		 nota.setLetraNota12(obtenerLetra(nota.getNota12()));
		 nota.setLetraNota13(obtenerLetra(nota.getNota13()));
		 nota.setLetraNota14(obtenerLetra(nota.getNota14()));
		 
		 nota.setLetraNota21(obtenerLetra(nota.getNota21()));
		 nota.setLetraNota22(obtenerLetra(nota.getNota22()));
		 nota.setLetraNota23(obtenerLetra(nota.getNota23()));
		 nota.setLetraNota24(obtenerLetra(nota.getNota24()));
		 
		 nota.setLetraNota31(obtenerLetra(nota.getNota31()));
		 nota.setLetraNota32(obtenerLetra(nota.getNota32()));
		 nota.setLetraNota33(obtenerLetra(nota.getNota33()));
		 nota.setLetraNota34(obtenerLetra(nota.getNota34()));
		 
		 nota.setLetraNota41(obtenerLetra(nota.getNota41()));
		 nota.setLetraNota42(obtenerLetra(nota.getNota42()));
		 nota.setLetraNota43(obtenerLetra(nota.getNota43()));
		 nota.setLetraNota44(obtenerLetra(nota.getNota44()));
		 
		    calcularPromedioFinal(nota);
			System.out.println(nota);
			nota.setOpcion(Constantes.ACTUALIZAR);
			int i = getGeneraServiceRemote().grabar(nota);
			evaluarResultado(i);
    }
	
//	public void onCellEdit(CellEditEvent event){
//		System.out.println("onCellEdit");
////		System.out.println("old "+event.getOldValue().getClass());
//		System.out.println("new >>>> "+getEditNota());
////		for(int i=0 ; i< notas.size(); i ++){
//			Nota nota = getEditNota();
//			System.out.println(nota);
//			nota.setOpcion(Constantes.ACTUALIZAR);
//			getGeneraServiceRemote().grabar(nota);
////		}
////			buscar();
//	}

	
	@Override
	public void grabar() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actualizar() {
		// TODO Auto-generated method stub
		
	}

	public Area getArea() {
		return area;
	}

	public void setArea(Area area) {
		this.area = area;
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

	public Maestra getGradoSec() {
		return gradoSec;
	}

	public void setGradoSec(Maestra gradoSec) {
		this.gradoSec = gradoSec;
	}

	public Capacidad getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(Capacidad capacidad) {
		this.capacidad = capacidad;
	}

	public List<Maestra> getNiveles() {
		return niveles;
	}

	public void setNiveles(List<Maestra> niveles) {
		this.niveles = niveles;
	}

	public Indicador getIndicador() {
		return indicador;
	}

	public void setIndicador(Indicador indicador) {
		this.indicador = indicador;
	}

	public int getBimestre() {
		return bimestre;
	}

	public void setBimestre(int bimestre) {
		this.bimestre = bimestre;
	}

	public Nota getNota(){
		return new Nota();
	}

	public Nota getEditNota() {
		return editNota;
	}

	public void setEditNota(Nota editNota) {
		this.editNota = editNota;
	}

	
}
