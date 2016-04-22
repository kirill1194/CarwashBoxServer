package aka.CarwashBoxServer.rest.exceptions;

import javax.ws.rs.ClientErrorException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

public class AutorizationHeaderNotExistException extends ClientErrorException
{
	public AutorizationHeaderNotExistException(String message)
	{
		super(Response.status(Status.BAD_REQUEST).entity(message).build());
	}
}
