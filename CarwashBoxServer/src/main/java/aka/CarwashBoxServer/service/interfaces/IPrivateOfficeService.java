package aka.CarwashBoxServer.service.interfaces;

import aka.CarwashBoxServer.rest.request.CarAdd;
import aka.CarwashBoxServer.rest.request.PrivateOfficeSet;
import aka.CarwashBoxServer.rest.response.PrivateOfficeGetResponse;

public interface IPrivateOfficeService
{
	public void setPrivateOffice(PrivateOfficeSet privateOffice, Integer userId);
	public PrivateOfficeGetResponse getPrivateOffice(Integer userId);
	public Integer addCar(CarAdd car, Integer userId);
	public void deleteCar(Integer carId, Integer userId);
	public void editCar(CarAdd car, Integer userId, Integer carId);
}
