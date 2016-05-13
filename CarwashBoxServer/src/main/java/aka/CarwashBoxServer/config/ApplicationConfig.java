package aka.CarwashBoxServer.config;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.ServerProperties;

import aka.CarwashBoxServer.rest.controllers.BaseController;
import aka.CarwashBoxServer.rest.exceptions.mapping.ClientErrorMapping;
import aka.CarwashBoxServer.rest.exceptions.mapping.RootExceptionMapping;
import aka.CarwashBoxServer.rest.filters.RequestLogger;
import aka.CarwashBoxServer.rest.filters.ResponseLogger;
import aka.CarwashBoxServer.rest.security.SecurityFilter;

@ApplicationPath("/")
public class ApplicationConfig extends ResourceConfig
{
	public ApplicationConfig()
	{
		//Регистрация package с ресурсами
		packages(BaseController.class.getPackage().getName());
		packages(ClientErrorMapping.class.getPackage().getName());

		//Регистрация логгеров
		register(RequestLogger.class);
		register(ResponseLogger.class);

		//Регистрация SecurityFilter
		register(SecurityFilter.class);

		//Exception Mapping
		//		register(AutorizationHeaderNotExistExceptionMapping.class);
		register(RootExceptionMapping.class);

		//register(ConstraintViolationExceptionMapper.class);
		register(ClientErrorMapping.class);

		//Bean Validation propertys
		property(ServerProperties.BV_SEND_ERROR_IN_RESPONSE, true);
		property(ServerProperties.BV_DISABLE_VALIDATE_ON_EXECUTABLE_OVERRIDE_CHECK, true);



	}
}
