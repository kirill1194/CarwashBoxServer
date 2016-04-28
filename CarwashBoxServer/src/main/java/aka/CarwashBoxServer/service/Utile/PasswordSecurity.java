package aka.CarwashBoxServer.service.Utile;

public class PasswordSecurity
{
	public static String encryptPass(String pass)
	{
		return pass;
	}

	public static String buildAccessToken(String phone, String pass)
	{
		return "token_"+phone+"_"+pass;
	}
}
