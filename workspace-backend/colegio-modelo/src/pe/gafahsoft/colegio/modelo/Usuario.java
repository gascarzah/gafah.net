package pe.gafahsoft.colegio.modelo;

import pe.gafahsoft.colegio.bean.Comun;

public class Usuario extends Comun {

	private static final long serialVersionUID = -912921517457211884L;

	private Integer usuId;
	
	

	private Integer empId;

	private String login;

	private String clave;

	private String perfil;
	
	private String nomUsu;

	public Integer getUsuId() {
		return usuId;
	}

	public Integer getEmpId() {
		return empId;
	}

	public void setEmpId(Integer empId) {
		this.empId = empId;
	}

	public void setUsuId(Integer usuId) {
		this.usuId = usuId;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public String getPerfil() {
		return perfil;
	}

	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}

	public String getNomUsu() {
		return nomUsu;
	}

	public void setNomUsu(String nomUsu) {
		this.nomUsu = nomUsu;
	}




	@Override
	public String toString() {
		return "Usuario [usuId=" + usuId + ", empId=" + empId + ", login=" + login
				+ ", clave=" + clave + ", perfil=" + perfil + ", nomUsu=" + nomUsu + "]";
	}


	

}