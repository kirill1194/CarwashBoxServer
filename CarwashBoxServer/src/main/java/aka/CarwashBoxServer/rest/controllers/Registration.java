package aka.CarwashBoxServer.rest.controllers;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import aka.CarwashBoxServer.rest.response.TokenResponse;
import aka.CarwashBoxServer.rest.validation.NotNullEmptyPar;
import aka.CarwashBoxServer.service.interfaces.IUserSecurityService;

@Component
@Path("registration")
public class Registration extends BaseController
{
	private static final Logger log = LogManager.getLogger(Registration.class);

	@Autowired
	public IUserSecurityService registrationService;

	@Produces(MEDIA_TYPE_JSON)
	@GET
	public TokenResponse registration(

			@NotNullEmptyPar(label = PHONE) @QueryParam(PHONE) String phone,
			@NotNullEmptyPar(label = PASS) @QueryParam(PASS) String pass) throws Exception
	{
		TokenResponse token = registrationService.registrate(phone, pass);
		return token;
	}
}
