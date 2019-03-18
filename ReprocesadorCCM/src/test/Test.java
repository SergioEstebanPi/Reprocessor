package test;

import controlador.Reprocesador;

public class Test {

	public static void main(String[] args) {
		Reprocesador reprocesador = new Reprocesador();
		reprocesador.reprocesarHistoricoMensaje("{error}", "CRM");
	}

}
