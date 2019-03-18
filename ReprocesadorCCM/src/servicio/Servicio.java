
package servicio;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import conexion.ParametrosRequest;
import conexion.RegistraLog;
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
	@Consumes("application/json")
	@Produces("application/json")
	public String resourceMethodGET() {
		return "health";
	}
	
	/**
	 * Retrieves representation of an instance of Servicio
	 * 
	 * @return an instance of String
	 */
	@POST
	@Path("sincronizar")
	@Consumes("application/json")
	@Produces("application/json")
	public String resourceMethodGET(ParametrosRequest parametrosRequest) {
		String respuesta = "";
		reprocesador.reprocesarHistoricoMensaje(parametrosRequest.getRespuestaServicio(), parametrosRequest.getCanal());
		respuesta = "Proceso de sincronizacion iniciado correctamente";
		RegistraLog.getLog().log(respuesta);
		return respuesta;
	}
	

	/**
	 * Retrieves representation of an instance of Servicio
	 * 
	 * @return an instance of String
	 */
	@PUT
	@Path("customer")
	@Consumes("application/json")
	@Produces("application/json")
	public String customerUpdate(DatosPersona datosPersona) {
		String respuesta = "";
		GsonBuilder gson = new GsonBuilder().setPrettyPrinting();
		if (datosPersona != null) {
			respuesta = gson.create().toJson(datosPersona);
		}
		return "MySQL actualiza: " + respuesta;
	}

	/**
	 * Retrieves representation of an instance of Servicio
	 * 
	 * @return an instance of String
	 */
	@POST
	@Path("customer")
	@Consumes("application/json")
	@Produces("application/json")
	public String customerInsert(DatosPersona datosPersona) {
		String respuesta = "";
		GsonBuilder gson = new GsonBuilder().setPrettyPrinting();
		if (datosPersona != null) {
			respuesta = gson.create().toJson(datosPersona);
		}
		return "MySQL inserta: " + respuesta;
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