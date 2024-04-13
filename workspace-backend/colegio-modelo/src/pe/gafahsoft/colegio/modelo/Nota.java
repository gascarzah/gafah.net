package pe.gafahsoft.colegio.modelo;

import pe.gafahsoft.colegio.bean.Comun;

public class Nota extends Comun {

	private static final long serialVersionUID = 416426867488910397L;

	private Integer notaId; 
	private Integer areaId; 
	private Integer capacidadId; 
	private Integer nivel; 
	private Integer matriId; 
	private String dniAlum; 
	
	private Integer bimestre=0; 
//	private Integer nota2=0; 
//	private Integer nota3=0; 
//	private Integer nota4=0; 
//	private Integer promFinal=0;
	
	private Integer nota11=0; 
	private Integer nota21=0; 
	private Integer nota31=0; 
	private Integer nota41=0; 
	private Integer promFinal1=0;
	
	private Integer nota12=0; 
	private Integer nota22=0; 
	private Integer nota32=0; 
	private Integer nota42=0; 
	private Integer promFinal2=0;
	
	private Integer nota13=0; 
	private Integer nota23=0; 
	private Integer nota33=0; 
	private Integer nota43=0; 
	private Integer promFinal3=0;
	
	private Integer nota14=0; 
	private Integer nota24=0; 
	private Integer nota34=0; 
	private Integer nota44=0; 
	private Integer promFinal4=0;
	
//	private String letraNota1; 
//	private String letraNota2; 
//	private String letraNota3; 
//	private String letraNota4; 
//	private String letraNotaPromFinal;
	
	private String letraNota11; 
	private String letraNota21; 
	private String letraNota31; 
	private String letraNota41; 
	private String letraPromFinal1;
	
	private String letraNota12; 
	private String letraNota22; 
	private String letraNota32; 
	private String letraNota42; 
	private String letraPromFinal2;
	
	private String letraNota13; 
	private String letraNota23; 
	private String letraNota33; 
	private String letraNota43; 
	private String letraPromFinal3;
	
	private String letraNota14; 
	private String letraNota24; 
	private String letraNota34; 
	private String letraNota44; 
	private String letraPromFinal4;
	
	private String alumno;

	public Integer getNotaId() {
		return notaId;
	}

	public void setNotaId(Integer notaId) {
		this.notaId = notaId;
	}

	public Integer getAreaId() {
		return areaId;
	}

	public void setAreaId(Integer areaId) {
		this.areaId = areaId;
	}

	public Integer getCapacidadId() {
		return capacidadId;
	}

	public void setCapacidadId(Integer capacidadId) {
		this.capacidadId = capacidadId;
	}

	public Integer getNivel() {
		return nivel;
	}

	public void setNivel(Integer nivel) {
		this.nivel = nivel;
	}

	public Integer getMatriId() {
		return matriId;
	}

	public void setMatriId(Integer matriId) {
		this.matriId = matriId;
	}

	public String getDniAlum() {
		return dniAlum;
	}

	public void setDniAlum(String dniAlum) {
		this.dniAlum = dniAlum;
	}

	public Integer getBimestre() {
		return bimestre;
	}

	public void setBimestre(Integer bimestre) {
		this.bimestre = bimestre;
	}

	public Integer getNota11() {
		return nota11;
	}

	public void setNota11(Integer nota11) {
		this.nota11 = nota11;
	}

	public Integer getNota21() {
		return nota21;
	}

	public void setNota21(Integer nota21) {
		this.nota21 = nota21;
	}

	public Integer getNota31() {
		return nota31;
	}

	public void setNota31(Integer nota31) {
		this.nota31 = nota31;
	}

	public Integer getNota41() {
		return nota41;
	}

	public void setNota41(Integer nota41) {
		this.nota41 = nota41;
	}

	public Integer getPromFinal1() {
		return promFinal1;
	}

	public void setPromFinal1(Integer promFinal1) {
		this.promFinal1 = promFinal1;
	}

	public Integer getNota12() {
		return nota12;
	}

	public void setNota12(Integer nota12) {
		this.nota12 = nota12;
	}

	public Integer getNota22() {
		return nota22;
	}

	public void setNota22(Integer nota22) {
		this.nota22 = nota22;
	}

	public Integer getNota32() {
		return nota32;
	}

	public void setNota32(Integer nota32) {
		this.nota32 = nota32;
	}

	public Integer getNota42() {
		return nota42;
	}

	public void setNota42(Integer nota42) {
		this.nota42 = nota42;
	}

	public Integer getPromFinal2() {
		return promFinal2;
	}

	public void setPromFinal2(Integer promFinal2) {
		this.promFinal2 = promFinal2;
	}

	public Integer getNota13() {
		return nota13;
	}

	public void setNota13(Integer nota13) {
		this.nota13 = nota13;
	}

	public Integer getNota23() {
		return nota23;
	}

	public void setNota23(Integer nota23) {
		this.nota23 = nota23;
	}

	public Integer getNota33() {
		return nota33;
	}

	public void setNota33(Integer nota33) {
		this.nota33 = nota33;
	}

	public Integer getNota43() {
		return nota43;
	}

	public void setNota43(Integer nota43) {
		this.nota43 = nota43;
	}

	public Integer getPromFinal3() {
		return promFinal3;
	}

	public void setPromFinal3(Integer promFinal3) {
		this.promFinal3 = promFinal3;
	}

	public Integer getNota14() {
		return nota14;
	}

	public void setNota14(Integer nota14) {
		this.nota14 = nota14;
	}

	public Integer getNota24() {
		return nota24;
	}

	public void setNota24(Integer nota24) {
		this.nota24 = nota24;
	}

	public Integer getNota34() {
		return nota34;
	}

	public void setNota34(Integer nota34) {
		this.nota34 = nota34;
	}

	public Integer getNota44() {
		return nota44;
	}

	public void setNota44(Integer nota44) {
		this.nota44 = nota44;
	}

	public Integer getPromFinal4() {
		return promFinal4;
	}

	public void setPromFinal4(Integer promFinal4) {
		this.promFinal4 = promFinal4;
	}

//	public String getLetraNota1() {
//		return letraNota1;
//	}
//
//	public void setLetraNota1(String letraNota1) {
//		this.letraNota1 = letraNota1;
//	}
//
//	public String getLetraNota2() {
//		return letraNota2;
//	}
//
//	public void setLetraNota2(String letraNota2) {
//		this.letraNota2 = letraNota2;
//	}
//
//	public String getLetraNota3() {
//		return letraNota3;
//	}
//
//	public void setLetraNota3(String letraNota3) {
//		this.letraNota3 = letraNota3;
//	}
//
//	public String getLetraNota4() {
//		return letraNota4;
//	}
//
//	public void setLetraNota4(String letraNota4) {
//		this.letraNota4 = letraNota4;
//	}
//
//	public String getLetraNotaPromFinal() {
//		return letraNotaPromFinal;
//	}
//
//	public void setLetraNotaPromFinal(String letraNotaPromFinal) {
//		this.letraNotaPromFinal = letraNotaPromFinal;
//	}

	public String getLetraNota11() {
		return letraNota11;
	}

	public void setLetraNota11(String letraNota11) {
		this.letraNota11 = letraNota11;
	}

	public String getLetraNota21() {
		return letraNota21;
	}

	public void setLetraNota21(String letraNota21) {
		this.letraNota21 = letraNota21;
	}

	public String getLetraNota31() {
		return letraNota31;
	}

	public void setLetraNota31(String letraNota31) {
		this.letraNota31 = letraNota31;
	}

	public String getLetraNota41() {
		return letraNota41;
	}

	public void setLetraNota41(String letraNota41) {
		this.letraNota41 = letraNota41;
	}

	public String getLetraPromFinal1() {
		return letraPromFinal1;
	}

	public void setLetraPromFinal1(String letraPromFinal1) {
		this.letraPromFinal1 = letraPromFinal1;
	}

	public String getLetraNota12() {
		return letraNota12;
	}

	public void setLetraNota12(String letraNota12) {
		this.letraNota12 = letraNota12;
	}

	public String getLetraNota22() {
		return letraNota22;
	}

	public void setLetraNota22(String letraNota22) {
		this.letraNota22 = letraNota22;
	}

	public String getLetraNota32() {
		return letraNota32;
	}

	public void setLetraNota32(String letraNota32) {
		this.letraNota32 = letraNota32;
	}

	public String getLetraNota42() {
		return letraNota42;
	}

	public void setLetraNota42(String letraNota42) {
		this.letraNota42 = letraNota42;
	}

	public String getLetraPromFinal2() {
		return letraPromFinal2;
	}

	public void setLetraPromFinal2(String letraPromFinal2) {
		this.letraPromFinal2 = letraPromFinal2;
	}

	public String getLetraNota13() {
		return letraNota13;
	}

	public void setLetraNota13(String letraNota13) {
		this.letraNota13 = letraNota13;
	}

	public String getLetraNota23() {
		return letraNota23;
	}

	public void setLetraNota23(String letraNota23) {
		this.letraNota23 = letraNota23;
	}

	public String getLetraNota33() {
		return letraNota33;
	}

	public void setLetraNota33(String letraNota33) {
		this.letraNota33 = letraNota33;
	}

	public String getLetraNota43() {
		return letraNota43;
	}

	public void setLetraNota43(String letraNota43) {
		this.letraNota43 = letraNota43;
	}

	public String getLetraPromFinal3() {
		return letraPromFinal3;
	}

	public void setLetraPromFinal3(String letraPromFinal3) {
		this.letraPromFinal3 = letraPromFinal3;
	}

	public String getLetraNota14() {
		return letraNota14;
	}

	public void setLetraNota14(String letraNota14) {
		this.letraNota14 = letraNota14;
	}

	public String getLetraNota24() {
		return letraNota24;
	}

	public void setLetraNota24(String letraNota24) {
		this.letraNota24 = letraNota24;
	}

	public String getLetraNota34() {
		return letraNota34;
	}

	public void setLetraNota34(String letraNota34) {
		this.letraNota34 = letraNota34;
	}

	public String getLetraNota44() {
		return letraNota44;
	}

	public void setLetraNota44(String letraNota44) {
		this.letraNota44 = letraNota44;
	}

	public String getLetraPromFinal4() {
		return letraPromFinal4;
	}

	public void setLetraPromFinal4(String letraPromFinal4) {
		this.letraPromFinal4 = letraPromFinal4;
	}

	public String getAlumno() {
		return alumno;
	}

	public void setAlumno(String alumno) {
		this.alumno = alumno;
	}

//	@Override
//	public String toString() {
//		return "Nota [notaId=" + notaId + ", areaId=" + areaId + ", capacidadId=" + capacidadId + ", nivel=" + nivel
//				+ ", matriId=" + matriId + ", dniAlum=" + dniAlum + ", bimestre=" + bimestre + ", nota11=" + nota11
//				+ ", nota21=" + nota21 + ", nota31=" + nota31 + ", nota41=" + nota41 + ", promFinal1=" + promFinal1
//				+ ", nota12=" + nota12 + ", nota22=" + nota22 + ", nota32=" + nota32 + ", nota42=" + nota42
//				+ ", promFinal2=" + promFinal2 + ", nota13=" + nota13 + ", nota23=" + nota23 + ", nota33=" + nota33
//				+ ", nota43=" + nota43 + ", promFinal3=" + promFinal3 + ", nota14=" + nota14 + ", nota24=" + nota24
//				+ ", nota34=" + nota34 + ", nota44=" + nota44 + ", promFinal4=" + promFinal4 + ", letraNota1="
//				+ letraNota1 + ", letraNota2=" + letraNota2 + ", letraNota3=" + letraNota3 + ", letraNota4="
//				+ letraNota4 + ", letraNotaPromFinal=" + letraNotaPromFinal + ", letraNota11=" + letraNota11
//				+ ", letraNota21=" + letraNota21 + ", letraNota31=" + letraNota31 + ", letraNota41=" + letraNota41
//				+ ", letraPromFinal1=" + letraPromFinal1 + ", letraNota12=" + letraNota12 + ", letraNota22="
//				+ letraNota22 + ", letraNota32=" + letraNota32 + ", letraNota42=" + letraNota42 + ", letraPromFinal2="
//				+ letraPromFinal2 + ", letraNota13=" + letraNota13 + ", letraNota23=" + letraNota23 + ", letraNota33="
//				+ letraNota33 + ", letraNota43=" + letraNota43 + ", letraPromFinal3=" + letraPromFinal3
//				+ ", letraNota14=" + letraNota14 + ", letraNota24=" + letraNota24 + ", letraNota34=" + letraNota34
//				+ ", letraNota44=" + letraNota44 + ", letraPromFinal4=" + letraPromFinal4 + ", alumno=" + alumno + "]";
//	}
	
		
}