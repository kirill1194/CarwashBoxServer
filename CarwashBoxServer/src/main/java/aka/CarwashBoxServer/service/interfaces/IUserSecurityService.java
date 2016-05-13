package aka.CarwashBoxServer.service.interfaces;

import aka.CarwashBoxServer.rest.exceptions.RegistrationException;
import aka.CarwashBoxServer.rest.response.TokenResponse;

public interface IUserSecurityService
{
	public TokenResponse registrate(String phone, String pass) throws RegistrationException;
	public TokenResponse signin(String phone, String pass);
}
