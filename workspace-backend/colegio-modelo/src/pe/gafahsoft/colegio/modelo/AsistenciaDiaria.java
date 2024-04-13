package pe.gafahsoft.colegio.modelo;

public class AsistenciaDiaria extends Alumno {

	private static final long serialVersionUID = 4309595212344046158L;

	private Integer asisDiaId;

	private Integer asisId;

	private Integer matriId;

	private Integer asiste;

	private String diaObserv;

	public Integer getAsisDiaId() {
		return asisDiaId;
	}

	public void setAsisDiaId(Integer asisDiaId) {
		this.asisDiaId = asisDiaId;
	}

	public Integer getAsisId() {
		return asisId;
	}

	public void setAsisId(Integer asisId) {
		this.asisId = asisId;
	}

	public Integer getMatriId() {
		return matriId;
	}

	public void setMatriId(Integer matriId) {
		this.matriId = matriId;
	}

	public Integer getAsiste() {
		return asiste;
	}

	public void setAsiste(Integer asiste) {
		this.asiste = asiste;
	}

	public String getDiaObserv() {
		return diaObserv;
	}

	public void setDiaObserv(String diaObserv) {
		this.diaObserv = diaObserv;
	}



	

}