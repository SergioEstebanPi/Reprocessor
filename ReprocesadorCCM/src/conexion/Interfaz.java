package conexion;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Interfaz {
	
	private Gson gson;
	
	public Interfaz() {
		gson = new GsonBuilder().setPrettyPrinting().create();
		//gson = new Gson();
	}

	public void post(Object object) {
		String json = gson.toJson(object);
		System.out.println(json);
	}

	public void get() {
		
	}

	public void put(Object object) {
		String json = gson.toJson(object);
		System.out.println(json);
	}
}
