package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conexion.ConectorDB;
import persistencia.HistoricoMensaje;
import persistencia.Mensaje;

public class HistoricoMensajeDao {
	
	private ConectorDB conectorDB;
	private static final String C_REPROCESADO = "REPROCESADO";
	private static final String C_INSERTADO = "{\"mensaje\"}";
	
	public HistoricoMensajeDao() {
	}
	
	public HistoricoMensajeDao(String baseDatos) {
		conectorDB = new ConectorDB("DBPORVE");
	}
	
	public List<Mensaje> getFallidos(String respuestaServicio, String canal) {
		List<Mensaje> mensajes = new ArrayList<Mensaje>();
		Connection connection = conectorDB.getConnection();
		String sql = "SELECT H.HISTORICO_MENSAJE_ID, "
				+ "H.MENSAJE_PK, "
				+ "H.ESTADO_MENSAJE, "
				+ "H.RESPUESTA_SERVICIO, "
				+ "M.NRO_IDENTIFICACION, "
				+ "M.ESTADO_MENSAJE, "
				+ "M.EVENTO "
				+ "FROM CCM_MENSAJE M "
				+ "INNER JOIN CCM_HISTORICO_MENSAJE H "
				+ "ON M.MENSAJE_ID = H.MENSAJE_PK "
				+ "WHERE H.RESPUESTA_SERVICIO = '" + respuestaServicio + "' "
				+ "AND M.CANAL = '" + canal + "' "
				+ "AND M.ESTADO_MENSAJE <> '" + C_REPROCESADO + "' "
				+ "";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Mensaje mensaje = new Mensaje();
				mensaje.setNroIdentidad(resultSet.getString("NRO_IDENTIFICACION"));
				mensaje.setEvento(resultSet.getString("EVENTO"));
				mensajes.add(mensaje);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return mensajes;
	}
	
	public void insertarHistorico(HistoricoMensaje historicoMensaje) {
		String sql = "";
		
	}
	
	public int actualizarHistorico(HistoricoMensaje historicoMensaje) {
		int actualizados = 0;
	    Connection connection = conectorDB.getConnection();
		String sql = "UPDATE CCM_HISTORICO_MENSAJE H "
				+ "SET H.ESTADO_MENSAJE = '" + C_REPROCESADO + "' "
				+ "WHERE H.MENSAJE_PK IN "
				+ "( "
				+ "SELECT M.MENSAJE_ID "
				+ "FROM CCM_MENSAJE M "
				+ "WHERE M.NRO_IDENTIFICACION = '" + 1234 + "' "
				+ "AND M.CANAL = '" + "CCM" + "' "
				+ "AND H.RESPUESTA_SERVICIO <> '" + C_INSERTADO + "' "
				+ "AND M.ESTADO_MENSAJE <> '" + C_REPROCESADO + "' "
				+ ") "
				+ "";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			actualizados = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return actualizados;
	}

}
