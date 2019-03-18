 
package servicio;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import controlador.Reprocesador;

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
     * PUT method for updating or creating an instance of Servicio
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