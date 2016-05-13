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
import javax.ws.rs.core.SecurityContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import aka.CarwashBoxServer.rest.request.CarAdd;
import aka.CarwashBoxServer.rest.request.PrivateOfficeSet;
import aka.CarwashBoxServer.rest.response.BaseResponse;
import aka.CarwashBoxServer.rest.response.IdResponse;
import aka.CarwashBoxServer.rest.response.PrivateOfficeGetResponse;
import aka.CarwashBoxServer.rest.security.Secured;
import aka.CarwashBoxServer.service.interfaces.IPrivateOfficeService;


@Component
@Path("privateOffice")
public class PrivateOffice extends BaseController
{

	public @Context SecurityContext securityContext;

	@Autowired
	public IPrivateOfficeService privateOfficeService;

	@Secured
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MEDIA_TYPE_JSON)
	public BaseResponse setPrivateOffice(
			@Valid @NotNull(message="{request.empty}") @RequestBody PrivateOfficeSet office)
	{
		privateOfficeService.setPrivateOffice(office, getUserId());
		System.out.println("POST1");
		return new BaseResponse();
	}

	@Secured
	@GET
	@Produces(MEDIA_TYPE_JSON)
	public PrivateOfficeGetResponse getPrivateOffice()
	{
		System.out.println("GET!");
		return privateOfficeService.getPrivateOffice(getUserId());
	}

	@Secured
	@Path("car")
	@POST
	@Produces(MEDIA_TYPE_JSON)
	public IdResponse addCar(
			@Valid @NotNull(message = "{request.empty}") @RequestBody CarAdd car
			)
	{
		IdResponse id = new IdResponse();
		id.setId(privateOfficeService.addCar(car, getUserId()));
		return id;
	}

	@Secured
	@Path("car/{carId}")
	@DELETE
	@Produces(MEDIA_TYPE_JSON)
	public BaseResponse deleteCar(
			@PathParam("carId") Integer carId
			)
	{
		privateOfficeService.deleteCar(carId, getUserId());
		return new BaseResponse();
	}

	@Secured
	@Path("car/{carId}")
	@PUT
	@Produces(MEDIA_TYPE_JSON)
	public BaseResponse editCar(
			@PathParam("carId") Integer carId,
			@RequestBody CarAdd car
			)
	{
		privateOfficeService.editCar(car, getUserId(), carId);
		return new BaseResponse();
	}
}
