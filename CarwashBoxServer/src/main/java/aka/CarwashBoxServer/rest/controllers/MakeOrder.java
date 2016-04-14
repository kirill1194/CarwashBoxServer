package aka.CarwashBoxServer.rest.controllers;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import aka.CarwashBoxServer.rest.request.Order;
import aka.CarwashBoxServer.service.OrderService;

@Component
@Path("makeOrder")
public class MakeOrder extends BaseController
{
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response makeOrder(@RequestBody Order order)
	{
		OrderService service = new OrderService();
		service.makeOrder(order);
		return Response.status(200).build();
	}
}
