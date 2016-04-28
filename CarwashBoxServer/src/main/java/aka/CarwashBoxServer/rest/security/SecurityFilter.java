package aka.CarwashBoxServer.rest.security;

import java.io.IOException;
import java.security.Principal;

import javax.annotation.Priority;
import javax.ws.rs.Priorities;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.ext.Provider;

import aka.CarwashBoxServer.rest.exceptions.AutorizationHeaderNotExistException;

@Secured
@Provider
@Priority(Priorities.AUTHENTICATION)
public class SecurityFilter implements ContainerRequestFilter
{

	@Override
	public void filter(ContainerRequestContext requestContext) throws IOException
	{
		String authorizationHeader =
				requestContext.getHeaderString(HttpHeaders.AUTHORIZATION);

		// Check if the HTTP Authorization header is present and formatted correctly
		if (authorizationHeader == null) {
			throw new AutorizationHeaderNotExistException("Request must have authorization header: \"Authorization: you_token\"");
		}

		// Extract the token from the HTTP Authorization header
		String token = authorizationHeader;
		TokenValidator validator = new TokenValidator();
		final User user;
		try {

			// Validate the token
			user = validator.validate(token);
			requestContext.setProperty("user", user);
			requestContext.setSecurityContext(new SecurityContext()
			{

				@Override
				public boolean isUserInRole(String role)
				{
					// TODO Auto-generated method stub
					return false;
				}

				@Override
				public boolean isSecure()
				{
					// TODO Auto-generated method stub
					return false;
				}

				@Override
				public Principal getUserPrincipal()
				{
					return new Principal()
					{
						@Override
						public String getName()
						{
							return user.getPhone();
						}
					};
				}

				@Override
				public String getAuthenticationScheme()
				{
					// TODO Auto-generated method stub
					return null;
				}
			});

		} catch (Exception e) {
			requestContext.abortWith(
					Response.status(Response.Status.UNAUTHORIZED).build());
		}

	}

}
