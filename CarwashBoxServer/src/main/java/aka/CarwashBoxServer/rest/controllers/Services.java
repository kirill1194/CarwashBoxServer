package aka.CarwashBoxServer.rest.controllers;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import aka.CarwashBoxServer.rest.response.ServicesResponse;
import aka.CarwashBoxServer.service.interfaces.IServicesService;

@Component
@Path("services")
public class Services extends BaseController
{

	@Autowired
	public IServicesService servicesService;

	@Produces(MEDIA_TYPE_JSON)
	@GET
	public ServicesResponse getServices()
	{
		return servicesService.getServices();
	}
}
