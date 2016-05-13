package aka.CarwashBoxServer.rest.exceptions.mapping;

import javax.annotation.Resource;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;

import aka.CarwashBoxServer.rest.exceptions.ClientError;
import aka.CarwashBoxServer.rest.exceptions.Errors;
import aka.CarwashBoxServer.rest.response.BaseResponse;

@Resource
public class ClientErrorMapping implements ExceptionMapper<ClientError>
{

	@Override
	public Response toResponse(ClientError e)
	{
		BaseResponse br = new BaseResponse();
		br.setStatusCode(e.getCode());
		br.setStatusMessage(Errors.getMessage(e.getCode()));
		return Response.status(Status.BAD_REQUEST).entity(br).build();
	}

}
