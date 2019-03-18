
package servicio;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import controlador.Reprocesador;
import persistencia.DatosPersona;

@Path("Servicio")
public class Servicio {

	private Reprocesador reprocesador;

	/**
	 * Default constructor.
	 */
	public Servicio() {
		reprocesador = new Reprocesador();
	}

	/**
	 * Retrieves representation of an instance of Servicio
	 * 
	 * @return an instance of String
	 */
	@GET
	@Produces("text/plain")
	public String resourceMethodGET() {
		String respuesta = "";
		reprocesador.reprocesarHistoricoMensaje();
		System.out.println(respuesta);
		return "health";
	}

	/**
	 * Retrieves representation of an instance of Servicio
	 * 
	 * @return an instance of String
	 */
	@POST
	@Produces("text/plain")
	public String customer(DatosPersona datosPersona) {
		String respuesta = "";
		GsonBuilder gson = new GsonBuilder().setPrettyPrinting();
		if (datosPersona != null) {
			respuesta = gson.create().toJson(datosPersona);
		}
		return "Servicio recibe: " + respuesta;
	}

	/**
	 * PUT method for updating or creating an instance of Servicio
	 * 
	 * @content content representation for the resource
	 * @return an HTTP response with content of the updated or created resource.
	 */
	@PUT
	@Consumes("text/plain")
	public void resourceMethodPUT(String content) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}
}