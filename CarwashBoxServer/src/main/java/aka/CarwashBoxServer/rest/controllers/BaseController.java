package aka.CarwashBoxServer.rest.controllers;

import java.net.HttpURLConnection;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public abstract class BaseController
{
	final public static  String MEDIA_TYPE_JSON = MediaType.APPLICATION_JSON + ";charset=utf-8";
	public static void checkQueryParam(String queryParam, String name)
	{
		if (queryParam == null)
			throw new WebApplicationException(
					Response.status(HttpURLConnection.HTTP_BAD_REQUEST)
					.entity(String.format("do not contains parameter \"%s\"", name))
					.build()
					);
	}
}
