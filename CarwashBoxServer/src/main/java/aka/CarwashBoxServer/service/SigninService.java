package aka.CarwashBoxServer.service;

import aka.CarwashBoxServer.rest.response.Token;

public class SigninService
{
	public Token signin(String pass, String phone)
	{
		return new Token("token_"+pass+"_"+phone);
	}
}
