package aka.CarwashBoxServer.service.interfaces;

import aka.CarwashBoxServer.rest.response.CarTypeResponse;
import aka.CarwashBoxServer.rest.response.CarTypesResponse;

public interface ICarTypeService
{
	public CarTypesResponse getCarTypes();
	public CarTypeResponse getCarTypeById(Integer id);

}
