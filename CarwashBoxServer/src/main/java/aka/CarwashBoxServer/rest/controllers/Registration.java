package aka.CarwashBoxServer.rest.controllers;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import aka.CarwashBoxServer.rest.response.Token;
import aka.CarwashBoxServer.rest.validation.NotNullEmptyPar;
import aka.CarwashBoxServer.service.RegistrationService;

@Component
@Path("registration")
public class Registration extends BaseController
{
	private static final Logger log = LogManager.getLogger(Registration.class);

	@Produces(MEDIA_TYPE_JSON)
	@GET
	public Response registration(

			@NotNullEmptyPar(label = PHONE) @QueryParam(PHONE) String phone,
			@NotNullEmptyPar(label = PASS) @QueryParam(PASS) String pass)
					throws Exception
	{
		RegistrationService registrationService = new RegistrationService();
		Token token = registrationService.registrate(phone, pass);
		return Response.status(200).entity(token).build();
	}
}
