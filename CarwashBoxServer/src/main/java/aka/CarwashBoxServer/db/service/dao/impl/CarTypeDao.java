package aka.CarwashBoxServer.db.service.dao.impl;

import aka.CarwashBoxServer.db.entity.CarType;
import aka.CarwashBoxServer.db.service.dao.GenericDao;
import aka.CarwashBoxServer.db.service.dao.interfaces.ICarTypeDao;

public class CarTypeDao extends GenericDao<CarType, Integer> implements ICarTypeDao
{
	public CarTypeDao()
	{
		super(CarType.class);
	}
}
