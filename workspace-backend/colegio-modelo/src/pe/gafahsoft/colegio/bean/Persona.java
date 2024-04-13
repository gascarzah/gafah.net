package pe.gafahsoft.colegio.bean;

import java.math.BigDecimal;
import java.util.Date;

public class Persona extends Comun {


	private static final long serialVersionUID = -2090848713996042204L;

	private String dni;

	private String nombres;

	private String apePate;

	private String apeMate;

	private Integer sexo;

	private Date fecNaci;

	private String direccion;

	private String telefono;

	private String email;

	

	private Integer tipoPers;

	private String celular;

	private Integer estadoCivil;

	

	private BigDecimal remunera;

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApePate() {
		return apePate;
	}

	public void setApePate(String apePate) {
		this.apePate = apePate;
	}

	public String getApeMate() {
		return apeMate;
	}

	public void setApeMate(String apeMate) {
		this.apeMate = apeMate;
	}

	public Integer getSexo() {
		return sexo;
	}

	public void setSexo(Integer sexo) {
		this.sexo = sexo;
	}

	public Date getFecNaci() {
		
		return fecNaci;
	}

	public void setFecNaci(Date fecNaci) {
		this.fecNaci = fecNaci;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getTipoPers() {
		return tipoPers;
	}

	public void setTipoPers(Integer tipoPers) {
		this.tipoPers = tipoPers;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public Integer getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(Integer estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public BigDecimal getRemunera() {
		return remunera;
	}

	public void setRemunera(BigDecimal remunera) {
		this.remunera = remunera;
	}

	@Override
	public String toString() {
		return "Persona [dni=" + dni + ", nombres=" + nombres + ", apePate=" + apePate + ", apeMate=" + apeMate
				+ ", sexo=" + sexo + ", fecNaci=" + fecNaci + ", direccion=" + direccion + ", telefono=" + telefono
				+ ", email=" + email + ", tipoPers=" + tipoPers + ", celular=" + celular + ", estadoCivil="
				+ estadoCivil + ", remunera=" + remunera + "]";
	}

	

}