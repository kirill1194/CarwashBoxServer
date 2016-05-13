package aka.CarwashBoxServer.db.service.dao.impl;

import aka.CarwashBoxServer.db.entity.Service;
import aka.CarwashBoxServer.db.service.dao.GenericDao;
import aka.CarwashBoxServer.db.service.dao.interfaces.IServiceDao;

public class ServiceDao extends GenericDao<Service, Integer> implements IServiceDao
{
	public ServiceDao()
	{
		super(Service.class);
	}
}
