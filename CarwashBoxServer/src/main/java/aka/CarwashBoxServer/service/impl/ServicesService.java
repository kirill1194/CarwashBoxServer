package aka.CarwashBoxServer.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import aka.CarwashBoxServer.db.entity.Service;
import aka.CarwashBoxServer.db.service.dao.interfaces.IServiceDao;
import aka.CarwashBoxServer.rest.response.ServicesResponse;
import aka.CarwashBoxServer.rest.response.components.ServiceComponentResponse;
import aka.CarwashBoxServer.service.Utile.CastUtiles;
import aka.CarwashBoxServer.service.interfaces.IServicesService;

@org.springframework.stereotype.Service
public class ServicesService implements IServicesService
{
	@Autowired
	public IServiceDao serviceDao;

	@Override
	public ServicesResponse getServices()
	{
		List<Service> dbServices = serviceDao.findAll();
		List<ServiceComponentResponse> resultList = new ArrayList<ServiceComponentResponse>(dbServices.size());
		for (Service dbService : dbServices)
		{
			resultList.add(CastUtiles.serviceDbToWeb(dbService));
		}

		ServicesResponse response = new ServicesResponse();
		response.setServices(resultList);
		return response;
	}

}
