package aka.CarwashBoxServer.rest.controllers;

import java.net.HttpURLConnection;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import aka.CarwashBoxServer.rest.security.User;

public abstract class BaseController
{
	public final static String PASS = "pass";
	public final static String PHONE = "phone";
	public final static String TOKEN = "token";


	final public static  String MEDIA_TYPE_JSON = MediaType.APPLICATION_JSON + ";charset=utf-8";

	public @Context ContainerRequestContext context;

	public Integer getUserId()
	{
		if (context == null)
			return null;
		Object o =  context.getProperty("user");
		if (o == null)
			return null;
		User user = (User) o;
		return user.getId();
	}


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
