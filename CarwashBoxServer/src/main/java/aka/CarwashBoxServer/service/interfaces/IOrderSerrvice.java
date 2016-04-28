package aka.CarwashBoxServer.service.interfaces;

import java.util.List;

import aka.CarwashBoxServer.rest.request.Order;

public interface IOrderSerrvice
{
	public Integer makeOrder(Order order, Integer userId);

	public Order getOrderById(Integer id);

	public List<Order> getListUserOrders(String phone);

}
