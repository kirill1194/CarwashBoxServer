package aka.CarwashBoxServer.rest.filters;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.PreMatching;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.Provider;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.glassfish.jersey.message.internal.ReaderWriter;

@Provider
@PreMatching
public class RequestLogger implements ContainerRequestFilter
{
	private static final String PREFIX = "\t- ";
	private static final String DOUBLE_TAB = "\t\t";
	private static final Logger log = LogManager.getLogger(RequestLogger.class);

	@Override
	public void filter(ContainerRequestContext arg) throws IOException
	{
		try
		{
			StringBuilder builder = new StringBuilder("");
			builder.append("new request: \n");
			builder.append(PREFIX + arg.getUriInfo().getAbsolutePath().toString() + " " + arg.getMethod() + '\n');
			if (arg.getMediaType() != null)
				builder.append(PREFIX + "Media-Type: " + arg.getMediaType().toString() + '\n');

			// query parameters
			MultivaluedMap<String, String> queryPar = arg.getUriInfo().getQueryParameters();
			if (queryPar.size() != 0)
				builder.append(PREFIX + "query parameters: \n");
			else if (arg.getMethod().equals("GET"))
				builder.append(PREFIX + "not exist query parameters" + '\n');
			for (String key : queryPar.keySet())
			{
				builder.append('\t' + PREFIX + key + " = " + queryPar.get(key) + '\n');
			}

			String authorizationHeader =
					arg.getHeaderString(HttpHeaders.AUTHORIZATION);
			if (authorizationHeader != null)
				builder.append(PREFIX + HttpHeaders.AUTHORIZATION + ": " + authorizationHeader);

			// entity JSON
			if (arg.getMediaType() != null && arg.getMediaType().toString().startsWith((MediaType.APPLICATION_JSON)))
			{
				builder.append(PREFIX + "entity: \n");

				ByteArrayOutputStream out = new ByteArrayOutputStream();
				InputStream in = arg.getEntityStream();
				final StringBuilder b = new StringBuilder();
				try
				{
					if (in.available() > 0)
					{
						ReaderWriter.writeTo(in, out);

						byte[] requestEntity = out.toByteArray();
						if (requestEntity.length != 0)
							b.append(new String(requestEntity));

						arg.setEntityStream(new ByteArrayInputStream(requestEntity));
					}
				} catch (IOException e)
				{
					log.error(e);
				}

				builder.append(b.toString() + '\n');

			}
			if (builder.charAt(builder.length() - 1) == '\n')
				builder.deleteCharAt(builder.length() - 1);

			log.info(builder.toString());
		} catch (Throwable ex)
		{
			log.error("Exception in RequestLogger", ex);
		}
		// return request;
	}

}