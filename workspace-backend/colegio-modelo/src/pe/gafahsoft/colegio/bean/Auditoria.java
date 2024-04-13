package pe.gafahsoft.colegio.bean;

import java.io.Serializable;
import java.util.Date;

public class Auditoria implements Serializable {

	private static final long serialVersionUID = -8082292798893225647L;
	private int opcion;

	 private String usuReg;

	    private Date fecReg;

	    private String usuMod;

	    private Date fecMod;

	    private String maqReg;

	    private String maqMod;

	
	public int getOpcion() {
		return opcion;
	}

	public void setOpcion(int opcion) {
		this.opcion = opcion;
	}

	public String getUsuReg() {
		return usuReg;
	}

	public void setUsuReg(String usuReg) {
		this.usuReg = usuReg;
	}

	public Date getFecReg() {
		return fecReg;
	}

	public void setFecReg(Date fecReg) {
		this.fecReg = fecReg;
	}

	public String getUsuMod() {
		return usuMod;
	}

	public void setUsuMod(String usuMod) {
		this.usuMod = usuMod;
	}

	public Date getFecMod() {
		return fecMod;
	}

	public void setFecMod(Date fecMod) {
		this.fecMod = fecMod;
	}

	public String getMaqReg() {
		return maqReg;
	}

	public void setMaqReg(String maqReg) {
		this.maqReg = maqReg;
	}

	public String getMaqMod() {
		return maqMod;
	}

	public void setMaqMod(String maqMod) {
		this.maqMod = maqMod;
	}

	
	
	
}
