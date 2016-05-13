package aka.CarwashBoxServer.db.service.dao.impl;

import aka.CarwashBoxServer.db.entity.Order;
import aka.CarwashBoxServer.db.service.dao.GenericDao;
import aka.CarwashBoxServer.db.service.dao.interfaces.IOrderDao;

public class OrderDao extends GenericDao<Order, Integer> implements IOrderDao
{
	public OrderDao()
	{
		super(Order.class);
	}
}
