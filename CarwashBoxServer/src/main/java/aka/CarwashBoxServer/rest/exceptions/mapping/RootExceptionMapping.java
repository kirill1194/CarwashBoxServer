package aka.CarwashBoxServer.rest.exceptions.mapping;



import javax.annotation.Resource;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


@Resource
public class RootExceptionMapping implements ExceptionMapper<Exception>
{

	private static final Logger log = LogManager.getLogger(RootExceptionMapping.class);
	@Override
	public Response toResponse(Exception exception)
	{
		log.error(exception);
		exception.printStackTrace();
		return Response.status(Status.INTERNAL_SERVER_ERROR).build();
	}

}
