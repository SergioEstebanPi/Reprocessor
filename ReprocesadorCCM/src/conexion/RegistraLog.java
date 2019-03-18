package conexion;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class RegistraLog {
	private static RegistraLog registraLog;
	private String carpeta;
	private String nombre;

	public RegistraLog() {
		String fileSeparator = System.getProperty("file.separator");
		File homedir = new File(System.getProperty("user.home"));
		carpeta = homedir + fileSeparator + "CCM" + fileSeparator;
		nombre = "log" + "_" + fecha() + ".txt";
	}
	
	public static RegistraLog getLog() {
		if(registraLog == null) {
			registraLog = new RegistraLog();
		}
		return registraLog;
	}

	public RegistraLog(String carpeta, String nombre) {
		this.carpeta = carpeta;
		this.nombre = nombre;
	}

	public String fecha() {
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
		String dateString = format.format(new Date());
		return dateString;
	}

	public void log(String linea) {
		try {
			File file = new File(carpeta, nombre);
			file.createNewFile();
			BufferedWriter out = new BufferedWriter(new FileWriter(file, true));
			out.newLine();
			out.write(linea);
			out.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
