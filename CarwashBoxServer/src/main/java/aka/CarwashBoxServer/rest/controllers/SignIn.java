package aka.CarwashBoxServer.rest.controllers;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import aka.CarwashBoxServer.rest.response.TokenResponse;
import aka.CarwashBoxServer.rest.validation.NotNullEmptyPar;
import aka.CarwashBoxServer.service.interfaces.IUserSecurityService;

@Component
@Path("signin")
public class SignIn extends BaseController
{
	@Autowired
	private IUserSecurityService userSecurityService;

	@GET
	@Produces(MEDIA_TYPE_JSON)
	public TokenResponse autorization(
			@NotNullEmptyPar(label = PASS) @QueryParam(PASS) String pass,
			@NotNullEmptyPar(label = PHONE) @QueryParam(PHONE) String phone)
	{
		throw new RuntimeException("RE!!!!!!!!!");
		//		return userSecurityService.signin(phone, pass);
	}
}
