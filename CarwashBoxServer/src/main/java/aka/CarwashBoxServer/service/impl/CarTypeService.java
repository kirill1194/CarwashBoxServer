package aka.CarwashBoxServer.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import aka.CarwashBoxServer.db.entity.CarType;
import aka.CarwashBoxServer.db.service.dao.interfaces.ICarTypeDao;
import aka.CarwashBoxServer.rest.exceptions.ClientError;
import aka.CarwashBoxServer.rest.exceptions.Errors;
import aka.CarwashBoxServer.rest.response.CarTypeResponse;
import aka.CarwashBoxServer.rest.response.CarTypesResponse;
import aka.CarwashBoxServer.service.Utile.CastUtiles;
import aka.CarwashBoxServer.service.interfaces.ICarTypeService;

@Service
public class CarTypeService implements ICarTypeService
{

	@Autowired
	public ICarTypeDao carTypeDao;

	@Override
	public CarTypesResponse getCarTypes()
	{
		List<CarType> carTypes = carTypeDao.findAll();
		CarTypesResponse result = new CarTypesResponse();
		for (CarType carType : carTypes)
		{
			result.addCarType(CastUtiles.carTypeDbToCarTypesComponentWeb(carType));
		}

		return result;
	}

	@Override
	public CarTypeResponse getCarTypeById(Integer id)
	{
		CarType carTypeDb = carTypeDao.findById(id);
		if (carTypeDb == null)
			throw new ClientError(Errors.CAR_TYPE_NOT_EXIST);
		return CastUtiles.carTypeDbToCarTypeWeb(carTypeDb);
	}

}
