package aka.CarwashBoxServer.db.service.dao.impl;

import aka.CarwashBoxServer.db.entity.Car;
import aka.CarwashBoxServer.db.service.dao.GenericDao;
import aka.CarwashBoxServer.db.service.dao.interfaces.ICarDao;

public class CarDao extends GenericDao<Car, Integer> implements ICarDao
{

	public CarDao()
	{
		super(Car.class);
	}

}
