package ar.edu.ubp.das.ws;

import javax.ws.rs.core.Response;

public class PingWS {

	public Response getPing() {	
		return Response.status(Response.Status.OK).entity("pong").build();
	}
}
