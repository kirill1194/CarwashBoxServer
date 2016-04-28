package aka.CarwashBoxServer.service.impl;

import java.util.List;

import org.springframework.stereotype.Controller;

import aka.CarwashBoxServer.rest.request.Order;
import aka.CarwashBoxServer.service.interfaces.IOrderSerrvice;

@Controller
public class OrderService implements IOrderSerrvice
{

	@Override
	public Integer makeOrder(Order order, Integer userId)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Order getOrderById(Integer id)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Order> getListUserOrders(String phone)
	{
		// TODO Auto-generated method stub
		return null;
	}
	//	@Autowired
	//	@Qualifier(value = "OrserDao")
	//	public IGenericDao<aka.CarwashBoxServer.db.entity.Order, Integer> orderDao;
	//
	//	@Autowired
	//	@Qualifier(value = "UserDao")
	//	public IUserDao userDao;
	//
	//	@Autowired
	//	@Qualifier(value = "CarDao")
	//	public IGenericDao<Car, Integer> carDao;
	//
	//	private static final Gson gson = new GsonBuilder().create();
	//
	//	@Override
	//	public Integer makeOrder(Order order, Integer userId)
	//	{
	//		aka.CarwashBoxServer.db.entity.Order entityOrder = new aka.CarwashBoxServer.db.entity.Order();
	//		entityOrder.setUser(userDao.findById(userId));
	//		Integer carId = order.getCarId();
	//		Car userCar = getUserCar(userId, carId);
	//		if (userCar != null)
	//			entityOrder.setCar(userCar);
	//		else
	//		{
	//
	//		}
	//		entityOrder.setComment(order.getComment());
	//		entityOrder.setServices(listSerializer(order.getIds()));
	//		entityOrder.setDate(order.getMeet());
	//		return orderDao.save(entityOrder);
	//
	//
	//	}
	//
	//	@SuppressWarnings("unused")
	//	private String listSerializer(List<?> list)
	//	{
	//		String result = gson.toJson(list);
	//		return result;
	//
	//	}
	//
	//	@SuppressWarnings("unchecked")
	//	private <K> List<K> listDeserealizer(String s)
	//	{
	//		List<K> result = gson.fromJson(s, List.class);
	//		return result;
	//	}
	//
	//	private Car getUserCar(Integer userId, Integer carId)
	//	{
	//		return null;
	//	}
	//
	//	@Override
	//	public Order getOrderById(Integer id)
	//	{
	//		// TODO Auto-generated method stub
	//		return null;
	//	}
	//
	//	@Override
	//	public List<Order> getListUserOrders(String phone)
	//	{
	//		User user = userDao.findByPhone(phone);
	//
	//	}

}
