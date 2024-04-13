package pe.gafahsoft.colegio.modelo;

import pe.gafahsoft.colegio.bean.Comun;

public class Menu extends Comun {

	private static final long serialVersionUID = -6041140268874212670L;

	private Integer menuId;

	private Integer padreId;

	private String descLarga;

	

	private String url;

	public Integer getMenuId() {
		return menuId;
	}

	public void setMenuId(Integer menuId) {
		this.menuId = menuId;
	}

	public Integer getPadreId() {
		return padreId;
	}

	public void setPadreId(Integer padreId) {
		this.padreId = padreId;
	}

	public String getDescLarga() {
		return descLarga;
	}

	public void setDescLarga(String descLarga) {
		this.descLarga = descLarga;
	}

	

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return "Menu [menuId=" + menuId + ", padreId=" + padreId + ", descLarga=" + descLarga 
				+ ", url=" + url + "]";
	}

}