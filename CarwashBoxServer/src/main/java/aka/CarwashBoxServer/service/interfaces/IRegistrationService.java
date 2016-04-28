package aka.CarwashBoxServer.service.interfaces;

import aka.CarwashBoxServer.rest.exceptions.RegistrationException;
import aka.CarwashBoxServer.rest.response.Token;

public interface IRegistrationService
{
	public Token registrate(String phone, String pass) throws RegistrationException;
}
