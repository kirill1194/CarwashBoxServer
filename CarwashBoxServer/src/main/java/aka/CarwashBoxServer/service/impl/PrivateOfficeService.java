package aka.CarwashBoxServer.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import aka.CarwashBoxServer.db.entity.Car;
import aka.CarwashBoxServer.db.entity.CarType;
import aka.CarwashBoxServer.db.entity.User;
import aka.CarwashBoxServer.db.service.dao.interfaces.ICarDao;
import aka.CarwashBoxServer.db.service.dao.interfaces.ICarTypeDao;
import aka.CarwashBoxServer.db.service.dao.interfaces.IUserDao;
import aka.CarwashBoxServer.rest.exceptions.ClientError;
import aka.CarwashBoxServer.rest.exceptions.Errors;
import aka.CarwashBoxServer.rest.request.CarAdd;
import aka.CarwashBoxServer.rest.request.PrivateOfficeSet;
import aka.CarwashBoxServer.rest.response.PrivateOfficeGetResponse;
import aka.CarwashBoxServer.service.Utile.CastUtiles;
import aka.CarwashBoxServer.service.interfaces.IPrivateOfficeService;

@Service
public class PrivateOfficeService implements IPrivateOfficeService
{

	@Autowired
	public IUserDao userDao;

	@Autowired
	public ICarDao carDao;

	@Autowired
	ICarTypeDao carTypeDao;

	@Override
	public void setPrivateOffice(PrivateOfficeSet privateOffice, Integer userId)
	{
		User userWithThisPhone = userDao.findByPhone(privateOffice.getPhone());
		if (userWithThisPhone != null && !userWithThisPhone.getId().equals(userId))
			throw new ClientError(Errors.PHONE_ALREADY_EXIST);
		User user = userDao.findById(userId);
		user.setFirstName(privateOffice.getName());
		user.setSecondName(privateOffice.getSecondName());
		user.setPhone(privateOffice.getPhone());
		userDao.update(user);
	}

	@Override
	public PrivateOfficeGetResponse getPrivateOffice(Integer userId)
	{
		User user = userDao.findById(userId);
		PrivateOfficeGetResponse result = new PrivateOfficeGetResponse();
		result.setName(user.getFirstName());
		result.setSecondName(user.getSecondName());
		result.setPhone(user.getPhone());
		List<Car> dbCars = user.getCars();
		for (Car dbCar : dbCars)
		{
			result.addCar(CastUtiles.carDbToCarGetComponentWeb(dbCar));
		}

		return result;
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public Integer addCar(CarAdd car, Integer userId)
	{
		CarType dbCarType = carTypeDao.findById(car.getType());
		if (dbCarType == null)
			throw new ClientError(Errors.CAR_TYPE_NOT_EXIST);
		Car dbCar = new Car();
		dbCar.setCarType(dbCarType);
		dbCar.setName(car.getName());
		dbCar.setNumber(car.getNumber());
		dbCar.setUser(userDao.findById(userId));
		carDao.save(dbCar);

		return dbCar.getId();
	}

	@Override
	public void deleteCar(Integer carId, Integer userId)
	{
		Car dbCar = carDao.findById(carId);

		if (dbCar == null || !dbCar.getUser().getId().equals(userId))
			throw new ClientError(Errors.CAR_NOT_EXIST);
		carDao.delete(dbCar);

	}

	@Override
	public void editCar(CarAdd car, Integer userId, Integer carId)
	{
		Car dbCar = carDao.findById(carId);
		if (dbCar == null)
			throw new ClientError(Errors.CAR_NOT_EXIST);
		if (!dbCar.getUser().getId().equals(userId))
			throw new ClientError(Errors.CAR_NOT_EXIST);

		if (!dbCar.getCarType().getId().equals(car.getType()))
		{
			CarType carType = carTypeDao.findById(car.getType());
			if (carType == null)
				throw new ClientError(Errors.CAR_TYPE_NOT_EXIST);
			dbCar.setCarType(carType);
		}

		dbCar.setName(car.getName());
		dbCar.setNumber(car.getNumber());

		carDao.update(dbCar);
	}

}
