package aka.CarwashBoxServer.rest.exceptions.mapping;

import javax.annotation.Resource;
import javax.ws.rs.NotAuthorizedException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;

@Resource
public class AutorizationHeaderNotExistExceptionMapping implements ExceptionMapper<NotAuthorizedException>
{

	@Override
	public Response toResponse(NotAuthorizedException e)
	{
		return Response.status(Status.BAD_REQUEST).encoding(e.getMessage()).build();
	}

}
