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
				stmt = conn.prepareCall("{CALL dbo.CREAR_ASISTENCIA(?,?,?,?)}");
				stmt.setString(1, asistencia.getIdServicio());
				stmt.setString(2, asistencia.getEstado());
				stmt.setInt(3, asistencia.getIdSolicitud());
				stmt.setLong(4,asistencia.getCuil());
				
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
	
	@WebMethod(operationName = "cerrarAsistencia", action = "urn:CerrarAsistencia")
	public Response cerrarAsistencia(@WebParam(name = "arg0") AsistenciaBean asistencia) {
		
		Connection conn;
		CallableStatement stmt;
		
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn=DriverManager.getConnection("jdbc:sqlserver://127.0.0.1;databaseName=defensa_civil","sa","AaBbCc123");
			conn.setAutoCommit(false);
			
			try {
				stmt = conn.prepareCall("{CALL dbo.CERRAR_ASISTENCIA(?)}");
				stmt.setInt(1, asistencia.getId());
				
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
}
