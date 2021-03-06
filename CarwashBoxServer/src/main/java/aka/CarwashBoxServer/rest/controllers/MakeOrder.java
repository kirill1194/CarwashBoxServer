package aka.CarwashBoxServer.rest.controllers;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;

import aka.CarwashBoxServer.rest.request.Order;
import aka.CarwashBoxServer.rest.security.Secured;
import aka.CarwashBoxServer.service.OrderService;

@Component
@Path("makeOrder")
public class MakeOrder extends BaseController
{
	public @Context SecurityContext securityContext;

	@Secured
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MEDIA_TYPE_JSON)
	public Response makeOrder(
			@Validated @RequestBody Order order)
	{
		OrderService service = new OrderService();
		service.makeOrder(order);
		return Response.status(200).build();
	}
}
