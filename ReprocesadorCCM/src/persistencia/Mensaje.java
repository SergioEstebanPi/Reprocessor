package persistencia;

public class Mensaje {
	private String mensajeId;
	private String canal;
	private String estadoMensaje;
	private String nroIdentidad;
	private String usuarioCreacion;
	private String fechaCreacion;
	private String usuarioUltimaModificacion;
	private String fechaUltimaModificacion;
	private String evento;
	private String nationalId;
	private String nationalIdType;
	private int reintento;

	public Mensaje() {

	}

	public String getNroIdentidad() {
		return nroIdentidad;
	}

	public void setNroIdentidad(String nroIdentidad) {
		this.nroIdentidad = nroIdentidad;
	}

	public String getEvento() {
		return evento;
	}

	public void setEvento(String evento) {
		this.evento = evento;
	}

	public String getCanal() {
		return canal;
	}

	public void setCanal(String canal) {
		this.canal = canal;
	}

	public String getMensajeId() {
		return mensajeId;
	}

	public void setMensajeId(String mensajeId) {
		this.mensajeId = mensajeId;
	}

	public String getEstadoMensaje() {
		return estadoMensaje;
	}

	public void setEstadoMensaje(String estadoMensaje) {
		this.estadoMensaje = estadoMensaje;
	}

	public String getUsuarioCreacion() {
		return usuarioCreacion;
	}

	public void setUsuarioCreacion(String usuarioCreacion) {
		this.usuarioCreacion = usuarioCreacion;
	}

	public String getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(String fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public String getUsuarioUltimaModificacion() {
		return usuarioUltimaModificacion;
	}

	public void setUsuarioUltimaModificacion(String usuarioUltimaModificacion) {
		this.usuarioUltimaModificacion = usuarioUltimaModificacion;
	}

	public String getFechaUltimaModificacion() {
		return fechaUltimaModificacion;
	}

	public void setFechaUltimaModificacion(String fechaUltimaModificacion) {
		this.fechaUltimaModificacion = fechaUltimaModificacion;
	}

	public String getNationalId() {
		return nationalId;
	}

	public void setNationalId(String nationalId) {
		this.nationalId = nationalId;
	}

	public String getNationalIdType() {
		return nationalIdType;
	}

	public void setNationalIdType(String nationalIdType) {
		this.nationalIdType = nationalIdType;
	}

	public int getReintento() {
		return reintento;
	}

	public void setReintento(int reintento) {
		this.reintento = reintento;
	}

}
