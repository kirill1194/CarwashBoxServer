package aka.CarwashBoxServer.rest.security;

public class TokenValidator
{
	public User validate(String token) throws AutorizationException
	{
		if (token == "111")
			throw new AutorizationException("un autorication");
		return new User();
	}
}
