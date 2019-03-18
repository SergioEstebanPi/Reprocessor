package persistencia;

public class Contacto {
	private String tipoContacto;
	private String proposito;
	private String valorContacto;
	private String pais;
	private String barrio;

	public Contacto() {
	}

	public String getTipoContacto() {
		return tipoContacto;
	}

	public void setTipoContacto(String tipoContacto) {
		this.tipoContacto = tipoContacto;
	}

	public String getProposito() {
		return proposito;
	}

	public void setProposito(String proposito) {
		this.proposito = proposito;
	}

	public String getValorContacto() {
		return valorContacto;
	}

	public void setValorContacto(String valorContacto) {
		this.valorContacto = valorContacto;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getBarrio() {
		return barrio;
	}

	public void setBarrio(String barrio) {
		this.barrio = barrio;
	}

}
