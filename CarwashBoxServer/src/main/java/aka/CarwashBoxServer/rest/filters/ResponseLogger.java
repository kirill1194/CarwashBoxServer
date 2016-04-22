package aka.CarwashBoxServer.rest.filters;

import java.io.IOException;
import java.util.Collection;
import java.util.List;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.ext.Provider;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.glassfish.jersey.server.validation.ValidationError;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@Provider
public class ResponseLogger implements ContainerResponseFilter
{

	private static final String PREFIX = "\t- ";
	private static final Logger log = LogManager.getLogger(ResponseLogger.class);
	private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();

	// @Override
	// public ContainerResponse filter(ContainerRequest request,
	// ContainerResponse response) {
	// try {
	// StringBuilder builder = new StringBuilder("response: " + '\n');
	// builder.append(PREFIX + request.getAbsolutePath().toString() + " " +
	// request.getMethod() + '\n');
	// //status
	// builder.append(PREFIX + "HTTP status: " + response.getStatus() + '\n');
	// //Content-Type
	// builder.append(PREFIX + "Content=type: " + response.getMediaType() +
	// '\n');
	// //entity
	// Object objEntity = response.getEntity();
	// if (objEntity instanceof Collection<?>) {
	// Collection<?> col = (Collection<?>) objEntity;
	// builder.append(PREFIX + "response: " +
	// response.getEntityType().toString() + "; size: " + col.size());
	// } else {
	// String entity = gson.toJson(response.getEntity());
	// builder.append(PREFIX + "response: " + entity);
	// }
	//
	// if (builder.charAt(builder.length()-1) == '\n')
	// builder.deleteCharAt(builder.length()-1);
	//
	// log.info(builder.toString());
	// } catch (Throwable ex) {
	// log.error("Exception in ResponseLog", ex);
	// }
	// return response;
	// }

	@Override
	public void filter(ContainerRequestContext request, ContainerResponseContext response) throws IOException
	{
		try
		{
			StringBuilder builder = new StringBuilder("response: " + '\n');
			builder.append(
					PREFIX + request.getUriInfo().getAbsolutePath().toString() + " " + request.getMethod() + '\n');
			// status
			builder.append(PREFIX + "HTTP status: " + response.getStatus() + '\n');
			// Content-Type
			builder.append(PREFIX + "Content=type: " + response.getMediaType() + '\n');
			// entity
			Object objEntity = response.getEntity();
			if (objEntity instanceof Collection<?>)
			{
				if (objEntity instanceof List<?>)
				{
					List<?> list = (List<?>) objEntity;
					StringBuilder validErrors = new StringBuilder();
					int i=0;
					for (Object o : list)
					{
						if (o instanceof ValidationError)
						{
							ValidationError validError = (ValidationError) o;
							validErrors.append("\t\t" + (i+1) + ") " + validError.getMessage() + '\n');
							i++;
						} else
						{
							break;
						}
						if (i == 5)
							validErrors.append("\t\t" + "and more " + (list.size()-i) +"...\n");

					}
					if (validErrors.length() != 0)
					{
						builder.append(PREFIX + "Validation errors: " + list.size() + '\n' + validErrors.toString());
					} else
					{
						Collection<?> col = (Collection<?>) objEntity;
						builder.append(
								PREFIX + "entity: " + response.getEntityType().toString() + "; size: " + col.size());

					}
				} else
				{
					Collection<?> col = (Collection<?>) objEntity;
					builder.append(PREFIX + "entity: " + response.getEntityType().toString() + "; size: " + col.size());
				}
			} else
			{
				String entity = gson.toJson(response.getEntity());
				builder.append(PREFIX + "entity: " + entity);
			}

			if (builder.charAt(builder.length() - 1) == '\n')
				builder.deleteCharAt(builder.length() - 1);

			log.info(builder.toString());
		} catch (Throwable ex)
		{
			log.error("Exception in ResponseLog", ex);
		}

	}

}
