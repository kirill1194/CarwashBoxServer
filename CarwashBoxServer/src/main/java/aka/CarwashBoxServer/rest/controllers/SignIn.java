package aka.CarwashBoxServer.rest.controllers;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import org.springframework.stereotype.Component;

import aka.CarwashBoxServer.rest.response.Token;
import aka.CarwashBoxServer.rest.validation.NotNullEmptyPar;
import aka.CarwashBoxServer.service.SigninService;

@Component
@Path("signin")
public class SignIn extends BaseController
{
	@GET
	@Produces(MEDIA_TYPE_JSON)
	public Token autorization(
			@NotNullEmptyPar(label = PASS) @QueryParam(PASS) String pass,
			@NotNullEmptyPar(label = PHONE) @QueryParam(PHONE) String phone)
	{
		return (new SigninService()).signin(pass, phone);
	}
}
