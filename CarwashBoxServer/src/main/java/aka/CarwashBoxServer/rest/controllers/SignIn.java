package aka.CarwashBoxServer.rest.controllers;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import org.springframework.stereotype.Component;

import aka.CarwashBoxServer.rest.response.Token;
import aka.CarwashBoxServer.service.SigninService;

@Component
@Path("signin")
public class SignIn extends BaseController
{
	@GET
	@Produces(MEDIA_TYPE_JSON)
	public Token autorization(
			@QueryParam("pass") String pass,
			@QueryParam("phone") String phone
			)
	{

		checkQueryParam(pass, "pass");
		checkQueryParam(phone, "phone");
		return (new SigninService()).signin(pass, phone);
	}
}
