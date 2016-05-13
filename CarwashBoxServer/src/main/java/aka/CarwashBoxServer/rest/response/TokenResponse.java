package aka.CarwashBoxServer.rest.response;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class TokenResponse extends BaseResponse
{
	private String token;

	public String getToken()
	{
		return token;
	}

	public void setToken(String token)
	{
		this.token = token;
	}

	public TokenResponse( String token )
	{
		this.token = token;
	}
}
