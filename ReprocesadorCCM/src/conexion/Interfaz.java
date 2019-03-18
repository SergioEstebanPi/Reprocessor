package conexion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;

import com.google.gson.Gson;

import weblogic.net.http.HttpURLConnection;


public class Interfaz {

	private Gson gson;
	private String endpoint;
	private RegistraLog registraLog;

	public Interfaz() {
		//gson = new GsonBuilder().setPrettyPrinting().create();
		gson = new Gson();
		endpoint = "http://localhost:7001/ReprocesadorCCM/resources/Servicio/customer";
		registraLog = RegistraLog.getLog();
	}

	public Object post(Object object) {
		String json = gson.toJson(object);
		String output = "";
		Object resultado;
		try {
			URL url = new URL(endpoint);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Type", "application/json");
			OutputStream os = conn.getOutputStream();
			os.write(json.getBytes());
			os.flush();
			registraLog.log("request: " + json);
			if (conn.getResponseCode() != HttpURLConnection.HTTP_CREATED) {
				//throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
				//System.out.println("Failed : HTTP error code : " + conn.getResponseCode());
				registraLog.log("No se ha podido crear el usuario");
			}
			registraLog.log("response code: " + conn.getResponseCode());
			
			BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
			while ((output = br.readLine()) != null) {
				registraLog.log("response body: " + output);
			}
			conn.disconnect();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		resultado = gson.fromJson(output, object.getClass());
		return resultado;
	}

	public Object get(Object object) {
		String output = "";
		Object resultado;
		try {
			URL url = new URL(endpoint);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");

			if (conn.getResponseCode() != 200) {
				registraLog.log("No se ha podido obtener la informacion");
				//throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
			}
			BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
			while ((output = br.readLine()) != null) {
				System.out.println(output);
			}
			conn.disconnect();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		resultado = gson.fromJson(output, object.getClass());
		return resultado;
	}

	public Object put(Object object) {
		String json = gson.toJson(object);
		String output = "";
		Object resultado;
		try {
			URL url = new URL(endpoint);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod("PUT");
			conn.setRequestProperty("Content-Type", "application/json");
			OutputStream os = conn.getOutputStream();
			os.write(json.getBytes());
			os.flush();
			registraLog.log("request: " + json);
			if (conn.getResponseCode() != HttpURLConnection.HTTP_CREATED) {
				//throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
				registraLog.log("No se ha podido obtener la informacion");
			}
			registraLog.log("response code: " + conn.getResponseCode());
			BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
			while ((output = br.readLine()) != null) {
				registraLog.log("response body: " + output);
			}
			conn.disconnect();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		resultado = gson.fromJson(output, object.getClass());
		return resultado;
	}

	public String getEndpoint() {
		return endpoint;
	}

	public void setEndpoint(String endpoint) {
		this.endpoint = endpoint;
	}

}
