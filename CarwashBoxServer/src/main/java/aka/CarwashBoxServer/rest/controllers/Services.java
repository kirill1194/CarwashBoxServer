package aka.CarwashBoxServer.rest.controllers;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.springframework.stereotype.Component;

import aka.CarwashBoxServer.rest.response.components.ServiceEntity;
import aka.CarwashBoxServer.service.ServicesService;

@Component
@Path("services")
public class Services extends BaseController
{
	@Produces(MEDIA_TYPE_JSON)
	@GET
	public List<ServiceEntity> getServices()
	{
		ServicesService service = new ServicesService();
		return service.getServices();
	}
}
