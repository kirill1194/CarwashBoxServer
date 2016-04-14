package aka.CarwashBoxServer.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import org.springframework.stereotype.Component;

@Component
@Path("/")
public class Test
{
	@GET
	@Path("/test")
	public Response savePayment() {

		return Response.status(200).entity("all work___!").build();

	}
}
