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
		conectorDB = new ConectorDB(baseDatos);
	}
	
	public List<Mensaje> getFallidos(String respuestaServicio, String canal) {
		List<Mensaje> mensajes = new ArrayList<Mensaje>();
		Connection connection = conectorDB.getConnection();
		String sql = "SELECT M.MENSAJE_ID, "
				+ "M.ESTADO_MENSAJE, "
				+ "M.NRO_IDENTIFICACION, "
				+ "M.ESTADO_MENSAJE, "
				+ "M.EVENTO, "
				+ "M.CANAL, "
				+ "M.USUARIO_CREACION, "
				+ "M.FECHA_CREACION, "
				+ "M.USUARIO_ULTIMA_MODIFICACION, "
				+ "M.FECHA_ULTIMA_MODIFICACION, "
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
				mensaje.setMensajeId(resultSet.getString("MENSAJE_ID"));
				mensaje.setEstadoMensaje(resultSet.getString("ESTADO_MENSAJE"));
				mensaje.setNroIdentidad(resultSet.getString("NRO_IDENTIFICACION"));
				mensaje.setEvento(resultSet.getString("EVENTO"));
				mensaje.setCanal(resultSet.getString("CANAL"));
				mensaje.setUsuarioCreacion(resultSet.getString("USUARIO_CREACION"));
				mensaje.setFechaCreacion(resultSet.getString("FECHA_CREACION"));
				mensaje.setUsuarioCreacion(resultSet.getString("USUARIO_ULTIMA_MODIFICACION"));
				mensaje.setFechaCreacion(resultSet.getString("FECHA_ULTIMA_MODIFICACION"));
				mensajes.add(mensaje);
			}
			resultSet.close();
			preparedStatement.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return mensajes;
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
			preparedStatement.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return actualizados;
	}
	
	public void getHistoricosPorId() {
		
	}

}
