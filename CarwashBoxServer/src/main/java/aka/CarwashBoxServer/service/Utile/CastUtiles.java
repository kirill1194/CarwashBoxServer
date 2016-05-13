package aka.CarwashBoxServer.service.Utile;

import aka.CarwashBoxServer.db.entity.Car;
import aka.CarwashBoxServer.db.entity.CarType;
import aka.CarwashBoxServer.db.entity.Service;
import aka.CarwashBoxServer.rest.response.CarTypeResponse;
import aka.CarwashBoxServer.rest.response.components.CarGetComponentResponse;
import aka.CarwashBoxServer.rest.response.components.CarTypesComponentResponse;
import aka.CarwashBoxServer.rest.response.components.ServiceComponentResponse;

public class CastUtiles
{
	public static ServiceComponentResponse serviceDbToWeb(Service dbService)
	{
		ServiceComponentResponse result = new ServiceComponentResponse();
		result.setCost(dbService.getCost());
		result.setId(dbService.getId());
		result.setLnDiscript(dbService.getLnDiscription());
		result.setPicture(dbService.getPicture());
		result.setShDiscript(dbService.getShDiscription());
		result.setTime(40);
		result.setTitle(dbService.getTitle());

		return result;
	}

	public static CarTypesComponentResponse carTypeDbToCarTypesComponentWeb(CarType carType)
	{
		CarTypesComponentResponse result = new CarTypesComponentResponse();
		result.setId(carType.getId());
		result.setType(carType.getType());

		return result;
	}

	public static CarTypeResponse carTypeDbToCarTypeWeb(CarType carType)
	{
		CarTypeResponse result = new CarTypeResponse();
		result.setId(carType.getId());
		result.setType(carType.getType());

		return result;
	}

	public static CarGetComponentResponse carDbToCarGetComponentWeb(Car car)
	{
		CarGetComponentResponse result = new CarGetComponentResponse();
		result.setId(car.getId());
		result.setName(car.getName());
		result.setNumber(car.getNumber());
		result.setType(car.getCarType().getId());
		result.setTypeName(car.getCarType().getType());

		return result;
	}
}
