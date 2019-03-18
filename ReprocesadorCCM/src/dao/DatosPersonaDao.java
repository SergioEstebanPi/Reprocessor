package dao;

import conexion.Interfaz;
import persistencia.DatosPersona;

public class DatosPersonaDao {
	private Interfaz interfaz;
	
	public DatosPersonaDao() {
		interfaz = new Interfaz();
	}

	public void insertarDatosPersona(DatosPersona datosPersona) {
		interfaz.post(datosPersona);
	}

	public int actualizarDatosPersona(DatosPersonaDao datosPersona) {
		interfaz.put(datosPersona);
		return 0;
	}
}
