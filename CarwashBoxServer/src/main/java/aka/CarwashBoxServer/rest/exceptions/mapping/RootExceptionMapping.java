package aka.CarwashBoxServer.rest.exceptions.mapping;

import javax.annotation.Resource;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.glassfish.jersey.spi.ExtendedExceptionMapper;

@Resource
public class RootExceptionMapping implements ExtendedExceptionMapper<Exception>
{

	private static final Logger log = LogManager.getLogger(RootExceptionMapping.class);

	@Override
	public boolean isMappable(Exception exception)
	{
		/*
		 * Primarily, we don't want to log client errors (i.e. 400's) as an
		 * error.
		 */

		/* TODO add information about the request (using @Context). */
		if (isServerError(exception))
		{
			log.error(exception.getMessage(), exception);
			//log.(level, "ThrowableLogger_ExceptionMapper logging error.", exception);
		}
		return false;
	}

	private boolean isServerError(Throwable thro)
	{
		//Exception валидации полей запроса
		if (thro instanceof javax.validation.ConstraintViolationException)
			return false;

		if (thro instanceof WebApplicationException)
		{
			WebApplicationException webApplicationException = (WebApplicationException) thro;
			if (webApplicationException.getResponse().getStatus() == 500)
				return true;
			else
				return false;
		} else
			return true;
	}

	@Override
	public Response toResponse(Exception exception)
	{
		// assert false;
		log.fatal("ThrowableLogger_ExceptionMapper.toResponse: This should not have been called.");
		throw new RuntimeException("This should not have been called");
	}

}
