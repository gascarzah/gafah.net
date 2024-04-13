package pe.gafahsoft.colegio.modelo;

import pe.gafahsoft.colegio.bean.Comun;

public class Maestra extends Comun {

	private static final long serialVersionUID = 779148954928614732L;

	private Integer maesId;

	private Integer maesPadreId;

	private String valor;

	private String descLarga;
	
	private String descCorta;

	public Integer getMaesId() {
		return maesId;
	}

	public void setMaesId(Integer maesId) {
		this.maesId = maesId;
	}

	public Integer getMaesPadreId() {
		return maesPadreId;
	}

	public void setMaesPadreId(Integer maesPadreId) {
		this.maesPadreId = maesPadreId;
	}



	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public String getDescLarga() {
		return descLarga;
	}

	public void setDescLarga(String descLarga) {
		this.descLarga = descLarga;
	}

	public String getDescCorta() {
		return descCorta;
	}

	public void setDescCorta(String descCorta) {
		this.descCorta = descCorta;
	}

	

	@Override
	public String toString() {
		return "Maestra [maesId=" + maesId + ", maesPadreId=" + maesPadreId + ", valor=" + valor + ", descLarga="
				+ descLarga + ", descCorta=" + descCorta + "]";
	}

	
}