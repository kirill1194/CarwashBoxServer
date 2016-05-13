package aka.CarwashBoxServer.rest.controllers;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import aka.CarwashBoxServer.rest.response.CarTypeResponse;
import aka.CarwashBoxServer.rest.response.CarTypesResponse;
import aka.CarwashBoxServer.service.interfaces.ICarTypeService;

@Component
@Path("carTypes")
public class CarTypes extends BaseController
{

	@Autowired
	public ICarTypeService carTypeService;

	@GET
	@Produces(MEDIA_TYPE_JSON)
	public CarTypesResponse getCarTypes()
	{
		return carTypeService.getCarTypes();
	}


	@GET
	@Path("{carType}")
	@Produces(MEDIA_TYPE_JSON)
	public CarTypeResponse getCarTypeById(@PathParam("carType") Integer carTypeId)
	{
		return carTypeService.getCarTypeById(carTypeId);
	}
}
