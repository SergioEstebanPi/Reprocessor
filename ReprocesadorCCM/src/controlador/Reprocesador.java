package controlador;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import conexion.RegistraLog;
import dao.DatosPersonaDao;
import dao.HistoricoMensajeDao;
import persistencia.Contacto;
import persistencia.DatosPersona;
import persistencia.HistoricoMensaje;
import persistencia.Mensaje;

public class Reprocesador {

	private List<Mensaje> historicosFallidos;
	private HistoricoMensajeDao historicoMensajeDao;
	private DatosPersonaDao datosPersonaDao;

	private static final String C_CRM = "CRM";
	private static final String C_DBPORVE = "DBPORVE";
	private static final String C_I = "I";
	private static final String C_U = "U";
	private static final String C_FALLIDO = "{error}";
	
	private RegistraLog registraLog;
	
	public Reprocesador() {
		historicosFallidos = new ArrayList<Mensaje>();
		historicoMensajeDao = new HistoricoMensajeDao(C_DBPORVE);
		datosPersonaDao = new DatosPersonaDao();
		registraLog = new RegistraLog();
	}

	public void reprocesarHistoricoMensaje() {
		registraLog.log("Inicio lectura de mensajes fallidos");
		//historicosFallidos = historicoMensajeDao.getFallidos(C_FALLIDO, C_CRM);

		for (int i = 0; i < 1; i++) {
			Mensaje mensaje = new Mensaje();
			mensaje.setMensajeId("" + i);
			mensaje.setEstadoMensaje("RECIBIDO");
			mensaje.setFechaCreacion("");
			mensaje.setUsuarioCreacion("POR09020");
			mensaje.setEvento("I");
			mensaje.setNroIdentidad("1234567" + i);
			mensaje.setCanal("CRM");
			historicosFallidos.add(mensaje);
		}
		
		for (int i = 0; i < 0; i++) {
			Mensaje mensaje = new Mensaje();
			mensaje.setMensajeId("" + i);
			mensaje.setEstadoMensaje("RECIBIDO");
			mensaje.setFechaCreacion("");
			mensaje.setUsuarioCreacion("POR09020");
			mensaje.setEvento("U");
			mensaje.setNroIdentidad("1234567" + i);
			mensaje.setCanal("CRM");
			historicosFallidos.add(mensaje);
		}

		/* elimina los nroidentificacion repetidos */
		HashSet<Mensaje> actualizables = new HashSet<Mensaje>();
		for (Mensaje mensaje : historicosFallidos) {
			actualizables.add(mensaje);
		}
		/* */

		/* preparcion de envio de mensajes actualizables */
		DatosPersona datosPersona = new DatosPersona();
		for (Mensaje mensaje : actualizables) {
			registraLog.log("[ENCOLA] -> " + mensaje.getNroIdentidad() + ";" + mensaje.getEvento());
			/* se obtiene la informacion de las base de datos */
			datosPersona = getDatosCliente(mensaje);
			if (datosPersona.getId() != null) {
				if (C_I.equals(mensaje.getEvento())) {
					/* se envia a la nube MySQL */
					datosPersonaDao.insertarDatosPersona(datosPersona);
				} else if (C_U.equals(mensaje.getEvento())) {
					/* se envia a la nube MySQL */
					datosPersonaDao.actualizarDatosPersona(datosPersonaDao);
				}
				
				/* actualizar historico si todo OK */
				if (true) {
					HistoricoMensaje historicoMensaje = new HistoricoMensaje();
					historicoMensajeDao.actualizarHistorico(historicoMensaje);
				}
			}
		}
		/* registra en el historico */

		System.out.println("Fin reprocesar mensajes");
	}

	public DatosPersona getDatosCliente(Mensaje mensaje) {
		DatosPersona datosPersona = new DatosPersona();
		if (C_CRM.equals(mensaje.getCanal())) {
			datosPersona = getInfoCRM(mensaje.getNroIdentidad());
			datosPersona.setOrigenDatos(C_CRM);
		} else if (C_DBPORVE.equals(mensaje.getCanal())) {
			datosPersona = getInfoDBPorve(mensaje.getNroIdentidad());
			datosPersona.setOrigenDatos(C_DBPORVE);
		}
		return datosPersona;
	}

	private DatosPersona getInfoCRM(String nroIdentificacion) {
		DatosPersona datosPersona = new DatosPersona();
		datosPersona.setId("1");
		datosPersona.setAceptaEmail("S");
		datosPersona.setAceptaSMS("N");
		datosPersona.setCicloDeVida(null);
		datosPersona.setMarcaSYQ("S");
		datosPersona.setTipoId("CC");
		datosPersona.setGenero("M");
		List<Contacto> contactos = new ArrayList<Contacto>();
		for (int i = 0; i < 2; i++) {
			Contacto contacto = new Contacto();
			contacto.setTipoContacto("ABC");
			contacto.setBarrio("1234");
			contacto.setPais("COLOMBIA");
			contacto.setProposito("32");
			contacto.setValorContacto("valor");
			contactos.add(contacto);
		}
		datosPersona.setContactos(contactos);
		return datosPersona;
	}

	private DatosPersona getInfoDBPorve(String nroIdentificacion) {
		DatosPersona datosPersona = new DatosPersona();
		List<Contacto> contactos = new ArrayList<Contacto>();
		for (int i = 0; i < 2; i++) {
			Contacto contacto = new Contacto();
			contacto.setTipoContacto("ABC");
			contacto.setBarrio("1234");
			contacto.setPais("COLOMBIA");
			contacto.setProposito("32");
			contacto.setValorContacto("valor");
			contactos.add(contacto);
		}
		datosPersona.setContactos(contactos);
		return datosPersona;
	}

}
