package aka.CarwashBoxServer.service;

import aka.CarwashBoxServer.rest.exceptions.RegistrationException;
import aka.CarwashBoxServer.rest.response.Token;

public class RegistrationService
{
	public Token registrate(String phone, String pass) throws RegistrationException
	{
		if (phone.equals("01"))
			throw new RegistrationException();
		return new Token("token_"+phone+"_"+pass);
	}
}
