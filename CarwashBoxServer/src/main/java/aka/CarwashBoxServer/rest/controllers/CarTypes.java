package aka.CarwashBoxServer.rest.controllers;

import java.util.LinkedList;
import java.util.List;

import javax.ws.rs.ClientErrorException;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.springframework.stereotype.Component;

import aka.CarwashBoxServer.rest.response.components.CarType;

@Component
@Path("carTypes")
public class CarTypes
{
	@GET
	public List<CarType> getCarTypes()
	{
		List<CarType> list = new LinkedList<CarType>();

		CarType type = new CarType();
		type.setId(1);
		type.setType("Универсал");
		list.add(type);

		type = new CarType();
		type.setId(2);
		type.setType("Лада СЕДААААААН!");
		list.add(type);

		return list;
	}


	@GET
	@Path("{carType}")
	public CarType getCarTypeById(@PathParam("carType") Integer carTypeId)
	{

		CarType carType = new CarType();
		carType.setId(carTypeId);
		if (carTypeId == 1)
			carType.setType("Универсал");
		else if (carTypeId == 2)
			carType.setType("Седан");
		else
			carType.setType("тип У меня закончилась фонтазия");
		if (carTypeId > 10)
			throw new ClientErrorException(Response.status(Status.NOT_FOUND).entity(
					"Not found car type with index " + carTypeId.toString()
					).build());
		return carType;
	}
}
