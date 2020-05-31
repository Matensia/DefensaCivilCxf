package ar.edu.ubp.das.ws;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.ws.rs.core.Response;

import ar.edu.ubp.das.bean.AsistenciaBean;
import ar.edu.ubp.das.bean.ChatBean;
import ar.edu.ubp.das.bean.DetalleAsistenciaBean;

@WebService(targetNamespace = "http://ws.das.ubp.edu.ar/", portName = "AsistenciaWSPort", serviceName = "AsistenciaWSService")
public class AsistenciaWS {
	
	@WebMethod(operationName = "insertarAsistencia", action = "urn:InsertarAsistencia")
	public Response insertarAsistencia (@WebParam(name = "arg0") AsistenciaBean asistencia) {
		
		Connection conn;
		CallableStatement stmt;
		
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn=DriverManager.getConnection("jdbc:sqlserver://127.0.0.1;databaseName=defensa_civil","sa","AaBbCc123");
			conn.setAutoCommit(false);
			
			try {
				stmt = conn.prepareCall("{CALL dbo.CREAR_ASISTENCIA(?,?,?)}");
				stmt.setString(1, asistencia.getIdServicio());
				stmt.setString(2, asistencia.getEstado());
				stmt.setInt(3, asistencia.getIdSolicitud());
				
				stmt.execute();
				
				stmt.close();
				conn.commit();
				
				return Response.ok().build();
			} catch (SQLException e) {
				conn.rollback();
				throw e;
			}finally {
				conn.setAutoCommit(true);
				conn.close();
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			return Response.status(Response.Status.BAD_REQUEST).entity(e).build();
		}
	}
	
	@WebMethod(operationName = "midificarEstadoAsistencia", action = "urn:MidificarEstadoAsistencia")
	public Response midificarEstadoAsistencia(@WebParam(name = "arg0") AsistenciaBean asistencia) {
		
		Connection conn;
		CallableStatement stmt;
		
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn=DriverManager.getConnection("jdbc:sqlserver://127.0.0.1;databaseName=defensa_civil","sa","AaBbCc123");
			conn.setAutoCommit(false);
			
			try {
				stmt = conn.prepareCall("{CALL dbo.CAMBIAR_ESTADO_ASISTENCIA(?,?)}");
				stmt.setInt(1, asistencia.getId());
				stmt.setString(2, asistencia.getEstado());
				
				stmt.execute();
				
				stmt.close();
				conn.commit();
				
				return Response.ok().build();
			} catch (SQLException e) {
				conn.rollback();
				throw e;
			}finally {
				conn.setAutoCommit(true);
				conn.close();
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			return Response.status(Response.Status.BAD_REQUEST).entity(e).build();
		}
	}
	
	@WebMethod(operationName = "insertarDetalleAsistencia", action = "urn:InsertarDetalleAsistencia")
	public Response insertarDetalleAsistencia(@WebParam(name = "arg0") DetalleAsistenciaBean detalleAsistencia) {
		
		Connection conn;
		CallableStatement stmt;
		
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn=DriverManager.getConnection("jdbc:sqlserver://127.0.0.1;databaseName=defensa_civil","sa","AaBbCc123");
			conn.setAutoCommit(false);
			
			try {
				stmt = conn.prepareCall("{CALL dbo.INSERTAR_DETALLE_ASISTENCIA(?,?,?)}");
				stmt.setInt(1, detalleAsistencia.getIdAsistencia());
				stmt.setString(2, detalleAsistencia.getTipoDato());
				stmt.setString(3, detalleAsistencia.getDato());
				
				stmt.execute();
				
				stmt.close();
				conn.commit();
				
				return Response.ok().build();
			} catch (SQLException e) {
				conn.rollback();
				throw e;
			}finally {
				conn.setAutoCommit(true);
				conn.close();
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			return Response.status(Response.Status.BAD_REQUEST).entity(e).build();
		}
	}
	
	@WebMethod(operationName = "insertarChatAsistencia", action = "urn:InsertarChatAsistencia")
	public Response insertarChatAsistencia(@WebParam(name = "arg0") ChatBean chat) {
		
		Connection conn;
		CallableStatement stmt;
		
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn=DriverManager.getConnection("jdbc:sqlserver://127.0.0.1;databaseName=defensa_civil","sa","AaBbCc123");
			conn.setAutoCommit(false);
			
			try {
				stmt = conn.prepareCall("{CALL dbo.INSERTAR_CHAT(?,?,?)}");
				stmt.setInt(1, chat.getIdAsistencia());
				stmt.setString(2, chat.getEstado());
				stmt.setString(3, chat.getMensaje());
				
				stmt.execute();
				
				stmt.close();
				conn.commit();
				
				return Response.ok().build();
			} catch (SQLException e) {
				conn.rollback();
				throw e;
			}finally {
				conn.setAutoCommit(true);
				conn.close();
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			return Response.status(Response.Status.BAD_REQUEST).entity(e).build();
		}
	}

}
