package aka.CarwashBoxServer.rest.controllers;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import aka.CarwashBoxServer.rest.request.CarAdd;
import aka.CarwashBoxServer.rest.request.PrivateOfficeSet;
import aka.CarwashBoxServer.rest.response.Id;
import aka.CarwashBoxServer.rest.response.PrivateOfficeGet;
import aka.CarwashBoxServer.rest.response.components.CarGet;
import aka.CarwashBoxServer.rest.security.Secured;


@Component
@Path("privateOffice")
public class PrivateOffice extends BaseController
{

	public @Context SecurityContext securityContext;

	@Secured
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response setPrivateOffice(
			@Valid @NotNull(message="{request.empty}") @RequestBody PrivateOfficeSet office)
	{
		return Response.status(200).build();
	}

	@Secured
	@GET
	@Produces(MEDIA_TYPE_JSON)
	public PrivateOfficeGet getPrivateOffice()
	{
		PrivateOfficeGet office = new PrivateOfficeGet();
		CarGet car = new CarGet();
		car.setId(1);
		car.setName("Volvo v50");
		car.setNumber("O861KU");
		car.setType(1);
		car.setTypeName("Универсал");
		office.addCar(car);

		car = new CarGet();
		car.setId(2);
		car.setName("Toyota Corolla");
		car.setNumber("T300TT");
		car.setType(2);
		car.setTypeName("Лада СЕДААААААН!");
		office.addCar(car);

		office.setName("Кирилл");
		office.setSecondName("Алтухов");
		office.setPhone("+79126696789");

		return office;
	}

	@Secured
	@Path("car")
	@POST
	public Id addCar(
			@Valid @NotNull(message = "{request.empty}") @RequestBody CarAdd car
			)
	{
		Id id = new Id();
		id.setId(1);
		return id;
	}

	@Secured
	@Path("car/{carId}")
	@DELETE
	public Response deleteCar(
			@PathParam("carId") Integer carId
			)
	{
		return Response.ok().build();
	}

	@Secured
	@Path("car/{carId}")
	@PUT
	public Response editCar(
			@PathParam("carId") String carId,
			@RequestBody CarAdd car
			)
	{
		return Response.ok().build();
	}
}
