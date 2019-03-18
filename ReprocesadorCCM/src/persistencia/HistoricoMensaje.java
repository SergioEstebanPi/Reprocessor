package persistencia;

public class HistoricoMensaje {
	private String historicoMensajeId;
	private String mensajePk;
	private String estadoMensaje;
	private String respuestaServicio;
	private String usuarioCreacion;
	private String fechaCreacion;

	public HistoricoMensaje() {
	}

	public String getHistoricoMensajeId() {
		return historicoMensajeId;
	}

	public void setHistoricoMensajeId(String historicoMensajeId) {
		this.historicoMensajeId = historicoMensajeId;
	}

	public String getMensajePk() {
		return mensajePk;
	}

	public void setMensajePk(String mensajePk) {
		this.mensajePk = mensajePk;
	}

	public String getEstadoMensaje() {
		return estadoMensaje;
	}

	public void setEstadoMensaje(String estadoMensaje) {
		this.estadoMensaje = estadoMensaje;
	}

	public String getRespuestaServicio() {
		return respuestaServicio;
	}

	public void setRespuestaServicio(String respuestaServicio) {
		this.respuestaServicio = respuestaServicio;
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

}
