package persistencia;

import java.util.List;

public class DatosPersona {

	private String id;
	private String tipoId;
	private String origenDatos;
	private String tipoPersona;
	private String sucursalPrincipal;
	private String nombres;
	private String apellidos;
	private String genero;
	private String razonSocial;
	private String segmento;
	private String cicloDeVida;
	private String marcaSYQ;
	private String tratamientoDatos;
	private String aceptaSMS;
	private String aceptaEmail;
	private List<Contacto> contactos;

	public DatosPersona() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTipoId() {
		return tipoId;
	}

	public void setTipoId(String tipoId) {
		this.tipoId = tipoId;
	}

	public String getOrigenDatos() {
		return origenDatos;
	}

	public void setOrigenDatos(String origenDatos) {
		this.origenDatos = origenDatos;
	}

	public String getTipoPersona() {
		return tipoPersona;
	}

	public void setTipoPersona(String tipoPersona) {
		this.tipoPersona = tipoPersona;
	}

	public String getSucursalPrincipal() {
		return sucursalPrincipal;
	}

	public void setSucursalPrincipal(String sucursalPrincipal) {
		this.sucursalPrincipal = sucursalPrincipal;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getRazonSocial() {
		return razonSocial;
	}

	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}

	public String getSegmento() {
		return segmento;
	}

	public void setSegmento(String segmento) {
		this.segmento = segmento;
	}

	public String getCicloDeVida() {
		return cicloDeVida;
	}

	public void setCicloDeVida(String cicloDeVida) {
		this.cicloDeVida = cicloDeVida;
	}

	public String getMarcaSYQ() {
		return marcaSYQ;
	}

	public void setMarcaSYQ(String marcaSYQ) {
		this.marcaSYQ = marcaSYQ;
	}

	public String getTratamientoDatos() {
		return tratamientoDatos;
	}

	public void setTratamientoDatos(String tratamientoDatos) {
		this.tratamientoDatos = tratamientoDatos;
	}

	public String getAceptaSMS() {
		return aceptaSMS;
	}

	public void setAceptaSMS(String aceptaSMS) {
		this.aceptaSMS = aceptaSMS;
	}

	public String getAceptaEmail() {
		return aceptaEmail;
	}

	public void setAceptaEmail(String aceptaEmail) {
		this.aceptaEmail = aceptaEmail;
	}

	public List<Contacto> getContactos() {
		return contactos;
	}

	public void setContactos(List<Contacto> contactos) {
		this.contactos = contactos;
	}

}
